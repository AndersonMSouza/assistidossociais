package com.andersonmendes.assistidossociais.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class FormularioAssistidos {
	
	@Embedded
	private Pessoa pessoa;
	
	@Embedded
	private Dependente dependente;
	
	@Embedded
	private SituacaoEconomica situacaoEconomica;
	
	@Embedded
	private SituacaoReligiosa situacaoReligiosa;
	
	@Embedded
	private TipoDeAssistencia tipoDeAssitencia;
	
	@Embedded
	private Parecer parecer;

}
