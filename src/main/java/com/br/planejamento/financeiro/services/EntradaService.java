package com.br.planejamento.financeiro.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.planejamento.financeiro.entities.EntradaEntity;
import com.br.planejamento.financeiro.exceptions.NotFoundBussinessException;
import com.br.planejamento.financeiro.repositories.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;

	public EntradaEntity cria(EntradaEntity entradaEntity) {
		return entradaRepository.save(entradaEntity);
	}

	public List<EntradaEntity> listaTodas() {
		return entradaRepository.findAll();
	}

	public EntradaEntity buscaPorId(Long id) {
		return entradaRepository.findById(id).orElseThrow(()-> new NotFoundBussinessException("Entrada não encontrada"));
	}

	public EntradaEntity altera(EntradaEntity entradaEncontrada) {
		return entradaRepository.save(entradaEncontrada);
	}
}
