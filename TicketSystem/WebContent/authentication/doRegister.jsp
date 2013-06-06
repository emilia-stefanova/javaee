<%@page import="database.users.UserRoles"%>
<%@ page import="java.sql.*"%>
<%@page import="cinema.database.CinemaDAOImpl"%>
<%@page import="cinema.database.CinemaDAO"%>
<%@page import="database.users.Person"%>
<%

	CinemaDAO dao = (CinemaDAO) application.getAttribute("cinemaDBAO");

	String str1 = request.getParameter("t1");
	String str2 = request.getParameter("t2");
	String str3 = request.getParameter("t3");
// 	Class.forName("com.mysql.jdbc.Driver");
// 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
// 			"root", "test");
// 	PreparedStatement pstmt = con
// 			.prepareStatement("insert into person(username,password) values(?,?)");
// 	pstmt.setString(1, str1);
// 	pstmt.setString(2, str2);
// 	pstmt.executeUpdate();
// 	con.close();
	Person person = new Person();
	person.setUsername(str1);
	person.setPassword(str2);
	UserRoles role = new UserRoles(str1, "user");
	dao.createPerson(person);
	dao.createRoleForPerson(role);
%>
<jsp:forward page="../general/homepage.jsp">
	<jsp:param name="reg" value="<%=str1%>" />
</jsp:forward>

success.jsp

<html>
<body>
	<%
		String str11 = request.getParameter("t1");
	%>
	<h4>
		<font color='Red'>Welcome:::</font><b><font color='#663300'><%=str1%></font></b>
	</h4>
</body>
</html>