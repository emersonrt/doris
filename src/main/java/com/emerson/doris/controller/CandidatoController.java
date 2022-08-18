package com.emerson.doris.controller;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCallback;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("candidato")
public class CandidatoController {

    @Value("${ibm.assistant.version.date}")
    private String assistantVersionDate;

    @Value("${ibm.assistant.workspace.id}")
    private String assistantWorkspace;

//    private Assistant service;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

//    @PostConstruct
//    public void init() {
//        service = new Assistant( assistantVersionDate );
//    }

    @GetMapping("teste")
    public String teste() {
        return "Hello World!!!";
    }

    @PostMapping(path = "/api/message", consumes = MediaType.APPLICATION_JSON_VALUE)
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


