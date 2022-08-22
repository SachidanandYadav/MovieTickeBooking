package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class CityDTO {

	@JsonProperty(value = "cityId")
	private int city_id;
	@JsonProperty(value = "cityName")
	private String city_name;
	private String zipcode;
	@JsonProperty(value = "stateId")
	private String state_id;
	
	
	
}
