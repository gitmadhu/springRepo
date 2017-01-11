package com.ibs.training.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibs.training.javaconfig.SpringAppContextConfig;
import com.ibs.training.model.Circle;
import com.ibs.training.model.Triangle;

public class BeanScopesTest {

	public static void main(String[] args) {
		//ClassPathXmlAppliationContext is load all beans in the application
	    ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppContextConfig.class);

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
