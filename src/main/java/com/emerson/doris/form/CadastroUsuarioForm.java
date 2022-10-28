package com.emerson.doris.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CadastroUsuarioForm {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> perfisAcesso;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

}
