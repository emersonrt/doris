package com.emerson.doris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidatoDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String telefoneCelular;
    private String email;
    private List<HardSkillDTO> hardSkills;
    private List<SoftSkillDTO> softSkills;
    private List<FormacaoDTO> formacoes;
    private List<String> linksRelevantes;
    private String cargaHoraria;
    private String turno;
    private String modalidadeTrabalho;
    private String cidadeResidencia;
    private Boolean disponibilidadeRealocacao;
    private String areaInteresse;
    private List<IdiomaDTO> idiomas;
    private List<CertificacaoDTO> certificacoes;
    private List<ExperienciaDTO> experiencias;
    private String pontosFortes;
    private String pontosFracos;
    private String informacaoRelevante;

}
