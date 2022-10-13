package com.br.planejamento.financeiro.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustoFixoOutput {

	private Long id;
	
	private String nome;
	
	private Float valor;
}
