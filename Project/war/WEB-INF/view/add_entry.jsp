<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.project.in.models.Group" %>
<%@ page import="com.project.in.models.User" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDoList</title>
<link href="<c:url value="/resources/style/todo.css" />" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function(){
	$("#datepicker").datepicker();
});
</script>
</head>
<body>
<h1>Add New Entry</h1>
<hr/>
<form action = "/todolist/add" method="post">
<div class="row-container">
<div class="row">
<div class="col col-size-2x"><label>Group :</label></div>
</div>
<div class="row">
<div class="col col-size-2x">
	<select id="groupId" name="groupId">
	<%
		if (request.getAttribute("groupy") != null) {
	
	List<Group> groupy = (List<Group>)request.getAttribute("groupy");
	
	for (Group g : groupy) {
	%>
		<option value="<%=g.getGroupId() %>"><%=g.getGroupName() %></option>
	<%
	} 
	}%>
	</select>
</div>
</div>
<div class="row">
<div class="col col-size-2x"><label>Date :</label></div>
</div>
<div class="row">
<div class="col col-size-2x">
	<input type="text" id="datepicker" name="date" >
</div>
</div>
<div class="row">
	<div class="col col-size-2x"><labe>Entry :</labe></div>
</div>
<div class="row">
<div class="col col-size-2x">
	<textarea id="entry" name="entry"></textarea>
	<!--  Do not add enter textarea tag in middle e.g
		<textarea>
		...
		...
		</textarea>
		Leave that as single line...
	 -->
	 </div>
</div>
<div class="row">
	<div class="col"><input type="submit" value="Add" id="submit" name="submit"></div>
</div>
</div>
</form>
<a href="/todolist">Back to Home</a>
</body>
</html>