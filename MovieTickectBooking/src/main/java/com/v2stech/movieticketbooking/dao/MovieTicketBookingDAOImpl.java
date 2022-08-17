package com.v2stech.movieticketbooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

@Repository
public class MovieTicketBookingDAOImpl implements MovieTickectBookingDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private int hallId;
	private int seatTypeID;

	@Override
	public List<City> getCityData() {
		return jdbcTemplate.query("select * from city", new BeanPropertyRowMapper<City>(City.class));
	}

	@Override
	public List<CinemaHall> getCinemaHallLists(int id) {
		return jdbcTemplate.query("select * from cinema_hall where city_id=?",
				new BeanPropertyRowMapper<CinemaHall>(CinemaHall.class), id);
	}

	@Override
	public List<MovieShow> getMovieShowDetails() {
		return jdbcTemplate.query("SELECT show_id,show_date,startTime,endTime,hall_name,title "
				+ "FROM movie_show INNER JOIN cinema_hall USING (hall_id) INNER JOIN movie USING (movie_id)order by show_id",
				new BeanPropertyRowMapper<MovieShow>(MovieShow.class));
	}

	@Override
	public List<MovieShow> getMovieShowByIds(int id) {
		return jdbcTemplate.query("SELECT show_id,show_date,startTime,endTime,hall_name,title "
				+ "FROM movie_show INNER JOIN cinema_hall USING (hall_id) INNER JOIN movie USING (movie_id) where show_id=?",
				new BeanPropertyRowMapper<MovieShow>(MovieShow.class), id);
	}

	@Override
	public void addMovieShow(MovieShow movieShow) {
		jdbcTemplate.update(
				"INSERT INTO movie_show(show_date,startTime,endTime,hall_id,movie_id) VALUES(?,?,?,(select hall_id from cinema_hall where hall_name=?),(select movie_id from movie where title=?))",
				movieShow.getShow_date(), movieShow.getStartTime(), movieShow.getEndTime(), movieShow.getHall_name(),
				movieShow.getTitle());
	}

	@Override
	public void updateMovieShows(MovieShow movieShow) {
		jdbcTemplate.update(
				"UPDATE movie_show SET show_date=?,startTime=?,endTime=?,hall_id=(select hall_id from cinema_hall where hall_name=?),movie_id=(select movie_id from movie where title=?) WHERE show_id=?",
				movieShow.getShow_date(), movieShow.getStartTime(), movieShow.getEndTime(), movieShow.getHall_name(),
				movieShow.getTitle(), movieShow.getShow_id());

	}

	@Override
	public void deleteMovieShow(int id) {
		jdbcTemplate.update("DELETE from movie_show where show_id=?", id);

	}

	@Override
	public List<State> getStateData() {
		return jdbcTemplate.query("select * from state", new BeanPropertyRowMapper<State>(State.class));
	}

	@Override
	public List<CinemaHall> getCinemaHallList() {
		return jdbcTemplate.query(
				"SELECT hall_id,hall_name,total_seat,address,city_name,state_name FROM cinema_hall INNER JOIN state using (state_id) Inner join city using (city_id) order by hall_id ",
				new BeanPropertyRowMapper<CinemaHall>(CinemaHall.class));
	}

	@Override
	public List<CinemaHall> getSingleCinemaHall(int id) {
		return jdbcTemplate.query(
				"SELECT hall_id,hall_name,total_seat,address,city_name,state_name FROM cinema_hall INNER JOIN state using (state_id) Inner join city using (city_id) where hall_id=?",
				new BeanPropertyRowMapper<CinemaHall>(CinemaHall.class), id);
	}

	@Override
	public List<City> getCityList(int id) {
		return jdbcTemplate.query("select city_name from city inner join state using (state_id) where state_id = ?",
				new BeanPropertyRowMapper<City>(City.class), id);
	}

	@Override
	public void addCinemaHall(CinemaHall cinemaHall) {
		jdbcTemplate.update(
				"INSERT INTO cinema_hall(hall_name,total_seat,address,city_id,state_id) VALUES(?,?,?,(select city_id from city where city_name=?),?)",
				cinemaHall.getHall_name(), cinemaHall.getTotal_seat(), cinemaHall.getAddress(),
				cinemaHall.getCity_name(), cinemaHall.getState_id());
	}

	@Override
	public void updateCinemaHall(CinemaHall cinemaHall) {
		jdbcTemplate.update(
				"UPDATE cinema_hall SET hall_name=?,total_seat=?,address=?,city_id=(select city_id from city where city_name=?),state_id=? where hall_id=?",
				cinemaHall.getHall_name(), cinemaHall.getTotal_seat(), cinemaHall.getAddress(),
				cinemaHall.getCity_name(), cinemaHall.getState_id(), cinemaHall.getHall_id());
	}

	@Override
	public void deleteCinemaHall(int id) {
		jdbcTemplate.update("DELETE from cinema_hall where hall_id=?", id);

	}

	@Override
	public void addMovie(Movie movie) {
		jdbcTemplate.update(
				"INSERT INTO movie(title,description,duration,language,releaseDate,genre,country_id,imageUrl) VALUES(?,?,?,?,?,?,(select country_id from country where country_name=?),?)",
				movie.getTitle(), movie.getDescription(), movie.getDuration(), movie.getLanguage(),
				movie.getReleaseDate(), movie.getGenre(), movie.getCountry_name(), movie.getImageUrl());
	}

	@Override
	public void updateMovie(Movie movie) {
		jdbcTemplate.update(
				"UPDATE movie SET title=?,description=?,duration=?,language=?,releaseDate=?,genre=?,country_id=(select country_id from country where country_name=?),imageUrl=? WHERE movie_id=?;",
				movie.getTitle(), movie.getDescription(), movie.getDuration(), movie.getLanguage(),
				movie.getReleaseDate(), movie.getGenre(), movie.getCountry_name(), movie.getImageUrl(),
				movie.getMovie_id());
	}

	@Override
	public List<CinemaSeat> getCinemaSeatList() {
		return jdbcTemplate.query(
				"select cinemaSeat_id,seat,hall_name,seatName from cinema_seat inner join cinema_hall using (hall_id)inner join seat_type using (seatType_id) order by cinemaSeat_id",
				new BeanPropertyRowMapper<CinemaSeat>(CinemaSeat.class));
	}

	@Override
	public List<CinemaSeat> getSingleCinemaSeat(int id) {
		return jdbcTemplate.query(
				"select cinemaSeat_id,seat,hall_name,seatName from cinema_seat inner join cinema_hall using (hall_id)inner join seat_type using (seatType_id) where cinemaSeat_id=?",
				new BeanPropertyRowMapper<CinemaSeat>(CinemaSeat.class), id);
	}

	@Override
	public List<CinemaSeat> getCinemaSeatType() {
		return jdbcTemplate.query("select * from seat_type", new BeanPropertyRowMapper<CinemaSeat>(CinemaSeat.class));
	}

	@Override
	public void addCinemaSeat(CinemaSeat cinemaSeat) {
		jdbcTemplate.update(
				"INSERT INTO cinema_seat(seat,hall_id,seatType_id) VALUES(?,(select hall_id from cinema_hall where hall_name=?),?)",
				cinemaSeat.getSeat(), cinemaSeat.getHall_name(), cinemaSeat.getSeatType_id());

	}

	@Override
	public void updateCinemaSeat(CinemaSeat cinemaSeat) {
		jdbcTemplate.update(
				"UPDATE cinema_seat SET seat=?,hall_id=(select hall_id from cinema_hall where hall_name=?),seatType_id=? where cinemaSeat_id=? ",
				cinemaSeat.getSeat(), cinemaSeat.getHall_name(), cinemaSeat.getSeatType_id(),
				cinemaSeat.getCinemaSeat_id());

	}

	@Override
	public void deleteCinemaSeat(int id) {
		jdbcTemplate.update("DELETE from cinema_seat where cinemaSeat_id=?", id);

	}

	@Override
	public List<ShowSeat> getShowSeatList() {
		return jdbcTemplate.query(
				"select showSeat_id,price,seat,startTime,endTime,seatStatus_Type,seatName from show_seat Inner join cinema_seat using(cinemaSeat_id) Inner join seat_type using(seatType_id) Inner join movie_show using(show_id) Inner join seat_status using(seatStatus_id)",
				new BeanPropertyRowMapper<ShowSeat>(ShowSeat.class));
	}

	@Override
	public List<SeatStatus> getSeatStatus() {
		return jdbcTemplate.query("select * from seat_status", new BeanPropertyRowMapper<SeatStatus>(SeatStatus.class));
	}

	@Override
	public List<ShowSeat> getShowSeatDetail(int id) {
		return jdbcTemplate.query(
				"select hall_id,cinemaSeat_id,show_id,startTime,endTime,seat,seatName from cinema_seat Inner join seat_type using(seatType_id) Inner join movie_show using(hall_id) where hall_id = ?",
				new BeanPropertyRowMapper<ShowSeat>(ShowSeat.class), id);
	}

	@Override
	public List<ShowSeat> getSingleShowSeat(int id) {
		return jdbcTemplate.query(
				"select showSeat_id,cinemaSeat_id,price,show_id,seat,startTime,endTime,seatStatus_id,seatStatus_Type,seatName from show_seat Inner join cinema_seat using(cinemaSeat_id) Inner join seat_type using(seatType_id) Inner join movie_show using(show_id) Inner join seat_status using(seatStatus_id) where showSeat_id=? ",
				new BeanPropertyRowMapper<ShowSeat>(ShowSeat.class), id);
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
	public List<adminBookedTicket> getBookedLists() {
		return jdbcTemplate.query("SELECT booking_id,seat,booking_time,user_name,show_date"
				+ " FROM booking INNER JOIN user_credentials USING (user_id) INNER JOIN movie_show USING (show_id) "
				+ " order by booking_id;",
				new BeanPropertyRowMapper<adminBookedTicket>(adminBookedTicket.class));
	}

	@Override
	public void deleteMovies(String id) {
		jdbcTemplate.update("DELETE from movie where movie_id=?", id);
	}

	@Override
	public List<Movie> getMovieByIds(String id) {
		return jdbcTemplate.query(
				"SELECT movie_id,title,description,duration,language,releaseDate,genre,country_name,imageUrl "
						+ "FROM movie INNER JOIN country USING (country_id) where movie_id= ?",
				new BeanPropertyRowMapper<Movie>(Movie.class), id);
	}

	@Override
	public List<Movie> getMovieDetail() {
		return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<Movie>(Movie.class));
	}

	@Override
	public List<Country> getCountryDatas() {
		return jdbcTemplate.query("select * from country", new BeanPropertyRowMapper<Country>(Country.class));
	}

	@Override
	public void saveCustomerDatas(Customer customer) {
		jdbcTemplate.update(
				"INSERT INTO customer(email,phone,first_name,last_name,birth,gender,addressLine1,addressLine2,areaPincode,city_id) VALUES(?,?,?,?,?,?,?,?,?,(select city_id from city where city_name=?))",
				customer.getEmail(), customer.getPhone(), customer.getFirst_name(), customer.getLast_name(),
				customer.getBirth(), customer.getGender(), customer.getAddressLine1(), customer.getAddressLine2(),
				customer.getAreaPincode(), customer.getCity_id());

		jdbcTemplate.update(
				"INSERT INTO user_credentials(user_name,password,customer_id) VALUES(?,?,(select customer_id from customer where email=?))",
				customer.getUser_name(), customer.getPassword(), customer.getEmail());
	}

	@Override
	public List<MovieShow> getMovieShowByHallId(int id,String title) {
		this.hallId = id;
		return jdbcTemplate.query("SELECT show_id,show_date,startTime,endTime,hall_name,title,description,language "
				+ "FROM movie_show INNER JOIN cinema_hall USING (hall_id) INNER JOIN movie USING (movie_id) where hall_id=? and title=?",
				new BeanPropertyRowMapper<MovieShow>(MovieShow.class), id,title);
	}

	@Override
	public List<CinemaSeat> getTotalSeat(int seatType) {
		this.seatTypeID = seatType;
		return jdbcTemplate.query("select seat,price from cinema_seat inner join show_seat using(cinemaSeat_id) where hall_id=? and seatType_id=? ", new BeanPropertyRowMapper<CinemaSeat>(CinemaSeat.class),hallId,seatType);
	}

	@Override
	public List<PaymentMethod> getPaymentMethod() {
		return jdbcTemplate.query("select * from paymentMethod", new BeanPropertyRowMapper<PaymentMethod>(PaymentMethod.class));
	}

	@Override
	public void setBookingDetail(adminBookedTicket bookedTicket,int showId,int totalSeat) {
		jdbcTemplate.update(
				"INSERT INTO booking (seat, user_id, show_id)VALUES(?,(select user_id from user_credentials where user_name=?),?)",bookedTicket.getSeat(),bookedTicket.getUser_name(),showId);

		jdbcTemplate.update(
				"INSERT INTO payment (Amount, booking_id, methodId) VALUES(?,(select booking_id from booking order by booking_id desc limit 1),?)",bookedTicket.getAmount(),bookedTicket.getMethodId());
		
		jdbcTemplate.update("UPDATE cinema_seat SET seat=? where hall_id=? and seatType_id=?",totalSeat,hallId,seatTypeID);
		
	}


	
	
	
	
	
	
	

}