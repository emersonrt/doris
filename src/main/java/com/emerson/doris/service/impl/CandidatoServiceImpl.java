package com.emerson.doris.service.impl;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.dto.CandidatoPaginacaoDTO;
import com.emerson.doris.dto.converter.CandidatoConverter;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.model.*;
import com.emerson.doris.repository.CandidatoRepository;
import com.emerson.doris.service.CandidatoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    private final CandidatoRepository candidatoRepository;
    private final ModelMapper mapper;

    @Autowired
    public CandidatoServiceImpl(CandidatoRepository candidatoRepository, ModelMapper mapper) {
        this.candidatoRepository = candidatoRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CandidatoDTO cadastrar(CandidatoForm form) {

        Candidato candidato = new Candidato();
        candidato.setNome(form.getNome());
        candidato.setDataNascimento(form.getDataNascimento());
        candidato.setTelefoneCelular(form.getTelefoneCelular());
        candidato.setEmail(form.getEmail());
        candidato.setHardSkills(mapperWithNullCheck(form.getHardSkills(), new TypeToken<List<HardSkill>>() {
        }.getType()));
        candidato.setSoftSkills(mapperWithNullCheck(form.getSoftSkills(), new TypeToken<List<SoftSkill>>() {
        }.getType()));
        candidato.setFormacoes(mapperWithNullCheck(form.getFormacoes(), new TypeToken<List<Formacao>>() {
        }.getType()));
        candidato.setLinksRelevantes(form.getLinksRelevantes());
        candidato.setCargaHoraria(form.getCargaHoraria());
        candidato.setTurno(form.getTurno());
        candidato.setModalidadeTrabalho(form.getModalidadeTrabalho());
        candidato.setCidadeResidencia(form.getCidadeResidencia());
        candidato.setDisponibilidadeRealocacao(form.getDisponibilidadeRealocacao());
        candidato.setAreaInteresse(form.getAreaInteresse());
        candidato.setIdiomas(mapperWithNullCheck(form.getIdiomas(), new TypeToken<List<Idioma>>() {
        }.getType()));
        candidato.setCertificacoes(mapperWithNullCheck(form.getCertificacoes(), new TypeToken<List<Certificacao>>() {
        }.getType()));
        candidato.setExperiencias(mapperWithNullCheck(form.getExperiencias(), new TypeToken<List<Experiencia>>() {
        }.getType()));
        candidato.setPontosFortes(form.getPontosFortes());
        candidato.setPontosFracos(form.getPontosFracos());
        candidato.setInformacaoRelevante(form.getInformacaoRelevante());

        return mapper.map(candidatoRepository.save(candidato), CandidatoDTO.class);
    }

    private <D> D mapperWithNullCheck(Object source, Type destinationType) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationType);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CandidatoPaginacaoDTO> buscaPaginada(Specification<Candidato> spec, Pageable pageable) {
        return candidatoRepository.findAll(spec, pageable).map(CandidatoConverter::convert);
    }

    @Override
    @Transactional(readOnly = true)
    public CandidatoDTO buscarPorId(long idCandidato) {
        Candidato record = candidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado!"));
        return mapper.map(record, CandidatoDTO.class);
    }
}
