package com.ibs.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingShapeTest {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext is load all beans in the application
	    ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		    //this step is used to get required bean using getBean() method of the created context
		Drawing drawing= (Drawing) context.getBean("profDrawing");
		drawing.drawShape();
	}

}
