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
import com.br.planejamento.financeiro.converts.CustoFixoConvert;
import com.br.planejamento.financeiro.dtos.inputs.CustoFixoInput;
import com.br.planejamento.financeiro.dtos.outputs.CustoFixoOutput;
import com.br.planejamento.financeiro.entities.CustoFixoEntity;
import com.br.planejamento.financeiro.services.CustoFixoService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/custos-fixos")
@CrossOrigin(origins = "*")
public class CustoFixoController {

	@Autowired
	private CustoFixoService custoFixoService;
	
	@Autowired
	private CustoFixoConvert custoFixoConvert;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustoFixoOutput cadastra(@RequestBody @Valid CustoFixoInput custoFixoInput) {
		CustoFixoEntity custoFixoEntity = custoFixoConvert.inputToEntity(custoFixoInput);
		CustoFixoEntity custoFixoCadastrado = custoFixoService.cadastra(custoFixoEntity);
		return custoFixoConvert.entityToOutput(custoFixoCadastrado);
	}
}
