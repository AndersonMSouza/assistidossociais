package com.andersonmendes.assistidossociais.domain.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

//@Data
//@Entity
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Embeddable
public class Parecer {

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
	private String descrever;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate primeiraVisita;
	
	private String relatoPrimeiraVisita;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ultimaVisita;

	private String relatoUltimaVisita;
	
//	@ManyToOne
//	@JoinColumn(nullable = false)
//	private Pessoa pessoa;
		
}
