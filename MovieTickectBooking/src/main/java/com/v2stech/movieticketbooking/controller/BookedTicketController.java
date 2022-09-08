package com.v2stech.movieticketbooking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.v2stech.movieticketbooking.service.BookedTicketService;

/**
 * @author Sachidanand Yadav
 *
 */
@RestController
public class BookedTicketController {


	@Autowired
	BookedTicketService ticketService;
	
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
		return ticketService.getBookedList();
	}
	
	/**
	 * @param id
	 * Delete Booking by Id.
	 */
	@DeleteMapping("/delete-booking/{id}")
	public void deleteBooking(@PathVariable int id) {
		ticketService.deleteBooking(id);
	}
	
	/**
	 * @param model
	 * @param bookedTicketDTO
	 * @return Admin Payment Page.
	 */
	@GetMapping("/payment-page")
	public ModelAndView getPaymentPage(Model model,BookedTicketDTO bookedTicketDTO) {
		model.addAttribute("paymentList", ticketService.getAllPayments());
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
		ticketService.deletePayment(id);
		model.addAttribute("paymentList", ticketService.getAllPayments());
		return new ModelAndView("adminPaymentPage");
	}
	
	/**
	 * @return Booking History By User Name
	 */
	@RequestMapping("/booking-history-list")
	public List<BookedTicketDTO> getBookingHistoryList(HttpSession session) {
		String userName = (String) session.getAttribute("username");
		return ticketService.getBookingHistoryLists(userName);
	}
}
