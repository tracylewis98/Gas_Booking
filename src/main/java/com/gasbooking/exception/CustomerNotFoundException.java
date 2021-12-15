package com.gasbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3095106509768620219L;

	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}