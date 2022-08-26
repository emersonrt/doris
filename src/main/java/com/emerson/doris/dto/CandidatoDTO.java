package com.emerson.doris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    //provavelmente será necessário um dto
    private String endereco;

    private String linkedin;

    private String github;

}
