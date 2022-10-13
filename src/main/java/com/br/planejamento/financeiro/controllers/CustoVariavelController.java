package com.br.planejamento.financeiro.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.planejamento.financeiro.configs.ControllerConfig;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/custos-variaveis")
@CrossOrigin("*")
public class CustoVariavelController {

}
