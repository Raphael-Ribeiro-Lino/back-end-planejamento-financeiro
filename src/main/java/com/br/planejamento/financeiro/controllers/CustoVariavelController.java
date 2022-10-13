package com.br.planejamento.financeiro.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.planejamento.financeiro.configs.ControllerConfig;
import com.br.planejamento.financeiro.converts.CustoVariavelConvert;
import com.br.planejamento.financeiro.dtos.inputs.CustoVariavelInput;
import com.br.planejamento.financeiro.dtos.outputs.CustoVariavelOutput;
import com.br.planejamento.financeiro.entities.CustoVariavelEntity;
import com.br.planejamento.financeiro.services.CustoVariavelService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/custos-variaveis")
@CrossOrigin(origins = "*")
public class CustoVariavelController {
	
	@Autowired
	private CustoVariavelService custoVariavelService;
	
	@Autowired
	private CustoVariavelConvert custoVariavelConvert;
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustoVariavelOutput cadastra(@RequestBody @Valid CustoVariavelInput custoVariavelInput) {
		CustoVariavelEntity custoVariavelEntity = custoVariavelConvert.inputToEntity(custoVariavelInput);
		CustoVariavelEntity custoVariavelCadastrado = custoVariavelService.cadastra(custoVariavelEntity);
		return custoVariavelConvert.entityToOutput(custoVariavelCadastrado);
	}

}
