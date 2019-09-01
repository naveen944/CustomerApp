package com.talentsprint.webtier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talentsprint.businesstier.dto.Customer;
import com.talentsprint.businesstier.manager.CustomerManager;

/**
 * Servlet implementation class CustomerServlet
 */
@Component
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomerManager manager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Customer customer = new Customer();
			
			customer.setFirstName(request.getParameter("firstname"));
			customer.setLastName(request.getParameter("lastname"));
			customer.setBalance(Double.parseDouble(request.getParameter("balance")));
			
			//CustomerManager manager=new CustomerManager();
			String message=manager.newCustomer(customer);
			response.getWriter().println("<html><body><h1>"+message+"</h1></body></html>");
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			response.getWriter().println("<html><body><h1>"+e.getMessage()+"</h1></body></html>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
