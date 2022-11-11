package com.emerson.doris.utils;

import com.emerson.doris.enums.DataCadastroEnum;
import com.emerson.doris.model.Candidato;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class FiltroPaginacaoSpec {

    public static Specification<Candidato> getCandidatoPorFiltrosSpec(
            String nome, String areaInteresse, DataCadastroEnum dataCadastro,
            List<String> idiomas, List<String> hardSkills, List<String> softSkills) {
        return new Specification<Candidato>() {
            @Override
            public Predicate toPredicate(Root<Candidato> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(nome)) {
                    predicates.add(cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
                }

                if (StringUtils.isNotEmpty(areaInteresse)) {
                    predicates.add(cb.like(cb.lower(root.get("areaInteresse")), "%" + areaInteresse.toLowerCase() + "%"));
                }

                if (dataCadastro != null) {
                    LocalDate dataAtual = Instant.now().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate();
                    LocalDate data = dataAtual;
                    switch (dataCadastro) {
                        case ULTIMOS_7_DIAS:
                            data = dataAtual.minusDays(7);
                            break;
                        case ULTIMOS_30_DIAS:
                            data = dataAtual.minusDays(30);
                            break;
                        case ULTIMOS_3_MESES:
                            data = dataAtual.minusMonths(3);
                            break;
                        case ULTIMOS_6_MESES:
                            data = dataAtual.minusMonths(6);
                            break;
                    }
                    predicates.add(cb.greaterThanOrEqualTo(root.get("dataCadastro"), data));
                }

                if (idiomas != null && !idiomas.isEmpty()) {
                    for (String idioma : idiomas) {
                        predicates.add(cb.equal(cb.lower(root.join("idiomas").get("idioma")), idioma.toLowerCase()));
                    }
                }

                if (hardSkills != null && !hardSkills.isEmpty()) {
                    for (String hardSkill : hardSkills) {
                        predicates.add(cb.equal(cb.lower(root.join("hardSkills").get("habilidade")), hardSkill.toLowerCase()));
                    }
                }

                if (softSkills != null && !softSkills.isEmpty()) {
                    for (String softSkill : softSkills) {
                        predicates.add(cb.equal(cb.lower(root.join("softSkills").get("habilidade")), softSkill.toLowerCase()));
                    }
                }

                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }

}
