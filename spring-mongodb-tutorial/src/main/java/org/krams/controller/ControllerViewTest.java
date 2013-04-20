package org.krams.controller;

import java.util.ArrayList;
import java.util.List;

import org.krams.domain.PGraph;
import org.krams.dto.PGraphDto;
import org.krams.service.PGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/view")
public class ControllerViewTest {
	@Autowired
	private PGraphService graphService;
	@RequestMapping
	public String getView(){
		return"view";
	}
	@RequestMapping(value="/records")
	public @ResponseBody PGraphDto getUsers() {
		
		PGraphDto dto = new PGraphDto();
		
	/*	List<PGraph> users = new ArrayList<PGraph>();
		PGraph user1 = new PGraph();
		user1.setTask("task1");
		user1.setId("100");
		user1.setProdF("1.2");
		
		PGraph user2 = new PGraph();
		user2.setTask("task2");
		user2.setId("101");
		user2.setProdF("2.4");
		
		PGraph user3 = new PGraph();
		user3.setTask("task3");
		user3.setId("103");
		user3.setProdF("1.7");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);*/
		dto.setGraph(graphService.readAll());
		return dto;
	}
	
}
