package com.emerson.doris.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private LocalDate dataCadastro = LocalDate.now();
    @Column(nullable = false)
    private String telefoneCelular;
    @Column(nullable = false)
    private String email;

    @ElementCollection
    private List<HardSkill> hardSkills = new java.util.ArrayList<>();

    @ElementCollection
    private List<SoftSkill> softSkills = new java.util.ArrayList<>();

    @ElementCollection
    private List<Formacao> formacoes = new java.util.ArrayList<>();

    @ElementCollection
    private List<String> linksRelevantes = new java.util.ArrayList<>();

    @Column(nullable = false)
    private String cargaHoraria;
    @Column(nullable = false)
    private String turno;
    @Column(nullable = false)
    private String modalidadeTrabalho;
    private String cidadeResidencia;
    private Boolean disponibilidadeRealocacao;
    @Column(nullable = false)
    private String areaInteresse;

    @ElementCollection
    private List<Idioma> idiomas = new java.util.ArrayList<>();

    @ElementCollection
    private List<Certificacao> certificacoes = new java.util.ArrayList<>();

    @ElementCollection
    private List<Experiencia> experiencias = new java.util.ArrayList<>();
    private String pontosFortes;
    private String pontosFracos;
    private String informacaoRelevante;

}