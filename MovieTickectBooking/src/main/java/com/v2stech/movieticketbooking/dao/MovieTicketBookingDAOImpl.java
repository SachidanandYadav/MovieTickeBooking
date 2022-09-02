package com.v2stech.movieticketbooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

/**
 * @author Sachidanand Yadav
 *
 */
@Repository
public class MovieTicketBookingDAOImpl implements MovieTickectBookingDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private int hallId;
	private int seatTypeID;

	/**
	 * Query For City Data  
	 */
	@Override
	public List<CityDTO> getCityData() {
		return jdbcTemplate.query("select * from city", new BeanPropertyRowMapper<CityDTO>(CityDTO.class));
	}

	@Override
	public List<CinemaHallDTO> getCinemaHallLists(final int id) {
		return jdbcTemplate.query("select * from cinema_hall where city_id=?",
				new BeanPropertyRowMapper<CinemaHallDTO>(CinemaHallDTO.class), id);
	}

	@Override
	public List<MovieShowDTO> getMovieShowDetails() {
		return jdbcTemplate.query("SELECT show_id,show_date,startTime,endTime,hall_name,title "
				+ "FROM movie_show INNER JOIN cinema_hall USING (hall_id) INNER JOIN movie USING (movie_id)order by show_id",
				new BeanPropertyRowMapper<MovieShowDTO>(MovieShowDTO.class));
	}

	@Override
	public MovieShowDTO getMovieShowByIds(int id) {
		return jdbcTemplate.queryForObject("SELECT show_id,show_date,startTime,endTime,hall_name,title,city_name FROM movie_show INNER JOIN cinema_hall USING (hall_id) INNER JOIN movie USING (movie_id) INNER JOIN city USING (city_id) where show_id=?",
				new BeanPropertyRowMapper<MovieShowDTO>(MovieShowDTO.class), id);
	}

	@Override
	public void addMovieShow(MovieShowDTO movieShow) {
		jdbcTemplate.update(
				"INSERT INTO movie_show(show_date,startTime,endTime,hall_id,movie_id) VALUES(?,?,?,(select hall_id from cinema_hall where hall_name=?),(select movie_id from movie where title=?))",
				movieShow.getShowDate(), movieShow.getStartTime(), movieShow.getEndTime(), movieShow.getHallName(),
				movieShow.getTitle());
	}

	@Override
	public void updateMovieShows(MovieShowDTO movieShow) {
		jdbcTemplate.update(
				"UPDATE movie_show SET show_date=?,startTime=?,endTime=?,hall_id=(select hall_id from cinema_hall where hall_name=?),movie_id=(select movie_id from movie where title=?) WHERE show_id=?",
				movieShow.getShowDate(), movieShow.getStartTime(), movieShow.getEndTime(), movieShow.getHallName(),
				movieShow.getTitle(), movieShow.getShowId());

	}

	@Override
	public void deleteMovieShow(int id) {
		jdbcTemplate.update("DELETE from movie_show where show_id=?", id);

	}

	@Override
	public List<StateDTO> getStateData() {
		return jdbcTemplate.query("select * from state", new BeanPropertyRowMapper<StateDTO>(StateDTO.class));
	}

	@Override
	public List<CinemaHallDTO> getCinemaHallList() {
		return jdbcTemplate.query(
				"SELECT hall_id,hall_name,total_seat,address,city_name,state_name FROM cinema_hall INNER JOIN state using (state_id) Inner join city using (city_id) order by hall_id ",
				new BeanPropertyRowMapper<CinemaHallDTO>(CinemaHallDTO.class));
	}

	@Override
	public CinemaHallDTO getSingleCinemaHall(int id) {
		return jdbcTemplate.queryForObject(
				"SELECT hall_id,hall_name,total_seat,address,city_name,state_name FROM cinema_hall INNER JOIN state using (state_id) Inner join city using (city_id) where hall_id=?",
				new BeanPropertyRowMapper<CinemaHallDTO>(CinemaHallDTO.class), id);
	}

	@Override
	public List<CityDTO> getCityList(int id) {
		return jdbcTemplate.query("select city_name from city inner join state using (state_id) where state_id = ?",
				new BeanPropertyRowMapper<CityDTO>(CityDTO.class), id);
	}

	@Override
	public void addCinemaHall(CinemaHallDTO cinemaHall) {
		jdbcTemplate.update(
				"INSERT INTO cinema_hall(hall_name,total_seat,address,city_id,state_id) VALUES(?,?,?,(select city_id from city where city_name=?),?)",
				cinemaHall.getHallName(), cinemaHall.getTotalSeat(), cinemaHall.getAddress(),
				cinemaHall.getCityName(), cinemaHall.getState_id());
	}

	@Override
	public void updateCinemaHall(CinemaHallDTO cinemaHall) {
		jdbcTemplate.update(
				"UPDATE cinema_hall SET hall_name=?,total_seat=?,address=?,city_id=(select city_id from city where city_name=?),state_id=? where hall_id=?",
				cinemaHall.getHallName(), cinemaHall.getTotalSeat(), cinemaHall.getAddress(),
				cinemaHall.getCityName(), cinemaHall.getState_id(), cinemaHall.getHallId());
	}

	@Override
	public void deleteCinemaHall(int id) {
		jdbcTemplate.update("DELETE from cinema_hall where hall_id=?", id);

	}

	@Override
	public void addMovie(MovieDTO movie) {
		jdbcTemplate.update(
				"INSERT INTO movie(title,description,duration,language,releaseDate,genre,country_id,imageUrl) VALUES(?,?,?,?,?,?,(select country_id from country where country_name=?),?)",
				movie.getTitle(), movie.getDescription(), movie.getDuration(), movie.getLanguage(),
				movie.getReleaseDate(), movie.getGenre(), movie.getCountryName(), movie.getImageUrl());
	}

	@Override
	public void updateMovie(MovieDTO movie) {
		jdbcTemplate.update(
				"UPDATE movie SET title=?,description=?,duration=?,language=?,releaseDate=?,genre=?,country_id=(select country_id from country where country_name=?),imageUrl=? WHERE movie_id=?;",
				movie.getTitle(), movie.getDescription(), movie.getDuration(), movie.getLanguage(),
				movie.getReleaseDate(), movie.getGenre(), movie.getCountryName(), movie.getImageUrl(),
				movie.getMovieId());
	}

	@Override
	public List<CinemaSeatDTO> getCinemaSeatList() {
		return jdbcTemplate.query(
				"select cinemaSeat_id,seat,hall_name,seatName from cinema_seat inner join cinema_hall using (hall_id)inner join seat_type using (seatType_id) order by cinemaSeat_id",
				new BeanPropertyRowMapper<CinemaSeatDTO>(CinemaSeatDTO.class));
	}

	@Override
	public CinemaSeatDTO getSingleCinemaSeat(int id) {
		return jdbcTemplate.queryForObject(
				"select cinemaSeat_id,seat,hall_name,seatName from cinema_seat inner join cinema_hall using (hall_id)inner join seat_type using (seatType_id) where cinemaSeat_id=?",
				new BeanPropertyRowMapper<CinemaSeatDTO>(CinemaSeatDTO.class), id);
	}

	@Override
	public List<CinemaSeatDTO> getCinemaSeatType() {
		return jdbcTemplate.query("select * from seat_type", new BeanPropertyRowMapper<CinemaSeatDTO>(CinemaSeatDTO.class));
	}

	@Override
	public void addCinemaSeat(CinemaSeatDTO cinemaSeat) {
		jdbcTemplate.update(
				"INSERT INTO cinema_seat(seat,hall_id,seatType_id) VALUES(?,(select hall_id from cinema_hall where hall_name=?),?)",
				cinemaSeat.getSeat(), cinemaSeat.getHallName(), cinemaSeat.getSeatType_id());

	}

	@Override
	public void updateCinemaSeat(CinemaSeatDTO cinemaSeat) {
		jdbcTemplate.update(
				"UPDATE cinema_seat SET seat=?,hall_id=(select hall_id from cinema_hall where hall_name=?),seatType_id=? where cinemaSeat_id=? ",
				cinemaSeat.getSeat(), cinemaSeat.getHallName(), cinemaSeat.getSeatType_id(),
				cinemaSeat.getCinemaSeat_id());

	}

	@Override
	public void deleteCinemaSeat(int id) {
		jdbcTemplate.update("DELETE from cinema_seat where cinemaSeat_id=?", id);

	}

	@Override
	public List<ShowSeatDTO> getShowSeatList() {
		return jdbcTemplate.query(
				"select showSeat_id,price,seat,startTime,endTime,seatStatus_Type,seatName from show_seat Inner join cinema_seat using(cinemaSeat_id) Inner join seat_type using(seatType_id) Inner join movie_show using(show_id) Inner join seat_status using(seatStatus_id)",
				new BeanPropertyRowMapper<ShowSeatDTO>(ShowSeatDTO.class));
	}

	@Override
	public List<SeatStatusDTO> getSeatStatus() {
		return jdbcTemplate.query("select * from seat_status", new BeanPropertyRowMapper<SeatStatusDTO>(SeatStatusDTO.class));
	}

	@Override
	public List<ShowSeatDTO> getShowSeatDetail(int id) {
		return jdbcTemplate.query(
				"select hall_id,cinemaSeat_id,show_id,startTime,endTime,seat,seatName from cinema_seat Inner join seat_type using(seatType_id) Inner join movie_show using(hall_id) where hall_id = ?",
				new BeanPropertyRowMapper<ShowSeatDTO>(ShowSeatDTO.class), id);
	}

	@Override
	public ShowSeatDTO getSingleShowSeat(int id) {
		return jdbcTemplate.queryForObject(
				"select showSeat_id,cinemaSeat_id,price,show_id,seat,startTime,endTime,seatStatus_id,seatStatus_Type,seatName from show_seat Inner join cinema_seat using(cinemaSeat_id) Inner join seat_type using(seatType_id) Inner join movie_show using(show_id) Inner join seat_status using(seatStatus_id) where showSeat_id=? ",
				new BeanPropertyRowMapper<ShowSeatDTO>(ShowSeatDTO.class), id);
	}

	@Override
	public void deleteShowSeat(int id) {
		jdbcTemplate.update("DELETE from show_seat where showSeat_id=?", id);
	}

	@Override
	public void deleteBookings(int id) {
		jdbcTemplate.update("DELETE from booking where booking_id=?", id);
	}

	@Override
	public List<BookedTicketDTO> getBookedLists() {
		return jdbcTemplate.query("SELECT booking_id,seat,booking_time,user_name,show_date"
				+ " FROM booking INNER JOIN user_credentials USING (user_id) INNER JOIN movie_show USING (show_id) "
				+ " order by booking_id;",
				new BeanPropertyRowMapper<BookedTicketDTO>(BookedTicketDTO.class));
	}

	@Override
	public void deleteMovies(String id) {
		jdbcTemplate.update("DELETE from movie where movie_id=?", id);
	}

	@Override
	public MovieDTO getMovieByIds(String id) {
		return jdbcTemplate.queryForObject(
				"SELECT movie_id,title,description,duration,language,releaseDate,genre,country_name,imageUrl "
						+ "FROM movie INNER JOIN country USING (country_id) where movie_id= ?",
				new BeanPropertyRowMapper<MovieDTO>(MovieDTO.class), id);
	}

	@Override
	public List<MovieDTO> getMovieDetail() {
		return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<MovieDTO>(MovieDTO.class));
	}

	@Override
	public List<CountryDTO> getCountryDatas() {
		return jdbcTemplate.query("select * from country", new BeanPropertyRowMapper<CountryDTO>(CountryDTO.class));
	}

	@Override
	public void saveCustomerDatas(CustomerDTO customer) {
		jdbcTemplate.update(
				"INSERT INTO customer(email,phone,first_name,last_name,birth,gender,addressLine1,addressLine2,areaPincode,city_id) VALUES(?,?,?,?,?,?,?,?,?,(select city_id from city where city_name=?))",
				customer.getEmail(), customer.getPhone(), customer.getFirst_name(), customer.getLast_name(),
				customer.getBirth(), customer.getGender(), customer.getAddressLine1(), customer.getAddressLine2(),
				customer.getAreaPincode(), customer.getCity_name());

		jdbcTemplate.update(
				"INSERT INTO user_credentials(user_name,password,customer_id) VALUES(?,?,(select customer_id from customer where email=?))",
				customer.getUser_name(), customer.getPassword(), customer.getEmail());
	}

	@Override
	public List<MovieShowDTO> getMovieShowByHallId(int id,String title) {
		this.hallId = id;
		return jdbcTemplate.query("SELECT show_id,show_date,startTime,endTime,hall_name,title,description,language "
				+ "FROM movie_show INNER JOIN cinema_hall USING (hall_id) INNER JOIN movie USING (movie_id) where hall_id=? and title=?",
				new BeanPropertyRowMapper<MovieShowDTO>(MovieShowDTO.class), id,title);
	}

	@Override
	public CinemaSeatDTO getTotalSeat(int seatType) {
		this.seatTypeID = seatType;
		return jdbcTemplate.queryForObject("select seat,price from cinema_seat inner join show_seat using(cinemaSeat_id) where hall_id=? and seatType_id=? ", new BeanPropertyRowMapper<CinemaSeatDTO>(CinemaSeatDTO.class),hallId,seatType);
	}

	@Override
	public List<PaymentMethodDTO> getPaymentMethod() {
		return jdbcTemplate.query("select * from paymentMethod", new BeanPropertyRowMapper<PaymentMethodDTO>(PaymentMethodDTO.class));
	}

	@Override
	public void setBookingDetail(BookedTicketDTO bookedTicket,int showId,int totalSeat) {
		jdbcTemplate.update(
				"INSERT INTO booking (seat, user_id, show_id)VALUES(?,(select user_id from user_credentials where user_name=?),?)",bookedTicket.getSeat(),bookedTicket.getUserName(),showId);

		jdbcTemplate.update(
				"INSERT INTO payment (Amount, booking_id, methodId) VALUES(?,(select booking_id from booking order by booking_id desc limit 1),?)",bookedTicket.getAmount(),bookedTicket.getMethodId());
		
		jdbcTemplate.update("UPDATE cinema_seat SET seat=? where hall_id=? and seatType_id=?",totalSeat,hallId,seatTypeID);
		
	}

	@Override
	public List<BookedTicketDTO> getBookingHistoryList(String userName) {
		return jdbcTemplate.query("select booking_id,seat,booking_time,startTime from booking inner join movie_show using(show_id) where user_id= (select user_id from user_credentials where user_name=?) ", new BeanPropertyRowMapper<BookedTicketDTO>(BookedTicketDTO.class),userName);
	}


	@Override
	public BookedTicketDTO getPaymentDetail(int bookingId) {
		return jdbcTemplate.queryForObject("select amount,payment_time,methodType,paymentStatus_Type from payment inner join paymentMethod using(methodId) inner join payment_status using(paymentStatus_id ) where booking_id=?", new BeanPropertyRowMapper<BookedTicketDTO>(BookedTicketDTO.class),bookingId);
	}
	
	@Override
	public List<BookedTicketDTO> getAllPayment() {
		return jdbcTemplate.query("select payment_id,amount,payment_time,methodType,paymentStatus_Type from payment inner join paymentMethod using(methodId) inner join payment_status using(paymentStatus_id )", new BeanPropertyRowMapper<BookedTicketDTO>(BookedTicketDTO.class));
	}

	@Override
	public CustomerDTO getUserProfile(String userName) {
		return jdbcTemplate.queryForObject("select customer_id,email,phone,first_name,last_name,birth,addressLine1,addressLine2,areaPincode,city_name,city_id from user_credentials inner join customer using(customer_id) inner join city using(city_id)  where user_id= (select user_id from user_credentials where user_name=?)",new BeanPropertyRowMapper<CustomerDTO>(CustomerDTO.class),userName);
	}

	@Override
	public void getUpdateCustomer(CustomerDTO customer ,int id) {
		jdbcTemplate.update("UPDATE customer SET email=?,phone=?,first_name=?,last_name=?,birth=?,addressLine1=?,addressLine2=?,areaPincode=?,city_id=? where customer_id= ?",  customer.getEmail(),customer.getPhone(),customer.getFirst_name(),customer.getLast_name(),customer.getBirth(),customer.getAddressLine1(),customer.getAddressLine2(),customer.getAreaPincode(),customer.getCity_id(),id);
	}

	@Override
	public void deletePaymentById(int id) {
		jdbcTemplate.update("DELETE from payment where payment_id=?",id);

	}

	

	
	
	
	
	
	
	

}