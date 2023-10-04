package com.Spring.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.demo.entity.Customer;
import com.Spring.demo.model.CustomerDTO;
import com.Spring.demo.service.CustomerService;
import com.Spring.demo.util.Converter;

@RestController
//@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@Autowired
	private Converter converter;
	
	@GetMapping("/customerHome")
	public String home()
	{
		return "Welcome to Customer home page....";
	}
	
	@PostMapping("/createCustomer")
	ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customDTO)
	{
		final Customer custom=converter.convertToCustomerEntity(customDTO);
		return new ResponseEntity<CustomerDTO>(custService.createCustomer(custom),HttpStatus.CREATED);
		
	}
//	@GetMapping("/searchCustomers")
//	List<CustomerDTO> searchAllCustomers()
//	{
//		return custService.getAllCustomer();
//	}
//	@GetMapping("/searchCustomerById/{cid}")
//	CustomerDTO getCustomerById(@PathVariable("cid") int id)
//	{
//		return custService.searchCustomerById(id);
//	}
//	@PutMapping("/updateCustomer/{id}")
//	CustomerDTO updateCustomer(@Valid @PathVariable int id,@RequestBody CustomerDTO custDTO)
//	{
//		final Customer cust=converter.convertToCustomerEntity(custDTO);
//		return custService.updateCustomerById(id, cust);
//	}
//	@DeleteMapping("/deleteCustomer/{id}")
//	String deleteCustomer(@PathVariable int id)
//	{
//		return custService.deleteCustomerById(id);
//	}
	
}
