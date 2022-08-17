<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.hr-primary{
border: 2px solid lightgray;
}
</style>
</head>
<body>
 <%@include file="adminHeaderPage.jsp"%>
	<div class="wrapper">
		<div class="container">
			<div id="addSuccess" class=" mt-4 col-sm-12" style="display: none;">
				<div class="alert alert-success">
					<strong><em class="fa fa-thumbs-up"></em> </strong> <span>Data
						Add Successfully</span>
				</div>
			</div>

			<div id="deleteSuccess" class=" mt-4 col-sm-12"
				style="display: none;">
				<div class="alert alert-success">
					<strong><em class="fa fa-thumbs-up"></em> </strong> <span>Data
						Deleted Successfully</span>
				</div>
			</div>

			<div id="updateSuccess" class=" mt-4 col-sm-12"
				style="display: none;">
				<div class="alert alert-success">
					<strong><em class="fa fa-thumbs-up"></em> </strong> <span>Data
						Updated Successfully</span>
				</div>
			</div>

			<div id="failure" class="col-sm-12" style="display: none;">
				<div class="alert alert-danger">
					<strong><em class="fa fa-thumbs-down"></em> </strong> <span>Failed
						!!</span>
				</div>
			</div>

			<div id="error" class="col-sm-12" style="display: none;">
				<div class="alert alert-danger">
					<strong><em class="fa fa-thumbs-down"></em> </strong> <span>Something
						went wrong !!</span>
				</div>
			</div>
			<div>
				<h1 class="display-4">Ticket</h1>
				<hr class="hr-primary" />
			</div>

			<div class="col-md-12">
				<h1 class="mb-4">Booked Ticket</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Booking ID</th>
							<th>Total Seat</th>
							<th>Booking Time</th>
							<th>User Name</th>
							<th>Show Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="user-table">
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="modal fade" id="confirm-delete" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							Confirm Delete
							<button type="button" class="close" data-dismiss="modal"aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">Are you sure you wanna delete this ?
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
							<a class="btn btn-danger btn-ok" id="delete" data-dismiss="modal">Delete</a>
						</div>
					</div>
				</div>
			</div>
	</div>
	<script type="text/javascript" src="<c:url value="/static/js/bookingScript.js" />"></script>
	
</body>
</html>