package com.talentsprint.persistencetier;

import java.util.List;

import com.talentsprint.businesstier.dto.Customer;

public interface ICustomer {
	public Customer getCustomer(int id);
	public String newCustomer(Customer customer);
	public String updateCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public String deleteCustomer(int id);
}
