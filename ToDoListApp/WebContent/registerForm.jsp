<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h2>User Register Form</h2>
<!-- the action references the Servlet's Annotation -->
<form method="post" action="<%= request.getContextPath() %>/register">
    Username: <input type="text" name="username" /><br /><br />
    Password: <input type="password" name="password" /><br /><br />
    Salt: <input type="text" name="salt" /><br /><br />
  <input type="submit" value="SEND" />
</form>
</body>
</html>