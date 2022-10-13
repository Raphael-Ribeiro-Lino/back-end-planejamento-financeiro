package com.br.planejamento.financeiro.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.planejamento.financeiro.entities.CustoFixoEntity;
import com.br.planejamento.financeiro.repositories.CustoFixoRepository;

@Service
public class CustoFixoService {

	@Autowired
	private CustoFixoRepository custoFixoRepository;

	@Transactional
	public CustoFixoEntity cadastra(CustoFixoEntity custoFixoEntity) {
		return custoFixoRepository.save(custoFixoEntity);
	}
}
