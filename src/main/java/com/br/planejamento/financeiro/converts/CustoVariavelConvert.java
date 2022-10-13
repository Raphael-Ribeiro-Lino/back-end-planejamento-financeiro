package com.br.planejamento.financeiro.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.planejamento.financeiro.dtos.inputs.CustoVariavelInput;
import com.br.planejamento.financeiro.dtos.outputs.CustoVariavelOutput;
import com.br.planejamento.financeiro.entities.CustoVariavelEntity;

@Component
public class CustoVariavelConvert {

	@Autowired
	private ModelMapper modelMapper;

	public CustoVariavelEntity inputToEntity(CustoVariavelInput custoVariavelInput) {
		return modelMapper.map(custoVariavelInput, CustoVariavelEntity.class);
	}

	public CustoVariavelOutput entityToOutput(CustoVariavelEntity custoVariavelCadastrado) {
		return modelMapper.map(custoVariavelCadastrado, CustoVariavelOutput.class);
	}
}
