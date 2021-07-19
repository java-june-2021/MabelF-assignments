<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<!DOCTYPE html>
			<html>

			<head>

				<meta charset="ISO-8859-1">
				<title> A list of programming languages </title>

				<title>Insert title here</title>
				<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
					integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
					crossorigin="anonymous">


			</head>

			<body>
				<div class="container">
					<h1>Welcome to the Programming Language Database</h1>
					<hr>
					<!-- <a href="/new">Add a New Album</a> -->
					<table class="table table-dark">
						<thead>
							<tr>
								<th> Name </th>
								<th> Creator </th>
								<th> Version </th>
								<th> Action </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allLanguages}" var="lang">
								<tr>
									<td><a href="/languages/${lang.id}">${lang.name}</a></td>
									<td>${lang.creator}</td>
									<td>${lang.currentVersion}</td>
									<td><a href="/languages/edit/${lang.id}">delete edit</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div class="d-flex align-items-center flex-column justify-content-center h-100 bg-dark text-white">
					<hr>
					<!-- <%-- modelAttribute attribute is the key which specifies a name of the model object that backs this form --%> -->
					<form:form action="/languages" method="POST" modelAttribute="language">
						<div class="form-group">
							<!-- This needs to match what's inside model -->
							<form:label path="name"> Name: </form:label>
							<form:errors path="name" />
							<form:input path="name" class="form-control form-control-lg" />
						</div>
						<div class="form-group">
							<!-- This needs to match what's inside model -->
							<form:label path="creator">Creator: </form:label>
							<form:errors path="creator" />
							<form:input path="creator" class="form-control form-control-lg" />
						</div>
						<div class="form-group">
							<!-- This needs to match what's inside model -->
							<form:label path="currentVersion"> Current Version: </form:label>
							<form:errors path="currentVersion" />
							<form:input path="currentVersion" class="form-control form-control-lg" />
						</div>
						<button class="btn btn-info btn-lg btn-block">Submit!</button>
					</form:form>
				</div>

			</body>

			</html>