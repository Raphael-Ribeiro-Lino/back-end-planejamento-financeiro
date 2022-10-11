package com.br.planejamento.financeiro.dtos.inputs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaInput {

	@NotBlank(message = "O atributo tipo é obrigatório")
	@Length(max = 100)
	private String tipo;
	
	@NotNull(message = "O atributo valor é obrigatório")
	private Float valor;
}
