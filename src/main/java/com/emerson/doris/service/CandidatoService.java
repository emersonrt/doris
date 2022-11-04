package com.emerson.doris.service;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.dto.CandidatoPaginacaoDTO;
import com.emerson.doris.form.CandidatoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CandidatoService {

    CandidatoDTO cadastrar(CandidatoForm form);

    Page<CandidatoPaginacaoDTO> buscaPaginada(Pageable pageable);

    List<CandidatoDTO> buscarTodos();
}
