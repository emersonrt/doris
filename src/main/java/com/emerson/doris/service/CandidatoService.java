package com.emerson.doris.service;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.form.CandidatoForm;

import java.util.List;

public interface CandidatoService {

    CandidatoDTO cadastrar(CandidatoForm form);

    List<CandidatoDTO> buscarTodos();
}
