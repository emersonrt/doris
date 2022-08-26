package com.emerson.doris.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandidatoForm {

    private String nome;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String telefoneCelular;

    private String email;

    //provavelmente será necessário um dto
    private String endereco;

    private String linkedin;

    private String github;

//    private CandidatoFormacaoForm formacao;

}
