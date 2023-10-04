package com.Spring.demo.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Spring.demo.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TravelAgentDTO {

	@NotNull
	private int id;

	@NotNull
	@Size(min = 2, max = 50, message = "Name should have min 2 to max 50 characters")
	private String name;

	@NotNull
	private long phNo;

	@NotNull
	private String email;

	@NotNull
	@Size(min = 5, max = 100, message = "Name should have min 5 to max 100 characters")
	private String address;
	List<Customer> cust;
}
