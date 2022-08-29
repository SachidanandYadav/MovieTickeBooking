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
import com.v2stech.movieticketbooking.model.CinemaHallDTO;
import com.v2stech.movieticketbooking.model.MovieShowDTO;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class MovieShowController {

	@Autowired
	MovieTicketBookingService bookingService;

	@RequestMapping("/cinema-hall-list/{cityId}")
	public List<CinemaHallDTO> getCinemaHallList(@PathVariable("cityId") int id) {
		return  bookingService.getCinemaHallList(id);
	}
	
	@RequestMapping("/movie-show")
	public ModelAndView getMovieShowDetail(Model model) {
		bookingService.getMovieShowLists();	
		model.addAttribute("cityList",bookingService.getCityDatas());
		model.addAttribute("movieList",bookingService.getMovieDetails());
		return new ModelAndView("adminMovieShow");
	}
	
	@RequestMapping("/movie-show-list")
	public List<MovieShowDTO> getMovieShowLists() {
		return bookingService.getMovieShowLists();
	}
	

	@RequestMapping("/movie-show/{id}")
	public MovieShowDTO getSingleMovieShow(@PathVariable("id") int id) {
		return  bookingService.getMovieShowById(id);
	}
	
	@PostMapping("/movie-show")
	public void movieShow(@Valid @RequestBody MovieShowDTO movieShow, BindingResult result) throws BindingResultException {
		if(result.hasErrors()) {
			throw new BindingResultException(result);
		}else {			
			bookingService.movieShow(movieShow);
		}
	}


	@DeleteMapping("/delete-movie-show/{id}")
	public void deleteMovieShow(@PathVariable int id) {
		bookingService.deleteMovieShows(id);
	}
	
}
