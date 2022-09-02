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
<title>Booking History Page</title>
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
				<span><spring:message code="movietickect.message.addsuccess" /></span>
			</div>
		</div>
		<div id="error" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong> 
				<span><spring:message code="movietickect.message.error" /></span>
			</div>
		</div> 
		
		<div id="deleteSuccess" class=" mt-4 col-sm-12" style="display: none;">
			<div class="alert alert-success">
				<strong><em class="fa fa-thumbs-up"></em> </strong>
				<span><spring:message code="movietickect.message.delete.success" /></span>
			</div>
		</div>
		
		<div id="updateSuccess" class=" mt-4 col-sm-12" style="display: none;">
			<div class="alert alert-success">
				<strong><em class="fa fa-thumbs-up"></em> </strong>
				<span><spring:message code="movietickect.message.update.success" /></span>
			</div>
		</div>
		
		
		
		<div id="failure" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong>
				<span><spring:message code="movietickect.message.failure" /></span>
			</div>
		</div>
		
		
			<div>
					<h1 class="display-4"><spring:message code="movietickect.bookinghistorypage.main.title" /></h1>
					<hr class="hr-primary" />
			</div>
	
			<div class="col-md-12 booking-div">
				<h1 class="mb-4"><spring:message code="movietickect.bookinghistorypage.body.title" /></h1>
				<table class="table table-hover" >
					<thead>
						<tr>
							<th><spring:message code="movietickect.bookinghistorypage.table.th.bookingid" /></th>
							<th><spring:message code="movietickect.bookinghistorypage.table.th.totalseat" /></th>
							<th><spring:message code="movietickect.bookinghistorypage.table.th.bookingdate" /></th>
							<th><spring:message code="movietickect.bookinghistorypage.table.th.showtime" /></th>
							<th><spring:message code="movietickect.bookinghistorypage.table.th.paymetdetail" /></th>
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
							<h5 class="modal-title" id="exampleModalLabel"><spring:message code="movietickect.bookinghistorypage.model.title" /></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookinghistorypage.model.lable.amount" /></label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentAmout" disabled="disabled">
						</div>
					</div>
					
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookinghistorypage.model.lable.paymentmenthod" /></label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentMethod" disabled="disabled">
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookinghistorypage.model.lable.paymentstatus" /></label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentStatus" disabled="disabled">
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookinghistorypage.model.lable.paymentdate" /></label>
						<div class="col-sm-8">
						<input type="text" class="form-control" id="paymentTime" disabled="disabled">
						</div>
					</div>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal"><spring:message code="movietickect.bookinghistorypage.model.close" /></button>
						</div>
				</div>
			</div>
		</div> 
		
		
	</div>
	<script type="text/javascript" src="<c:url value="/static/js/paymentScript.js" />"></script>
</body>
</html>