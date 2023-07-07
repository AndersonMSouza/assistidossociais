package com.andersonmendes.assistidossociais.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParecerNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ParecerNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ParecerNaoEncontradoException(Long parecerId) {
		this(String.format("Não existe um cadastro de parecer com código %d", parecerId));
	}
	
}