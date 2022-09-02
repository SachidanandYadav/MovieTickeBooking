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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <link rel="stylesheet" href="<c:url value="/static/css/AdminCss.css" />" />
</head>
<body>
  <%@include file="adminHeaderPage.jsp"%>
	<div class="wrapper">
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
					<h1 class="display-4"><spring:message code="movietickect.adminmoviespage.main.title" /></h1>
					<button type="button" class="btn btn-outline-primary waves-effec px-3" onclick="resetAllFiled()" data-toggle="modal" data-target="#exampleModal" ><i class="fa fa-plus" aria-hidden="true"></i></button>
				<hr class="hr-primary" />
			</div>
	
			<div class="col-md-12">
				<h1 class="mb-4"><spring:message code="movietickect.adminmoviespage.body.title" /></h1>
				<table class="table table-hover" >
					<thead>
						<tr>
							<th><spring:message code="movietickect.adminmoviespage.table.th.movieid" /></th>
							<th><spring:message code="movietickect.adminmoviespage.table.th.title" /></th>
							<th><spring:message code="movietickect.adminmoviespage.table.th.description" /></th>
							<th><spring:message code="movietickect.adminmoviespage.table.th.duration" /></th>
							<th><spring:message code="movietickect.adminmoviespage.table.th.language" /></th>
							<th><spring:message code="movietickect.adminmoviespage.table.th.action" /></th>
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
							<h5 class="modal-title" id="exampleModalLabel"><spring:message code="movietickect.adminmoviespage.model.title" /></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
						<input type="hidden" class="form-control" id="movieid">
						<div class="form-group row">
						<label for="title" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.title" /></label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="title" placeholder="Title" name="title">
							<span id="TitleError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="description" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.description" /></label>
						<div class="col-sm-8">
							<textarea class="form-control" id="description" placeholder="Description" name="description"></textarea>
							<span id="DescriptionError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="duration" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.duration" /></label>
						<div class="col-sm-8">
							<input type="time" class="form-control" id="duration" placeholder="Duration" name="Duration">
							<span id="DurationError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="language" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.language" /></label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="language" placeholder="Language" name="language">
							<span id="LanguageError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="releaseDate" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.releasedate" /></label>
						<div class="col-sm-8">
							<input type="date" class="form-control" id="releaseDate" placeholder="Date" name="releaseDate">
							<span id="ReleaseDateError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="genre" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.genre" /></label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="genre" placeholder="Gener" name="genre">
							<span id="GenreError" class="error"></span>
						</div>
					</div>
					
					<div class="form-group row">
						<label for="country" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.image" /></label>
						<div class="col-sm-8">
							<select id="country"class="form-control">
								<option selected disabled>Choose...</option>
								<c:forEach items="${countryList}" var="countryList">
									<option value="${countryList.country_name}">${countryList.country_name}</option>
								</c:forEach>
							</select>
							<span id="CountryError" class="error"></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="imageUrl" class="col-sm-3 col-form-label"><spring:message code="movietickect.adminmoviespage.model.lable.image" /></label>
						<div class="col-sm-8">
							<textarea class="form-control" id="imageUrl" placeholder="Image Url" name="imageUrl"></textarea>
							<span id="ImageUrlError" class="error"></span>
						</div>
					</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
							onclick="restAllError()" data-dismiss="modal"><spring:message code="movietickect.adminmoviespage.model.button.close" /></button>
							<button type="button"  class="btn btn-primary" id="Movie"><spring:message code="movietickect.adminmoviespage.model.button.movie" /></button>
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
							<spring:message code="movietickect.adminmoviespage.model.delete.confirm" />
							<button type="button" class="close" data-dismiss="modal"aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body"><spring:message code="movietickect.adminmoviespage.model.delete.body" />
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="movietickect.adminmoviespage.model.delete.cancle" /></button>
							<a class="btn btn-danger btn-ok" id="delete" data-dismiss="modal"><spring:message code="movietickect.adminmoviespage.model.button.delete" /></a>
						</div>
					</div>
				</div>
			</div>
		
	</div>
	<script type="text/javascript" src="<c:url value="/static/js/movieScript.js" />"></script>
	
</body>
</html>