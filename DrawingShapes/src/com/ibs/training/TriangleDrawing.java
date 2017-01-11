package com.ibs.training;

public class TriangleDrawing implements Drawing {

	Triangle triangle;
	
	TriangleDrawing(){
		triangle = new Triangle(); 
	}
	@Override
	public void drawShape() {
		triangle.draw();
	}

}
