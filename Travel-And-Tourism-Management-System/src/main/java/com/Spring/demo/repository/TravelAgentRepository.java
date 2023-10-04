package com.Spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.demo.entity.TravelAgent;

public interface TravelAgentRepository extends JpaRepository<TravelAgent, Integer> {

}
