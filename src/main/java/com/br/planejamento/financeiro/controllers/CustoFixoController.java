package com.br.planejamento.financeiro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.planejamento.financeiro.configs.ControllerConfig;
import com.br.planejamento.financeiro.converts.CustoFixoConvert;
import com.br.planejamento.financeiro.services.CustoFixoService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/custos-fixos")
@CrossOrigin(origins = "*")
public class CustoFixoController {

	@Autowired
	private CustoFixoService custoFixoService;
	
	@Autowired
	private CustoFixoConvert custoFixoConvert;
	
}
