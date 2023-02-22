package com.andersonmendes.assistidossociais.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class Pessoa {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCompleto;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String telefone;
	private String pontoReferencia;
	private String cpf;
	private String rg;
	private String estadoCivil;
	private String dataNascimento;
	private String profissao;
	private String nomeConjuge;
	private String dataNascimentoConjuge;
	private String profissaoConjuge;
	private String telefoneConjuge;
	
}
