<%@page import="java.util.List"%>
<%@page import="database.cinema.Showing"%>
<%@page import="database.cinema.Movie"%>
<%@page import="database.cinema.Hall"%>
<%@page import="database.cinema.Seats"%>
<%@page import="cinema.database.CinemaDAOImpl"%>
<%@page import="cinema.database.CinemaDAO"%>
<%@page import="movies.ShowingsManagement"%>
<%@page import="users.UsersManagement"%>
<%@page import="cinema.listeners.ContextListener"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
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

<%
	CinemaDAO dao = (CinemaDAO) application.getAttribute("cinemaDBAO");
	UsersManagement usersInfo = (UsersManagement) application
			.getAttribute("usersInfo");
	ShowingsManagement showingsInfo = (ShowingsManagement) application
			.getAttribute("showingsInfo");
	String role = "";
%>

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
					if (request.getUserPrincipal() != null) {
						role = usersInfo.getRoleForPerson(request.getUserPrincipal()
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
							href="/TicketSystem/administration/usermanagement.jsp">Manage
							users</a>
					</div></li>
				<li><div style="display: inline">
						<a onclick="test(this);"
							href="/TicketSystem/useraccess/reservationsreview.jsp">My
							reservations</a>
					</div></li>
			</ul>
		</div>
	</div>

	<div id="page" class="container">
		<div id="back-top" style="display: none;">
			<a href="#content"> <span></span> Back to top
			</a>
		</div>
		<div id="content">


			<h3>Reserve tickets:</h3>

			<br>
			<br>

			<%
				Showing showing = showingsInfo.getShowing(Integer.parseInt(request
						.getParameter("showingid")));

				Hall hall = showing.getHall();
				int rows = hall.getRowsCount();
				int seatsPerRow = hall.getSeatsCount() / rows;
				List<Seats> seats = hall.getSeats();
			%>
			<table id="hallplan">
				<tr>
					<td class="rownumber">Row 1&nbsp;&nbsp;&nbsp;</td>
					<%
						for (int i = 0; i < seats.size(); i++) {

							if (i % seatsPerRow == 0 && i != 0) {
					%>
				</tr>
				<tr>
					<td class="rownumber">Row <%=seats.get(i).getRowNumber()%>&nbsp;&nbsp;&nbsp;
					</td>
					<%
						}
							if (seats.get(i).isOccupied()) {
					%>
					<td id=<%=seats.get(i).getSeatID()%> class="notavailable"><%=seats.get(i).getSeatNumber()%></td>
					<%
						} else {
					%>
					<td id=<%=seats.get(i).getSeatID()%>><%=seats.get(i).getSeatNumber()%></td>
					<%
						}

						}
					%>
				</tr>
			</table>

			<p>Credit card number:</p>

			<input id="creditcard" /> <a id="reserve"
				href="payment.jsp?showingid=<%=request.getParameter("showingid")%>"><button
					id=reserveButton>Make reservation</button></a>

		</div>
		<div id="footer" class="container">
			<p>Copyright (c) 2013 TUCinema.com. All rights reserved. Design
				by TU.</p>
		</div>
	</div>
</body>
</html>