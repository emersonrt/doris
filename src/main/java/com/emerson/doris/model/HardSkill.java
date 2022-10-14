package com.emerson.doris.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class HardSkill implements Serializable {

    private String habilidade;
    private Float tempoExperiencia;

}