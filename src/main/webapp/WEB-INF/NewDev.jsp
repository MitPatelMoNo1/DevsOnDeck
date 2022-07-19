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
      </li>
    </ul>
  </div>
</nav>
<h2>Create A Profile</h2>
<div class="container">
<form:form class="form" action="/devs" method="post" modelAttribute="dev">
	<hr>
	<table>
		<thead>
			
		</thead>
		<thead>
			<tr>
				<td>Name</td>
				<td>
					<form:errors path="devname"/>
					<form:input class="input" path="devname"/>
				</td>
			</tr>
			<tr>
			<td>Description</td>
				<td>
					<form:errors path="devdescription"/>
					<form:textarea class="input" path="devdescription" rows="7" cols="30"/>
				</td>
			</tr>
			<tr>
			<td>Languages</td>
			<td>
				<form:errors path="languages"/>
  				Java <form:checkbox path="languages" value="Java"/>
  			   Danjo <form:checkbox path="languages" value="Danjo"/>
  			   Flask <form:checkbox path="languages" value="Flask"/>
  			   Rails <form:checkbox path="languages" value="Rails"/>
  			   Spring <form:checkbox path="languages" value="Spring"/>
  				SQL	 <form:checkbox path="languages" value="SQL"/>
  				JS	 <form:checkbox path="languages" value="JS"/>
  				C#	 <form:checkbox path="languages" value="C#"/>
  				GO	 <form:checkbox path="languages" value="GO"/>
  				CSS	 <form:checkbox path="languages" value="CSS"/>
  				RUBY <form:checkbox path="languages" value="RUBY"/>
  			  Python <form:checkbox path="languages" value="Python"/>
  			</td>
			</tr>
			<tr>
			<td>Frameworks</td>
			<td>
				<form:errors path="frameworks"/>
  				Java <form:checkbox path="frameworks" value="Java"/>
  			   Danjo <form:checkbox path="frameworks" value="Danjo"/>
  			   Flask <form:checkbox path="frameworks" value="Flask"/>
  			   Rails <form:checkbox path="frameworks" value="Rails"/>
  			   Spring <form:checkbox path="frameworks" value="Spring"/>
  				SQL	 <form:checkbox path="frameworks" value="SQL"/>
  				JS	 <form:checkbox path="frameworks" value="JS"/>
  				C#	 <form:checkbox path="frameworks" value="C#"/>
  				GO	 <form:checkbox path="frameworks" value="GO"/>
  				CSS	 <form:checkbox path="frameworks" value="CSS"/>
  				RUBY <form:checkbox path="frameworks" value="RUBY"/>
  			  Python <form:checkbox path="frameworks" value="Python"/>
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