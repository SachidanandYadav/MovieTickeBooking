package com.v2stech.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.model.BookedTicketDTO;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

/**
 * @author Sachidanand Yadav
 *
 */
@RestController
public class BookedTicketController {


	@Autowired
	MovieTicketBookingService bookingService;
	
	/**
	 * @return
	 * return Admin booked Ticket Page.
	 */
	@GetMapping("/booking-page")
	public ModelAndView getBookingPage() {
		return new ModelAndView("adminBookedTicket");
	}
	
	/**
	 * @return List
	 * return Booked Ticket List.
	 */
	@RequestMapping("/booking-list")
	public List<BookedTicketDTO> getBookedLists() {
		return bookingService.getBookedList();
	}
	
	/**
	 * @param id
	 * Delete Booking by Id.
	 */
	@DeleteMapping("/delete-booking/{id}")
	public void deleteBooking(@PathVariable int id) {
		bookingService.deleteBooking(id);
	}
	
	/**
	 * @param model
	 * @param bookedTicketDTO
	 * @return Admin Payment Page.
	 */
	@GetMapping("/payment-page")
	public ModelAndView getPaymentPage(Model model,BookedTicketDTO bookedTicketDTO) {
		model.addAttribute("paymentList", bookingService.getAllPayments());
		return new ModelAndView("adminPaymentPage");
	}
	
	
	/**
	 * @param id
	 * @param model
	 * @return Admin Payment Page
	 * Delete Payment By Payment Id;
	 */
	@PostMapping("/payment")
	public ModelAndView deletePayment(@RequestParam("paymentid") int id ,Model model) {
		bookingService.deletePayment(id);
		model.addAttribute("paymentList", bookingService.getAllPayments());
		return new ModelAndView("adminPaymentPage");
	}
}
