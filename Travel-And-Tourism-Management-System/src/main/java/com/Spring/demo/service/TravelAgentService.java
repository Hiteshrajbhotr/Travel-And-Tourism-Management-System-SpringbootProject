package com.Spring.demo.service;

import java.util.List;

import com.Spring.demo.entity.TravelAgent;
import com.Spring.demo.model.TravelAgentDTO;

public interface TravelAgentService {
	
	//Creating new Agent
	TravelAgentDTO createAgent(TravelAgent travelAgent);
	
	//Assigning agent to customer
	String assignCustomerToAgent(int taid, int cid);
	
	//We can find agent by their id
	TravelAgentDTO searchTravelAgentById(int id);
	
	//update agent details by id
	TravelAgentDTO updateTravelAgentById(int id,TravelAgent travelAgent);
	
	//delete agent by id 
	String deleteAgentById(int id);
	
	//find all the agents
	List<TravelAgentDTO> getAllAgents();
}
