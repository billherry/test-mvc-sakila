package com.billherry.mvc.controlling;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.billherry.mvc.domain.Actor;
import com.billherry.mvc.service.ActorService;

@Controller
@RequestMapping("/actor/*")
public class ActorController {
	
	@Autowired
	private ActorService service;
	
	
	
	@RequestMapping(value ="select")
	public Map<String,Object>  findAll(){		
		return service.findAll();
	}
	
	@RequestMapping("create")
	public Actor save(@Valid Actor actor){
		return service.save(actor);
	}
	
	@RequestMapping("delete")
	public void delete(@Valid Actor actor){
		//Update hogyan?
		service.delete(actor.getActor_id());
	}
}
