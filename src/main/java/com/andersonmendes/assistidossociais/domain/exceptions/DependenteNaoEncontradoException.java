package com.andersonmendes.assistidossociais.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DependenteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public DependenteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public DependenteNaoEncontradoException(Long dependenteId) {
		this(String.format("Não existe um cadastro de dependente com código %d", dependenteId));
	}
	
}