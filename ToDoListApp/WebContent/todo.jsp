<!-- @author Jeasung Chun -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>To DO List</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<head>
    <style>
        .header {
            padding: 0px;
            margin-bottom: 50px;
        }

        .header h1 {
            text-align: center;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        form {
            border: 3px solid #f1f1f1;
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

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }


        .container {
            width: 600px;
            height: 400px;
            padding: 16px;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -350px;
            margin-top: -300px;

        }

        .container ul {
            margin: 0;
            padding: 0;
        }

        .container ul li {
            cursor: pointer;
            position: relative;
            padding: 12px 8px 12px 40px;
            list-style-type: none;
            background: rgb(226, 237, 255);
            font-size: 20px;
            transition: 0.2s;
            /* make the list items unselectable */
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        .container ul li:hover {
            background: rgb(170, 189, 206);
        }

        /* When clicked on, add a background color and strike out text */
        .container ul li.checked {
            background: rgb(133, 144, 156);
            color: #fff;
            text-decoration: line-through;
        }

        /* Add a "checked" mark when clicked on */
        .container ul li.checked::before {
            content: '';
            position: absolute;
            border-color: #fff;
            border-style: solid;
            border-width: 0 2px 2px 0;
            top: 10px;
            left: 16px;
            transform: rotate(45deg);
            height: 15px;
            width: 7px;
        }
    </style>
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
        <div class="header">
            <h1>List of Todos</h1>
        </div>
        <div>
            <div id="editlist">
                <input type="text" placeholder="Add your tasks...">
                
                <a href="home.html"><button type="submit" id="addbtn">ADD</button></a>
            </div>
            <div id="todolist">
                <ul id="listUL">
                    <li class="checked">First Task</li>
                    <li>Second Task</li>
                    <li>Third Task</li>
                </ul>
            </div>

        </div>
    </div>
 </div>