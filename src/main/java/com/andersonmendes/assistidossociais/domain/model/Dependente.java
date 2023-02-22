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
public class Dependente {

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	private String nomeCompleto;
	private String dataNascimento;
	private String relacao;
	private String ocupacao;
	
//	@ManyToOne
//	@JoinColumn(nullable = false)
//	private Pessoa pessoa;
	
}
