package com.emerson.doris.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class Certificacao implements Serializable {

    private String nome;
    private String organizacaoEmissora;
    private String urlCodigo;
    private LocalDate dataEmissao;

}