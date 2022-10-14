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
public class ExperienciaDTO {

    private Long id;
    private String empresaOrganizacao;
    private String tituloCargo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

}
