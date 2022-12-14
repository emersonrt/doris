package com.emerson.doris.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class Formacao implements Serializable {

    private String nomeInstituicao;
    private String tipoGraduacao;
    private String nomeCurso;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

}