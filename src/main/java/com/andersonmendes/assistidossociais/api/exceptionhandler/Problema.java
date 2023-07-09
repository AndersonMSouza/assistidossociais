package com.andersonmendes.assistidossociais.api.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problema {

	private LocalDateTime dataHora;;
	private String mensagem;
}
