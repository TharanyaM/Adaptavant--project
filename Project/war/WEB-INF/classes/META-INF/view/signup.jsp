<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Redirection</title>
</head>
<body>
<center>
<h1>Redirection</h1>
</center>
<%
   // New location to be redirected
   String site = new String("https://accounts.google.com/o/oauth2/auth?scope=email%20profile&state=%2Fprofile&"
			 +"redirect_uri=http://localhost:8888/oauth&"+
			 "response_type=code&"+
			 "client_id=482631779289-nogvfvhsce52astjajqnh526ia4a75e0.apps.googleusercontent.com");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
%>
</body>
</html>