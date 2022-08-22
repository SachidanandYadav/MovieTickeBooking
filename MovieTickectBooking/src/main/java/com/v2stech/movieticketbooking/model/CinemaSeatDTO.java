package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class CinemaSeatDTO {

	@JsonProperty(value = "cinemaSeatId")
	private int cinemaSeat_id;
	private int seat;
	@JsonProperty(value = "hallName")
	private String hall_name;
	@JsonProperty(value = "hallId")
	private String hall_id;
	private String seatName;
	@JsonProperty(value = "seatTypeId")
	private int seatType_id;
	private int price;
	@JsonProperty(value = "totalPrice")
	private int TotalPrice;
	
	
}
