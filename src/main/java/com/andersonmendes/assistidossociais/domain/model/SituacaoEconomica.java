package com.andersonmendes.assistidossociais.domain.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

//@Data
//@Entity
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Embeddable
public class SituacaoEconomica {
//
//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	private String situacaoEconomica;
	private String casa;
	private String rendaFamiliar;
	private String explicacaoRenda;
	private String escolaridade;
	
//	@ManyToOne
//	@JoinColumn(nullable = false)
//	private Pessoa pessoa;
	
}
