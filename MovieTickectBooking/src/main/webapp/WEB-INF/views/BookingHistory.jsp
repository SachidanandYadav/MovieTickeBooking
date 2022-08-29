<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Page</title>
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
		<div id="addSuccess" class=" mt-4 col-sm-12" style="display: none;">
			<div class="alert alert-success">
				<strong><em class="fa fa-thumbs-up"></em> </strong>
				<span>Data Add Successfully</span>
			</div>
		</div>
		
		<div id="deleteSuccess" class=" mt-4 col-sm-12" style="display: none;">
			<div class="alert alert-success">
				<strong><em class="fa fa-thumbs-up"></em> </strong>
				<span>Data Deleted Successfully</span>
			</div>
		</div>
		
		<div id="updateSuccess" class=" mt-4 col-sm-12" style="display: none;">
			<div class="alert alert-success">
				<strong><em class="fa fa-thumbs-up"></em> </strong>
				<span>Data Updated Successfully</span>
			</div>
		</div>
		
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
			<div>
					<h1 class="display-4">Booking</h1>
					<hr class="hr-primary" />
			</div>
	
			<div class="col-md-12 booking-div">
				<h1 class="mb-4">Booking History</h1>
				<table class="table table-hover" >
					<thead>
						<tr>
							<th>Booking Id </th>
							<th>Total Seat</th>
							<th>Booking Date/Time</th>
							<th>Show Time</th>
							<th>Payment Detail</th>
						</tr>
					</thead>
					<tbody id="booking-table" >
					</tbody>
				</table>
			</div>
				

			
			   <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Cinema Seat</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label">Amount</label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentAmout" disabled="disabled">
						</div>
					</div>
					
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label">Payment Method</label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentMethod" disabled="disabled">
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label">Payment Status</label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentStatus" disabled="disabled">
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label">Payment Date / Time</label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentTime" disabled="disabled">
						</div>
					</div>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
		</div> 
		
		
	</div>
	<script type="text/javascript" src="<c:url value="/static/js/paymentScript.js" />"></script>
</body>
</html>