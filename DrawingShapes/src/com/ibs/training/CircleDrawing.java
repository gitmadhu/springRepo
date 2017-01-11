package com.ibs.training;

public class CircleDrawing implements Drawing {

	Circle circle;
	
	CircleDrawing(){
		circle = new Circle(); 
	}
	@Override
	public void drawShape() {
		circle.draw();
	}

}
