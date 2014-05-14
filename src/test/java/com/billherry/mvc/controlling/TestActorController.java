package com.billherry.mvc.controlling;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class TestActorController {
	Log log = LogFactory.getLog(ActorController.class);
	
	@Autowired
	private ActorController controller;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testActorControllRequest() throws Exception {
		mockMvc.perform(get("/actor/select").param("start", "0").param("limit", "100"))
				.andExpect(status().isOk()).andDo(new ResultHandler() {
			
			@Override
			public void handle(MvcResult result) throws Exception {
				for (Entry<String, Object> entry : result.getModelAndView().getModel().entrySet()) {
							System.out.println(entry.);
				}
			}
		});
	}
}
