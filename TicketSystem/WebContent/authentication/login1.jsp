<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Form</title>
</head>
<body>
	<h2>Hello, please log in:</h2>
	<form name="loginForm" method="POST" action="j_security_check">
		<p>
			<strong>Please type your user name: </strong> <input type="text"
				name="j_username" size="25">
		</p>
		<p>
			<strong>Please type your password: </strong> <input type="password"
				size="15" name="j_password">
		</p>
		<p>
			<input type="submit" value="Submit" /> <input type="reset"
				value="Reset" />
		</p>
	</form>
	If you do not have registration click
	<a href="/TicketSystem/authentication/register.jsp">here</a>
</body>
</html>
