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

import com.v2stech.movieticketbooking.model.ShowSeat;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

@RestController
public class ShowSeatController {

	
	@Autowired
	MovieTicketBookingService bookingService;
		
	@RequestMapping("/showSeat")
	public ModelAndView getshowSeatDeatil(Model model) {
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("seatStatus", bookingService.getSeatStatusDetails());
		return new ModelAndView("adminShowSeat");
	}
	
	@RequestMapping("/ShowSeatList")
	public List<ShowSeat> getShowSeatList() {
		return bookingService.getShowSeatLists();
	}
	
	
	@RequestMapping("/ShowSeatDetails/{id}")
	public List<ShowSeat> getShowSeatDetail(@PathVariable("id") int id) {
		return bookingService.getShowSeatDetails(id);
	}
	
//	@RequestMapping("/singleShowSeat/{id}")
//	public List<ShowSeat> getSingleShowSeat(@PathVariable("id") int id) {
//		return bookingService.getSingleShowSeats(id);
//	}
	
//	@PostMapping("/addShowSeat")
//	public void addShowSeat(@RequestBody ShowSeat showSeat) {
//		bookingService.showSeat(showSeat);
//	}

	@DeleteMapping("/DeleteShowSeat/{id}")
	public void deleteShowSeat(@PathVariable int id) {
		bookingService.deleteShowSeats(id);
	}	
}
