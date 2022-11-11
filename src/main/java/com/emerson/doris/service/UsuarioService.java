package com.emerson.doris.service;

import com.emerson.doris.form.CadastroUsuarioForm;

public interface UsuarioService {

    public Long cadastrar(CadastroUsuarioForm usuarioForm) throws Exception;

}
