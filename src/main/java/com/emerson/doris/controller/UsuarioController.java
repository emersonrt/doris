package com.emerson.doris.controller;

import com.emerson.doris.dto.MensagemDTO;
import com.emerson.doris.form.CadastroUsuarioForm;
import com.emerson.doris.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("cadastro")
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody CadastroUsuarioForm cadastroForm) {

        try {
            usuarioService.cadastrar(cadastroForm);
        } catch (ResourceNotFoundException | DuplicateKeyException ex) {
            return ResponseEntity.badRequest().body(new MensagemDTO(ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(new MensagemDTO("Erro ao cadastrar usuário!"));
        }

        return ResponseEntity.ok(new MensagemDTO("Usuario registrado com sucesso."));
    }

}
