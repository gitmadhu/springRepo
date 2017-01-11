package com.ibs.training.collections.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DepInjectionTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-beans.xml");

    	ShapesCollection cust = (ShapesCollection)context.getBean("shapesCollection");
    	System.out.println(cust.getLists());
    	System.out.println("------------------------------");
    	System.out.println(cust.getSets());
    	System.out.println("------------------------------");
    	System.out.println(cust.getMaps());
    	System.out.println("------------------------------");
    	System.out.println(cust.getPros());
    	System.out.println("------------------------------");
	}

}
