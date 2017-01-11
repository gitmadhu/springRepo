package com.ibs.training.greetings;

public class SimpleGreetings implements Greetings {

	private String name;
	
	public SimpleGreetings(String name) {
		this.name= name;
	}

	@Override
	public void greet() {
		System.out.println("Greetings "+name);
	}

}
