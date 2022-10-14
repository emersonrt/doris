package com.emerson.doris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdiomaDTO {

    private Long id;
    private String idioma;
    private String nivelFluencia;

}
