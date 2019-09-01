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
@WebServlet("/ShowCustomer")
public class ShowCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomerManager manager;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int id=Integer.parseInt(request.getParameter("id"));
		//	CustomerManager manager=new CustomerManager();
			Customer customer=manager.getCustomer(id);
			if(customer!=null){
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("jsp/showcustomer.jsp").forward(request, response);
			}else{
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid Customer Id");				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
