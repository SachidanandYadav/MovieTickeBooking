package com.v2stech.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.v2stech.movieticketbooking.dao.MovieTickectBookingDAO;
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

@Service
public class MovieTicketBookingServiceImpl implements MovieTicketBookingService {

	@Autowired
	MovieTickectBookingDAO movieTickectBookingDAO;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private List<MovieShow> singleShow;
	private	List<CinemaSeat> singleSeats;

	@Override
	public void saveCustomerData(Customer customer) {
		movieTickectBookingDAO.saveCustomerDatas(customer);
	}

	@Override
	public List<City> getCityDatas() {
		return movieTickectBookingDAO.getCityData();
	}

	@Override
	public List<Country> getCountryData() {
		return movieTickectBookingDAO.getCountryDatas();
	}

	@Override
	public String getUserCredentials(UserCredentials credentials) {
		String viewNameString = "";
		System.out.println(credentials.getIsAdmin());
		if (credentials.getIsAdmin() == 1) {

			List<UserCredentials> admin = jdbcTemplate.query(
					"select * from adminCredential where adminUserName='" + credentials.getUser_name()
							+ "'and password='" + credentials.getPassword() + "'",
					new BeanPropertyRowMapper<UserCredentials>(UserCredentials.class));
			if (!admin.isEmpty()) {
				viewNameString = "adminDashboardPage";
			} else {
				System.out.println("Wrong Credential");
			}

		} else if (credentials.getIsAdmin() == 0) {

			List<UserCredentials> user = jdbcTemplate.query(
					"select * from user_credentials where user_name='" + credentials.getUser_name() + "'and password='"
							+ credentials.getPassword() + "'",
					new BeanPropertyRowMapper<UserCredentials>(UserCredentials.class));
			if (!user.isEmpty()) {
				viewNameString = "dashboardPage";
			} else {
				System.out.println("Wrong Credential");
			}

		} else {

		}
		return viewNameString;
	}

	@Override
	public List<Movie> getMovieDetails() {
		return movieTickectBookingDAO.getMovieDetail();
	}

	@Override
	public List<Movie> getMovieList() {
		return getMovieDetails();
	}

	@Override
	public List<Movie> getMovieById(String id) {
		return movieTickectBookingDAO.getMovieByIds(id);
	}

	@Override
	public void movies(Movie movie) {
		if (movie.getMovie_id() == 0) {
			movieTickectBookingDAO.addMovie(movie);
		} else {
			movieTickectBookingDAO.updateMovie(movie);
		}
	}

	@Override
	public void deleteMovie(String id) {
		movieTickectBookingDAO.deleteMovies(id);
	}

	@Override
	public Movie getMovieSingleDetail(String movieName) {
		for (Movie movie : getMovieDetails()) {
			if (movie.getTitle().equals(movieName)) {
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<adminBookedTicket> getBookedList() {
		return movieTickectBookingDAO.getBookedLists();
	}

	@Override
	public void deleteBooking(int id) {
		movieTickectBookingDAO.deleteBookings(id);
	}

	@Override
	public List<MovieShow> getMovieShowLists() {
		return movieTickectBookingDAO.getMovieShowDetails();
	}

	@Override
	public List<CinemaHall> getCinemaHallList(int id) {
		return movieTickectBookingDAO.getCinemaHallLists(id);
	}

	@Override
	public List<MovieShow> getMovieShowById(int id) {
		return movieTickectBookingDAO.getMovieShowByIds(id);
	}

	@Override
	public void movieShow(MovieShow movieShow) {
		if (movieShow.getShow_id() == 0) {
			movieTickectBookingDAO.addMovieShow(movieShow);
		} else {
			movieTickectBookingDAO.updateMovieShows(movieShow);
		}

	}

	@Override
	public void deleteMovieShows(int id) {
		movieTickectBookingDAO.deleteMovieShow(id);

	}

	@Override
	public List<State> getStateDatas() {
		return movieTickectBookingDAO.getStateData();
	}

	@Override
	public List<CinemaHall> getCinemaHallLists() {
		return movieTickectBookingDAO.getCinemaHallList();
	}

	@Override
	public List<CinemaHall> getSingleCinemaHalls(int id) {
		return movieTickectBookingDAO.getSingleCinemaHall(id);
	}

	@Override
	public List<City> getCityLists(int id) {
		return movieTickectBookingDAO.getCityList(id);
	}

	@Override
	public void cinemaHalls(CinemaHall cinemaHall) {
		if (cinemaHall.getHall_id() == 0) {
			movieTickectBookingDAO.addCinemaHall(cinemaHall);
		} else {
			movieTickectBookingDAO.updateCinemaHall(cinemaHall);
		}
	}

	@Override
	public void deleteCinemaHalls(int id) {
		movieTickectBookingDAO.deleteCinemaHall(id);

	}

	@Override
	public List<CinemaSeat> getCinemaSeatLists() {
		return movieTickectBookingDAO.getCinemaSeatList();
	}

	@Override
	public List<CinemaSeat> getSingleCinemaSeats(int id) {
		return movieTickectBookingDAO.getSingleCinemaSeat(id);
	}

	@Override
	public List<CinemaSeat> getCinemaSeatTypes() {
		return movieTickectBookingDAO.getCinemaSeatType();
	}

	@Override
	public void CinemaSeats(CinemaSeat cinemaSeat) {
		if (cinemaSeat.getCinemaSeat_id() == 0) {
			movieTickectBookingDAO.addCinemaSeat(cinemaSeat);
		} else {
			movieTickectBookingDAO.updateCinemaSeat(cinemaSeat);
		}
	}

	@Override
	public void deleteCinemaSeats(int id) {
		movieTickectBookingDAO.deleteCinemaSeat(id);
	}

	@Override
	public List<ShowSeat> getShowSeatLists() {
		return movieTickectBookingDAO.getShowSeatList();
	}

	@Override
	public List<SeatStatus> getSeatStatusDetails() {
		return movieTickectBookingDAO.getSeatStatus();
	}

	@Override
	public List<ShowSeat> getShowSeatDetails(int id) {
		return movieTickectBookingDAO.getShowSeatDetail(id);
	}

	@Override
	public List<ShowSeat> getSingleShowSeats(int id) {
		return movieTickectBookingDAO.getSingleShowSeat(id);
	}

	@Override
	public void deleteShowSeats(int id) {
		movieTickectBookingDAO.deleteShowSeat(id);

	}

	@Override
	public List<MovieShow> getMovieShowByHall(int id,String title) {
		this.singleShow = movieTickectBookingDAO.getMovieShowByHallId(id,title);
		return 	movieTickectBookingDAO.getMovieShowByHallId(id,title);
	}

	@Override
	public List<CinemaSeat> getTotalSeats(int seatType) {
		this.singleSeats = movieTickectBookingDAO.getTotalSeat(seatType);
		return movieTickectBookingDAO.getTotalSeat( seatType);
	}

	@Override
	public List<PaymentMethod> getPaymentMethods() {
		return movieTickectBookingDAO.getPaymentMethod();
	}

	@Override
	public void setBookingDetails(adminBookedTicket bookedTicket) {
		int totalSeat=0;
		for(CinemaSeat seat : singleSeats) {
		totalSeat = seat.getSeat()-bookedTicket.getSeat();
		}
		
		for(MovieShow show : singleShow) {
			movieTickectBookingDAO.setBookingDetail(bookedTicket,show.getShow_id(),totalSeat);
		}
		
		
	}

	

	
	
	
	
	
	

}
