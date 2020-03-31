<!-- @author: Jeasung Chun -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
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
         margin-left: -250px;
         margin-top: -300px;
         }
      </style>
      <title>JJ ToDo</title>
   </head>
   </head>
   <body>
   	  <div class="container">
      <h1 class="header">To Do List</h1>
      <ul>
         <li><a href="index.jsp">Main</a></li>
         <li class ="active" style="float:right"><a href="registerForm.jsp">Sign Up</a></li>
         <li style="float:right"><a href="loginForm.jsp">Login</a></li>
         <li class ="logout" style="float:right"><a href="LogoutServlet">Logout</a></li>
      </ul>
      <h2>Create an Account</h2>
      <form action="<%=request.getContextPath()%>/register" method="post">
         <div class="form-group">
            <label for="uname">User Name</label> <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
         </div>
         <div class="form-group">
            <label for="password">Password</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
         </div>
         <div>
        	<label for="confirm_password">Confirm Password</label> <input type="password" placeholder="Confirm Password" id="confirm_password" required>
         </div>
         <button type="submit">Submit</button>
      </form>
      <p class="footer">Created by Jessica Krishtul, Jeasung Chun (2020)</p>
      </div>
   </body>
</html>

<script>
var password = document.getElementById("password"), confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>