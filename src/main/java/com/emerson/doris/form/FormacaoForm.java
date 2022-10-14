package com.emerson.doris.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormacaoForm {

    private String nomeInstituicao;
    private String tipoGraduacao;
    private String nomeCurso;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dataTermino;

}
