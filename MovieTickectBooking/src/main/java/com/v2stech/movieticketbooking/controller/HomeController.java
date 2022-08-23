package com.v2stech.movieticketbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.exception.InvalidCredentialException;
import com.v2stech.movieticketbooking.model.BookedTicketDTO;
import com.v2stech.movieticketbooking.model.CinemaSeatDTO;
import com.v2stech.movieticketbooking.model.CityDTO;
import com.v2stech.movieticketbooking.model.CustomerDTO;
import com.v2stech.movieticketbooking.model.MovieDTO;
import com.v2stech.movieticketbooking.model.MovieShowDTO;
import com.v2stech.movieticketbooking.model.PaymentMethodDTO;
import com.v2stech.movieticketbooking.model.UserCredentialsDTO;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

/**
 * @author v2stech
 *
 */
@RestController
//@RequestMapping("/home")
public class HomeController {

	@Autowired
	MovieTicketBookingService bookingService;

	private String userName;

	private MovieDTO singleMovieDetail;

	private List<MovieShowDTO> movieShowDetail;

	@RequestMapping("/login-page")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login");
	}

	@GetMapping("/register-page")
	public ModelAndView getRegisterPage(Model model) {
		List<CityDTO> list = bookingService.getCityDatas();
		model.addAttribute("cityList", list);
		return new ModelAndView("registrationPage");
	}

	@PostMapping("/customer")
	public void saveCustomer(@RequestBody CustomerDTO customer) {
		bookingService.saveCustomerData(customer);
	}

	@PostMapping("/login-customer")
	public String loginCustomer(@Valid @RequestBody UserCredentialsDTO user, BindingResult result)
			throws MethodArgumentNotValidException, InvalidCredentialException {
		if (result.hasErrors()) {
			throw new MethodArgumentNotValidException(null, result);
		} else {
			userName = user.getUserName();
			return bookingService.getUserCredentials(user);
		}

	}

	@RequestMapping("/dashboard-page")
	public ModelAndView getDashboardPage(Model model) {
		List<MovieDTO> movie = bookingService.getMovieDetails();
		model.addAttribute("movieList", movie);
		model.addAttribute("username", userName);
		return new ModelAndView("DashboardPage");
	}

	@RequestMapping("/admin-dashboard-page")
	public ModelAndView getAdminDashboardPage(Model model) {
		model.addAttribute("username", userName);
		return new ModelAndView("adminDashboardPage");
	}

	@GetMapping("/movie-details/{movieName}")
	public String getFullDetails(@PathVariable String movieName, Model model) {
		singleMovieDetail = bookingService.getMovieSingleDetail(movieName);
		return "movie-detail-page";
	}

	@RequestMapping("/movie-detail-page")
	public ModelAndView getMovieDetailPage(Model model) {
		model.addAttribute("username", userName);
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("Movie", singleMovieDetail);
		return new ModelAndView("movieDetails");
	}

	@GetMapping("/movie-show-detail/{hallId}/{title}")
	public String getMovieShowById(@PathVariable int hallId, @PathVariable String title, Model model) {
		movieShowDetail = bookingService.getMovieShowByHall(hallId, title);
		return "show-detail-page";
	}

	@RequestMapping("/show-detail-page")
	public ModelAndView getMovieShowPage(Model model) {
		model.addAttribute("username", userName);
		model.addAttribute("movieShow", movieShowDetail);
		return new ModelAndView("ShowDetails");
	}

	@RequestMapping("/show-booking-page")
	public ModelAndView getBookingPage(Model model) {
		model.addAttribute("username", userName);
		model.addAttribute("movieShow", movieShowDetail);
		model.addAttribute("seatType", bookingService.getCinemaSeatTypes());
		return new ModelAndView("BookingPage");
	}

	@GetMapping("/total-seat/{seatType}")
	public CinemaSeatDTO getTotalSeat(@PathVariable int seatType) {
		return bookingService.getTotalSeats(seatType);
	}

	@GetMapping("/payment-method")
	public List<PaymentMethodDTO> getPayment() {
		return bookingService.getPaymentMethods();
	}

	@PostMapping("/booking-detail")
	public void setBookingDetail(@RequestBody BookedTicketDTO bookedTicket) {
		bookingService.setBookingDetails(bookedTicket);
	}

	@RequestMapping("/booking-history")
	public ModelAndView getBookingHistoryPage(Model model) {
		model.addAttribute("username", userName);
		return new ModelAndView("BookingHistory");
	}

	@RequestMapping("/booking-history-list")
	public List<BookedTicketDTO> getBookingHistoryList() {
		return bookingService.getBookingHistoryLists(userName);
	}

	@RequestMapping("/payment-detail/{bookingId}")
	public BookedTicketDTO getPaymentDetail(@PathVariable int bookingId) {
		return bookingService.getPaymentDetails(bookingId);
	}

	@RequestMapping("/profile")
	public ModelAndView getProfilePage(Model model) {
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("profile", bookingService.getUserProfiles(userName));
		return new ModelAndView("userProfile");
	}

	@RequestMapping("/user-profile")
	public CustomerDTO getUserProfile() {
		return bookingService.getUserProfiles(userName);
	}

	@RequestMapping("/update-customer")
	public void getUpdateCustomer(@RequestBody CustomerDTO customer) {
		bookingService.getUpdateCustomers(customer);
	}

}