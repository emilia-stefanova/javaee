<%@page import="cinema.database.CinemaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,700"
	rel="stylesheet" type="text/css" />
<link href="/TicketSystem/css/default.css" rel="stylesheet"
	type="text/css" />
<script src="/TicketSystem/js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="/TicketSystem/js/JQueryCheckin.js" type="text/javascript"></script>
<script src="/TicketSystem/js/JQuery.js" type="text/javascript"></script>
</head>
<body>
	<div id="header" class="container">
		<div id="logo">
			<h1>
				<a class="logogreet">Welcome to TU Cinema!</a>
			</h1>
		</div>
		<div id="menu">
			<div id="greeting">
				<%
					CinemaDAO dao = (CinemaDAO) application.getAttribute("cinemaDBAO");
					String role = "";
					if (request.getUserPrincipal() != null) {
						role = dao.getRoleForPerson(request.getUserPrincipal()
								.getName());
				%>
				<p>
					Hello,
					<%=request.getUserPrincipal().getName()%></p>
				<a href="/TicketSystem/authentication/logout.jsp">Click here to
					log out</a>
				<%
					} else {
				%>
				<p>Hello, guest</p>
				<a href="/TicketSystem/authentication/register.jsp">Register</a>
				<%
					}
				%>
			</div>
			<ul>
				<li><div style="display: inline">
						<a onclick="test(this);" href="/TicketSystem/general/homepage.jsp">Homepage</a>
					</div></li>
				<li><div style="display: inline">
						<a onclick="test(this);"
							href="/TicketSystem/showings/listshowings.jsp">Showings</a>
					</div></li>

				<li><div style="display: inline">
						<a onclick="test(this);"
							href="/TicketSystem/useraccess/reservationsreview.jsp">My
							reservations</a>
					</div></li>

				<%
					if (role.equals("admin")) {
				%>
				<li><div style="display: inline">

						<a onclick="test(this);"
							href="/TicketSystem/administration/usermanagement.jsp">Manage
							users</a>
					</div></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>

	<div id="page" class="container">
		<div id="back-top" style="display: none;">
			<a href="#content"> <span></span> Back to top
			</a>
		</div>
	</div>
</body>
</html>