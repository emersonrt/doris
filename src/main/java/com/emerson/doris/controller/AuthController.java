package com.emerson.doris.controller;

import com.emerson.doris.app.security.jwt.JwtUtils;
import com.emerson.doris.app.security.services.UserDetailsImpl;
import com.emerson.doris.dto.JwtResponse;
import com.emerson.doris.dto.MensagemDTO;
import com.emerson.doris.form.CadastroUsuarioForm;
import com.emerson.doris.form.LoginForm;
import com.emerson.doris.model.PerfisAcesso;
import com.emerson.doris.model.Usuario;
import com.emerson.doris.model.enums.EPerfisAcesso;
import com.emerson.doris.repository.PerfisAcessoRepository;
import com.emerson.doris.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UsuarioRepository usuarioRepository;

    private final PerfisAcessoRepository perfisAcessoRepository;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          UsuarioRepository usuarioRepository,
                          PerfisAcessoRepository perfisAcessoRepository,
                          PasswordEncoder encoder,
                          JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.perfisAcessoRepository = perfisAcessoRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    @Transactional(readOnly = true)
    public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody LoginForm loginForm) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> perfisAcesso = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(JwtResponse.builder()
                .token(jwt)
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .perfisAcesso(perfisAcesso)
                .build());
    }

    @PostMapping("/cadastro")
    @Transactional()
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody CadastroUsuarioForm cadastroForm) {
        if (usuarioRepository.existsByUsername(cadastroForm.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MensagemDTO("Error: Usuário já existente!"));
        }

        if (usuarioRepository.existsByEmail(cadastroForm.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MensagemDTO("Error: Email já existente!"));
        }

        Usuario user = new Usuario(cadastroForm.getUsername(),
                cadastroForm.getEmail(),
                encoder.encode(cadastroForm.getPassword()));

        Set<String> strPerfisAcessos = cadastroForm.getPerfisAcesso();
        Set<PerfisAcesso> roles = new HashSet<>();

        if (strPerfisAcessos == null) {
            PerfisAcesso userPerfisAcesso = perfisAcessoRepository.findByName(EPerfisAcesso.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Perfil de Acesso não encontrado."));
            roles.add(userPerfisAcesso);
        } else {
            strPerfisAcessos.forEach(role -> {
                switch (role) {
                    case "admin":
                        PerfisAcesso adminPerfisAcesso = perfisAcessoRepository.findByName(EPerfisAcesso.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Perfil de Acesso não encontrado."));
                        roles.add(adminPerfisAcesso);

                        break;
                    default:
                        PerfisAcesso userPerfisAcesso = perfisAcessoRepository.findByName(EPerfisAcesso.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Perfil de Acesso não encontrado."));
                        roles.add(userPerfisAcesso);
                }
            });
        }

        user.setPerfisAcessos(roles);
        usuarioRepository.save(user);

        return ResponseEntity.ok(new MensagemDTO("Usuario registrado com sucesso!"));
    }

}
