package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;

@Data
@JsonIgnoreType
public class PaymentMethodDTO {

	private int methodId;
	private String methodType;
	
}
