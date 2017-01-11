package com.ibs.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingShapeTest {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext is load all beans in the application
	    ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

	    System.out.println("\nTriangle with session scope");
	    Triangle triangle1= (Triangle) context.getBean("triangle");
	    triangle1.setColor("Green");
	    triangle1.draw();
	    
	    //second instance of Triagle 
	    Triangle triangle2= (Triangle) context.getBean("triangle");
	    triangle2.setColor("Blue"); //change the color
	    triangle2.draw();
	    
	    triangle1.draw();// print first triangle again to check the color
	    
	    System.out.println("\nCircle with prototype scope");
	    Circle circle1= (Circle) context.getBean("circle");
	    circle1.setColor("Green");
	    circle1.draw();
	    
	    //second instance of Triagle 
	    Circle circle2= (Circle) context.getBean("circle");
	    circle2.setColor("Blue");
	    circle2.draw();
	    
	    circle1.draw();// print first triangle again to check the color
	    
	    
	}

}
