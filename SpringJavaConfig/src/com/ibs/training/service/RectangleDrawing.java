package com.ibs.training.service;

import com.ibs.training.model.Drawing;
import com.ibs.training.model.Rectangle;

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
