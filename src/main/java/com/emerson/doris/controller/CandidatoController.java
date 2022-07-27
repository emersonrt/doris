package com.emerson.doris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("candidato")
public class CandidatoController {

    @RequestMapping("teste")
    @ResponseBody
    public String teste() {
        return "Hello World!!!";
    }

}
