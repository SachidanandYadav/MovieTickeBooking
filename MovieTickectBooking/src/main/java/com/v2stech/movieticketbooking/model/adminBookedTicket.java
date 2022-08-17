package com.v2stech.movieticketbooking.model;


import java.sql.Time;


public class adminBookedTicket {

	private int booking_id;
	private int seat;
	private Time booking_time;
	private String user_name;
	private String show_date;
	private Integer amount;
	private int methodId;
	
	public int getBooking_id() {
		return booking_id;
	}
	public int getSeat() {
		return seat;
	}
	public Time getBooking_time() {
		return booking_time;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getShow_date() {
		return show_date;
	}
	public Integer getAmount() {
		return amount;
	}
	public int getMethodId() {
		return methodId;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public void setBooking_time(Time booking_time) {
		this.booking_time = booking_time;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setShow_date(String show_date) {
		this.show_date = show_date;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}
	
	
	
	

}

