package com.billherry.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billherry.mvc.domain.Actor;
import com.billherry.mvc.repository.ActorRepository;

@Service
public class ActorService {
	Logger log = LoggerFactory.getLogger(ActorService.class);
	
	@Autowired
	private ActorRepository repository;	
	
	@Transactional(readOnly=true)
	public Map<String,Object> findAll(){
		System.out.println(String.format("TOTAL ITEM: %s",repository.count()));
		Map<String,Object> findAllMap = new HashMap<String,Object>();
		findAllMap.put("Actors", repository.findAll());
		findAllMap.put("Total",repository.count());		
		return findAllMap;
	}
	
	@Transactional
	public void delete(Long id){
		repository.delete(id);
	}
	
	@Transactional
	public Actor save(Actor actor){
		return repository.save(actor);
	}
}
