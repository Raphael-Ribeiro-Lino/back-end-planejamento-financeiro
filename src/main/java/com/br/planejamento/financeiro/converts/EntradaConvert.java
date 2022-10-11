package com.br.planejamento.financeiro.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntradaConvert {

	@Autowired
	private ModelMapper modelMapper;
}
