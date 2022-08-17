<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value="/static/css/style.css" />" />
</head>
<body>

		<div id="failure" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong>
				<span>Failed !!</span>
			</div>
		</div>
		
		<div id="error" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong>
				<span>Something went wrong !!</span>
			</div>
		</div>
	<div class="container mt-5">
	<div id="error" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong> 
				<span>Wrong User Credentials !!</span>
			</div>
		</div>
		<div class="row m-auto p-4 mt-2">
			<div class="col-md-4 jumbotron offset-md-4 ">
				<h3 class="text-center">Login here</h3>
					<div class="form-group ">
						<label for="email">Email</label> 
						<input type="text" class="form-control" id="username" placeholder="Enter UsreName">  
					</div>
					<div class="form-group ">
						<label for="password">Password</label> 
						<input type="password" class="form-control" id="password" placeholder="Enter Password">
					</div>
				<div class="form-check mb-2">
					<input class="form-check-input" type="checkbox" value=0 onchange='handleChange(this);'id="adminlogin"> 
						<label class="form-check-label" for="flexCheckIndeterminate"> Admin </label>
				</div>
				<button type="submit" id="login" class="btn btn-primary btn-block">Submit</button>
					
					<div class="text-center mt-3">
					<a href="/MovieTickectBooking/RegisterPage">Create Account</a>
					</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
</body>
</html>