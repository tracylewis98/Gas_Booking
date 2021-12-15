package com.gasbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GasBookingNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3290797084368181452L;

	public GasBookingNotFoundException(String msg) {
		super(msg);
	}
}