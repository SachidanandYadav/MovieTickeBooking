package com.v2stech.movieticketbooking.model;

public class CinemaHall {

	private int hall_id;
	private String hall_name;
	private int total_seat;
	private String address;
	private int city_id;
	private int state_id;
	private String city_name;
	private String state_name;
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public int getHall_id() {
		return hall_id;
	}
	public String getHall_name() {
		return hall_name;
	}

	public int getTotal_seat() {
		return total_seat;
	}
	public String getAddress() {
		return address;
	}
	public String getCity_name() {
		return city_name;
	}
	public String getState_name() {
		return state_name;
	}
	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	
	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	

}
