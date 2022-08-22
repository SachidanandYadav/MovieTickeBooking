package com.v2stech.movieticketbooking.dao;

import java.util.List;

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

public interface MovieTickectBookingDAO {

	void saveCustomerDatas(CustomerDTO customer);

	List<CountryDTO> getCountryDatas();

	List<MovieDTO> getMovieDetail();

	MovieDTO getMovieByIds(String id);

	List<CityDTO> getCityData();

	void deleteBookings(int id);

	List<BookedTicketDTO> getBookedLists();

	List<CinemaHallDTO> getCinemaHallLists(int id);

	List<MovieShowDTO> getMovieShowDetails();

	MovieShowDTO getMovieShowByIds(int id);

	void deleteMovies(String id);

	void addMovieShow(MovieShowDTO movieShow);

	void updateMovieShows(MovieShowDTO movieShow);

	void deleteMovieShow(int id);

	List<StateDTO> getStateData();

	List<CinemaHallDTO> getCinemaHallList();

	CinemaHallDTO getSingleCinemaHall(int id);

	List<CityDTO> getCityList(int id);

	void addCinemaHall(CinemaHallDTO cinemaHall);

	void updateCinemaHall(CinemaHallDTO cinemaHall);

	void deleteCinemaHall(int id);

	void addMovie(MovieDTO movie);

	void updateMovie(MovieDTO movie);

	List<CinemaSeatDTO> getCinemaSeatList();

	CinemaSeatDTO getSingleCinemaSeat(int id);

	List<CinemaSeatDTO> getCinemaSeatType();

	void addCinemaSeat(CinemaSeatDTO cinemaSeat);

	void updateCinemaSeat(CinemaSeatDTO cinemaSeat);

	void deleteCinemaSeat(int id);

	List<ShowSeatDTO> getShowSeatList();

	List<SeatStatusDTO> getSeatStatus();

	List<ShowSeatDTO> getShowSeatDetail(int id);

	ShowSeatDTO getSingleShowSeat(int id);

	// void addShowSeat(ShowSeat showSeat);

	void deleteShowSeat(int id);
	
	List<MovieShowDTO> getMovieShowByHallId(int id,String title);
	
	CinemaSeatDTO getTotalSeat(int seatType);
	
	List<PaymentMethodDTO> getPaymentMethod();
	
	void setBookingDetail(BookedTicketDTO bookedTicket,int showId,int totalSeat);
	
	List<BookedTicketDTO> getBookingHistoryList(String userName);
	
	BookedTicketDTO getPaymentDetail( int bookingId);
	
	CustomerDTO getUserProfile(String userName);
	
	void getUpdateCustomer(CustomerDTO customer);
	
	
	
	
	

}
