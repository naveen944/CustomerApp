<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="customer" type="com.talentsprint.businesstier.dto.Customer" scope="request"></jsp:useBean>
	<form action="UpdateCustomerServlet">	
		Id		:	<input type="text" name="customerId" readonly="readonly" value="${customer.customerId}" size="15"><br>
		First Name:  <input type="text" name="firstName" value="${customer.firstName}" size="15"><br>
		Last Name:  <input type="text" name="lastName" value="${customer.lastName}" size="15"><br>
		Balance:     <input type="text" name="balance" value="${customer.balance}" size="14"><br>
		<input type="submit" value="Update">
	
	</form>
</body>
</html>