package com.talentsprint.webtier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talentsprint.businesstier.manager.CustomerManager;


@Component
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerManager manager;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		//	CustomerManager manager=new CustomerManager();
			
			int id = Integer.parseInt(request.getParameter("p_customerid"));
			String message = manager.deleteCustomer(id);
			response.getWriter().println("<html><body><h1>"+message+"</h1></body></html>");
		}
		catch(Exception e){
			e.printStackTrace();
			response.getWriter().println("<html><body><h1>"+"Unable to delete customer record"+"</h1></body></html>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
