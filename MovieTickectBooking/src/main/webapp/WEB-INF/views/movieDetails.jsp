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
   <link rel="stylesheet" href="<c:url value="/static/css/image.css" />" />
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
		<div class="col-md-12 boundery">
			<div class="col-md-8 inner-boundery">
				<h1 class="title"><input type='hidden'  id='movieTitle' value="${Movie.title} "> Movie : ${Movie.title}</h1>
				<h3>Description : ${Movie.description}</h3>
				<h5>Genre :<strong> ${Movie.genre}</strong> / language :<strong> ${Movie.language} </strong></h5>
				<h4>Release Date : ${Movie.releaseDate}</h4>
			</div>
			<div class="col-md-3 image">
				<img src="${Movie.imageUrl}" alt="...">
			</div>
		</div>
	</div>
	<div class="container">
		<div class="body">
			<h1 class="title">To Book Tickect</h1>
			<div class="form-group row col-md-6 city">
				<label for="city" class="col-sm-3 col-form-label">Select City:</label>
				<div class="col-sm-8">
					<select id="cityid" class="form-control"
						onchange="selectCityOption()">
						<option selected disabled>Choose...</option>
						<c:forEach items="${cityList}" var="cityList">
							<option value="${cityList.city_id}">${cityList.city_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="col-md-8" id="table-div">
			<h1 class="mb-4">Cinema Hall</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Cinema Hall Name</th>
						<th>Cinema Address</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="user-table">
				</tbody>
			</table>
		</div>
		<div class="col-sm-3 back-button">
		<a href="/MovieTickectBooking/dashboard-page"><button type="button" class="btn btn-danger">Back</button></a>	
		</div>
	</div>


	<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
</body>
</html>