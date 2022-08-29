package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CinemaHallDTO {

	private int hallId;
	@NotEmpty(message = "Titles Can not be empty")
	@Size(min = 3,max = 15)
	private String hallName;
	@NotNull(message = "Total Seat Can not be empty")
	private Integer totalSeat;
	@NotEmpty(message = "Address Can not be empty")
	@Size(min = 3,max = 15)
	private String address;
	private int cityId;
	@JsonProperty(value = "stateId")
	private Integer state_id;
	@NotEmpty(message = "City Name Can not be empty")
	private String cityName;
	@NotNull(message = "State Name Can not be empty")
	private String stateName;

}
