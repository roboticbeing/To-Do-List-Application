<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
	<div class="form-group">
                	<label for="username">User Name</label> <input type="text" class="form-control" id="uname" placeholder="User Name" name="username" required>
            	</div>

            	<div class="form-group">
                	<label for="password">Password</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
            	</div>
            	
            	<button type="submit">Submit</button>
</form>
</body>
</html>