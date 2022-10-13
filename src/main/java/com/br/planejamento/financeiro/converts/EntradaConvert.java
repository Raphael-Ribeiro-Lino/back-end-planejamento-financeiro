package com.br.planejamento.financeiro.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.planejamento.financeiro.dtos.inputs.EntradaInput;
import com.br.planejamento.financeiro.dtos.outputs.EntradaOutput;
import com.br.planejamento.financeiro.entities.EntradaEntity;

@Component
public class EntradaConvert {

	@Autowired
	private ModelMapper modelMapper;

	public EntradaEntity inputToEntity( EntradaInput entradaInput) {
		return modelMapper.map(entradaInput, EntradaEntity.class);
	}

	public EntradaOutput entityToOutput(EntradaEntity entradaCadastrada) {
		return modelMapper.map(entradaCadastrada, EntradaOutput.class);
	}

	public List<EntradaOutput> pageEntityToPageOutput(List<EntradaEntity> listaTodas) {
		return listaTodas.stream().map(entrada -> this.entityToOutput(entrada)).collect(Collectors.toList());
	}

	public void copyInputToEntity(EntradaEntity entradaEncontrada, EntradaInput entradaInput) {
		modelMapper.map(entradaInput, entradaEncontrada);
	}
}
