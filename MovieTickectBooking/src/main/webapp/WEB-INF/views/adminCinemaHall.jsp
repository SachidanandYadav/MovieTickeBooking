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
					<h1 class="display-4">Cinema Hall</h1>
					<button type="button" class="btn btn-outline-primary waves-effec px-3" onclick="resetAllFiled()" data-toggle="modal" data-target="#exampleModal" ><i class="fa fa-plus" aria-hidden="true"></i></button>
				<hr class="hr-primary" />
			</div>
	
			<div class="col-md-12">
				<h1 class="mb-4">Cinema Hall List</h1>
				<table class="table table-hover" >
					<thead>
						<tr>
							<th>Hall Id </th>
							<th>Hall Name</th>
							<th>Total Seat</th>
							<th>Address</th>
							<th>City Name </th>
							<th>State Name </th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="user-table" >
					</tbody>
				</table>
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
						<input type="hidden" class="form-control" id="hallid">
						<div class="form-group row">
						<label for="hallName" class="col-sm-3 col-form-label">Hall Name</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="hallName" placeholder="Hall Name">
						</div>
					</div>
					<div class="form-group row">
						<label for="totalSeat" class="col-sm-3 col-form-label">Total Seat</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="totalSeat" placeholder="Total Seat">
						</div>
					</div>
					<div class="form-group row">
						<label for="address" class="col-sm-3 col-form-label">Address</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="address" placeholder="Address">
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label">State</label>
						<div class="col-sm-8">
							<select id="stateid" class="form-control" onchange="selectOption()" >
								<option  selected disabled value="">Chose Option</option>
								<c:forEach items="${stateList}" var="stateList">
									<option value="${stateList.state_id}">${stateList.state_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="city" class="col-sm-3 col-form-label">City</label>
						<div class="col-sm-8">
							<select id="city" class="form-control" onchange="" >
							</select>
						</div>
					</div>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal" id="CinemaHall">Cinema Hall</button>
						</div>
				</div>
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
	<script type="text/javascript" src="<c:url value="/static/js/cinemaHallScript.js" />"></script>
</body>
</html>