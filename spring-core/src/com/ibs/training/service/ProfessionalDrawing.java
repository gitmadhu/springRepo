package com.ibs.training.service;

import com.ibs.training.model.Drawing;
import com.ibs.training.model.Shape;

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
