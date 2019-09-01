<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
		Customer customer= (Customer)request.getAttribute("customer");
		out.println("<html><body>"+"Customer Id: "+customer.getCustomerId()+"<br>");
		out.println("First Name: "+customer.getFirstName()+"</body></html>");
	%> --%>
	
	<jsp:useBean id="customer" type="com.talentsprint.businesstier.dto.Customer" scope="request"></jsp:useBean>
	
	<h1><font color="green">Customer Details</font></h1>
	<%-- Customer Id: <jsp:getProperty property="customerId" name="customer"/><br>
	First Name: <jsp:getProperty property="firstName" name="customer"/><br>
	Last Name: <jsp:getProperty property="lastName" name="customer"/><br>
	Balance: <jsp:getProperty property="balance" name="customer"/><br> --%>
	Customer Id: <c:out value="${customer.customerId}"></c:out>  <br>
	First Name: <c:out value="${customer.firstName}"></c:out>  <br>
	Last Name: <c:out value="${customer.lastName}"></c:out>  <br>
	Balance: <c:out value="${customer.balance}"></c:out>  
	
	
</body>
</html>