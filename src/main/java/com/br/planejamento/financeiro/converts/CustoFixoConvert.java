package com.br.planejamento.financeiro.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.planejamento.financeiro.dtos.inputs.CustoFixoInput;
import com.br.planejamento.financeiro.dtos.outputs.CustoFixoOutput;
import com.br.planejamento.financeiro.entities.CustoFixoEntity;

@Component
public class CustoFixoConvert {

	@Autowired
	private ModelMapper modelMapper;

	public CustoFixoEntity inputToEntity(CustoFixoInput custoFixoInput) {
		return modelMapper.map(custoFixoInput, CustoFixoEntity.class);
	}

	public CustoFixoOutput entityToOutput(CustoFixoEntity custoFixoCadastrado) {
		return modelMapper.map(custoFixoCadastrado, CustoFixoOutput.class);
	}

	public List<CustoFixoOutput> pageEntityToPageOutput(List<CustoFixoEntity> listaTodos) {
		return listaTodos.stream().map(custoFixo -> this.entityToOutput(custoFixo)).collect(Collectors.toList());
	}
	
}
