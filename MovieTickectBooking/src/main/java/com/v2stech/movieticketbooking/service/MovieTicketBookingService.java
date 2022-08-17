package com.v2stech.movieticketbooking.service;

import java.util.List;

import com.v2stech.movieticketbooking.model.CinemaHall;
import com.v2stech.movieticketbooking.model.CinemaSeat;
import com.v2stech.movieticketbooking.model.City;
import com.v2stech.movieticketbooking.model.Country;
import com.v2stech.movieticketbooking.model.Customer;
import com.v2stech.movieticketbooking.model.Movie;
import com.v2stech.movieticketbooking.model.MovieShow;
import com.v2stech.movieticketbooking.model.PaymentMethod;
import com.v2stech.movieticketbooking.model.SeatStatus;
import com.v2stech.movieticketbooking.model.ShowSeat;
import com.v2stech.movieticketbooking.model.State;
import com.v2stech.movieticketbooking.model.UserCredentials;
import com.v2stech.movieticketbooking.model.adminBookedTicket;

public interface MovieTicketBookingService {

	void saveCustomerData(Customer customer);

	List<City> getCityDatas();

	List<State> getStateDatas();

	List<Country> getCountryData();

	String getUserCredentials(UserCredentials credentials);

	List<Movie> getMovieDetails();

	List<Movie> getMovieList();

	List<Movie> getMovieById(String id);

	void movies(Movie movie);

	void deleteMovie(String id);

	Movie getMovieSingleDetail(String movieName);

	List<adminBookedTicket> getBookedList();

	void deleteBooking(int id);

	List<MovieShow> getMovieShowLists();

	List<CinemaHall> getCinemaHallList(int id);

	List<MovieShow> getMovieShowById(int id);

	void movieShow(MovieShow movieShow);

	void deleteMovieShows(int id);

	List<CinemaHall> getCinemaHallLists();

	List<CinemaHall> getSingleCinemaHalls(int id);

	List<City> getCityLists(int id);

	void cinemaHalls(CinemaHall cinemaHall);

	void deleteCinemaHalls(int id);

	List<CinemaSeat> getCinemaSeatLists();

	List<CinemaSeat> getSingleCinemaSeats(int id);

	List<CinemaSeat> getCinemaSeatTypes();

	void CinemaSeats(CinemaSeat cinemaSeat);

	void deleteCinemaSeats(int id);

	List<ShowSeat> getShowSeatLists();

	List<SeatStatus> getSeatStatusDetails();

	List<ShowSeat> getShowSeatDetails(int id);

	List<ShowSeat> getSingleShowSeats(int id);

	// void showSeat(ShowSeat showSeat);

	void deleteShowSeats(int id);
	
	List<MovieShow> getMovieShowByHall(int id,String title);
	
	List<CinemaSeat> getTotalSeats(int seatType);
	
	List<PaymentMethod> getPaymentMethods();
	
	void setBookingDetails(adminBookedTicket bookedTicket);
	
	
	//int getTotalSeatPrice(int totalSeat);
	

}
