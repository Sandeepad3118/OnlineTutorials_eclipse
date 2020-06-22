<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styling/css/styleHome.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Expires","0");
	response.setDateHeader("Expires",-1);
%>

<!--  <div class = "header">
	<h1>Welcome ${username}</h1>
</div>
-->

<form action="RegisterSubject" method="post">
<div class="container1">
	<div class="box">
		<div class="imgBx">
			<img src="styling/css/java.png" alt="image" height="230" width="230">
		</div>
		<div class="content">
		<h2>Java Course Registration</h2>
		<p>This is a java course which includes all basic 
		level of java concepts.</p>
		<input type="submit" value="register" name="java">
		</div>
	</div>
</div>

<div class="container2">
	<div class="box">
		<div class="imgBx">
			<img src="styling/css/py.jpg"  alt="image" height="230" width="230">
		</div>
		<div class="content">
		<h2>Python Course Registration</h2>
		<p>This is a python course which includes all basic 
		level of python concepts.</p>
		<input type="submit" value="register" name="python">
		</div>
	</div>
</div>
</form>>

	<div class = "yourcourse">
	<form action="yourcourse.jsp">
		<span><input type="submit" value="Your Courses" ></span>
	</form>
	</div>
	
	<div class = "logout">
	<form action="Logout">
		<button class="button"><span>Logout</span></button>
	</form>
	</div>
	
	<div class = "message">
	<%if(request.getAttribute("message")!=null){
			%>
			<h5>${message}</h5>
			<% }%>
	</div>

</body>
</html>