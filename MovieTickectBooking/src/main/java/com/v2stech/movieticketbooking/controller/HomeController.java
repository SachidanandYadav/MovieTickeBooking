package com.v2stech.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.movieticketbooking.model.AdminBookedTicket;
import com.v2stech.movieticketbooking.model.CinemaSeat;
import com.v2stech.movieticketbooking.model.City;
import com.v2stech.movieticketbooking.model.Customer;
import com.v2stech.movieticketbooking.model.Movie;
import com.v2stech.movieticketbooking.model.MovieShow;
import com.v2stech.movieticketbooking.model.PaymentMethod;
import com.v2stech.movieticketbooking.model.UserCredentials;
import com.v2stech.movieticketbooking.service.MovieTicketBookingService;

/**
 * @author v2stech
 *
 */
@RestController
public class HomeController {
	
	
	@Autowired
	MovieTicketBookingService bookingService;
	
	private String userName ;
	
	private Movie singleMovieDetail;
	
	private List<MovieShow> movieShowDetail;
		
	@RequestMapping("/LoginPage")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login");
	}

	@GetMapping("/RegisterPage")
	public ModelAndView getRegisterPage(Model model) {
		List<City> list = bookingService.getCityDatas();	
		model.addAttribute("cityList",list);
		return new ModelAndView("registrationPage");
	}
	
	@PostMapping("/customer")
	public ModelAndView saveCustomer(@RequestBody Customer customer) {
		bookingService.saveCustomerData(customer);
	  return null;
	}
	
	@PostMapping("/LoginCustomer")
	public String loginCustomer(@RequestBody UserCredentials user) {
	userName = user.getUser_name();
		return bookingService.getUserCredentials(user);
	}
	
	@RequestMapping("/dashboardPage")
	public ModelAndView getDashboardPage(Model model) {		
		List<Movie> movie = bookingService.getMovieDetails();
		model.addAttribute("movieList",movie);
		model.addAttribute("username",userName);
		return new ModelAndView("DashboardPage");
	}
	
	
	@RequestMapping("/adminDashboardPage")
	public ModelAndView getAdminDashboardPage(Model model) {		
		model.addAttribute("username",userName);
		return new ModelAndView("adminDashboardPage");
	}
	
	
	@GetMapping("/movieDetails/{movieName}")
	public String getFullDetails(@PathVariable String movieName,Model model) {
	singleMovieDetail =  bookingService.getMovieSingleDetail(movieName);
	return "movieDetailPage";
	}
	
	@RequestMapping("/movieDetailPage")
	public ModelAndView getMovieDetailPage(Model model) {
		model.addAttribute("username",userName);
		model.addAttribute("cityList", bookingService.getCityDatas());
		model.addAttribute("Movie",singleMovieDetail);
		return new ModelAndView("movieDetails");
	}
	
	
	@GetMapping("/MovieShowDetail/{hallId}/{title}")
	public String getMovieShowById(@PathVariable int hallId, @PathVariable String title, Model model) {
		movieShowDetail = bookingService.getMovieShowByHall(hallId, title);
		return "ShowDetailPage";
	}
	
	@RequestMapping("/ShowDetailPage")
	public ModelAndView getMovieShowPage(Model model) {
		model.addAttribute("username",userName);
		model.addAttribute("movieShow",movieShowDetail);
		return new ModelAndView("ShowDetails");
	}
	
	
	@RequestMapping("/ShowBookingPage")
	public ModelAndView getBookingPage(Model model) {
		model.addAttribute("username",userName);
		model.addAttribute("movieShow",movieShowDetail);
		model.addAttribute("seatType",bookingService.getCinemaSeatTypes());
		return new ModelAndView("BookingPage");
	}
	
	@GetMapping("/TotalSeat/{seatType}")
	public List<CinemaSeat> getTotalSeat(@PathVariable int seatType) {
		return bookingService.getTotalSeats(seatType);
	}

	@GetMapping("/PaymentMethod")
	public List<PaymentMethod> getPayment() {
		return bookingService.getPaymentMethods();
	}
	
	
	@PostMapping("/BookingDetail")
	public void setBookingDetail(@RequestBody AdminBookedTicket bookedTicket) {
		bookingService.setBookingDetails(bookedTicket);
	}
	
	@RequestMapping("/BookingHistory")
	public ModelAndView getBookingHistoryPage(Model model) {
		model.addAttribute("username",userName);
		return new ModelAndView("BookingHistory");
	}

	@RequestMapping("/BookingHistoryList")
	public List<AdminBookedTicket> getBookingHistoryList() {
		return bookingService.getBookingHistoryLists(userName);
	}
	
	@RequestMapping("/paymentDetail/{bookingId}")
	public List<AdminBookedTicket> getPaymentDetail(@PathVariable int bookingId) {
		return bookingService.getPaymentDetails(bookingId);
	}

	
}