package com.eventoapi.erros;

/** Classe referente ao tratamento de erro, para a situação em que o recurso desejado
* não foi encontrado, retornando então uma mensagem e o status http relacionado.
* @author Daniel Júnior
*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontrado(String mensagem) {
		super(mensagem);
	}
}
