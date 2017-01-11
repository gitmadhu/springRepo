package com.ibs.training;

public class CircleDrawing implements Drawing {

	Circle circle;
	
	@Override
	public void drawShape() {
		circle.draw();
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}

}
