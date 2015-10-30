<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.project.in.models.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Thank you! Registering Here</h1>
<div style="background-color:#f8f8f8;">
<%
if (request.getAttribute("user")!=null)
{
User user = (User) request.getAttribute("user");
%>
<p><%=user.getEmail() %></p>
<img src="<%=user.getPicture() %>"/>
<%} %>
</div>
<a href="/todolist">Go to ToDo</a>
</body>
</html>