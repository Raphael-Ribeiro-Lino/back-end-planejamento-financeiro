package com.br.planejamento.financeiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.planejamento.financeiro.entities.EntradaEntity;
import com.br.planejamento.financeiro.repositories.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;

	public EntradaEntity cria(EntradaEntity entradaEntity) {
		return entradaRepository.save(entradaEntity);
	}
}
