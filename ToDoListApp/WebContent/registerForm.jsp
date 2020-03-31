<!-- @author: Jeasung Chun -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <style>
        .header {
            padding: 0px;
            margin-bottom: 150px;
        }

        .header h1 {
            text-align: center;
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
        	<h2>Create an Account</h2>
           
        	<form action="<%=request.getContextPath()%>/register" method="post">

            	<div class="form-group">
                	<label for="uname">User Name</label> <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
            	</div>

            	<div class="form-group">
                	<label for="uname">Password</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
            	</div>

            	<button type="submit">Submit</button>

        	</form>
    	</div>
	</body>
	
    

    </html>