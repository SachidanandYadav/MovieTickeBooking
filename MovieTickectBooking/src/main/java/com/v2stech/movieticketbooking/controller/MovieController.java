package com.v2stech.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.model.Movie;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class MovieController {

	@Autowired
	MovieTicketBookingService bookingService;
	
	@RequestMapping("/Movie")
	public ModelAndView getMovieDetail(Model model) {
		bookingService.getMovieDetails();
		model.addAttribute("countryList",bookingService.getCountryData());
		return new ModelAndView("AdminMovie");
	}
	
	@RequestMapping("/movieList")
	public List<Movie> getMovieLists() {
		return bookingService.getMovieList();
	}
	
	@RequestMapping("/movie/{movieid}")
	public List<Movie> getSingleMovie(@PathVariable("movieid") String id) {
		return  bookingService.getMovieById(id);
	}
	
	@PostMapping("/Movie")
	public void movie(@RequestBody Movie movie) {
		bookingService.movies(movie);
	}

	
	@DeleteMapping("/DeleteMovie/{id}")
	public void deleteMovie(@PathVariable String id) {
		bookingService.deleteMovie(id);
	}
	
}
