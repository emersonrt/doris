package com.emerson.doris.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormacaoDTO {

    private Long id;
    private String nomeInstituicao;
    private String tipoGraduacao;
    private String nomeCurso;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

}
