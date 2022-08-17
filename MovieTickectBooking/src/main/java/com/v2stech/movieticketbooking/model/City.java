package com.v2stech.movieticketbooking.model;

public class City {

	private int city_id;
	private String city_name;
	private String zipcode;
	private String created_at;
	private String state_id;
	
	
	public int getCity_id() {
		return city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getCreated_at() {
		return created_at;
	}
	public String getState_id() {
		return state_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	
	
	
	
}
