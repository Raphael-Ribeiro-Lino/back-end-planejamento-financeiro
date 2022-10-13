package com.br.planejamento.financeiro.converts;

import java.util.List;
import java.util.stream.Collectors;

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

	public List<CustoVariavelOutput> pageEntityToPageOutput(List<CustoVariavelEntity> listaTodos) {
		return listaTodos.stream().map(custoVariavel -> this.entityToOutput(custoVariavel)).collect(Collectors.toList());
	}

	public void copyInputToEntity(CustoVariavelInput custoVariavelInput,
			CustoVariavelEntity custoVariavelEncontrado) {
		modelMapper.map(custoVariavelInput, custoVariavelEncontrado);
	}
}
