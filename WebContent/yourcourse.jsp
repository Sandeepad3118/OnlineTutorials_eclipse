<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.login.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
body{
  background : url("styling/css/image.jpg");
}

.yourcourse{
	position : absolute;
	top : 120px;
	left : 470px;
}

.yourcourse .java{
	background : #021c3a;
	color : #fff;
	font-family : popins;
	font-weight : bold;
	font-size : 30px;
	border : none;
	width : 320px;
	height : 120px;
	border-radius : 30px;
}

.yourcourse .python{
	background : #021c3a;
	color : #fff;
	font-family : popins;
	font-weight : bold;
	font-size : 30px;
	border : none;
	width : 320px;
	height : 120px;
	border-radius : 30px;
}

.yourcourse .python:hover,
.yourcourse .java:hover{
	background : transparent;
	color : #000;
	border : solid;
	box-shadow : 0 0 10px #000;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("username")==null){
	response.sendRedirect("login.jsp");
}
%>
<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Expires","0");
	response.setDateHeader("Expires",-1);
%>
<div class="yourcourse">
<form action="WatchCourse" method="post">
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
	Dao d=new Dao();
	String uname=(String)session.getAttribute("username");
	d.yourCourse(uname);
	if (!d.java && !d.python){
		out.println("No course registered");
	}
	else if(d.java){
	%>
		<input type="submit" value="Java" name="watch" class="java"><br><br>
	<%
	}
	%>
	<%
	if(d.python){
	%>
		<input type="submit" value="Python" name="watch" class="python">
	<%
	}
%>
</form>
<%if(request.getAttribute("message")!=null){
			%>
			<h5>${message}</h5>
			<% }%>
</div>
</body>
</html>