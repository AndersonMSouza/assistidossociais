package com.andersonmendes.assistidossociais.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FormularioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FormularioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public FormularioNaoEncontradoException(Long formularioId) {
		this(String.format("Não existe um cadastro de formulario com código %d", formularioId));
	}
	
}