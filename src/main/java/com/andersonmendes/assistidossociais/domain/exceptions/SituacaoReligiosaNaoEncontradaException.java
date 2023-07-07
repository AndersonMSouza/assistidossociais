package com.andersonmendes.assistidossociais.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SituacaoReligiosaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public SituacaoReligiosaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public SituacaoReligiosaNaoEncontradaException(Long situacaoReligiosaId) {
		this(String.format("Não existe um cadastro de situação religiosa com código %d", situacaoReligiosaId));
	}
	
}