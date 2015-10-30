<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Page Redirection</title>
</head>
<body>
<center>
<h1>Page Redirection</h1>
</center>
<%
   // New location to be redirected
   String site = new String("https://accounts.google.com/o/oauth2/auth?scope=email%20profile&state=%2Fprofile&"
			 +"redirect_uri=http://localhost:8888/oauth1"+
			 "response_type=code&"+
			 "client_id=444826947556-h8mut1gide92n3qneri26hl8vde6nbdn.apps.googleusercontent.com");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
%>
</body>
</html>