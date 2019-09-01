<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2><font color=green>Enter Your Credentials</font></h2>
	<form action="LoginServlet" method="post">
		Enter Username: <input type="text"  name="username" size="15"><br>
		Enter Password:<input type="password" name="password" size="30"><br>
		<input  type="submit">
	</form>
</body>
</html>