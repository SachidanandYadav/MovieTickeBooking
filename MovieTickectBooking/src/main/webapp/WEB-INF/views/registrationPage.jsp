<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
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
				<span><spring:message code="movietickect.message.addsuccess" /></span>
			</div>
		</div>
		<div id="error" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong> 
				<span><spring:message code="movietickect.message.error" /></span>
			</div>
		</div>

		<div class="row m-auto p-2 mt-1">
			<div class="col-md-6 jumbotron offset-md-3 ">
				<h3 class="text-center"><spring:message code="movietickect.registerpage.header" /></h3>
			
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="fname"><spring:message code="movietickect.registerpage.firstname" /></label> 
							<input type="text" class="form-control" id="first_name" name="first_name" placeholder="<spring:message code="movietickect.registerpage.placeholder.firstname" />">
							<span id="FirstnameError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="lname"><spring:message code="movietickect.registerpage.firstname" /></label> 
							<input type="text" class="form-control" id="last_name" name="last_name" placeholder="<spring:message code="movietickect.registerpage.placeholder.lastname" />">
							<span id="LastnameError" class="error"></span>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="email"><spring:message code="movietickect.registerpage.email" /></label> 
							<input type="email" class="form-control" id="email" name="email" placeholder="<spring:message code="movietickect.registerpage.placeholder.email" />">
							<span id="EmailError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="phone"><spring:message code="movietickect.registerpage.phone" /></label> 
							<input type="tel" class="form-control" id="phone" name="phone"placeholder="<spring:message code="movietickect.registerpage.placeholder.phone" />">
							<span id="PhoneError" class="error"></span>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="birth"><spring:message code="movietickect.registerpage.birthdate" /></label> 
							<input type="date" class="form-control" id="birth" name="birth">
							<span id="BirthError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-4 control-label"><spring:message code="movietickect.registerpage.gender" /></label>
							<div class="col-sm-12">
								<label class="radio-inline"><input type="radio"name="gender" id="gender" value="1" checked> <spring:message code="movietickect.registerpage.gender.male" /></label> 
								<label class="radio-inline ml-3"><input type="radio" name="gender" id="gender" value="2"> <spring:message code="movietickect.registerpage.gender.female" /></label> 
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputAddress"><spring:message code="movietickect.registerpage.address1" /></label> 
						<input type="text" class="form-control" id="addressLine1" name="addressLine1" placeholder="<spring:message code="movietickect.registerpage.placeholder.address1" />">
						<span id="AddressError" class="error"></span>
					</div>
					<div class="form-group">
						<label for="inputAddress2"><spring:message code="movietickect.registerpage.address2" /></label> 
						<input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="<spring:message code="movietickect.registerpage.placeholder.address2" />">
						<span id="Address2Error" class="error"></span>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="city"><spring:message code="movietickect.registerpage.city" /></label> 
							<select id="city"class="form-control">
								<option selected disabled>Choose...</option>
								<c:forEach items="${cityList}" var="cityList">
									<option value="${cityList.city_name}">${cityList.city_name}</option>
								</c:forEach>
							</select>
							<span id="CityError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="zip"><spring:message code="movietickect.registerpage.zipcode" /></label> 
							<input type="text" class="form-control" id="areaPincode" placeholder="<spring:message code="movietickect.registerpage.placeholder.zipcode" />" name="areaPincode">
							<span id="AreaPincodeError" class="error"></span>
						</div>
					</div>
					 <div class="form-row">
						<div class="form-group col-md-6">
							<label for="username"><spring:message code="movietickect.registerpage.username" /></label> 
							<input type="text" class="form-control" id="username" placeholder="<spring:message code="movietickect.registerpage.placeholder.username" />">
							<span id="UsernameError" class="error"></span>
						</div>
						<div class="form-group col-md-6">
							<label for="password"><spring:message code="movietickect.registerpage.password" /></label> 
							<input type="password" class="form-control" id="password" placeholder="<spring:message code="movietickect.registerpage.placeholder.password" />">
							<span id="PasswordError" class="error"></span>
						</div>
					</div>
				<div class="form-row ">
					<div class="form-group col-sm-2">
						<button type="submit" class="btn btn-primary" id="addCustomer"><spring:message code="movietickect.registerpage.submit" /></button>
					</div>
					<div class="form-group col-sm-3">
					<a href="/MovieTickectBooking/login-page"><button type="button" class="btn btn-danger"><spring:message code="movietickect.registerpage.back" /></button></a>
					
					</div>
				</div>

			</div>
		</div>
	</div>
	
		<script type="text/javascript" src="<c:url value="/static/js/loginScript.js" />"></script>
</body>
</html>