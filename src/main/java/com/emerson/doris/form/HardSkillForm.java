package com.emerson.doris.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HardSkillForm {

    private String habilidade;
    private Float tempoExperiencia;

}
