package com.andersonmendes.assistidossociais.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TipoDeAssistenciaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public TipoDeAssistenciaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TipoDeAssistenciaNaoEncontradaException(Long tipoDeAssistenciaId) {
		this(String.format("Não existe um cadastro detipo de assistencia com código %d", tipoDeAssistenciaId));
	}
	
}