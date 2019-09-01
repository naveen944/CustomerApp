package com.talentsprint.businesstier.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talentsprint.businesstier.dto.Customer;
import com.talentsprint.persistencetier.CustomerService;

@Component
public class CustomerManager {
	
	@Autowired
	private CustomerService service;
	
	public Customer getCustomer(int id){
		//pre-processing
		
		//CustomerService service=new CustomerService();
		return service.getCustomer(id);
	}
	
	public String newCustomer(Customer customer){
		//CustomerService service=new CustomerService();
		return service.newCustomer(customer);
	}
	
	public List<Customer> getAllCustomers(){
		//CustomerService service= new CustomerService();
		return service.getAllCustomers();
	}
	
	public String updateCustomer(Customer customer){
		//CustomerService service= new CustomerService();
		return service.updateCustomer(customer);
	}
	
	public String deleteCustomer(int id){
		//CustomerService service= new CustomerService();
		return service.deleteCustomer(id);
	}
	
}
