package com.Spring.demo.service;

import java.util.List;

import com.Spring.demo.entity.Customer;
import com.Spring.demo.model.CustomerDTO;

public interface CustomerService {
	
	//Create a new customer
	CustomerDTO createCustomer(Customer cust);
	
	//Read all customer details
	List<CustomerDTO> getAllCustomer();
	
	//find customer by id 
	CustomerDTO searchCustomerById(int id);
	
	//Update details of customer by id
	CustomerDTO updateCustomerById(int id,Customer cust);
	
	//delete customer by id 
	String deleteCustomerById(int id);
	
}
