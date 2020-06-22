<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styling/css/loginStyle.css">
</head>
<body>

	<div class="header">
		<h1>Welcome to Online Tutorials</h1>
	</div>

	<div class="studentLogin">
		<img src="styling/css/avatar.png" class="avatar1">
		<h3>Students Login Here</h3>
		<form action="Login" method="post">
			<p>Username</p>
			<input type="text" name="username" placeholder="Enter Username"
				required>
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter Password"
				required><br> 
				
			<input type="submit" value="login"><br>
			<a href="registerStudent.jsp">New Student? Register</a>
		</form>
	</div>

	<div class="teacherLogin">

		<img src="styling/css/avatar.png" class="avatar2">
		<h3>Teachers Login Here</h3>
		<form action="LoginTeacher" method="post">
			<p>Username</p>
			<input type="text" name="username" placeholder="Enter Username"
				required>
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter Password"
				required><br> <input type="submit" value="login"><br>
	</div>
</body>
</html>