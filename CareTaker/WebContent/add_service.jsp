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
<h1>Add the service</h1>
<%
	Vendor v=(Vendor)session.getAttribute("user");
%>
<form action="add_service" method="post">
E-mail :<br />
<input type="text" name="t5" value=<%=v.getEmail() %>><br />
Service type :<br />
<select name="t1" >
<option>Saloon at home</option>
<option>Repairing Home Appliance</option>
<option>Home shifting</option>
<option>Body checkup</option>
</select><br />
Service :<br />
<input type="text" name="t2"><br />
Charges :<br />
<input type="text" name="t3"><br />
Warranty :<br />
<input type="text" name="t4"><br />
<input type="submit" value="Submit">
</form>
</body>
</html>