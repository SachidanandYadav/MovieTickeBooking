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
					<h1 class="display-4">Movie</h1>
					<button type="button" class="btn btn-outline-primary waves-effec px-3" onclick="resetAllFiled()" data-toggle="modal" data-target="#exampleModal" ><i class="fa fa-plus" aria-hidden="true"></i></button>
				<hr class="hr-primary" />
			</div>
	
			<div class="col-md-12">
				<h1 class="mb-4">Movie List</h1>
				<table class="table table-hover" >
					<thead>
						<tr>
							<th>Movie ID</th>
							<th>Title</th>
							<th>Description</th>
							<th>Duration</th>
							<th>Language</th>
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
							<h5 class="modal-title" id="exampleModalLabel">Movie</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
						<input type="hidden" class="form-control" id="movieid">
						<div class="form-group row">
						<label for="title" class="col-sm-3 col-form-label">Title</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="title" placeholder="Title" name="title">
						</div>
					</div>
					<div class="form-group row">
						<label for="description" class="col-sm-3 col-form-label">Description</label>
						<div class="col-sm-8">
							<textarea class="form-control" id="description" placeholder="Description" name="description"></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label for="duration" class="col-sm-3 col-form-label">Duration</label>
						<div class="col-sm-8">
							<input type="time" class="form-control" id="duration" placeholder="Duration" name="Duration">
						</div>
					</div>
					<div class="form-group row">
						<label for="language" class="col-sm-3 col-form-label">Language</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="language" placeholder="Language" name="language">
						</div>
					</div>
					<div class="form-group row">
						<label for="releaseDate" class="col-sm-3 col-form-label">Release Date</label>
						<div class="col-sm-8">
							<input type="date" class="form-control" id="releaseDate" placeholder="Language" name="releaseDate">
						</div>
					</div>
					<div class="form-group row">
						<label for="genre" class="col-sm-3 col-form-label">Movie Genre</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="genre" placeholder="Gener" name="genre">
						</div>
					</div>
					
					<div class="form-group row">
						<label for="country" class="col-sm-3 col-form-label">Country</label>
						<div class="col-sm-8">
							<select id="country"class="form-control">
								<option selected disabled>Choose...</option>
								<c:forEach items="${countryList}" var="countryList">
									<option value="${countryList.country_name}">${countryList.country_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="imageUrl" class="col-sm-3 col-form-label">Image URL</label>
						<div class="col-sm-8">
							<textarea class="form-control" id="imageUrl" placeholder="Image Url" name="imageUrl"></textarea>
						</div>
					</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" data-dismiss="modal" class="btn btn-primary" id="Movie">Movie</button>
						</div>
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
	<script type="text/javascript" src="<c:url value="/static/js/movieScript.js" />"></script>
	
</body>
</html>