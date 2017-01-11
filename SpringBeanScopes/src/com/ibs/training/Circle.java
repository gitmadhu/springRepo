package com.ibs.training;

public class Circle implements Shape {

	private String color;
	private String name;
	
	@Override
	public void draw() {
		System.out.println("draw circle with color "+this.color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
