<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ page import="java.text.DateFormat" %>
<%@ page import="com.project.in.models.Entry" %>
<%@ page import="com.project.in.models.Group" %>
<%@ page import="com.project.in.models.User" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDoList</title>
<link href="<c:url value="/resources/style/todo.css" />" rel="stylesheet">
<title>DatePicker</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
    
  });
  </script>
</head>
<body>
<%
if (request.getAttribute("user") != null) {
User user = (User) request.getAttribute("user");
%>
<div class="header">
<div class="row" style="width:400px">
<div class="col col-size-3x">
<img src="<%=user.getPicture() %>" width="32" height="32" style="float:left;"/><p><%=user.getEmail() %></p>
</div>
<div class="col col-size-5x"></div>
<div class="col col-size-2x"><a href="/todolist/add">Add Entry</a></div>
<div class="col col-size-2x"><a href="/todolist/addgroup">Add List</a></div>
<div class="col col-size-1x"><a href="/todolist/logout">Logout</a></div>
</div>
</div>
<%} %>
<div class="row-container">
<div class="row-header">
	<div class="col col-size-2x">Date</div>
	<div class="col">Entry</div>
	<div class="col col-size-1x">
	<a href="/todolist">Show All Entry</a>
	</div>
	<div class="col col-size-1.5x">
	<%DateFormat format = new SimpleDateFormat("MM/dd/yyyy"); %>
	<form action="/todolist" method="post">
	<select id="groupId" name="groupId">
	<%
		if (request.getAttribute("groupy") != null) {
	
	List<Group> groupy = (List<Group>)request.getAttribute("groupy");
	
	for (Group g : groupy) {
	%>
		<option value="<%=g.getGroupId() %>" selected><%=g.getGroupName() %></option>
	<%
	} 
	}%>
	</select>
	<input type="text" id="datepicker" name="date" value="<%=format.format((Date)request.getAttribute("userDate"))%>">
	<input type="submit" id="submit" name="submit" value="Filter">
	</form>
	</div>
</div>

<%
if (request.getAttribute("entries") != null) {
	
	List<Entry> entries = (List<Entry>)request.getAttribute("entries");
	
	for (Entry e : entries) {
	%>
		<div class="row">
		<div class="col col-size-2x"><%=e.getDate()%></div>
		<div class="col"><%=e.getEntry()%></div>
		</div>
	<%
	}
 	
} else {
	%>
	<p>No Entry is there!</p>
	<%
}
%>
</div>
</body>
</html>