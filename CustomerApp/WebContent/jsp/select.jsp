<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession session = request.getSession();
	    System.out.print(session);
		if(session !=null){
			out.println("<h1>Hi, "+session.getAttribute("username")+"</h1><br>");
			%>
			<a href="jsp/newcustomer.jsp">New Customer</a><br>
			<a href="jsp/getcustomerid.jsp">Get Customer</a><br>
			<a href="ShowAllCustomers">Get All Customers</a><br>
			<a href="LogoutServlet">Logout</a>	<br>
		<%}else{
			response.getWriter().println("<html><body><h1>"+"Please Login"+"</h1></body></html>");
			request.getRequestDispatcher("../login.jsp").include(request, response);
		
	}%>
	%>
	
	
	
	
</body>
</html>