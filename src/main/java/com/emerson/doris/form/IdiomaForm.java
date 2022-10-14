package com.emerson.doris.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdiomaForm {

    private String idioma;
    private String nivelFluencia;

}
