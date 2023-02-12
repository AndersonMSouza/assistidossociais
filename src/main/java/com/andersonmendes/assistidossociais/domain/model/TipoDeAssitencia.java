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
public class TipoDeAssitencia {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private FornecerAlimentos fornecerAlimentos;
	private NecessitaConsultaMedica necessitaConsultaMedica;
	private AviamentoReceitasMedicamentos aviamentoReceitasMedicamentos;
	private VerificarEmprego verificarEmprego;
	private NecessitaRoupas necessitaRoupas;
	private NecessitaAssistenciaJuridica necessitaAssistenciaJuridica;
	private EncaminhamentoAposentadoria encaminhamentoAposentadoria;
	private EncaminhamentoSebem encaminhamentoSebem;
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
