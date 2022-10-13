package com.br.planejamento.financeiro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_custos_variaveis")
@Getter
@Setter
public class CustoVariavelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = true, length = 100)
	private String nome;
	
	@Column(name = "valor", nullable = true)
	private Float valor;
}
