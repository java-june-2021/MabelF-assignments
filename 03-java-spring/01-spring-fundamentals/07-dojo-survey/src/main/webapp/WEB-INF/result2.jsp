<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dojo Survey</title>
</head>
<body>
    <h1> You chose Java! Good choice </h1>
	<h3> Submitted Info </h3>
	<p> Name: ${name} </p>
	<p> Dojo Location: ${location} </p>
	<p> Favorite Language: ${language} </p>
	<p> Comment: ${comment} </p>

	<button onclick="location.href='/'" type="button">Go back</button>


</body>
</html>
