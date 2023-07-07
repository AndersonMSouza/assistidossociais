package com.andersonmendes.assistidossociais.domain.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.andersonmendes.assistidossociais.domain.enums.AviamentoReceitasMedicamentos;
import com.andersonmendes.assistidossociais.domain.enums.EncaminhamentoAposentadoria;
import com.andersonmendes.assistidossociais.domain.enums.EncaminhamentoSebem;
import com.andersonmendes.assistidossociais.domain.enums.FornecerAlimentos;
import com.andersonmendes.assistidossociais.domain.enums.NecessitaAssistenciaJuridica;
import com.andersonmendes.assistidossociais.domain.enums.NecessitaConsultaMedica;
import com.andersonmendes.assistidossociais.domain.enums.NecessitaRoupas;
import com.andersonmendes.assistidossociais.domain.enums.Outros;
import com.andersonmendes.assistidossociais.domain.enums.VerificarEmprego;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

//@Data
//@Entity
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Embeddable
public class TipoDeAssistencia {

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
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
	
//	@ManyToOne
//	@JoinColumn(nullable = false)
//	private Pessoa pessoa;
}
