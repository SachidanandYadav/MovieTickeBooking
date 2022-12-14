package com.v2stech.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.model.BookedTicketDTO;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class BookedTicketController {


	@Autowired
	MovieTicketBookingService bookingService;
	
	@GetMapping("/booking-page")
	public ModelAndView getBookingPage() {
		return new ModelAndView("adminBookedTicket");
	}
	
	@RequestMapping("/booking-list")
	public List<BookedTicketDTO> getBookedLists() {
		return bookingService.getBookedList();
	}
	
	@DeleteMapping("/delete-booking/{id}")
	public void deleteBooking(@PathVariable int id) {
		bookingService.deleteBooking(id);
	}
	
}
