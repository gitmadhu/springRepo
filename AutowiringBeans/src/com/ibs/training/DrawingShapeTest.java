package com.ibs.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingShapeTest {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext is load all beans in the application
	    ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		    //this step is used to get required bean using getBean() method of the created context
		Drawing triagleDrawing = (Drawing) context.getBean("triagleDrawing");
		triagleDrawing.drawShape();
		
		Drawing circleDrawing = (Drawing) context.getBean("circleDrawing");
		circleDrawing.drawShape();
		
		Drawing rectangleDrawing = (Drawing) context.getBean("rectangleDrawing");
		rectangleDrawing.drawShape();
		
		// dependencies for this bean injected by autowire annotation feature
		Drawing squareDrawing = (Drawing) context.getBean("squareDrawing");
		squareDrawing.drawShape();
	}

}
