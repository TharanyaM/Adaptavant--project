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
			 +"redirect_uri=http://1-dot-tharantodo.appspot.com/oauth&"+
			 "response_type=code&"+
			 "client_id=266721251481-lkvqhftqpv5o2k91ipvel8n6mrf7jind.apps.googleusercontent.com");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
%>
</body>
</html>