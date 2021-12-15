package com.gasbooking.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BankNotFoundException  extends Exception{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 8819628847380077213L;

public BankNotFoundException(String msg) {
	   super(msg);
   }
}