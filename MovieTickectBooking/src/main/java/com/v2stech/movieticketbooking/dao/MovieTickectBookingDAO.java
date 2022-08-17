package com.v2stech.movieticketbooking.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

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
import com.v2stech.movieticketbooking.model.adminBookedTicket;

public interface MovieTickectBookingDAO {

	void saveCustomerDatas(Customer customer);

	List<Country> getCountryDatas();

	List<Movie> getMovieDetail();

	List<Movie> getMovieByIds(String id);

	List<City> getCityData();

	void deleteBookings(int id);

	List<adminBookedTicket> getBookedLists();

	List<CinemaHall> getCinemaHallLists(int id);

	List<MovieShow> getMovieShowDetails();

	List<MovieShow> getMovieShowByIds(int id);

	void deleteMovies(String id);

	void addMovieShow(MovieShow movieShow);

	void updateMovieShows(MovieShow movieShow);

	void deleteMovieShow(int id);

	List<State> getStateData();

	List<CinemaHall> getCinemaHallList();

	List<CinemaHall> getSingleCinemaHall(int id);

	List<City> getCityList(int id);

	void addCinemaHall(CinemaHall cinemaHall);

	void updateCinemaHall(CinemaHall cinemaHall);

	void deleteCinemaHall(int id);

	void addMovie(Movie movie);

	void updateMovie(Movie movie);

	List<CinemaSeat> getCinemaSeatList();

	List<CinemaSeat> getSingleCinemaSeat(int id);

	List<CinemaSeat> getCinemaSeatType();

	void addCinemaSeat(CinemaSeat cinemaSeat);

	void updateCinemaSeat(CinemaSeat cinemaSeat);

	void deleteCinemaSeat(int id);

	List<ShowSeat> getShowSeatList();

	List<SeatStatus> getSeatStatus();

	List<ShowSeat> getShowSeatDetail(int id);

	List<ShowSeat> getSingleShowSeat(int id);

	// void addShowSeat(ShowSeat showSeat);

	void deleteShowSeat(int id);
	
	List<MovieShow> getMovieShowByHallId(int id,String title);
	
	List<CinemaSeat> getTotalSeat(int seatType);
	
	List<PaymentMethod> getPaymentMethod();
	
	void setBookingDetail(adminBookedTicket bookedTicket,int showId,int totalSeat);
	
	
	
	
	

}
