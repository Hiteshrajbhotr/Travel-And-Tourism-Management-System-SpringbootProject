package com.Spring.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50)
	private String name;
	
	@Column(unique=true)
	private long phNo;
	
	private String email;
	
	@Column(length=100)
	private String address;
	private boolean status=Boolean.TRUE;
	
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="taId")
	@JsonIgnoreProperties("cust")
	private TravelAgent travelAgent;

}
