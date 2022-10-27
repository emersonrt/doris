package com.emerson.doris.controller;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.service.CandidatoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<List<CandidatoDTO>> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

}


