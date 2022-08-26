package com.emerson.doris.controller;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.service.CandidatoService;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
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

    //retornar o DTO criado
    @PostMapping
    public ResponseEntity<CandidatoDTO> create(@RequestBody CandidatoForm form) {
        CandidatoDTO dto = service.cadastrar(form);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CandidatoDTO>> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping(path = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<MessageResponse> postMessage(RequestEntity<String> requestEntity) {
        try {

            String json = requestEntity.getBody();
            log.info("json:", json);
//            log.info("TESTE: ", response.toString());

//            String text = (messageInput.text() == null) ? "" : messageInput.text();
//            String messageType = (messageInput.messageType() == null) ? "" : messageInput.messageType();
//            String suggestionIdType = (messageInput.suggestionId() == null) ? "" : messageInput.suggestionId();

//            log.info("text", text);
//            log.info("messageType", messageType);
//            log.info("suggestionIdType", suggestionIdType);

//            MessageOptions options =
//                    new MessageOptions.Builder( assistantWorkspace,  ).build();

//            Response<MessageResponse> response = service.message(options).execute();
            return null;

        } catch (NotFoundException e) {
            log.error("NotFoundException", e);
            throw e;
        } catch (RequestTooLargeException e) {
            log.error("RequestTooLargeException", e);
            throw e;
        } catch (ServiceResponseException e) {
            log.error("ServiceResponseException", e);
            throw e;
        }
    }

}


