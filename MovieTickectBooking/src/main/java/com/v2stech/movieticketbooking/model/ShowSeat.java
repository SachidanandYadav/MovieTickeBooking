package com.v2stech.movieticketbooking.model;

import java.sql.Time;

public class ShowSeat {

	private int showSeat_id;
	private int price;
	private int cinemaSeat_id;
	private String show_Date;
	private String seatStatus_Type;
	private int seat;
	private Time startTime;
	private Time endTime;
	private int seatStatus_id;
	private String seatName;
	
	
	
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public int getShowSeat_id() {
		return showSeat_id;
	}
	public int getPrice() {
		return price;
	}
	public int getCinemaSeat_id() {
		return cinemaSeat_id;
	}
	public String getShow_Date() {
		return show_Date;
	}
	public String getSeatStatus_Type() {
		return seatStatus_Type;
	}
	public int getSeat() {
		return seat;
	}
	public Time getStartTime() {
		return startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public int getSeatStatus_id() {
		return seatStatus_id;
	}
	public void setShowSeat_id(int showSeat_id) {
		this.showSeat_id = showSeat_id;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCinemaSeat_id(int cinemaSeat_id) {
		this.cinemaSeat_id = cinemaSeat_id;
	}
	public void setShow_Date(String show_Date) {
		this.show_Date = show_Date;
	}
	public void setSeatStatus_Type(String seatStatus_Type) {
		this.seatStatus_Type = seatStatus_Type;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public void setSeatStatus_id(int seatStatus_id) {
		this.seatStatus_id = seatStatus_id;
	}
	

	
	
	
	
	
	
	
}
