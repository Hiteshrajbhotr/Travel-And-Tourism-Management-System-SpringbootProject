package com.Spring.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.demo.entity.TravelAgent;
import com.Spring.demo.model.TravelAgentDTO;
import com.Spring.demo.service.TravelAgentService;
import com.Spring.demo.util.Converter;

@RestController
//@RequestMapping("/api")
public class TravelAgentController {

	@Autowired
	private TravelAgentService agentService;
	
	@Autowired 
	private Converter converter;
	
	@PostMapping("/createAgent")
	ResponseEntity<TravelAgentDTO> createAgent(@Valid @RequestBody TravelAgentDTO agentDTO) 
	{
		final TravelAgent agent=converter.convertToTravelAgentEntity(agentDTO);
		return new ResponseEntity<TravelAgentDTO>(agentService.createAgent(agent),HttpStatus.CREATED);	
	}
	@PostMapping("/assign/{taid}/{cid}")
	public String assignCustomerToAgent(@PathVariable("taid") int taid,@PathVariable("cid") int cid)
	{
		return agentService.assignCustomerToAgent(taid, cid);
	}
}
