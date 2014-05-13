package com.billherry.mvc.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billherry.mvc.domain.Actor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class TestActorService {
	private Log log = LogFactory.getLog(TestActorService.class);

	@Autowired
	private ActorService service;

	@Test
	public void findAllWithoutSort() {
		int start = 10;
		int limit = 5;
		Page<Actor> findAll = service.findAll(start, limit, null, null);
		long actorId = findAll.getContent().get(0).getActorId();
		printActors(findAll);
		Assert.assertEquals(actorId, start + 1);
		Assert.assertEquals(findAll.getNumberOfElements(), limit);
	}

	@Test
	public void findAllWithSorting() {
		int start = 50;
		int limit = 10;
		String dir = "DESC";
		String sortBy = "actorId";
		Page<Actor> findAll = service.findAll(start, limit, dir, sortBy);
		long actorId = findAll.getContent().get(0).getActorId();
		printActors(findAll);
		Assert.assertEquals(findAll.getTotalElements() - start, actorId);
		Assert.assertEquals(findAll.getNumberOfElements(), limit);
	}

	private void printActors(Page<Actor> findAll) {
		for (Actor actor : findAll) {
			System.out.println(actor);
		}
	}
}
