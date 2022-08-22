package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class CountryDTO {

	@JsonProperty(value = "countryId")
	private int country_id;
	@JsonProperty(value = "countryName")
	private String country_name;	
}
