package com.andersonmendes.assistidossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonmendes.assistidossociais.domain.model.SituacaoEconomica;

@Repository
public interface SituacaoEconomicaRepository extends JpaRepository<SituacaoEconomica, Long>{

}
