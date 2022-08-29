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
import com.v2stech.movieticketbooking.model.CityDTO;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class CinemaHallController {

	@Autowired
	MovieTicketBookingService bookingService;
	
	@RequestMapping("/cinema-hall")
	public ModelAndView getcinemaHallDeatil(Model model) {
		model.addAttribute("stateList",bookingService.getStateDatas());
		return new ModelAndView("adminCinemaHall");
	}
	
	
	@RequestMapping("/cinema-hall-list")
	public List<CinemaHallDTO> getCinemaHallList() {
		return bookingService.getCinemaHallLists();
	}
	
	
	@RequestMapping("/cinema-hall/{id}")
	public CinemaHallDTO getSingleCinemaHall(@PathVariable("id") int id,Model model) {
		model.addAttribute("value",bookingService.getSingleCinemaHalls(id));
		return  bookingService.getSingleCinemaHalls(id);
	}
	
	@RequestMapping("/cinema-state-list/{cityId}")
	public List<CityDTO> getCityList(@PathVariable("cityId") int id) {
		return  bookingService.getCityLists(id);
	}
	
	@PostMapping("/cinema-halls")
	public void cinemaHall(@Valid @RequestBody CinemaHallDTO cinemaHall,BindingResult result) throws BindingResultException {
		if (result.hasErrors()) {
			throw new BindingResultException(result);
		} else {
			bookingService.cinemaHalls(cinemaHall);
		}
	}

	@DeleteMapping("/delete-cinema-hall/{id}")
	public void deleteCinemaHall(@PathVariable int id) {
		bookingService.deleteCinemaHalls(id);
	}
	
	
}
