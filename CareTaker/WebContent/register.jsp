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
	color:red;
}
</style>
</head>
<body>
<h4>${msg }</h4>
<h1>Registration</h1>

<form action="vregister" method="post">
User type :<br />
<select name="t6" >
<option>Select option</option>
<option>Client</option>
<option>Vendor</option>
</select><br />
First name :<br />
<input type="text" name="t1"><br />
Last name  :<br />
<input type="text" name="t2"><br />
Password :<br />
<input type="password" name="t3"><br />
E-mail :<br />
<input type="text" name="t4"><br />
Mobile :<br />
<input type="text" name="t5"><br />
<input type="submit" value="Register">
</form>
</body>
</html>