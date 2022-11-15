package com.emerson.doris.service.impl;

import com.emerson.doris.form.CadastroUsuarioForm;
import com.emerson.doris.model.PerfisAcesso;
import com.emerson.doris.model.Usuario;
import com.emerson.doris.model.enums.EPerfisAcesso;
import com.emerson.doris.repository.PerfisAcessoRepository;
import com.emerson.doris.repository.UsuarioRepository;
import com.emerson.doris.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PerfisAcessoRepository perfisAcessoRepository;

    private final PasswordEncoder encoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PerfisAcessoRepository perfisAcessoRepository, PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.perfisAcessoRepository = perfisAcessoRepository;
        this.encoder = encoder;
    }

    @Override
    @Transactional()
    public Long cadastrar(CadastroUsuarioForm usuarioForm) throws Exception {

        if (usuarioRepository.existsByUsername(usuarioForm.getUsername())) {
            throw new DuplicateKeyException("Erro: Usuário já existente!");
        }

        if (usuarioRepository.existsByEmail(usuarioForm.getEmail())) {
            throw new DuplicateKeyException("Erro: Email já existente!");
        }

        Usuario user = new Usuario(usuarioForm.getUsername(),
                usuarioForm.getEmail(),
                encoder.encode(usuarioForm.getPassword()));

        Set<String> strPerfisAcessos = usuarioForm.getPerfisAcesso();
        Set<PerfisAcesso> roles = new HashSet<>();

        if (strPerfisAcessos == null) {
            PerfisAcesso userPerfisAcesso = perfisAcessoRepository.findByName(EPerfisAcesso.USER)
                    .orElseThrow(() -> new ResourceNotFoundException("Erro: Perfil de Acesso não encontrado."));
            roles.add(userPerfisAcesso);
        } else {
            strPerfisAcessos.forEach(role -> {
                switch (role) {
                    case "admin":
                        PerfisAcesso adminPerfisAcesso = perfisAcessoRepository.findByName(EPerfisAcesso.ADMIN)
                                .orElseThrow(() -> new ResourceNotFoundException("Erro: Perfil de Acesso não encontrado."));
                        roles.add(adminPerfisAcesso);

                        break;
                    default:
                        PerfisAcesso userPerfisAcesso = perfisAcessoRepository.findByName(EPerfisAcesso.USER)
                                .orElseThrow(() -> new ResourceNotFoundException("Erro: Perfil de Acesso não encontrado."));
                        roles.add(userPerfisAcesso);
                }
            });
        }

        user.setPerfisAcessos(roles);
        return usuarioRepository.save(user).getId();
    }
}
