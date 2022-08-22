package com.v2stech.movieticketbooking.model;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class BookedTicketDTO {

	@JsonProperty(value = "bookingId")
	private int booking_id;
	private int seat;
	@JsonProperty(value = "bookingTime")
	private String booking_time;
	@JsonProperty(value = "userName")
	private String user_name;
	@JsonProperty(value = "showDate")
	private String show_date;
	private Integer amount;
	private int methodId;
	@JsonProperty(value = "userId")
	private int user_Id;
	private Time startTime;
	@JsonProperty(value = "paymentType")
	private String paymentStatus_Type;
	@JsonProperty(value = "paymentTime")
	private String payment_time;
	private String methodType;
	
}

