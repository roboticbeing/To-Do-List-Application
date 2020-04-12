<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>View Tasks</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	border-right: 1px solid #bbb;
}

li a {
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change the link color to #00BFFF (deep sky blue) on hover */
li a:hover {
	background-color: #00BFFF;
}

li:last-child {
	border-right: none;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

.active {
	background-color: rgb(34, 120, 177);
}

.footer {
	color: #f2f2f2;
	background-color: #333;
	text-align: center;
	padding: 10px;
}

h1 {
	text-align: center;
}

.container {
	width: 400px;
	height: 400px;
	padding: 16px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-left: -250px;
	margin-top: -300px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>To Do List</h1>
		<ul>
			<li><a href="index.jsp">Main</a></li>
			<c:choose>
				<c:when test="${sessionScope.loggedUser != null}">
					<li><a class="active" href="toDoList.jsp">To Do List</a>
					<li style="float: right"><a href="LogoutServlet">Logout</a></li>
				</c:when>
				<c:otherwise>
					<li style="float: right"><a href="registerForm.jsp">Sign
							Up</a></li>
					<li style="float: right"><a href="loginForm.jsp">Login</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<div
			style="display: flex; justify-content: flex-end; width: 55%; padding: 0;">
			<a href="toDoList.jsp"><button class="w3-button w3-circle w3-black w3-hover-blue">+</button></a>
		</div>
		
		<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
						<th>Status</th>
						<th>Priority</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="list" items="${toDoList}">
						<tr>
							<td><c:out value="${list.title}" /></td>
							<td><c:out value="${list.description}" /></td>
							<td><c:out value="${list.status}" /></td>
							<td><c:out value="${list.priority}" /></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		<p class="footer">Created by Jessica Krishtul (2020)</p>
	</div>
</body>
</html>