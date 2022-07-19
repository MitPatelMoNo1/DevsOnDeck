<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body class="dark-background">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand">DevsOnDeck</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/logout">LogOut</a>
      </li>
    </ul>
  </div>
</nav>
<p><a href="/jobs/new"><button  class="btn2 btn-success">List A New Position</button></a></p>
<div class="container">
	<hr>
	<table  class="table table-striped table-hover" >
		<thead>
			<tr>
			<th><h2>Positions</h2></th>
			<tr>
		</thead>
		<tbody>
		<c:forEach var="jobs" items="${jobService}">
			<tr>
			<td><a href="/jobs/${jobs.id}"><c:out  value = "${jobs.jobname}"></c:out></a><td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
</div>
<div class="container">
	<table  class="table table-striped table-hover" >
		<thead>
			<tr>
			<th><h2>Available Devs</h2></th>
			<tr>
		</thead>
		<tbody>
		<c:forEach var="devs" items="${devService}">
			<tr>
			<td><a href="/devs/${devs.id}"><c:out  value = "${devs.devname}"></c:out></a><td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
</div>
</body>
</html>