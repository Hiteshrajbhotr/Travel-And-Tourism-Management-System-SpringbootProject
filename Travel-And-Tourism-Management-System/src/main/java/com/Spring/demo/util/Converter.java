package com.Spring.demo.util;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.Spring.demo.entity.Customer;
import com.Spring.demo.entity.TravelAgent;
import com.Spring.demo.model.CustomerDTO;
import com.Spring.demo.model.TravelAgentDTO;

@Component
public class Converter {

	//convert DTO to Entity
	public Customer convertToCustomerEntity(CustomerDTO customerDTO)
	{
		Customer cust=new Customer();
		if(customerDTO!=null)
		{
			BeanUtils.copyProperties(customerDTO, cust);
		}
		return cust;
	}
	
	//convert from Entity to DTO
	public CustomerDTO convertToCustomerDTO(Customer customer)
	{
		CustomerDTO custDTO=new CustomerDTO();
		if(customer!=null)
		{
			BeanUtils.copyProperties(customer, custDTO);
		}
		return custDTO;
	}
	
	//convert DTO to Entity
	public TravelAgent convertToTravelAgentEntity(TravelAgentDTO travelagentDTO)
	{
		TravelAgent agent=new TravelAgent();
		if(travelagentDTO!=null)
		{
			BeanUtils.copyProperties(travelagentDTO, agent);
		}
		return agent;
	}
	
	//convert from Entity to DTO
	public TravelAgentDTO convertToTravelAgentDTO(TravelAgent travelAgent)
	{
		TravelAgentDTO agentDTO =new TravelAgentDTO();
		if(travelAgent!=null)
		{
			BeanUtils.copyProperties(travelAgent, agentDTO);
		}
		return agentDTO;
	}
}
