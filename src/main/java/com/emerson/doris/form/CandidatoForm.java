package com.emerson.doris.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandidatoForm {

    private String nome;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate dataNascimento;

    private String telefoneCelular;
    private String email;
    private List<HardSkillForm> hardSkills;
    private List<SoftSkillForm> softSkills;
    private List<FormacaoForm> formacoes;
    private List<String> linksRelevantes;
    private String cargaHoraria;
    private String turno;
    private String modalidadeTrabalho;
    private String cidadeResidencia;
    private Boolean disponibilidadeRealocacao;
    private String areaInteresse;
    private List<IdiomaForm> idiomas;
    private List<CertificacaoForm> certificacoes;
    private List<ExperienciaForm> experiencias;
    private String pontosFortes;
    private String pontosFracos;
    private String informacaoRelevante;

}









