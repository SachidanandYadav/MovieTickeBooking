package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class MovieShowDTO {
	
	@JsonProperty(value = "showId")
	private int show_id;
	@JsonProperty(value = "showDate")
	private String show_date;
	private String startTime;
	private String  endTime;
	@JsonProperty(value = "hallName")
	private String hall_name;
	private String title;
	private String description;
	private String language;
	
}
