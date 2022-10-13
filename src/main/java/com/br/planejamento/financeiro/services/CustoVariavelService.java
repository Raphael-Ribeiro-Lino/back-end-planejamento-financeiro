package com.br.planejamento.financeiro.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.planejamento.financeiro.entities.CustoVariavelEntity;
import com.br.planejamento.financeiro.repositories.CustoVariavelRepository;

@Service
public class CustoVariavelService {

	@Autowired
	private CustoVariavelRepository custoVariavelRepository;

	@Transactional
	public CustoVariavelEntity cadastra(CustoVariavelEntity custoVariavelEntity) {
		return custoVariavelRepository.save(custoVariavelEntity);
	}
}
