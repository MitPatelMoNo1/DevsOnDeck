<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Add A Job</title>
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
        <a class="nav-link" href="/orgs/dashboard">Main Page</a>
      </li>
    </ul>
  </div>
</nav>
<div class="container">
<form:form class="form" action="/jobs" method="post" modelAttribute="job">
	<hr>
	<table>
		<thead>
			<tr>
				<td><h3>Create A Job Listing</h3></td>
			</tr>
		</thead>
		<thead>
			<tr>
				<td>Name</td>
				<td>
					<form:errors path="jobname"/>
					<form:input class="input" path="jobname"/>
				</td>
			</tr>
			<tr>
			<td>Description</td>
				<td>
					<form:errors path="jobdesc"/>
					<form:textarea class="input" path="jobdesc" rows="7" cols="30"/>
				</td>
			</tr>
			<tr>
			<td>Skills</td>
			<td>
				<form:errors path="skills"/>
  				Java <form:checkbox path="skills" value="Java"/>
  			   Danjo <form:checkbox path="skills" value="Danjo"/>
  			   Flask <form:checkbox path="skills" value="Flask"/>
  			   Rails <form:checkbox path="skills" value="Rails"/>
  			   Spring <form:checkbox path="skills" value="Spring"/>
  				SQL	 <form:checkbox path="skills" value="SQL"/>
  				JS	 <form:checkbox path="skills" value="JS"/>
  				C#	 <form:checkbox path="skills" value="C#"/>
  				GO	 <form:checkbox path="skills" value="GO"/>
  				CSS	 <form:checkbox path="skills" value="CSS"/>
  				RUBY <form:checkbox path="skills" value="RUBY"/>
  			  Python <form:checkbox path="skills" value="Python"/>
  			</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</thead>
	</table>
	</form:form>
</div>
</body>
</html>