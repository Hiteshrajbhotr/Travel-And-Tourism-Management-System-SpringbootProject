package com.Spring.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TravelAgent {

	@Id
	private int id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=10,unique=true)
	private long phNo;
	
	private String email;
	
	@Column(length=100)
	private String address;
	
	@OneToMany(mappedBy="travelAgent",cascade = CascadeType.PERSIST) //travel agent id will be foreign key)
	@JsonIgnoreProperties("travelAgent")
	List<Customer> cust;//in customer table

	
}
