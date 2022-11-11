package com.emerson.doris.utils;

import com.emerson.doris.model.Candidato;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FiltroPaginacaoSpec {

    public static Specification<Candidato> getCandidatoPorFiltrosSpec(String nome) {
        return new Specification<Candidato>() {
            @Override
            public Predicate toPredicate(Root<Candidato> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(StringUtils.isNotEmpty(nome)) {
                    predicates.add(cb.like(cb.lower(root.get("nome")), "%"+nome.toLowerCase()+"%"));
                }
                return cb.and(predicates.toArray(new Predicate[] {}));
            }
        };
    }

}
