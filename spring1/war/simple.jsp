<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body>
<h1>welcome</h1>
<%


String studentName=request.getParameter("studentName");
String collegeName=request.getParameter("collegeName");
%>
<%
out.println("studentName:"+studentName);
%>
<%
out.println("collegeName:"+collegeName);
%>
</body>
</html>