package com.andersonmendes.assistidossociais.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class SituacaoReligiosa {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private StatusMatrimonial statusMatrimonial;
	
	@Enumerated(EnumType.STRING)
	private StatusCivil statusCivil;
	
	@Enumerated(EnumType.STRING)
	private FilhosBatizados filhosBatizados;
	
	private String religiao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
}
