package com.Spring.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.demo.entity.Customer;
import com.Spring.demo.entity.TravelAgent;
import com.Spring.demo.exception.ResourceNotFoundException;
import com.Spring.demo.model.TravelAgentDTO;
import com.Spring.demo.repository.CustomerRepository;
import com.Spring.demo.repository.TravelAgentRepository;
import com.Spring.demo.service.TravelAgentService;
import com.Spring.demo.util.Converter;

@Service
public class TravelAgentServiceImpl implements TravelAgentService {

	@Autowired
	private TravelAgentRepository agentrepo;
	
	@Autowired
	private CustomerRepository customerepo;
	
	@Autowired
	private Converter converter;

	@Override
	public TravelAgentDTO createAgent(TravelAgent travelAgent) {
		
		return converter.convertToTravelAgentDTO(agentrepo.save(travelAgent));
	}

	@Override
	public String assignCustomerToAgent(int taid, int cid) {
		Customer c=customerepo.findById(cid).orElseThrow(()->
		new ResourceNotFoundException("Customer", "Id", cid));
		
		TravelAgent  t=agentrepo.findById(taid).orElseThrow(()->
		new ResourceNotFoundException("TravelAgent", "Id", taid));
		
		List<Customer> cust=new ArrayList<>();
		cust.add(c);
		
		//assign students to teacher
		t.setCust(cust);
		
		//assign teacher to student
		c.setTravelAgent(t);
		
		agentrepo.save(t);
		return "Customer assigned to TravelAgent successfully";
	}

	@Override
	public TravelAgentDTO searchTravelAgentById(int id) {
		TravelAgent t=agentrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",id));
		return converter.convertToTravelAgentDTO(t);
	}

	@Override
	public TravelAgentDTO updateTravelAgentById(int id, TravelAgent travelAgent) {
		TravelAgent c=agentrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",id));
		c.setName(travelAgent.getName());
		c.setAddress(travelAgent.getAddress());
		c.setPhNo(travelAgent.getPhNo());
		
		TravelAgent agent=agentrepo.save(c);
		return converter.convertToTravelAgentDTO(agent);
	}

	@Override
	public String deleteAgentById(int id) {
		agentrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",id));
		
		agentrepo.deleteById(id);
		return "Agent got deleted successfully!!";
	}

	@Override
	public List<TravelAgentDTO> getAllAgents() {
List<TravelAgent> ta=agentrepo.findAll();
		
		//list of type DTO
		List<TravelAgentDTO> dtoList=new ArrayList<>();
		for(TravelAgent t:ta)
		{
			dtoList.add(converter.convertToTravelAgentDTO(t));
		}
		return dtoList;
	}
}
