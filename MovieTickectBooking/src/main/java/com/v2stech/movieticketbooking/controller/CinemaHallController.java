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

/**
 * @author Sachidanand Yadav
 *
 */
@RestController
public class CinemaHallController {

	@Autowired
	MovieTicketBookingService bookingService;
	
	/**
	 * @param model
	 * @return Admin Cinema Hall Page.
	 * 
	 */
	@RequestMapping("/cinema-hall")
	public ModelAndView getcinemaHallDeatil(Model model) {
		model.addAttribute("stateList",bookingService.getStateDatas());
		return new ModelAndView("adminCinemaHall");
	}
	
	
	/**
	 * @return Cinema Hall List
	 */
	@RequestMapping("/cinema-hall-list")
	public List<CinemaHallDTO> getCinemaHallList() {
		return bookingService.getCinemaHallLists();
	}
	
	
	/**
	 * @param id
	 * @param model
	 * @return Single Cinema Hall By Hall Id;
	 */
	@RequestMapping("/cinema-hall/{id}")
	public CinemaHallDTO getSingleCinemaHall(@PathVariable("id") int id,Model model) {
		model.addAttribute("value",bookingService.getSingleCinemaHalls(id));
		return  bookingService.getSingleCinemaHalls(id);
	}
	
	/**
	 * @param id
	 * @return Single City Data By city Id;
	 */
	@RequestMapping("/cinema-state-list/{cityId}")
	public List<CityDTO> getCityList(@PathVariable("cityId") int id) {
		return  bookingService.getCityLists(id);
	}
	
	/**
	 * @param cinemaHall
	 * @param result
	 * @throws BindingResultException
	 * Add & Updating Cinema Hall ;
	 */
	@PostMapping("/cinema-halls")
	public void cinemaHall(@Valid @RequestBody CinemaHallDTO cinemaHall,BindingResult result) throws BindingResultException {
		if (result.hasErrors()) {
			throw new BindingResultException(result);
		} else {
			bookingService.cinemaHalls(cinemaHall);
		}
	}

	/**
	 * @param id
	 * Delete Cinema Hall By Id.
	 */
	@DeleteMapping("/delete-cinema-hall/{id}")
	public void deleteCinemaHall(@PathVariable int id) {
		bookingService.deleteCinemaHalls(id);
	}
	
	
}
