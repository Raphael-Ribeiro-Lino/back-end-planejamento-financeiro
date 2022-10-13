package com.br.planejamento.financeiro.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.planejamento.financeiro.entities.CustoFixoEntity;
import com.br.planejamento.financeiro.exceptions.NotFoundBussinessException;
import com.br.planejamento.financeiro.repositories.CustoFixoRepository;

@Service
public class CustoFixoService {

	@Autowired
	private CustoFixoRepository custoFixoRepository;

	@Transactional
	public CustoFixoEntity cadastra(CustoFixoEntity custoFixoEntity) {
		return custoFixoRepository.save(custoFixoEntity);
	}

	public List<CustoFixoEntity> listaTodos() {
		return custoFixoRepository.findAll();
	}

	public CustoFixoEntity buscaPorId(Long id) {
		return custoFixoRepository.findById(id).orElseThrow(() -> new NotFoundBussinessException("Custo fixo não encontrado"));
	}

	@Transactional
	public CustoFixoEntity altera(CustoFixoEntity custoFixoEncontrado) {
		return custoFixoRepository.save(custoFixoEncontrado);
	}
}
