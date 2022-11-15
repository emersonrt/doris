package com.emerson.doris.service;

import com.emerson.doris.form.CadastroUsuarioForm;
import com.emerson.doris.model.Candidato;
import com.emerson.doris.model.PerfisAcesso;
import com.emerson.doris.model.Usuario;
import com.emerson.doris.model.enums.EPerfisAcesso;
import com.emerson.doris.repository.CandidatoRepository;
import com.emerson.doris.repository.PerfisAcessoRepository;
import com.emerson.doris.repository.UsuarioRepository;
import com.emerson.doris.service.impl.CandidatoServiceImpl;
import com.emerson.doris.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PerfisAcessoRepository perfisAcessoRepository;

    @Mock
    private PasswordEncoder encoder;

    @Test
    void deveCadastrarComSucesso() throws Exception {

        //ARRANGE
        String nomeUsuario = "teste";
        String email = "teste@email.com";
        String senha = "teste";
        HashSet perfisAcesso = new HashSet<>();
        perfisAcesso.add("admin");
        perfisAcesso.add("admin33");
        CadastroUsuarioForm form = new CadastroUsuarioForm(nomeUsuario, email, perfisAcesso, senha);

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setUsername(nomeUsuario);

        PerfisAcesso perfilAcesso = new PerfisAcesso();
        HashSet perfisAcessoUsuario = new HashSet<>();
        perfisAcessoUsuario.add(perfilAcesso);
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
        Mockito.when(perfisAcessoRepository.findByName(Mockito.any(EPerfisAcesso.class))).thenReturn(Optional.of(perfilAcesso));

        //ACT
        usuarioService.cadastrar(form);

        //ASSERT
        ArgumentCaptor<Usuario> usuarioCaptor = ArgumentCaptor.forClass(Usuario.class);
        Mockito.verify(usuarioRepository).save(usuarioCaptor.capture());

        assertEquals(nomeUsuario, usuarioCaptor.getValue().getUsername());
        assertEquals(email, usuarioCaptor.getValue().getEmail());
        assertEquals(perfisAcessoUsuario, usuarioCaptor.getValue().getPerfisAcessos());
    }

    @Test
    void deveCadastrarComSucessoPerfisAcessoNull() throws Exception {

        //ARRANGE
        String nomeUsuario = "teste";
        String email = "teste@email.com";
        String senha = "teste";
        CadastroUsuarioForm form = new CadastroUsuarioForm(nomeUsuario, email, null, senha);

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setUsername(nomeUsuario);

        PerfisAcesso perfilAcesso = new PerfisAcesso();
        HashSet perfisAcessoUsuario = new HashSet<>();
        perfisAcessoUsuario.add(perfilAcesso);
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
        Mockito.when(perfisAcessoRepository.findByName(Mockito.any(EPerfisAcesso.class))).thenReturn(Optional.of(perfilAcesso));

        //ACT
        usuarioService.cadastrar(form);

        //ASSERT
        ArgumentCaptor<Usuario> usuarioCaptor = ArgumentCaptor.forClass(Usuario.class);
        Mockito.verify(usuarioRepository).save(usuarioCaptor.capture());

        assertEquals(nomeUsuario, usuarioCaptor.getValue().getUsername());
        assertEquals(email, usuarioCaptor.getValue().getEmail());
        assertEquals(perfisAcessoUsuario, usuarioCaptor.getValue().getPerfisAcessos());
    }

    @Test
    void deveCadastrarComErroUsuarioIgual() throws Exception {

        //ARRANGE
        String nomeUsuario = "teste";
        String email = "teste@email.com";
        String senha = "teste";
        CadastroUsuarioForm form = new CadastroUsuarioForm(nomeUsuario, email, new HashSet<>(), senha);
        Mockito.when(usuarioRepository.existsByUsername(Mockito.any())).thenReturn(true);

        //ASSERT //ACT
        assertThrows(DuplicateKeyException.class, () -> usuarioService.cadastrar(form));
    }

    @Test
    void deveCadastrarComErroEmailIgual() throws Exception {

        //ARRANGE
        String nomeUsuario = "teste";
        String email = "teste@email.com";
        String senha = "teste";
        CadastroUsuarioForm form = new CadastroUsuarioForm(nomeUsuario, email, new HashSet<>(), senha);
        Mockito.when(usuarioRepository.existsByEmail(Mockito.any())).thenReturn(true);

        //ASSERT //ACT
        assertThrows(DuplicateKeyException.class, () -> usuarioService.cadastrar(form));
    }

    @Test
    void deveCadastrarComErroPerfisAcessoNull() throws Exception {

        //ARRANGE
        String nomeUsuario = "teste";
        String email = "teste@email.com";
        String senha = "teste";
        CadastroUsuarioForm form = new CadastroUsuarioForm(nomeUsuario, email, new HashSet<>(), senha);
        Mockito.when(usuarioRepository.existsByEmail(Mockito.any())).thenReturn(true);

        //ASSERT //ACT
        assertThrows(DuplicateKeyException.class, () -> usuarioService.cadastrar(form));
    }

}