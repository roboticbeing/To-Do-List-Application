<!-- @author Jessica Krishtul, Jeasung Chun -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<style>
         .container ul {
         list-style-type: none;
         margin: 0;
         padding: 0;
         overflow: hidden;
         background-color: #333;
         }
         .container ul li {
         float: left;
         border-right: 1px solid #bbb;
         }
         .container ul li a {
         display: block;
         color: #f2f2f2;
         text-align: center;
         padding: 14px 16px;
         text-decoration: none;
         }
         /* Change the link color to #00BFFF (deep sky blue) on hover */
         .container ul li a:hover {
         background-color: #00BFFF;
         }
         .container ul li:last-child {
         border-right: none;
         }
         .logout {
         visibility: hidden;
         }
         .active {
         background-color: rgb(34, 120, 177);
         }
         .header {
         text-align: center;
         }
         .footer {
         color: #f2f2f2;
         background-color: #333;
         text-align: center;
         padding: 10px;
         }
         body {
         font-family: Arial, Helvetica, sans-serif;
         }
         input[type=text],
         input[type=password] {
         width: 100%;
         padding: 12px 20px;
         margin: 8px 0;
         display: inline-block;
         border: 1px solid #ccc;
         box-sizing: border-box;
         }
         button {
         background-color: rgb(34, 120, 177);
         color: white;
         padding: 14px 20px;
         margin: 8px 0;
         border: none;
         cursor: pointer;
         width: 100%;
         }
         button:hover {
         opacity: 0.8;
         }
         .container {
         width: 400px;
         height: 400px;
         padding: 16px;
         position: absolute;
         top: 50%;
         left: 50%;
         margin-left: -200px;
         margin-top: -200px;
         }
      </style>
<title>Main Page</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="/ToDoList/todo" class="navbar-brand"> ToDo</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">List</a></li>
			</ul>
			<c:choose>
				<c:when test="${sessionScope.loggedUser != null}">
					<ul class="navbar-nav navbar-collapse justify-content-end">
						<li><a href="LogoutServlet" class="nav-link">Logout</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav navbar-collapse justify-content-end">
						<li><a href="loginForm.jsp" class="nav-link">Login</a></li>
						<li><a href="registerForm.jsp" class="nav-link">Sign Up</a></li>	
					</ul>
				</c:otherwise>
			</c:choose>
		</nav>
	</header>
	<div class="container">
		
		
		<p class="footer">Once a user is logged into our application, they will have the ability to create, read, update, and delete to-do lists.
		Created by Jessica Krishtul, Jeasung Chun (2020)</p>

	</div>
</body>
</html>