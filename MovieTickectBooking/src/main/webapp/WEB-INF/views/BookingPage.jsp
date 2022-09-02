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
				<span><spring:message code="movietickect.bookingpage.success.payment" /></span>
			</div>
		</div>
		<div id="failure" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong>
				<span><spring:message code="movietickect.message.failure" /></span>
			</div>
		</div>
		
		<div id="error" class="col-sm-12" style="display: none;">
			<div class="alert alert-danger">
				<strong><em class="fa fa-thumbs-down"></em> </strong>
				<span><spring:message code="movietickect.message.error" /></span>
			</div>
		</div>
	
		<div class="modal-content col-md-8 block">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"><spring:message code="movietickect.bookingpage.modal.title" /></h5>
						</div>
						<div class="modal-body">
						<input type="hidden" class="form-control" id="hallid">
						<input type="hidden" class="form-control" value="${username}" id="userName">
						<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookingpage.modal.label.seattype" /></label>
						<div class="col-sm-8">
							<select id="seatType" class="form-control" onchange="totalSeat()" required="required" >
								<option  selected disabled value="">Chose Option</option>
								<c:forEach items="${seatType}" var="seatType">
									<option value="${seatType.seatType_id}">${seatType.seatName}</option>
								</c:forEach>
							</select>
							<span id="SeatTypeError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="totalSeat" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookingpage.modal.label.seatavailable" /></label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="totalSeat" placeholder="<spring:message code="movietickect.bookingpage.modal.placeholder.totalseat" />" disabled="disabled">
							
						</div>
					</div>
					<div class="form-group row">
						<label for="address" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookingpage.modal.label.seatprice" /></label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="seatPrice" placeholder="<spring:message code="movietickect.bookingpage.modal.placeholder.seatprice" />" disabled="disabled">
						</div>
					</div>
					<div class="form-group row">
						<label for="address" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookingpage.modal.label.totalseat" /></label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="seat" placeholder="<spring:message code="movietickect.bookingpage.modal.placeholder.totalseat" />" onkeyup="totalPrice()" required="required">
							<span id="SeatError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookingpage.modal.label.totalamount" /></label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="totalAmount" placeholder="<spring:message code="movietickect.bookingpage.modal.placeholder.totalamount" />" disabled="disabled">
						</div>
					</div>
					</div>
						<div class="modal-footer">
							<a href="/MovieTickectBooking/show-detail-page"><button type="button" class="btn btn-danger"><spring:message code="movietickect.bookingpage.modal.button.back" /></button></a>
							<button type="submit" class="btn btn-primary" onclick="payment()"><spring:message code="movietickect.bookingpage.modal.button.payment" /></button>
						</div>
				</div>
				
				
				
				
				
					 <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"><spring:message code="movietickect.bookingpage.modal.payment.title" /></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
						<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookingpage.modal.label.totalamount" /></label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="finalAmount"  disabled="disabled">
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label"><spring:message code="movietickect.bookingpage.modal.payment.label.paymentmethod" /></label>
						<div class="col-sm-8">
							<select id="PaymentMethod" class="form-control" onchange="totalSeat()" required="required" >
								<option  selected disabled value="">Chose Option</option>
							</select>
							<span id="PaymentMethodError" class="error"></span>
						</div>
					</div>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal"><spring:message code="movietickect.bookingpage.modal.payment.button.close" /></button>
							<button type="button" class="btn btn-primary"  id="pay"><spring:message code="movietickect.bookingpage.modal.payment.button.pay" /></button>
						</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
</body>
</html>