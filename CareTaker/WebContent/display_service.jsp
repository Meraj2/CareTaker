<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="bean.Service"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Display all records</h1>
<%
List list=(List)session.getAttribute("services");
Iterator it=list.iterator();
%>
<table width="100%"  border="3">
<tr><th>E-mail</th>
<th>Service ID</th>
<th>Service type</th>
<th>service </th>
<th>Visit charge</th>
<th>Warranty</th>
<th>Update</th>
<th>Delete</th></tr>
<%
while(it.hasNext())
{
	Service obj=(Service)it.next();
%>
	<tr><td><form action="update" method="post"><input type="text" value=<%=obj.getEmail() %> name="t1" ></td>
	<td><input type="text" value=<%=obj.getId() %> name="t6" ></td>
	<td><input type="text" value=<%=obj.getService_type() %> name="t2" ></td>
	<td><input type="text" value=<%=obj.getService() %> name="t3" ></td>
	<td><input type="text" value=<%=obj.getCharges() %> name="t4" ></td>
	<td><input type="text" value=<%=obj.getWarranty() %> name="t5" ></td>
	<td><input type="submit" value="Update"></form></td>
	<td><form action="delete" method="post">
	<input type="hidden" value=<%=obj.getId() %> name="t1" >
	<input type="submit" value="Delete"></form></td></tr>
<%
}
%>	

</table>

</body>
</html>