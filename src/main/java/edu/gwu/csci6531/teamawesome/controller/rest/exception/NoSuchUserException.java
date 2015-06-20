package edu.gwu.csci6531.teamawesome.controller.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Incorrect username or password.")
public class NoSuchUserException extends RuntimeException {

	private static final long serialVersionUID = -7379288195009389842L;

}
