package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class CinemaHallDTO {

	@JsonProperty(value = "hallId")
	private int hall_id;
	@JsonProperty(value = "hallName")
	private String hall_name;
	@JsonProperty(value = "totalSeat")
	private int total_seat;
	private String address;
	@JsonProperty(value = "cityId")
	private int city_id;
	@JsonProperty(value = "stateId")
	private int state_id;
	@JsonProperty(value = "cityName")
	private String city_name;
	@JsonProperty(value = "stateName")
	private String state_name;
	
}
