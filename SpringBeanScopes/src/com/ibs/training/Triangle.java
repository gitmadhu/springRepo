package com.ibs.training;

public class Triangle implements Shape {

	private String color;
	private String name;
	
	@Override
	public void draw() {
		System.out.println("draw triangle with color "+this.color);
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
