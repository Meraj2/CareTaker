<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h4
{
	color:green;
}
</style>
</head>
<body>
<h4>${msg }</h4>
<form action="login" method="post">
User type :<br />
<select name="t1">
<option>Select one option</option>
<option>Client</option>
<option>Vendor</option>
</select><br />
E-mail :<br />
<input type="text" name="t2"><br />
Password :<br />
<input type="password" name="t3"><br />
<input type="submit" value="Login">
</form>
</body>
</html>