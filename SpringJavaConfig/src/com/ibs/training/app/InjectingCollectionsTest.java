package com.ibs.training.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ibs.training.javaconfig.SpringAppContextConfig;
import com.ibs.training.service.ShapesCollection;

public class InjectingCollectionsTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppContextConfig.class);

    	ShapesCollection cust = (ShapesCollection)context.getBean("shapesCollection");
    	System.out.println("-------------List-----------------");
    	System.out.println(cust.getLists());
    	System.out.println("-------------Set-----------------");
    	System.out.println(cust.getSets());
    	System.out.println("-------------Map-----------------");
    	System.out.println(cust.getMaps());
    	System.out.println("-------------Properties-----------------");
    	System.out.println(cust.getPros());

    	System.out.println("-------------Number-----------------");
    	System.out.println(cust.getNum());

    	System.out.println("-------------Message-----------------");
    	System.out.println(cust.getMessage());
	}

}
