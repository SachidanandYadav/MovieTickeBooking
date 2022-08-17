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
import com.v2stech.movieticketbooking.model.City;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class CinemaHallController {

	@Autowired
	MovieTicketBookingService bookingService;
	
	@RequestMapping("/cinemaHall")
	public ModelAndView getcinemaHallDeatil(Model model) {
		model.addAttribute("stateList",bookingService.getStateDatas());
		return new ModelAndView("adminCinemaHall");
	}
	
	
	@RequestMapping("/cinemaHallList")
	public List<CinemaHall> getCinemaHallList() {
		return bookingService.getCinemaHallLists();
	}
	
	
	@RequestMapping("/cinemaHall/{id}")
	public List<CinemaHall> getSingleCinemaHall(@PathVariable("id") int id,Model model) {
		model.addAttribute("value",bookingService.getSingleCinemaHalls(id));
		return  bookingService.getSingleCinemaHalls(id);
	}
	
	@RequestMapping("/cinemaStateList/{cityId}")
	public List<City> getCityList(@PathVariable("cityId") int id) {
		return  bookingService.getCityLists(id);
	}
	
	@PostMapping("/CinemaHall")
	public void cinemaHall(@RequestBody CinemaHall cinemaHall) {
		bookingService.cinemaHalls(cinemaHall);
	}

	@DeleteMapping("/DeleteCinemaHall/{id}")
	public void deleteCinemaHall(@PathVariable int id) {
		bookingService.deleteCinemaHalls(id);
	}
	
	
}
