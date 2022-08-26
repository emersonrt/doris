package com.emerson.doris.service;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.model.Candidato;

import java.util.List;

public interface CandidatoService {

    public CandidatoDTO cadastrar(CandidatoForm form);

    public List<CandidatoDTO> buscarTodos();
}
