package com.emerson.doris.repository;

import com.emerson.doris.model.Candidato;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.stream.DoubleStream;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>, JpaSpecificationExecutor<Candidato> {
}
