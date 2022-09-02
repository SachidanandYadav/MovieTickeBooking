<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="/MovieTickectBooking/dashboard-page"><spring:message code="movietickect.headerpage.href.main" /></a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="/MovieTickectBooking/dashboard-page"><spring:message code="movietickect.headerpage.href.home" /></a></li>
         <li><a href="/MovieTickectBooking/profile"><spring:message code="movietickect.headerpage.href.profile" /></a></li>
        <li><a href="/MovieTickectBooking/booking-history"><spring:message code="movietickect.headerpage.href.bookedticket" /></a></li>
		</ul>
      <ul class="nav navbar-nav navbar-right">
       <li><a href=""><span class="glyphicon glyphicon-user"></span> ${username}</a></li>
      <%--   <li><span class="glyphicon glyphicon-user"></span></li> --%>
        <li><a href="/MovieTickectBooking/login-page"><span class="glyphicon glyphicon-log-out"></span><spring:message code="movietickect.headerpage.href.logout" /></a></li>
      </ul>
    </div>
  </nav>
  </body>
  </html>