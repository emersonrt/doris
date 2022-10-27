package com.emerson.doris.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
