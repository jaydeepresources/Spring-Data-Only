package com.boot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.boot.controller.DuplicateProductFoundException;
import com.boot.exceptions.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(ProductNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateProductFoundException.class)
	public ResponseEntity<String> handleDuplicateProductFoundException(DuplicateProductFoundException exception) {
		return new ResponseEntity<String>("Product with same name already exists.", HttpStatus.CONFLICT);
	}

}