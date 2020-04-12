<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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

input {
	border: 0;
	width: 300px;
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
<title>To Do List</title>
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

		<div class="w3-container">
			<form action="<%=request.getContextPath()%>/ToDoServlet"
				method="post">
				<h2>
					<input type="text" class="form-control" id="title" name="title"
						placeholder="Title" required>
				</h2>

				<div class="w3-panel w3-card">
					<p>
						<input type="text" class="form-control" id="description"
							name="description" placeholder="Description" required>
					</p>
				</div>
				<div class="w3-panel w3-card">
					<p>
						<input type="text" class="form-control" id="status" name="status"
							placeholder="Status" required>
					</p>
				</div>
				<div class="w3-panel w3-card">
					<p>
						<input type="text" class="form-control" id="priority"
							name="priority" placeholder="Priority" required>
					</p>
				</div>
				<p style="text-align: center;">Would you like to save your list?</p>
				<div
					style="display: flex; justify-content: flex-end; width: 58%; padding: 0;">
					<a href="ToDoServlet"><button
							class="w3-button w3-hover-blue w3-black w3-round-xxlarge"
							type="submit">Save</button></a>
				</div>
			</form>
		</div>



		<p class="footer">Created by Jessica Krishtul (2020)</p>

	</div>
</body>
</html>