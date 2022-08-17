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

import com.v2stech.movieticketbooking.model.CinemaSeat;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class CinemaSeatController {

	@Autowired
	MovieTicketBookingService bookingService;
	
	@RequestMapping("/cinemaSeat")
	public ModelAndView getcinemaSeatDeatil(Model model) {
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("seatType", bookingService.getCinemaSeatTypes());
		return new ModelAndView("adminCinemaSeat");
	}
	
	
	@RequestMapping("/cinemaSeatList")
	public List<CinemaSeat> getCinemaSeatList() {
		return bookingService.getCinemaSeatLists();
	}
	
	
	@RequestMapping("/cinemaSeat/{id}")
	public List<CinemaSeat> getSingleCinemaSeat(@PathVariable("id") int id) {
		return  bookingService.getSingleCinemaSeats(id);
	}
	

	@PostMapping("/CinemaSeat")
	public void cinemaHall(@RequestBody CinemaSeat cinemaSeat) {
		bookingService.CinemaSeats(cinemaSeat);
	}

	@DeleteMapping("/DeleteCinemaSeat/{id}")
	public void deleteCinemaSeat(@PathVariable int id) {
		bookingService.deleteCinemaSeats(id);
	}
	
}
