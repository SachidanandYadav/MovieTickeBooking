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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value="/static/css/style.css" />" />
</head>
<body>
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

		<div class="row m-auto p-2 mt-1">
			<div class="col-md-6 jumbotron offset-md-3 ">
				<h3 class="text-center">Register here</h3>
			
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="fname">First Name</label> 
							<input type="text" class="form-control" id="first_name" name="first_name" placeholder="First Name">
							<span id="FirstnameError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="lname">Last Name</label> 
							<input type="text" class="form-control" id="last_name" name="last_name" placeholder="Last Name">
							<span id="LastnameError" class="error"></span>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="email">Email</label> 
							<input type="email" class="form-control" id="email" name="email" placeholder="Email">
							<span id="EmailError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="phone">Phone</label> 
							<input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone">
							<span id="PhoneError" class="error"></span>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="birth">Birth Date</label> 
							<input type="date" class="form-control" id="birth" name="birth" placeholder="Birth Date">
							<span id="BirthError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-4 control-label">Gender</label>
							<div class="col-sm-12">
								<label class="radio-inline"><input type="radio"name="gender" id="gender" value="1" checked> Mail</label> 
								<label class="radio-inline ml-3"><input type="radio" name="gender" id="gender" value="2"> Femail</label> 
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputAddress">Address</label> 
						<input type="text" class="form-control" id="addressLine1" name="addressLine1" placeholder="1234 Main St">
						<span id="AddressError" class="error"></span>
					</div>
					<div class="form-group">
						<label for="inputAddress2">Address 2</label> 
						<input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="Apartment, studio, or floor">
						<span id="Address2Error" class="error"></span>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="city">City</label> 
							<select id="city"class="form-control">
								<option selected disabled>Choose...</option>
								<c:forEach items="${cityList}" var="cityList">
									<option value="${cityList.city_name}">${cityList.city_name}</option>
								</c:forEach>
							</select>
							<span id="CityError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="zip">Zip Code</label> 
							<input type="text" class="form-control" id="areaPincode" name="areaPincode">
							<span id="AreaPincodeError" class="error"></span>
						</div>
					</div>
					 <div class="form-row">
						<div class="form-group col-md-6">
							<label for="username">Username</label> 
							<input type="text" class="form-control" id="username" placeholder="Username">
							<span id="UsernameError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="password">Password</label> 
							<input type="password" class="form-control" id="password" placeholder="Password">
							<span id="PasswordError" class="error"></span>
						</div>
					</div>
				<div class="form-row ">
					<div class="form-group col-sm-2">
						<button type="submit" class="btn btn-primary" id="addCustomer">Sign in</button>
					</div>
					<div class="form-group col-sm-3">
						<button type="button" class="btn btn-danger">Back</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	
		<script type="text/javascript" src="<c:url value="/static/js/loginScript.js" />"></script>
</body>
</html>