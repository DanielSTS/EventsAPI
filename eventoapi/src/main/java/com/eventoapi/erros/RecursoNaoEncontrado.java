package com.eventoapi.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontrado extends RuntimeException {
	public RecursoNaoEncontrado(String mensagem) {
		super(mensagem);
	}
}
