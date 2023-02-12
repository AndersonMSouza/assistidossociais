package com.andersonmendes.assistidossociais.domain.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoDeAssitencia {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private FornecerAlimentos fornecerAlimentos;
	
	@Enumerated(EnumType.STRING)
	private NecessitaConsultaMedica necessitaConsultaMedica;
	
	@Enumerated(EnumType.STRING)
	private AviamentoReceitasMedicamentos aviamentoReceitasMedicamentos;
	
	@Enumerated(EnumType.STRING)
	private VerificarEmprego verificarEmprego;
	
	@Enumerated(EnumType.STRING)
	private NecessitaRoupas necessitaRoupas;
	
	@Enumerated(EnumType.STRING)
	private NecessitaAssistenciaJuridica necessitaAssistenciaJuridica;
	
	@Enumerated(EnumType.STRING)
	private EncaminhamentoAposentadoria encaminhamentoAposentadoria;
	
	@Enumerated(EnumType.STRING)
	private EncaminhamentoSebem encaminhamentoSebem;
	
	@Enumerated(EnumType.STRING)
	private Outros outros;
	
	private String quais;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate sindicancia;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate admissao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate promocao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate recusa;
	
	private String sindicanciaRealizadaPor; 
	
	
}
