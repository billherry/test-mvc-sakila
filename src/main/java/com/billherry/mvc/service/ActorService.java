package com.billherry.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billherry.mvc.domain.Actor;
import com.billherry.mvc.repository.ActorRepository;

@Service
public class ActorService {
	@Autowired
	private ActorRepository repository;
	
	@Transactional(readOnly=true)
	public List<Actor> findAll(){
		return repository.findAll();
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
