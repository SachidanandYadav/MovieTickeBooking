package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class CinemaSeatDTO {

	@JsonProperty(value = "cinemaSeatId")
	private int cinemaSeat_id;
	@NotNull(message = "Seat Can not be empty")
	private Integer seat;
	@NotEmpty(message = "Hall Name Can not be empty")
	private String hallName;
	private String hallId;
	private String seatName;
	@NotNull(message = "Seat Type Can not be empty")
	@JsonProperty(value = "seatTypeId")
	private Integer seatType_id;
	private int price;
	private int totalPrice;
	@NotNull(message = "City Can not be empty")
	@JsonProperty(value = "cityId")
	private Integer city_id;
	
	
}
