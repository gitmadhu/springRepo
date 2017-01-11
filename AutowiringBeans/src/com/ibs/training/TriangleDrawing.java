package com.ibs.training;

public class TriangleDrawing implements Drawing {

	Triangle triangle;
	
	TriangleDrawing(Triangle triangle ){
		this.triangle = triangle;
	}
	@Override
	public void drawShape() {
		triangle.draw();
	}

}
