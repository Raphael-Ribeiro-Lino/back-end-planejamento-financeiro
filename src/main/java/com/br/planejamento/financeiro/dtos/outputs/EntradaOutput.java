package com.br.planejamento.financeiro.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaOutput {

	private Long id;
	
	private String tipo;
	
	private Float valor;
}
