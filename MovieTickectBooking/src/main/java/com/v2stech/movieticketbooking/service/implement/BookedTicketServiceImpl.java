package com.v2stech.movieticketbooking.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2stech.movieticketbooking.dao.MovieTickectBookingDAO;
import com.v2stech.movieticketbooking.model.BookedTicketDTO;
import com.v2stech.movieticketbooking.service.BookedTicketService;

@Service
public class BookedTicketServiceImpl implements BookedTicketService{
	@Autowired
	MovieTickectBookingDAO movieTickectBookingDAO;

	@Override
	public List<BookedTicketDTO> getBookedList() {
		return movieTickectBookingDAO.getBookedLists();
	}

	@Override
	public void deleteBooking(int id) {
		movieTickectBookingDAO.deleteBookings(id);
	}
	
	@Override
	public List<BookedTicketDTO> getAllPayments() {
		return movieTickectBookingDAO.getAllPayment();
	}
	
	@Override
	public List<BookedTicketDTO> getBookingHistoryLists(String userName) {
		return movieTickectBookingDAO.getBookingHistoryList(userName);
	}

	
	@Override
	public void deletePayment(int id) {
		movieTickectBookingDAO.deletePaymentById(id);
	}
	
}
