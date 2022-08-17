package com.v2stech.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.model.CinemaHall;
import com.v2stech.movieticketbooking.model.MovieShow;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class MovieShowController {

	@Autowired
	MovieTicketBookingService bookingService;

	@RequestMapping("/cinemaHallList/{cityId}")
	public List<CinemaHall> getCinemaHallList(@PathVariable("cityId") int id) {
		return  bookingService.getCinemaHallList(id);
	}
	
	@RequestMapping("/movieShow")
	public ModelAndView getMovieShowDetail(Model model) {
		bookingService.getMovieShowLists();	
		model.addAttribute("cityList",bookingService.getCityDatas());
		model.addAttribute("movieList",bookingService.getMovieDetails());
		return new ModelAndView("adminMovieShow");
	}
	
	@RequestMapping("/movieShowList")
	public List<MovieShow> getMovieShowLists() {
		return bookingService.getMovieShowLists();
	}
	

	@RequestMapping("/movieShow/{id}")
	public List<MovieShow> getSingleMovieShow(@PathVariable("id") int id) {
		return  bookingService.getMovieShowById(id);
	}
	
	@PostMapping("/MovieShow")
	public void movieShow(@RequestBody MovieShow movieShow) {
		bookingService.movieShow(movieShow);
	}


	@DeleteMapping("/DeleteMovieShow/{id}")
	public void deleteMovieShow(@PathVariable int id) {
		bookingService.deleteMovieShows(id);
	}
	
}
