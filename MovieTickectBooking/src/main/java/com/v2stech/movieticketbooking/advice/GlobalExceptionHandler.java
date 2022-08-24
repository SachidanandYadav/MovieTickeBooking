package com.v2stech.movieticketbooking.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.v2stech.movieticketbooking.exception.InvalidCredentialException;
import com.v2stech.movieticketbooking.exception.InvalidFiledException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidFiledException.class)
	public ResponseEntity<Map<String, String>> getInvalidFiledException(InvalidFiledException ex) {
		Map<String, String> errorMessage = new HashMap<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String filedName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errorMessage.put(filedName, message);
		}
		return new ResponseEntity<Map<String, String>>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<String> getInvalidCredentialException(InvalidCredentialException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}
