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
<title>Dash Board Page</title>
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
 	
  <c:forEach items="${movieList}" var="movieList">
		<div class="col-md-3">
			<div class="card bg-secondary " style="width: 20rem;">
				<img src="${movieList.imageUrl}" width="200" height="200" class="card-img-top" alt="...">
				<div class="card-body">
					<button  onclick="myFunction('${movieList.title}')" class="btn btn-primary">${movieList.title}</button>
					<p class="card-text"><strong><spring:message code="movietickect.moviedetails.genre" /> </strong>${movieList.genre}</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
	</body>
	</html>
	