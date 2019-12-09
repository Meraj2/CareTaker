<%@page import="bean.Vendor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Vendor v=(Vendor)session.getAttribute("user");
out.print("<h4>Welcome "+v.getEmail()+"</h4>");
%>
<cemter>
<hr>
<a href="add_service.jsp">Add service</a>
|<a href="display_service">Display service</a>
|<a href="logout.jsp">Logout</a>
<hr>
</cemter>
</body>
</html>