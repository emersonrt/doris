package com.emerson.doris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HardSkillDTO {

    private String habilidade;
    private Float tempoExperiencia;

}
