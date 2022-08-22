package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class SeatStatusDTO {

	@JsonProperty(value = "seatStatusId")
	private int seatStatus_id;
	@JsonProperty(value = "seatStatusType")
	private String seatStatus_Type;	
	
}
