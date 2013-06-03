<%@page import="cinema.database.UserRoles"%>
<%@ page import="java.sql.*"%>
<%@page import="cinema.database.CinemaDAOImpl"%>
<%@page import="cinema.database.CinemaDAO"%>
<%@page import="cinema.database.Person"%>
<%

	CinemaDAO dao = (CinemaDAO) application.getAttribute("cinemaDBAO");

	String str1 = request.getParameter("t1");
	String str2 = request.getParameter("t2");
	String str3 = request.getParameter("t3");
	Person person = new Person();
	person.setUsername(str1);
	person.setPassword(str2);
	UserRoles role = new UserRoles(str1, "user");
	dao.createPerson(person);
	dao.createRoleForPerson(role);
%>
<jsp:forward page="./successful_registration.jsp"></jsp:forward>

