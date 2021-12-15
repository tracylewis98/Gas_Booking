package com.gasbooking.exception;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		HashMap<String,String> errorsmessage=new HashMap<String,String>();
		
		ex.getBindingResult().getAllErrors().forEach((errors)->{
			String fieldName=((FieldError)errors).getField();
			String message=errors.getDefaultMessage();
			
			errorsmessage.put(fieldName, message);
			
			
		});
		return new ResponseEntity<Object>(errorsmessage,HttpStatus.BAD_REQUEST);
	}
}