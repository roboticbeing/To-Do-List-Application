<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<head>
    
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

 <div class="row">

  <div class="container">
   <h3 class="text-center">List of Todos</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success">Add Todo</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Title</th>
      <th>Todo Status</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="task" items="${listTask}">

      <tr>
       <td><c:out value="${task.title}" /></td>
       <td><c:out value="${task.status}" /></td>

       <td>
       	<a href="edit?id=<c:out value='${task.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; 
        <a href="delete?id=<c:out value='${task.id}' />">Delete</a>
       </td>

      </tr>
     </c:forEach>
    </tbody>

   </table>
  </div>
 </div>