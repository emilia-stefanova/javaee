<%@page import="java.util.List"%>
<%@page import="cinema.database.Showing"%>
<%@page import="cinema.database.Movie"%>
<%@page import="cinema.database.Hall"%>
<%@page import="cinema.database.CinemaDAOImpl"%>
<%@page import="cinema.database.CinemaDAO"%>
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
	List<Showing> showings = dao.getShowings();
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
				<a
					href="/TicketSystem/authentication/register.jsp">Register</a>
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


			<h3>Movie list</h3>



			<%
				for (Showing showing : showings) {
			%>
			<div class="movieinfo">
				<div class="title">
					<a class="movieTitle"
						href="/TicketSystem/useraccess/reservations.jsp?showingid=<%=showing.getShowingID()%>"><%=showing.getMovie().getMovieTitle()%></a>
				</div>
				<div class="moviePoster"
					style="background-image: url('<%=showing.getMovie().getMoviePoster()%>')"
					onclick="document.location='/TicketSystem/useraccess/reservations.jsp?showingid=<%=showing.getShowingID()%>';return false;"
					value="Redirect"></div>
				<table>
					<tr>
						<td class="parameter">Genre:</td>
						<td><p class="movieGenre"><%=showing.getMovie().getMovieGenre()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Year:</td>
						<td><p class="movieYear"><%=showing.getMovie().getMovieYear()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Category:</td>
						<td><p class="movieCategory"><%=showing.getMovie().getMovieCategory()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Country:</td>
						<td><p class="movieCountry"><%=showing.getMovie().getMovieCountry()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Director:</td>
						<td><p class="movieDirector"><%=showing.getMovie().getMovieDirector()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Cast:</td>
						<td><p class="movieCast"><%=showing.getMovie().getMovieCast()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Duration:</td>
						<td><p class="movieDuration"><%=showing.getMovie().getMovieDuration()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Trailer:</td>
						<td><p class="movieTrailer"><%=showing.getMovie().getMovieTrailer()%></p></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td class="parameter">Time:</td>
						<td><p class="movieTrailer"><%=showing.getTime()%></p></td>
					</tr>
					<tr>
						<td class="parameter">Hall:</td>
						<td><p class="movieTrailer"><%=showing.getHall().getHallNumber()%></p></td>
					</tr>


				</table>
				<a
					href="/TicketSystem/useraccess/reservations.jsp?showingid=<%=showing.getShowingID()%>"><button>Reserve
						tickets</button></a>

			</div>
			<%
				}
			%>

		</div>
		<div id="footer" class="container">
			<p>Copyright (c) 2013 TUCinema.com. All rights reserved. Design
				by TU.</p>
		</div>
	</div>
</body>
</html>