<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/todolist/addgroup" method="post">
	<div class="row-container">
		<div class="row">
			<div class="col col-size-2x"><label>Enter Group Name</label></div>
		</div>
		<div class="row">
			<div class="col col-size-2x">
				<input type="text" id="groupName" name="groupName"/>
			</div>
		</div>
		<div class="row">
			<div class="col col-size-2x">
				<input type="submit" id="submit" name="submit" value="Add"/>
			</div>
		</div>
	</div>
</form>
<a href="/todolist">Back to Home</a>
</body>
</html>