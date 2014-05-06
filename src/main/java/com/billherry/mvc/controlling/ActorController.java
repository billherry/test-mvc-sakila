package com.billherry.mvc.controlling;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billherry.mvc.domain.Actor;
import com.billherry.mvc.service.ActorService;

@Controller
@RequestMapping("/actor/*")
public class ActorController {
	
	@Autowired
	private ActorService service;
	
	@RequestMapping("select")
	public List<Actor> findAll(){
		System.out.println("Request mapping");
		return service.findAll();
	}
	
	@RequestMapping("create")
	public Actor save(@Valid Actor actor){
		return service.save(actor);
	}
}
