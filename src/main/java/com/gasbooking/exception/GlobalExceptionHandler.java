package com.gasbooking.exception;

import java.time.LocalDateTime;
import java.util.InputMismatchException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InputMismatchException.class)
	public ResponseEntity<?> inputMismatchException(InputMismatchException im, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), im.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<?> numberFormatException(NumberFormatException nfe, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), nfe.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<?> adminNotFoundException(AdminNotFoundException ae, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ae.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> customerNotFoundException(CustomerNotFoundException ce, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ce.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GasBookingNotFoundException.class)
	public ResponseEntity<?> gasBookingNotFoundException(GasBookingNotFoundException ge, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ge.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SurrenderCylinderNotFoundException.class)
	public ResponseEntity<?> surrenderCylinderNotFound(SurrenderCylinderNotFoundException se, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), se.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BankNotFoundException.class)
	public ResponseEntity<?> bankNotFoundException(BankNotFoundException be, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), be.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}