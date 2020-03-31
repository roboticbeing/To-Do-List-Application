<!-- @author Jessica Krishtul -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Main Page</title>
</head>
<body>
<div class="container">
<h1>To Do List</h1>
<ul>
  <li><a class ="active" href="index.jsp">Main</a></li>
  <c:choose>
  <c:when test="${sessionScope.loggedUser != null}">
   <li style="float:right"><a href="LogoutServlet">Logout</a></li>
</c:when>
<c:otherwise>
  <li style="float:right"><a href="registerForm.jsp">Sign Up</a></li>
  <li style="float:right"><a href="loginForm.jsp">Login</a></li>
</c:otherwise>
</c:choose>
</ul>

<p class="footer">Created by Jessica Krishtul, Jeasung Chun (2020)</p>

</div>
</body>
</html>