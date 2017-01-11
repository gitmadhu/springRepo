package com.ibs.training.greetings;

public class NiceGreetings implements Greetings {
	

	private String name;
	private GreetingService greetingService;
	
	@Override
	public void greet() {
		System.out.println(greetingService.getGreeting()+" ! "+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GreetingService getGreetingService() {
		return greetingService;
	}

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

}
