<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<p>${data}</p>
	<p>${errorMessage}</p>
	<p>${name}</p>
	
	<form action="/add_contact" method="post">
		Id : <input type="text" name="id">
		Name : <input type="text" name="name">
		Email : <input type="text" name="email">
		Country : <input type="text" name="country">
		<input type="submit" name="submit">
	</form>
</body>
</html>