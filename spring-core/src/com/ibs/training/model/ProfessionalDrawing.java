package com.ibs.training.model;

public class ProfessionalDrawing implements Drawing {

	Shape shape;
	
	public ProfessionalDrawing(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public void drawShape() {
		shape.draw();
	}
	
}
