package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserCredentialsDTO {

	@NotEmpty(message="User Name Can not be empty")
	@JsonProperty(value = "username")
	private String userName;
	@NotEmpty(message="Password Can not be empty")
	private String password;
	private int isAdmin;
	
	

	

	
	
	
	
	
	
}
