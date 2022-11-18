package com.emerson.doris.controller;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.dto.CandidatoPaginacaoDTO;
import com.emerson.doris.enums.DataCadastroEnum;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.model.Candidato;
import com.emerson.doris.service.CandidatoService;
import com.emerson.doris.utils.FiltroPaginacaoSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("candidato")
public class CandidatoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CandidatoService service;

    @Autowired
    public CandidatoController(CandidatoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CandidatoDTO> create(@RequestBody CandidatoForm form) {
        CandidatoDTO dto = service.cadastrar(form);
        log.info("Candidato cadastrado: " + dto.toString());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("paginado")
    public ResponseEntity<Page<CandidatoPaginacaoDTO>> listaPaginada(
            @RequestParam(defaultValue = "") String nome,
            @RequestParam(defaultValue = "") String areaInteresse,
            @RequestParam(defaultValue = "") String dataCadastro,
            @RequestParam(defaultValue = "") List<String> idiomas,
            @RequestParam(defaultValue = "") List<String> hardSkills,
            @RequestParam(defaultValue = "") List<String> softSkills,
            Pageable pageable
    ) {
        Specification<Candidato> t = FiltroPaginacaoSpec.getCandidatoPorFiltrosSpec(
                nome,
                areaInteresse,
                DataCadastroEnum.fromString(dataCadastro),
                idiomas,
                hardSkills,
                softSkills
        );
        return ResponseEntity.ok(service.buscaPaginada(t, pageable));
    }

    @GetMapping()
    public ResponseEntity<CandidatoDTO> getById(Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("wakeup")
    public ResponseEntity<Boolean> wakeUpHeroku() {
        return ResponseEntity.ok(true);
    }

}


