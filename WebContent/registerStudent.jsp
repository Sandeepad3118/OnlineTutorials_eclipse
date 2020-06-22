<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="styling/css/registerStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="studentRegister">
	<img src="styling/css/registration.png" class="avatar">
		<h3>Students Register Here</h3>
		<form action="RegisterStudent" method="post">
			<p>Username</p>
			<input type="text" name="username" placeholder="Enter Username"
				required>
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter Password"
				required><br> <input type="submit" value="Register"><br>
			<%if(request.getAttribute("message")!=null){
			%>
			<h5>${message}</h5>
			<% }%>
		</form>
	</div>
</body>
</html>