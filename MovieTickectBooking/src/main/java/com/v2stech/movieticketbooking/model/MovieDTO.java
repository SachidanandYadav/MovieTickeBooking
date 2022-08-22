package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class MovieDTO {
	
	@JsonProperty(value = "movieId")
	private int movie_id;
	private String title;
	private String description;
	private String duration;
	private String language;
    private String releaseDate;
	private String genre;
	@JsonProperty(value = "countryName")
	private String country_name;
	private String imageUrl;
	
	}
