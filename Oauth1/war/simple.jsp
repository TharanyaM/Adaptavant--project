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
			 +"redirect_uri=http://localhost:8888/oauth&"+
			 "response_type=code&"+
			 "client_id=482631779289-nogvfvhsce52astjajqnh526ia4a75e0.apps.googleusercontent.com");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
%>
</body>
</html>