package com.billherry.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Page<Actor> findAll(int start, int limit) {
		Pageable page = new PageRequest(start / limit, limit);
		return repository.findAll(page);
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
