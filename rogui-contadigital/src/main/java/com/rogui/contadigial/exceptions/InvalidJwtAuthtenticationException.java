package com.rogui.contadigial.exceptions;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthtenticationException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public InvalidJwtAuthtenticationException(String exception) {
		super(exception);

	}

}
