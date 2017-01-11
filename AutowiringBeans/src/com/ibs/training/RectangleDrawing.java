package com.ibs.training;

public class RectangleDrawing implements Drawing {

	Rectangle rectangle;
	
	@Override
	public void drawShape() {
		rectangle.draw();
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

}
