package com.v2stech.movieticketbooking.service;

import java.util.List;

import com.v2stech.movieticketbooking.exception.InvalidCredentialException;
import com.v2stech.movieticketbooking.exception.InvalidSeatException;
import com.v2stech.movieticketbooking.model.BookedTicketDTO;
import com.v2stech.movieticketbooking.model.CinemaHallDTO;
import com.v2stech.movieticketbooking.model.CinemaSeatDTO;
import com.v2stech.movieticketbooking.model.CityDTO;
import com.v2stech.movieticketbooking.model.CountryDTO;
import com.v2stech.movieticketbooking.model.CustomerDTO;
import com.v2stech.movieticketbooking.model.MovieDTO;
import com.v2stech.movieticketbooking.model.MovieShowDTO;
import com.v2stech.movieticketbooking.model.PaymentMethodDTO;
import com.v2stech.movieticketbooking.model.SeatStatusDTO;
import com.v2stech.movieticketbooking.model.ShowSeatDTO;
import com.v2stech.movieticketbooking.model.StateDTO;
import com.v2stech.movieticketbooking.model.UserCredentialsDTO;

public interface MovieTicketBookingService {

	void saveCustomerData(CustomerDTO customer);

	List<CityDTO> getCityDatas();

	List<StateDTO> getStateDatas();

	List<CountryDTO> getCountryData();

	String getUserCredentials(UserCredentialsDTO credentials) throws InvalidCredentialException;

	List<MovieDTO> getMovieDetails();

	List<MovieDTO> getMovieList();

	MovieDTO getMovieById(String id);

	void movies(MovieDTO movie);

	void deleteMovie(String id);

	MovieDTO getMovieSingleDetail(String movieName);

	List<BookedTicketDTO> getBookedList();

	void deleteBooking(int id);

	List<MovieShowDTO> getMovieShowLists();

	List<CinemaHallDTO> getCinemaHallList(int id);

	MovieShowDTO getMovieShowById(int id);

	void movieShow(MovieShowDTO movieShow);

	void deleteMovieShows(int id);

	List<CinemaHallDTO> getCinemaHallLists();

	CinemaHallDTO getSingleCinemaHalls(int id);

	List<CityDTO> getCityLists(int id);

	void cinemaHalls(CinemaHallDTO cinemaHall);

	void deleteCinemaHalls(int id);

	List<CinemaSeatDTO> getCinemaSeatLists();

	CinemaSeatDTO getSingleCinemaSeats(int id);

	List<CinemaSeatDTO> getCinemaSeatTypes();

	void cinemaSeats(CinemaSeatDTO cinemaSeat);

	void deleteCinemaSeats(int id);

	List<ShowSeatDTO> getShowSeatLists();

	List<SeatStatusDTO> getSeatStatusDetails();

	List<ShowSeatDTO> getShowSeatDetails(int id);

	ShowSeatDTO getSingleShowSeats(int id);

	// void showSeat(ShowSeat showSeat);

	void deleteShowSeats(int id);
	
	List<MovieShowDTO> getMovieShowByHall(int id,String title);
	
	CinemaSeatDTO getTotalSeats(int seatType);
	
	List<PaymentMethodDTO> getPaymentMethods();
	
	void setBookingDetails(BookedTicketDTO bookedTicket) throws InvalidSeatException;
	
	List<BookedTicketDTO> getBookingHistoryLists(String userName);
	
	 BookedTicketDTO getPaymentDetails(int bookingId);
	 
	 CustomerDTO getUserProfiles(String userName);
	 
	 void getUpdateCustomers(CustomerDTO customer,int id);
	 
	 List<BookedTicketDTO> getAllPayments();
	 
	 void deletePayment(int id);
	
	
	//int getTotalSeatPrice(int totalSeat);
	

}
