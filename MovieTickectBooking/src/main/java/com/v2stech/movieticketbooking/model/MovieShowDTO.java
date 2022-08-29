package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class MovieShowDTO {
	

	private int showId;

	@NotEmpty(message = "Show Date Can not be empty")
	private String showDate;
	@NotEmpty(message = "Start Time Can not be empty")
	private String startTime;
	@NotEmpty(message = "End Time Can not be empty")
	private String  endTime;
	@NotEmpty(message = "Hall Name Can not be empty")
	private String hallName;
	@NotEmpty(message = "Movie Can not be empty")
	private String title;
	private String description;
	private String language;
	private String cityName;

}
