package com.br.planejamento.financeiro.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
import com.br.planejamento.financeiro.converts.EntradaConvert;
import com.br.planejamento.financeiro.dtos.inputs.EntradaInput;
import com.br.planejamento.financeiro.dtos.outputs.EntradaOutput;
import com.br.planejamento.financeiro.entities.EntradaEntity;
import com.br.planejamento.financeiro.services.EntradaService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/entradas")
@CrossOrigin(origins = "*")
public class EntradaController {
	
	@Autowired
	private EntradaService entradaService;
	
	@Autowired
	private EntradaConvert entradaConvert;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EntradaOutput cadastra(@RequestBody @Valid EntradaInput entradaInput) {
		EntradaEntity entradaEntity = entradaConvert.inputToEntity(entradaInput);
		EntradaEntity entradaCadastrada = entradaService.cria(entradaEntity);
		return entradaConvert.entityToOutput(entradaCadastrada);
	}
	
	@GetMapping
	public Page<EntradaOutput> listaTodas(@PageableDefault(sort ="valor", direction = Direction.DESC, size = 9 ) Pageable paginacao){
		Page<EntradaEntity> listaTodas = entradaService.listaTodas(paginacao);
		return entradaConvert.pageEntityToPageOutput(listaTodas);
	}
	
	@PutMapping("/{id}")
	public EntradaOutput altera(@PathVariable Long id, @RequestBody @Valid EntradaInput entradaInput) {
		EntradaEntity entradaEncontrada = entradaService.buscaPorId(id);
		entradaConvert.copyInputToEntity(entradaEncontrada, entradaInput);
		EntradaEntity entradaAlterada = entradaService.altera(entradaEncontrada);
		return entradaConvert.entityToOutput(entradaAlterada);
	}
	
	@GetMapping("/{id}")
	public EntradaOutput buscaPorId(@PathVariable Long id) {
		EntradaEntity entradaEncontrada = entradaService.buscaPorId(id);
		return entradaConvert.entityToOutput(entradaEncontrada);
	}
	

}
