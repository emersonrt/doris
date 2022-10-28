package com.emerson.doris.repository;

import com.emerson.doris.model.PerfisAcesso;
import com.emerson.doris.model.enums.EPerfisAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfisAcessoRepository extends JpaRepository<PerfisAcesso, Long> {

    Optional<PerfisAcesso> findByName(EPerfisAcesso name);

}