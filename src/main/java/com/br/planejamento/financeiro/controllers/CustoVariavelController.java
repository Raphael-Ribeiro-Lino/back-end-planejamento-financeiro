package com.br.planejamento.financeiro.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping()
	public List<CustoVariavelOutput> listaTodos(){
		List<CustoVariavelEntity> listaTodos = custoVariavelService.listaTodos();
		return custoVariavelConvert.pageEntityToPageOutput(listaTodos);
	}
	
	@PutMapping("/{id}")
	public CustoVariavelOutput altera(@PathVariable Long id, @RequestBody @Valid CustoVariavelInput custoVariavelInput) {
		CustoVariavelEntity custoVariavelEncontrado = custoVariavelService.buscaPorId(id);
		custoVariavelConvert.copyInputToEntity(custoVariavelInput, custoVariavelEncontrado);
		CustoVariavelEntity custoVariavelAlterado = custoVariavelService.altera(custoVariavelEncontrado);
		return custoVariavelConvert.entityToOutput(custoVariavelAlterado);
	}
	
	@GetMapping("/{id}")
	public CustoVariavelOutput buscaPorId(@PathVariable Long id) {
		CustoVariavelEntity custoVariavelEncontrado = custoVariavelService.buscaPorId(id);
		return custoVariavelConvert.entityToOutput(custoVariavelEncontrado);
	}

}
