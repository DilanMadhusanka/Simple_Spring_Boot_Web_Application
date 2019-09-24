<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>${delete}</p>
	<p>${errorMessage}</p>
	
	<form action="delete_contact" method="post">
		Id : <input type="text" name="id">
		<input type="submit" name="submit">
	</form>
</body>
</html>