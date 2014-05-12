package com.billherry.mvc.controlling;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	@RequestMapping(value = "select")
	public Page<Actor> findAll(@RequestParam("start") Integer start, @RequestParam("limit") Integer limit,
			@RequestParam(value = "dir", required = false) String dir,
			@RequestParam(value = "sort", required = false) String sortBy) {
		System.out.println("Start: " + start + " Limit: " + limit + "Dir: " + dir + " SortBy: " + sortBy);
		return service.findAll(start, limit, dir, sortBy);
	}

	@RequestMapping("create")
	public Actor save(@Valid Actor actor){
		return service.save(actor);
	}
	
	@RequestMapping("delete")
	public void delete(@Valid Actor actor){
		service.delete(actor.getActorId());
	}
}
