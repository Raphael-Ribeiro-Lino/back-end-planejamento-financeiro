package com.br.planejamento.financeiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.planejamento.financeiro.repositories.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
}
