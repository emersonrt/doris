package com.emerson.doris.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class Experiencia implements Serializable {

    private String empresaOrganizacao;
    private String tituloCargo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

}