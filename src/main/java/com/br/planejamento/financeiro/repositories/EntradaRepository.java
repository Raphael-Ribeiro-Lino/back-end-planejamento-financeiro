package com.br.planejamento.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.planejamento.financeiro.entities.EntradaEntity;

@Repository
public interface EntradaRepository extends JpaRepository<EntradaEntity, Long>{

}
