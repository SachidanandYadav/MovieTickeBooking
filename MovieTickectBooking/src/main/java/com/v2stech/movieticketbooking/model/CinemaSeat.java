package com.v2stech.movieticketbooking.model;

public class CinemaSeat {

	private int cinemaSeat_id;
	private int seat;
	private String hall_name;
	private String hall_id;
	private String seatName;
	private int seatType_id;
	private int price;
	private int TotalPrice;
	
	
	public int getCinemaSeat_id() {
		return cinemaSeat_id;
	}
	public int getSeat() {
		return seat;
	}
	public String getHall_name() {
		return hall_name;
	}
	public String getHall_id() {
		return hall_id;
	}
	public String getSeatName() {
		return seatName;
	}
	public int getSeatType_id() {
		return seatType_id;
	}
	public int getPrice() {
		return price;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setCinemaSeat_id(int cinemaSeat_id) {
		this.cinemaSeat_id = cinemaSeat_id;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public void setHall_id(String hall_id) {
		this.hall_id = hall_id;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public void setSeatType_id(int seatType_id) {
		this.seatType_id = seatType_id;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}
	
	
	

	
}
