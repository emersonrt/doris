package com.emerson.doris.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro = LocalDate.now();
    private String telefoneCelular;
    private String email;
    private String endereco;
//    private List<String> linksUteis;
//    private

}