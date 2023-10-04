package com.Spring.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.demo.entity.Customer;
import com.Spring.demo.exception.ResourceNotFoundException;
import com.Spring.demo.model.CustomerDTO;
import com.Spring.demo.repository.CustomerRepository;
import com.Spring.demo.service.CustomerService;
import com.Spring.demo.util.Converter;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custrepo;
	
	@Autowired
	private Converter converter;

	@Override
	public CustomerDTO createCustomer(Customer cust) {
		
		Customer customer=custrepo.save(cust);
		return converter.convertToCustomerDTO(customer);
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		
		List<Customer> customers=custrepo.findAll();
		
		//list of type DTO
		List<CustomerDTO> dtoList=new ArrayList<>();
		for(Customer c:customers)
		{
			dtoList.add(converter.convertToCustomerDTO(c));
		}
		return dtoList;
	}

	@Override
	public CustomerDTO searchCustomerById(int id) {
		Customer c=custrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",id));
		return converter.convertToCustomerDTO(c);
	}

	@Override
	public CustomerDTO updateCustomerById(int id, Customer cust) {
		
		Customer c=custrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",id));
		c.setName(cust.getName());
		c.setAddress(cust.getAddress());
		c.setPhNo(cust.getPhNo());
		c.setEmail(cust.getEmail());
		
		Customer custom=custrepo.save(c);
		return converter.convertToCustomerDTO(custom);
	}

	@Override
	public String deleteCustomerById(int id) {
		custrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",id));
		
		custrepo.deleteById(id);
		return "Customer got deleted successfully!!";
	}
}
