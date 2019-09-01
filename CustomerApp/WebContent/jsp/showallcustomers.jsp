<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="customerList" type="java.util.ArrayList" scope="request"></jsp:useBean>
	<h1><font color="green">Customer Details</font></h1>
	
	<table border="1" bgcolor="cyan">
	<tr><th>Customer Id</th><th>First Name</th><th>Last Name</th><th>Balance</th><th>Update</th><th>Delete</th></tr>
	<c:forEach var="cust" items="${customerList}">
		<tr><td><c:out value="${cust.customerId}"></c:out></td><td><c:out value="${cust.firstName}"></c:out></td>
			<td><c:out value="${cust.lastName}"></c:out></td><td><c:out value="${cust.balance}"></c:out></td>
			<td><a href="EditServlet?p_customerid=${cust.customerId}">Edit</a></td><td><a href="DeleteServlet?p_customerid=${cust.customerId}">Delete</a></td>	</tr>
	</c:forEach>            
	</table><br>
	<a href="jsp/select.jsp">Home</a>
</body>
</html>