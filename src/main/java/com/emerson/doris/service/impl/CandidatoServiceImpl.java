package com.emerson.doris.service.impl;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.model.Candidato;
import com.emerson.doris.repository.CandidatoRepository;
import com.emerson.doris.service.CandidatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    private CandidatoRepository candidatoRepository;
    private ModelMapper mapper;

    @Autowired
    public CandidatoServiceImpl(CandidatoRepository candidatoRepository, ModelMapper mapper) {
        this.candidatoRepository = candidatoRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public CandidatoDTO cadastrar(CandidatoForm form) {
        Candidato candidato = new Candidato();
        candidato.setNome(form.getNome());
        candidato.setEmail(form.getEmail());
        candidato.setTelefoneCelular(form.getTelefoneCelular());
        candidato.setDataNascimento(form.getDataNascimento());

        candidatoRepository.save(candidato);
        return mapper.map(candidato, CandidatoDTO.class);
    }

    @Override
    public List<CandidatoDTO> buscarTodos() {
        List<Candidato> candidatos = candidatoRepository.findAll();
        return candidatos.stream()
                .map(candidato -> mapper.map(candidato, CandidatoDTO.class))
                .collect(Collectors.toList());
    }
}
