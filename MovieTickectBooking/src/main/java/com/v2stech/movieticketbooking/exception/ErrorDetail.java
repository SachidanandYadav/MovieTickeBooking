package com.v2stech.movieticketbooking.exception;

import lombok.Data;

@Data
public class ErrorDetail {
	
	private String message;

	public ErrorDetail(String message) {
		super();
		this.setMessage(message);
	}
	
	

}
