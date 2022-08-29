package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;

@Data
@JsonIgnoreType
public class MovieDTO {
	
	private int movieId;
	@NotEmpty(message = "Titles Can not be empty")
	@Size(min = 3,max = 15)
	private String title;
	@NotEmpty(message = "Description Can not be empty")
	@Size(min = 3,max = 15)
	private String description;
	@NotEmpty(message = "Duration Can not be empty")
	private String duration;
	@NotEmpty(message = "Language Can not be empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Only Alphabets")
	private String language;
	@NotEmpty(message = "Release Date Can not be empty")
    private String releaseDate;
	@NotEmpty(message = "Gener Can not be empty")
	@Pattern(regexp = "^[a-zA-Z/ ]*$", message = "Only Alphabets")
	private String genre;
	@NotEmpty(message = "Country Name Can not be empty")
	private String countryName;
	@NotEmpty(message = "ImageUrl Can not be empty")
	private String imageUrl;
	
	}
