package com.talentsprint.webtier;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ShowAllCustomers
 */
@Component
@WebServlet("/ShowAllCustomers")
public class ShowAllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomerManager manager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//CustomerManager manager=new CustomerManager();
			List<Customer> customerList=manager.getAllCustomers();
			if(customerList != null){
				request.setAttribute("customerList", customerList);
				request.getRequestDispatcher("jsp/showallcustomers.jsp").forward(request, response);
			}else{
				response.sendError(HttpServletResponse.SC_NO_CONTENT, "No Records in the table");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
