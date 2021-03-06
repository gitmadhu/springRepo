package com.ibs.training.model;

import org.springframework.beans.factory.annotation.Autowired;

public class SquareDrawing implements Drawing {

	// make sure you added <context:annotation-config /> to the spring xml to use this feature
	@Autowired   
	private Square square; // autowired dependency
	
	@Override
	public void drawShape() {
		square.draw();
	}

}
