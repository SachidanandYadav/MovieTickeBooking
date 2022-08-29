package com.v2stech.movieticketbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.exception.BindingResultException;
import com.v2stech.movieticketbooking.model.MovieDTO;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class MovieController {

	@Autowired
	MovieTicketBookingService bookingService;
	
	@RequestMapping("/movie")
	public ModelAndView getMovieDetail(Model model) {
		bookingService.getMovieDetails();
		model.addAttribute("countryList",bookingService.getCountryData());
		return new ModelAndView("AdminMovie");
	}
	
	@RequestMapping("/movie-list")
	public List<MovieDTO> getMovieLists() {
		return bookingService.getMovieList();
	}
	
	@RequestMapping("/movie/{movieid}")
	public MovieDTO getSingleMovie(@PathVariable("movieid") String id) {
		return  bookingService.getMovieById(id);
	}
	
	@PostMapping("/movie-detail")
	public void movie(@Valid @RequestBody MovieDTO movie, BindingResult result) throws BindingResultException {
		if (result.hasErrors()) {
			throw new BindingResultException(result);
		}else {
			bookingService.movies(movie);
		}
		
	}

	
	@DeleteMapping("/delete-movie/{id}")
	public void deleteMovie(@PathVariable String id) {
		bookingService.deleteMovie(id);
	}
	
}
