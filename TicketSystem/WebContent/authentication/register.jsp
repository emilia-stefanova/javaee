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
<script src="../js/regvalidation.js" type="text/javascript"></script>
</head>
<body>
	<center>
		<form name="objForm" action="./doRegister.jsp" method="post"
			onSubmit="return validate(this)">
			<table>
				<tr>
					<td class="deepbluetExampletbold"><b>Create a user account</b></td>
				</tr>
				<tr>
					<td class="colouredCell"><b>Name*</b></td>
					<td><input name="t1" /></td>
				</tr>
				<tr>
					<td class="colouredCell"><b>Password*</b></td>
					<td><input name="t2" type="password" /></td>
				</tr>
				<tr>
					<td class="colouredCell"><b>Confirm password*</b></td>
					<td><input name="t3" type="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Register" />
		</form>
	</center>
</body>
</html>