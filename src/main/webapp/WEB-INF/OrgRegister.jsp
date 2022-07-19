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
<title>Organization Sign-Up</title>
</head>
<body class="dark-background">
	<div class= title>
		<div class=title-cont>
			</div>
	</div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand">DevsOnDeck</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/devs/register">Dev Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/orgs/login">Org Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/devs/login">Dev Login</a>
      </li>
    </ul>
  </div>
</nav>
	<div class="container">
	<form:form action="/orgs/register" method="post" modelAttribute="newOrg">
	<h1 class="welcome d-flex justify-content-center ">Organization Sign Up</h1>
	<table>
		<thead>
			<tr>
				<td>Org Name</td>
				<td>
					<form:errors path="org"/>
					<form:input class="input" path="org"/>
				</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>
					<form:errors path="firstName"/>
					<form:input class="input" path="firstName"/>
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>
					<form:errors path="lastName"/>
					<form:input class="input" path="lastName"/>
				</td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td>
					<form:errors path="email"/>
					<form:input class="input" path="email"/>
				</td>
			</tr>
			<tr>
				<td>Org Address</td>
				<td>
					<form:errors path="orgAddress"/>
					<form:input class="input" path="orgAddress"/>
				</td>
			</tr>
			<tr>
				<td>Org City</td>
				<td>
					<form:errors path="orgCity"/>
					<form:input class="input" path="orgCity"/>
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<form:errors path="state"/>
					<form:input class="input" path="state"/>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<form:errors path="password"/>
					<form:input class="input" path="password"/>
				</td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td>
					<form:errors path="confirm"/>
					<form:input class="input" path="confirm"/>
				</td>
			</tr>
			<tr>
				<td><input class="button" type="submit" value="Register"/></td>
			</tr>
		</thead>
	</table>
	</form:form>
	</div>
</body>
</html>