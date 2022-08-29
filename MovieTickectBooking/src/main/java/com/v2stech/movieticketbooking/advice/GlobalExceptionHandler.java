package com.v2stech.movieticketbooking.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.v2stech.movieticketbooking.exception.BindingResultException;
import com.v2stech.movieticketbooking.exception.ErrorDetail;
import com.v2stech.movieticketbooking.exception.InvalidCredentialException;
import com.v2stech.movieticketbooking.exception.InvalidSeatException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BindingResultException.class)
	public ResponseEntity<Map<String, String>> getInvalidFiledException(BindingResultException ex) {
		Map<String, String> errorMessage = new HashMap<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String filedName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errorMessage.put(filedName, message);
		}
		return new ResponseEntity<Map<String, String>>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<String> getInvalidCredentialException(InvalidCredentialException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidSeatException.class)
	public ResponseEntity<String> getInvalidSeatException(InvalidSeatException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalException(Exception exception) {
		ErrorDetail errorDetail = new ErrorDetail(exception.getMessage());
		return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
