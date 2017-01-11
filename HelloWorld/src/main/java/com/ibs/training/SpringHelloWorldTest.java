package com.ibs.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorldTest {

	public static void main(String...strings){
	
		//ClassPathXmlApplicationContext is load all beans in the application
	    ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		    //this step is used to get required bean using getBean() method of the created context
		HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld");
		helloWorld.getMessage();
	}
	
}
