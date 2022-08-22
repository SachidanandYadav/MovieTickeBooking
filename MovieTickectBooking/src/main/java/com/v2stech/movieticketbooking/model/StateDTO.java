package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class StateDTO {

	@JsonProperty(value = "stateId")
	private int state_id;
	@JsonProperty(value = "stateName")
	private String state_name;
	
}
