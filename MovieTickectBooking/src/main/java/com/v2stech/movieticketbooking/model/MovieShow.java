package com.v2stech.movieticketbooking.model;

public class MovieShow {
	
	private int show_id;
	private String show_date;
	private String startTime;
	private String  endTime;
	private String hall_name;
	private String title;
	private String description;
	private String language;
	
	
	public int getShow_id() {
		return show_id;
	}
	public String getShow_date() {
		return show_date;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public String getHall_name() {
		return hall_name;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getLanguage() {
		return language;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public void setShow_date(String show_date) {
		this.show_date = show_date;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
