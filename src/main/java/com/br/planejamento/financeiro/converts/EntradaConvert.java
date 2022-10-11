package com.br.planejamento.financeiro.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	public Page<EntradaOutput> pageEntityToPageOutput(Page<EntradaEntity> listaTodas) {
		return listaTodas.map(this::entityToOutput);
	}

	public void copyInputToEntity(EntradaEntity entradaEncontrada, EntradaInput entradaInput) {
		modelMapper.map(entradaInput, entradaEncontrada);
	}
}
