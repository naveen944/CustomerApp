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
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
			out.println("<h2><font color=\"blue\">"+"You have logged out of XXX Application"+"</font></h2>");
			out.println("<a href=\"login.jsp\">Login</a>");
		}else{
			out.println("<a href=\"login.jsp\">Login</a>");
		}
	%>
</body>
</html>