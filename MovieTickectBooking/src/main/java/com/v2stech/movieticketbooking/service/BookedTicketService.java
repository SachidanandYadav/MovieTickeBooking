package com.v2stech.movieticketbooking.service;

import java.util.List;

import com.v2stech.movieticketbooking.model.BookedTicketDTO;

public interface BookedTicketService {

	List<BookedTicketDTO> getBookedList();

	void deleteBooking(int id);

	List<BookedTicketDTO> getAllPayments();

	List<BookedTicketDTO> getBookingHistoryLists(String userName);
	
	 void deletePayment(int id);

}