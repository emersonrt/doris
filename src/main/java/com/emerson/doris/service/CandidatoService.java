package com.emerson.doris.service;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.dto.CandidatoPaginacaoDTO;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.model.Candidato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CandidatoService {

    CandidatoDTO cadastrar(CandidatoForm form);

    Page<CandidatoPaginacaoDTO> buscaPaginada(Specification<Candidato> spec, Pageable pageable);

    CandidatoDTO buscarPorId(long idCandidato);
}
