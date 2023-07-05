package com.andersonmendes.assistidossociais.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SituacaoEconomicaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public SituacaoEconomicaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public SituacaoEconomicaNaoEncontradaException(Long situacaoEconomicaId) {
		this(String.format("Não existe um cadastro de situação economica com código %d", situacaoEconomicaId));
	}
	
}