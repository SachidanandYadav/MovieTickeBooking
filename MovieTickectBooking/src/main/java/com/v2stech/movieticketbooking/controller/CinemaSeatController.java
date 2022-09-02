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
import com.v2stech.movieticketbooking.model.CinemaSeatDTO;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

/**
 * @author Sachidanand Yadav
 *
 */
@RestController
public class CinemaSeatController {

	@Autowired
	MovieTicketBookingService bookingService;
	
	/**
	 * @param model
	 * @return Admin Cinema Seat.
	 * 
	 */
	@RequestMapping("/cinema-seat")
	public ModelAndView getcinemaSeatDeatil(Model model) {
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("seatType", bookingService.getCinemaSeatTypes());
		return new ModelAndView("adminCinemaSeat");
	}
	
	
	/**
	 * @return Cinema Seat List.
	 */
	@RequestMapping("/cinema-seat-list")
	public List<CinemaSeatDTO> getCinemaSeatList() {
		return bookingService.getCinemaSeatLists();
	}
	
	
	/**
	 * @param id
	 * @return Single Cinema Seat List By Cinema Seat Id.
	 */
	@RequestMapping("/cinema-seat/{id}")
	public CinemaSeatDTO getSingleCinemaSeat(@PathVariable("id") int id) {
		return  bookingService.getSingleCinemaSeats(id);
	}
	

	/**
	 * @param cinemaSeat
	 * @param result
	 * @throws BindingResultException
	 * Add & Update  Cinema Seat List .
	 */
	@PostMapping("/cinema-seats")
	public void cinemaHall(@Valid @RequestBody CinemaSeatDTO cinemaSeat,BindingResult result) throws BindingResultException  {
		if (result.hasErrors()) {
			throw new BindingResultException(result);
		} else {	
			bookingService.cinemaSeats(cinemaSeat);
		}
	}

	/**
	 * @param id
	 * Deleting Cinema Seat by Id.
	 */
	@DeleteMapping("/delete-cinema-seat/{id}")
	public void deleteCinemaSeat(@PathVariable int id) {
		bookingService.deleteCinemaSeats(id);
	}
	
}
