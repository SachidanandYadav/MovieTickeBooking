<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
	background-attachment: fixed;
	background-size:cover;
	background-image:
		url("https://media.istockphoto.com/photos/theatre-curtains-background-picture-id173588123?b=1&k=20&m=173588123&s=170667a&w=0&h=v5hk2I3ACNaWSn0VZeD39iwQ6uLSrf-qb0Dfezr4bNM=");	
}
.col-8{
    background-color: aqua;
    padding: 3%;
    margin: 10px 30px;
   	text-align: center;
}
.link{
font-size: xx-large;
font-family: monospace;
text-decoration: none !important;
}
  </style>
</head>
  <body>
  <%@include file="adminHeaderPage.jsp"%>
  <div class="container">
  <div class="row">
  <div class="col-8 col-md-3 " ><a class="link" href="/MovieTickectBooking/booking-page">Booked Ticket</a></div>
  <div class="col-8 col-md-3 "><a class="link" href="/MovieTickectBooking/movie">Movie</a></div>
  <div class="col-8 col-md-3"><a class="link" href="/MovieTickectBooking/movie-show">Movie Show</a></div>
</div>
<div class="row">
  <!-- <div class="col-8 col-md-3 "><a class="link" href="/MovieTickectBooking/show-seat">Show Seat</a></div> -->
  <div class="col-8 col-md-3 "><a class="link" href="/MovieTickectBooking/cinema-hall">Cinema Hall</a></div>
  <div class="col-8 col-md-3"><a class="link" href="/MovieTickectBooking/cinema-seat">Cinema Seat</a></div>
  <div class="col-8 col-md-3 "><a class="link" href="/MovieTickectBooking/payment-page">Ticket Payment</a></div>
</div>
	</div>
	<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
	</body>
	</html>
	