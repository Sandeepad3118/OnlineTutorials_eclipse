<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body{
  background : url("styling/css/image.jpg");
	}
</style>
</head>
<body>
<center>
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
<%
	if (session.getAttribute("unique").equals("no")){
%>
	<form method="post" action="Unique">
	Unique Code:<input type="text" name="unique"><input type="submit" value="Submit">
	</form>
	<%if(request.getAttribute("message")!=null){
			%>
			<h5>${message}</h5>
			<% }%>
<%
	}
	else{
%>
<%
	if (session.getAttribute("subject").equals("python")){
%>
	<iframe width="560" height="315" src="https://www.youtube.com/embed/YfO28Ihehbk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<%}else{%>
	<iframe width="560" height="315" src="https://www.youtube.com/embed/eIrMbAQSU34" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<%} %>
<%
	}
%>
</center>
</body>
</html>