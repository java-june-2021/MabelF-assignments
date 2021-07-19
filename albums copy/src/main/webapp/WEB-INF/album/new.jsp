<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


</head>
<body>

<div class = "container"> 
	<h1>Add A new Album </h1>
	<hr>
	<form:form action="/addRecord" method="POST" modelAttribute="album">
		<div class="form-group">
			<!-- This needs to match what's inside model -->
			<form:label path="bandName">Band Name: </form:label> 
			<form:errors path="bandName"/>
			<form:input path="bandName"/>
		</div>
		<div class="form-group">
			<!-- This needs to match what's inside model -->
			<form:label path="albumName">Album Name: </form:label>
			<form:errors path="albumName" />
			<form:input path="albumName" />
		</div>
		<div class="form-group">
			<!-- This needs to match what's inside model -->
			<form:label path="releaseYear">Release Year: </form:label>
			<form:errors path="releaseYear" />
			<form:input path="releaseYear" />
		</div>
		<button>Add Record</button>
	</form:form>


<hr>
<h1>HTML Way</h1>
<c:forEach items="${error}" var="err">
	<p>${err}</p>
</c:forEach>

<form action="/addRecordHTMLWay" method="POST"> 
	<div class="form-group">
	<label for="bandName"> Band Name </label>
	<input type="text" name="bandName">
	</div>
	
	
	<div class="form-group">
	<label for="albumName"> Album Name </label>
	<input type="text" name="albumName">
	</div>
	
	
	<div class="form-group">
	<label for="releaseYear"> Release Year  </label>
	<input type="text" name="releaseYear">
	</div>
	
	<button>Add Album</button>

	
	</form>
</div>
</body>
</html>