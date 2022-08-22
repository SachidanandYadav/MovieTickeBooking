package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
@JsonIgnoreProperties
public class UserCredentialsDTO {

	@NotBlank(message="User Name Can not be empty")
	@JsonProperty(value = "userName")
	private String user_name;
	@NotBlank(message="Password Can not be empty")
	private String password;
	private int isAdmin;
	
	

	

	
	
	
	
	
	
}
