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
<div class="container mt-2">
		<div id="addSuccess" class=" mt-4 col-sm-12" style="display: none;">
			<div class="alert alert-success">
				<strong><em class="fa fa-thumbs-up"></em> </strong> 
				<span>Data Add Successfully</span>
			</div>
		</div>
		<div id="error" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong> 
				<span>Something went wrong !!</span>
			</div>
		</div>
		<div class="col-md-6 profile-div">
		<table class="table">
			<tbody>
				<tr>
					<td>First Name</td>
					<td>${profile.first_name}</td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>${profile.last_name}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${profile.email}</td>
				</tr>
				<tr>
					<td>Phone</td>
					<td>${profile.phone}</td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td>${profile.birth}</td>
				</tr>
				<tr>
					<td>Address 1</td>
					<td>${profile.addressLine1}</td>
				</tr>
				<tr>
					<td>Address 2</td>
					<td>${profile.addressLine2}</td>
				</tr>
				 <tr>
					<td>Aera Pincode</td>
					<td>${profile.areaPincode}</td>
				</tr>
				 <tr>
					<td>City</td>
					<td>${profile.city_name}</td>
				</tr>		
				<tr>
					<td rowspan="2"><button type="button" class="btn btn-primary" id="editCustomer"  data-toggle="modal" data-target="#exampleModal" >Edit Profile</button></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
	
	 <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Cinema Hall</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
						<input type="hidden" class="form-control" id="customerId">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="fname">First Name</label> <input type="text"
									class="form-control" id="firstname" name="first_name"
									placeholder="First Name">
							</div>
							<div class="form-group col-md-6">
								<label for="lname">Last Name</label> <input type="text"
									class="form-control" id="lastname" name="last_name"
									placeholder="Last Name">
							</div>
						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="email">Email</label> <input type="email"
									class="form-control" id="email" name="email"
									placeholder="Email">
							</div>
							<div class="form-group col-md-6">
								<label for="phone">Phone</label> <input type="tel"
									class="form-control" id="phone" name="phone"
									placeholder="Phone">
							</div>
						</div>

						<div class="form-row">
						<div class="form-group col-md-6">
							<label for="birth">Birth Date</label> 
							<input type="date" class="form-control" id="birth" name="birth" placeholder="Birth Date">
						</div>
					</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputAddress">Address 1</label> <input type="text"
									class="form-control" id="addressLine1" name="addressLine1"
									placeholder="1234 Main St">
							</div>
							<div class="form-group col-md-6">
								<label for="inputAddress2">Address 2</label> <input type="text"
									class="form-control" id="addressLine2" name="addressLine2"
									placeholder="Apartment, studio, or floor">
							</div>
						</div>


						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="city">City</label> 
								<select id="city" class="form-control">
								<option selected disabled>Select City..</option>
									<c:forEach items="${cityList}" var="cityList">
										<option value="${cityList.city_id}">${cityList.city_name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-6">
								<label for="zip">Zip Code</label> <input type="text"
									class="form-control" id="areaPincode" name="areaPincode">
							</div>
						</div>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary" onclick="updateCustomer()" data-dismiss="modal" id="CinemaHall">Cinema Hall</button>
						</div>
				</div>
			</div>
		</div> 
	
		<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
</body>
</html>