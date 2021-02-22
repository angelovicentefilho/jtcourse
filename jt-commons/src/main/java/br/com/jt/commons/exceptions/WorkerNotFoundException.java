package br.com.jt.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WorkerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2858378874566371761L;

	public WorkerNotFoundException(String message) {
		super(message);
	}
	

}
