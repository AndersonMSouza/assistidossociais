package com.andersonmendes.assistidossociais.domain.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parecer {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descrever;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate primeiraVisita;
	
	private String relatoPrimeiraVisita;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ultimaVisita;

	private String relatoUltimaVisita;
	
	
		
}
