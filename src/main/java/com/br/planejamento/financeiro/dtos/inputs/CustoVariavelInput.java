package com.br.planejamento.financeiro.dtos.inputs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustoVariavelInput {

	@NotBlank(message = "O atributo nome é obrigatório")
	@Length(max = 100, message = "O atributo nome pode ter no máximo 100 caracteres")
	private String nome;
	
	@NotNull(message = "O atributo valor é obrigatório")
	private Float valor;
}
