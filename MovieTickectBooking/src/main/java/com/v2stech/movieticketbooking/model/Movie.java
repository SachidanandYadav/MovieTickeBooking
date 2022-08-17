package com.v2stech.movieticketbooking.model;

public class Movie {
	
	private int movie_id;
	private String title;
	private String description;
	private String duration;
	private String language;
    private String releaseDate;
	private String genre;
	private String country_name;
	private String imageUrl;
	
	public int getMovie_id() {
		return movie_id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getDuration() {
		return duration;
	}
	public String getLanguage() {
		return language;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public String getGenre() {
		return genre;
	}
	public String getCountry_name() {
		return country_name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	
	
	
}
