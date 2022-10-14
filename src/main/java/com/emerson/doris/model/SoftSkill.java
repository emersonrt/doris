package com.emerson.doris.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class SoftSkill implements Serializable {

    private String habilidade;

}