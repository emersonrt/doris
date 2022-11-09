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
public class CandidatoPaginacaoDTO {

    private Long idCandidato;
    private String nome;
    private LocalDate dataCadastro;
    private List<String> hardSkills;
    private List<String> softSkills;
    private String areaInteresse;
    private List<String> idiomas;

}
