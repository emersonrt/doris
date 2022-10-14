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
public class CertificacaoDTO {

    private Long id;
    private String nome;
    private String organizacaoEmissora;
    private String urlCodigo;
    private LocalDate dataEmissao;

}
