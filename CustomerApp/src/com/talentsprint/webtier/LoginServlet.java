package com.talentsprint.webtier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.talentsprint.businesstier.manager.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManager manager=new UserManager();
		Boolean flag=manager.getUser(request.getParameter("username"), request.getParameter("password"));
		if(flag==true){
			HttpSession session= request.getSession();
			session.setAttribute("username", request.getParameter("username"));
			session.setAttribute("password", request.getParameter("password"));
			request.getRequestDispatcher("jsp/select.jsp").forward(request, response);
		}else{
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid Credentials");
			request.getRequestDispatcher("login.jsp").include(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
