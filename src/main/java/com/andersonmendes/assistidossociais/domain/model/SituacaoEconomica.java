package com.andersonmendes.assistidossociais.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SituacaoEconomica {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String situacaoEconomica;
	private String casa;
	private String rendaFamiliar;
	private String explicacaoRenda;
	private String escolaridade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
}
