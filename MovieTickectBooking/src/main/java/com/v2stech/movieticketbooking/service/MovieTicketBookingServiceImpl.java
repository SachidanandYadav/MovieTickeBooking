package com.v2stech.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.v2stech.movieticketbooking.dao.MovieTickectBookingDAO;
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

@Service
public class MovieTicketBookingServiceImpl implements MovieTicketBookingService {

	@Autowired
	MovieTickectBookingDAO movieTickectBookingDAO;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private List<MovieShowDTO> singleShow;
	private	CinemaSeatDTO singleSeats;

	@Override
	public void saveCustomerData(CustomerDTO customer) {
		movieTickectBookingDAO.saveCustomerDatas(customer);
	}

	@Override
	public List<CityDTO> getCityDatas() {
		return movieTickectBookingDAO.getCityData();
	}

	@Override
	public List<CountryDTO> getCountryData() {
		return movieTickectBookingDAO.getCountryDatas();
	}

	@Override
	public String getUserCredentials(UserCredentialsDTO credentials) throws InvalidCredentialException {
		String viewNameString = "";
		if (credentials.getIsAdmin() == 1) {
				List<UserCredentialsDTO> admin = jdbcTemplate.query(
						"select * from adminCredential where adminUserName='" + credentials.getUserName()
								+ "'and password='" + credentials.getPassword() + "'",
						new BeanPropertyRowMapper<UserCredentialsDTO>(UserCredentialsDTO.class));
				if (!admin.isEmpty()) {
					viewNameString = "admin-dashboard-page";
				} else {
					throw new InvalidCredentialException("Invalid Credential");
				}

		} else if (credentials.getIsAdmin() == 0) {

				List<UserCredentialsDTO> user = jdbcTemplate.query(
						"select * from user_credentials where user_name='" + credentials.getUserName()
								+ "'and password='" + credentials.getPassword() + "'",
						new BeanPropertyRowMapper<UserCredentialsDTO>(UserCredentialsDTO.class));
				if (!user.isEmpty()) {
					viewNameString = "dashboard-page";
				} else {
					throw new InvalidCredentialException("Invalid Credential");
				}


		} else {

		}
		return viewNameString;
	}

	@Override
	public List<MovieDTO> getMovieDetails() {
		return movieTickectBookingDAO.getMovieDetail();
	}

	@Override
	public List<MovieDTO> getMovieList() {
		return getMovieDetails();
	}

	@Override
	public MovieDTO getMovieById(String id) {
		return movieTickectBookingDAO.getMovieByIds(id);
	}

	@Override
	public void movies(MovieDTO movie) {
		if (movie.getMovieId() == 0) {
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
	public MovieDTO getMovieSingleDetail(String movieName) {
		for (MovieDTO movie : getMovieDetails()) {
			if (movie.getTitle().equals(movieName)) {
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<BookedTicketDTO> getBookedList() {
		return movieTickectBookingDAO.getBookedLists();
	}

	@Override
	public void deleteBooking(int id) {
		movieTickectBookingDAO.deleteBookings(id);
	}

	@Override
	public List<MovieShowDTO> getMovieShowLists() {
		return movieTickectBookingDAO.getMovieShowDetails();
	}

	@Override
	public List<CinemaHallDTO> getCinemaHallList(int id) {
		return movieTickectBookingDAO.getCinemaHallLists(id);
	}

	@Override
	public MovieShowDTO getMovieShowById(int id) {
		return movieTickectBookingDAO.getMovieShowByIds(id);
	}

	@Override
	public void movieShow(MovieShowDTO movieShow) {
		if (movieShow.getShowId() == 0) {
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
	public List<StateDTO> getStateDatas() {
		return movieTickectBookingDAO.getStateData();
	}

	@Override
	public List<CinemaHallDTO> getCinemaHallLists() {
		return movieTickectBookingDAO.getCinemaHallList();
	}

	@Override
	public CinemaHallDTO getSingleCinemaHalls(int id) {
		return movieTickectBookingDAO.getSingleCinemaHall(id);
	}

	@Override
	public List<CityDTO> getCityLists(int id) {
		return movieTickectBookingDAO.getCityList(id);
	}

	@Override
	public void cinemaHalls(CinemaHallDTO cinemaHall) {
		if (cinemaHall.getHallId() == 0) {
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
	public List<CinemaSeatDTO> getCinemaSeatLists() {
		return movieTickectBookingDAO.getCinemaSeatList();
	}

	@Override
	public CinemaSeatDTO getSingleCinemaSeats(int id) {
		return movieTickectBookingDAO.getSingleCinemaSeat(id);
	}

	@Override
	public List<CinemaSeatDTO> getCinemaSeatTypes() {
		return movieTickectBookingDAO.getCinemaSeatType();
	}

	@Override
	public void cinemaSeats(CinemaSeatDTO cinemaSeat) {
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
	public List<ShowSeatDTO> getShowSeatLists() {
		return movieTickectBookingDAO.getShowSeatList();
	}

	@Override
	public List<SeatStatusDTO> getSeatStatusDetails() {
		return movieTickectBookingDAO.getSeatStatus();
	}

	@Override
	public List<ShowSeatDTO> getShowSeatDetails(int id) {
		return movieTickectBookingDAO.getShowSeatDetail(id);
	}

	@Override
	public ShowSeatDTO getSingleShowSeats(int id) {
		return movieTickectBookingDAO.getSingleShowSeat(id);
	}

	@Override
	public void deleteShowSeats(int id) {
		movieTickectBookingDAO.deleteShowSeat(id);

	}

	@Override
	public List<MovieShowDTO> getMovieShowByHall(int id,String title) {
		this.singleShow = movieTickectBookingDAO.getMovieShowByHallId(id,title);
		return 	movieTickectBookingDAO.getMovieShowByHallId(id,title);
	}

	@Override
	public CinemaSeatDTO getTotalSeats(int seatType) {
		this.singleSeats = movieTickectBookingDAO.getTotalSeat(seatType);
		return movieTickectBookingDAO.getTotalSeat( seatType);
	}

	@Override
	public List<PaymentMethodDTO> getPaymentMethods() {
		return movieTickectBookingDAO.getPaymentMethod();
	}

	@Override
	public void setBookingDetails(BookedTicketDTO bookedTicket) throws InvalidSeatException {
		int totalSeat=0;
		totalSeat = singleSeats.getSeat()-bookedTicket.getSeat();
		if(totalSeat < 0) {
			throw new InvalidSeatException("Seat Not Available");
		}else {
			for(MovieShowDTO show : singleShow) {
				movieTickectBookingDAO.setBookingDetail(bookedTicket,show.getShowId(),totalSeat);
			}
		}
		
	}

	@Override
	public List<BookedTicketDTO> getBookingHistoryLists(String userName) {
		return movieTickectBookingDAO.getBookingHistoryList(userName);
	}

	@Override
	public BookedTicketDTO getPaymentDetails(int bookingId) {
		return movieTickectBookingDAO.getPaymentDetail(bookingId);
	}

	@Override
	public CustomerDTO getUserProfiles(String userName) {
		return movieTickectBookingDAO.getUserProfile(userName);
	}

	@Override
	public void getUpdateCustomers(CustomerDTO customer, int id) {
		movieTickectBookingDAO.getUpdateCustomer(customer,id);
		
	}
	
	
	@Override
	public List<BookedTicketDTO> getAllPayments() {
		return movieTickectBookingDAO.getAllPayment();
	}

	@Override
	public void deletePayment(int id) {
		movieTickectBookingDAO.deletePaymentById(id);
	}
	

	
	
	
	
	
	

}
