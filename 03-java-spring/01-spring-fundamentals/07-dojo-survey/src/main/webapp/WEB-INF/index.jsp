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
	<form method="POST" action="/result">
	<p>Your Name: <input type="text" name="name"></p>
	<label for="location">Dojo Location:</label>
		<select id="location" name="location">
		  <option value="sanjose">San Jose</option>
		  <option value="seattle">Seattle</option>
		  <option value="bellevue">Bellevue</option>
		  <option value="dallas">Dallas</option>
		  <option value="la">Los Angeles</option>
		  <option value="chicago">Chicago</option>
		  <option value="arlington">Arlington</option>
		</select>
	<br>
	<br>
	<label for="language">Favorite Language:</label>
		<select id="language" name="language">
		  <option value="python">Python</option>
		  <option value="java">Java</option>
		  <option value="javascript">JavaScript</option>
		  <option value="c">C</option>
		  <option value="c#">C#</option>
		  <option value="ruby">Ruby</option>
		</select>

	<p>Comment (optional): </p>
	<textarea name="comment" rows="10" cols="30"> </textarea>
	
	<br>
	<button>Submit</button>
	</form>
    
</body>
</html>

