package org.zer0.pocs.springreactive.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonaNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5522368114807396802L;

	public PersonaNotFoundException(String personaId) {
		super("No se encuentra persona con id: '" + personaId + "'.");
	}
	
}
