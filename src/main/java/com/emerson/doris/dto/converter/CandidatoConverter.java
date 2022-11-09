package com.emerson.doris.dto.converter;

import com.emerson.doris.dto.CandidatoPaginacaoDTO;
import com.emerson.doris.model.Candidato;

import java.util.stream.Collectors;

public class CandidatoConverter {

    public static CandidatoPaginacaoDTO convert(Candidato candidato) {
        return CandidatoPaginacaoDTO.builder()
                .idCandidato(candidato.getId())
                .nome(candidato.getNome())
                .areaInteresse(candidato.getAreaInteresse())
                .hardSkills(candidato.getHardSkills() != null ?
                        candidato.getHardSkills().stream().map(hardSkill -> hardSkill.getHabilidade()).collect(Collectors.toList()) : null)
                .softSkills(candidato.getSoftSkills() != null ?
                        candidato.getSoftSkills().stream().map(softSkill -> softSkill.getHabilidade()).collect(Collectors.toList()) : null)
                .idiomas(candidato.getIdiomas() != null ?
                        candidato.getIdiomas().stream().map(idioma -> idioma.getIdioma()).collect(Collectors.toList()) : null)
                .dataCadastro(candidato.getDataCadastro())
                .build();
    }
}
