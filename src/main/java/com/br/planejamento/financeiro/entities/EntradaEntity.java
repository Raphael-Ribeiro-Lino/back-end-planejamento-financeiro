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
@Table(name = "tb_entradas")
@Getter
@Setter
public class EntradaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tipo", nullable = true, length = 100)
	private String tipo;
	
	@Column(name = "valor", nullable = true)
	private Float valor;
	
}
