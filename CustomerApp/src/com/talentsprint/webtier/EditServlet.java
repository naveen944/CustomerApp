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

@Component
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomerManager manager;   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().println("Edit Servlet");
		
		int id = Integer.parseInt(request.getParameter("p_customerid"));
		//CustomerManager manager = new CustomerManager();
		Customer customer=manager.getCustomer(id);
		if(customer !=null){
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("jsp/updatecustomer.jsp").forward(request, response);
		}else{
			response.getWriter().println("<html><body><h1>"+"Invalid Customer Id"+"</h1></body></html>");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
