package com.br.planejamento.financeiro.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.planejamento.financeiro.entities.CustoVariavelEntity;
import com.br.planejamento.financeiro.exceptions.NotFoundBussinessException;
import com.br.planejamento.financeiro.repositories.CustoVariavelRepository;

@Service
public class CustoVariavelService {

	@Autowired
	private CustoVariavelRepository custoVariavelRepository;

	@Transactional
	public CustoVariavelEntity cadastra(CustoVariavelEntity custoVariavelEntity) {
		return custoVariavelRepository.save(custoVariavelEntity);
	}

	public List<CustoVariavelEntity> listaTodos() {
		return custoVariavelRepository.findAll();
	}

	public CustoVariavelEntity buscaPorId(Long id) {
		return custoVariavelRepository.findById(id).orElseThrow(() -> new NotFoundBussinessException("Custo variável não encontrado"));
	}

	@Transactional
	public CustoVariavelEntity altera(CustoVariavelEntity custoVariavelEncontrado) {
		return custoVariavelRepository.save(custoVariavelEncontrado);
	}
}
