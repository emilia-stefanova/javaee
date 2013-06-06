<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Untitled Page</title>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,700"
	rel="stylesheet" type="text/css" />
<link href="../css/default.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="../js/JQueryCheckin.js" type="text/javascript"></script>
<script src="../js/JQuery.js" type="text/javascript"></script>
</head>
<body>
	<form action="j_security_check" method=post>
		<table>
			<tr>
				<td align="center">
					<table border="0">
						<tr>
							<td><b>Enter your name: </b></td>
							<td><input type="text" size="15" name="j_username">
							</td>
						</tr>
						<tr>
							<td><b>Enter your password: </b></td>
							<td><input type="password" size="15" name="j_password">
							</td>
						</tr>
						<tr>
							<td></td>
							<td align="right"><input type="submit" value="Submit">
							</td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>