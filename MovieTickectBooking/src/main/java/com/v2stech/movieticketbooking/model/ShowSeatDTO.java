package com.v2stech.movieticketbooking.model;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class ShowSeatDTO {

	@JsonProperty(value = "showSeatId")
	private int showSeat_id;
	private int price;
	@JsonProperty(value = "cinemaSeatId")
	private int cinemaSeat_id;
	@JsonProperty(value = "showDate")
	private String show_Date;
	@JsonProperty(value = "seatStatusType")
	private String seatStatus_Type;
	private int seat;
	private Time startTime;
	private Time endTime;
	@JsonProperty(value = "seatStatusId")
	private int seatStatus_id;
	private String seatName;
	
}
