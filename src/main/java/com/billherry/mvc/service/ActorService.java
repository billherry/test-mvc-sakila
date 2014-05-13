package com.billherry.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Page<Actor> findAll(int start, int limit, String dir, String sortBy) {
		Pageable page;
		if (dir != null && !dir.isEmpty()) {
			System.out.println(String.format("%s , %s", dir, sortBy));
			Sort sort = new Sort(Sort.Direction.fromString(dir), sortBy);
			page = new PageRequest(start / limit, limit, sort);
		} else {
			page = new PageRequest(start / limit, limit);
		}
		Page<Actor> pageResult = repository.findAll(page);
		return pageResult;
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
