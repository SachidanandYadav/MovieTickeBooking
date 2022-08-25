package com.v2stech.movieticketbooking.model;

import java.sql.Time;

import lombok.Data;

@Data
public class BookedTicketDTO {

	private int bookingId;
	private int seat;
	private String bookingTime;
	private String userName;
	private String showDate;
	private Integer amount;
	private int methodId;
	private int userId;
	private Time startTime;
	private String paymentType;
	private String paymentTime;
	private String methodType;
	
}

