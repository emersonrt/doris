package com.emerson.doris.model;

import com.emerson.doris.model.enums.EPerfisAcesso;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "perfis_acesso")
public class PerfisAcesso {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EPerfisAcesso name;

    public PerfisAcesso() {

    }

}