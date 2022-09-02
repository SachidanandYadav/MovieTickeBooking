package com.v2stech.movieticketbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.exception.InvalidCredentialException;
import com.v2stech.movieticketbooking.exception.BindingResultException;
import com.v2stech.movieticketbooking.exception.InvalidSeatException;
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
 * @author Sachidanand Yadav
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

	/**
	 * @return Login Page
	 */
	@RequestMapping("/login-page")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login");
	}

	/**
	 * @param model
	 * @return Registration Page
	 */
	@GetMapping("/register-page")
	public ModelAndView getRegisterPage(Model model) {
		List<CityDTO> list = bookingService.getCityDatas();
		model.addAttribute("cityList", list);
		return new ModelAndView("registrationPage");
	}

	/**
	 * @param customer
	 * @param result
	 * @throws BindingResultException
	 * Add New Customer 
	 */
	@PostMapping("/customer")
	public void saveCustomer(@Valid @RequestBody CustomerDTO customer, BindingResult result) throws BindingResultException {
		if (result.hasErrors()) {
			throw new BindingResultException(result);
		} else {
			bookingService.saveCustomerData(customer);
		}
	}

	/**
	 * @param user
	 * @param result
	 * @return Check Credential For Login.
	 * @throws InvalidCredentialException
	 * @throws BindingResultException
	 */
	@PostMapping("/login-customer")
	public String loginCustomer(@Valid @RequestBody UserCredentialsDTO user, BindingResult result)
			throws InvalidCredentialException, BindingResultException {
		if (result.hasErrors()) {
			throw new BindingResultException(result);
		} else {
			userName = user.getUserName();
			return bookingService.getUserCredentials(user);
		}

	}

	/**
	 * @param model
	 * @return Dash Board Page.
	 */
	@RequestMapping("/dashboard-page")
	public ModelAndView getDashboardPage(Model model) {
		List<MovieDTO> movie = bookingService.getMovieDetails();
		model.addAttribute("movieList", movie);
		model.addAttribute("username", userName);
		return new ModelAndView("DashboardPage");
	}

	/**
	 * @param model
	 * @return Admin Dash Board Page.
	 */
	@RequestMapping("/admin-dashboard-page")
	public ModelAndView getAdminDashboardPage(Model model) {
		model.addAttribute("username", userName);
		return new ModelAndView("adminDashboardPage");
	}

	/**
	 * @param movieName
	 * @param model
	 * @return Controller name in String.
	 */
	@GetMapping("/movie-details/{movieName}")
	public String getFullDetails(@PathVariable String movieName, Model model) {
		singleMovieDetail = bookingService.getMovieSingleDetail(movieName);
		return "movie-detail-page";
	}

	/**
	 * @param model
	 * @return Single movie Details Page
	 */
	@RequestMapping("/movie-detail-page")
	public ModelAndView getMovieDetailPage(Model model) {
		model.addAttribute("username", userName);
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("Movie", singleMovieDetail);
		return new ModelAndView("movieDetails");
	}

	/**
	 * @param hallId
	 * @param title
	 * @param model
	 * @return Show Detail Page Controller  
	 */
	@GetMapping("/movie-show-detail/{hallId}/{title}")
	public String getMovieShowById(@PathVariable int hallId, @PathVariable String title, Model model) {
		movieShowDetail = bookingService.getMovieShowByHall(hallId, title);
		return "show-detail-page";
	}

	/**
	 * @param model
	 * @return Show Detail Page
	 */
	@RequestMapping("/show-detail-page")
	public ModelAndView getMovieShowPage(Model model) {
		model.addAttribute("username", userName);
		model.addAttribute("movieShow", movieShowDetail);
		return new ModelAndView("ShowDetails");
	}

	/**
	 * @param model
	 * @return Booking Page
	 */
	@RequestMapping("/show-booking-page")
	public ModelAndView getBookingPage(Model model) {
		model.addAttribute("username", userName);
		model.addAttribute("movieShow", movieShowDetail);
		model.addAttribute("seatType", bookingService.getCinemaSeatTypes());
		return new ModelAndView("BookingPage");
	}

	/**
	 * @param seatType
	 * @return Total Seat By Seat Type.
	 */
	@GetMapping("/total-seat/{seatType}")
	public CinemaSeatDTO getTotalSeat(@PathVariable int seatType) {
		return bookingService.getTotalSeats(seatType);
	}

	/**
	 * @return Payment Method Detail.
	 */
	@GetMapping("/payment-method")
	public List<PaymentMethodDTO> getPayment() {
		return bookingService.getPaymentMethods();
	}

	/**
	 * @param bookedTicket
	 * @throws InvalidSeatException
	 * Add Booking Details.
	 */
	@PostMapping("/booking-detail")
	public void setBookingDetail(@RequestBody BookedTicketDTO bookedTicket) throws InvalidSeatException {
		bookingService.setBookingDetails(bookedTicket);
	}
	

	/**
	 * @param model
	 * @return Booking History.
	 */
	@RequestMapping("/booking-history")
	public ModelAndView getBookingHistoryPage(Model model) {
		model.addAttribute("username", userName);
		return new ModelAndView("BookingHistory");
	}

	/**
	 * @return Booking History By User Name
	 */
	@RequestMapping("/booking-history-list")
	public List<BookedTicketDTO> getBookingHistoryList() {
		return bookingService.getBookingHistoryLists(userName);
	}

	/**
	 * @param bookingId
	 * @return Payment Details By Booking Id
	 */
	@RequestMapping("/payment-detail/{bookingId}")
	public BookedTicketDTO getPaymentDetail(@PathVariable int bookingId) {
		return bookingService.getPaymentDetails(bookingId);
	}

	/**
	 * @param model
	 * @return User Profile Controller
	 */
	@RequestMapping("/profile")
	public ModelAndView getProfilePage(Model model) {
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("profile", bookingService.getUserProfiles(userName));
		return new ModelAndView("userProfile");
	}

	/**
	 * @return User Profile By UserName
	 */
	@RequestMapping("/user-profile")
	public CustomerDTO getUserProfile() {
		return bookingService.getUserProfiles(userName);
	}

	/**
	 * @param customer
	 * @param id
	 * Update Customer By Customer Id.
	 */
	@RequestMapping("/update-customer/{id}")
	public void getUpdateCustomer(@RequestBody CustomerDTO customer,@PathVariable int id) {
		bookingService.getUpdateCustomers(customer,id);
	}

}