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
<title>Job</title>
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
      <li>
      	<a class="nav-link" href="/orgs/dashboard">Main-Page</a>
      </li>
      <li>
      	<a class="nav-link" href="/jobs/new">Add A Job</a> 
      </li>
    </ul>
  </div>
</nav>
<h2>Job Posting</h2>
<div class="container2">
	<table  class="table table-striped table-hover" >
			    <thead>
			        <tr>
			            <th class = "white">Name</th>
			            <th class = "white">Description</th>
			            <th class = "white">Skills</th>
			        </tr>
			    </thead>
			   	<tbody>
						<tr >
							<td class = "white"><c:out value="${job.jobname}"></c:out></td>
							<td class = "white"><c:out value="${job.jobdesc}"></c:out></td>
							<td class = "white"><c:out value="${job.skills}"></c:out></td>
						</tr>	
			    </tbody>
	</table>
</div>
<div>
	<a href="/jobs/${job.id}/edit"><button type="button" class="btn2 btn-primary btn-lg btn-block btn btn-success">Edit</button></a>
</div>
<div>
	<form:form action="/jobs/${job.id}" method="post" modelAttribute="job">
    	<input type="hidden" name="_method" value="delete">
    	<input class="btn2 btn-primary btn-lg btn-block btn btn-danger" type="submit" value="Positon Filled">
</form:form>
</div>
<h1>Developers On Deck</h1>
<div class="container2">
	<table  class="table table-striped table-hover" >
			    <thead>
			        <tr>
			            <th class = "white">Dev Name</th>
			            <th class = "white">Languages</th>
			            <th class = "white">Frameworks</th>
			            <th class= "white" >Get To Know The Dev</th>
			        </tr>
			    
			    </thead>
			   	<tbody>
			   	<c:forEach var="devs" items="${devService}">
						<tr >
							<td class = "white"><c:out value="${devs.devname}"></c:out></td>
							<td class = "white"><c:out value="${devs.languages}"></c:out></td>
							<td class = "white"><c:out value="${devs.frameworks}"></c:out></td>
							<td class = "white"><c:out value="${devs.devdescription}"></c:out></td>
						</tr>
				</c:forEach>	
			    </tbody>
	</table>
</div>
</body>
</html>