<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<div class="col-md-12 table-section" >
				<h1 class="mb-4">Movie Show Detail</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Movie Show Detail</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="user-table">
					<c:forEach items="${movieShow}" var="movieShow">
							<tr>
							<td>Movie : ${movieShow.title}<br>
							Description : ${movieShow.description}/Language : ${movieShow.language}<br>
							Start Time : ${movieShow.startTime} / End Time : ${movieShow.endTime}
							</td>
							<td>
							<a href="/MovieTickectBooking/show-booking-page"><button type="button" class="btn btn-danger">Booking</button></a>
							</td>
							</tr>
						</c:forEach>
					
					</tbody>
				</table>
			</div>
		</div>
	
	
	<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
</body>
</html>