package com.abc.ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(Exception ex){
		ResponseEntity<String> responseEntity=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(Exception ex){
		ResponseEntity<String> responseEntity=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(Exception ex){
		ResponseEntity<String> responseEntity=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	
	}
}