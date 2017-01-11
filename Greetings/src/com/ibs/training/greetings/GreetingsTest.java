package com.ibs.training.greetings;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingsTest {

	public static void main(String[] args) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
			
			//this step is used to get required bean using getBean() method of the created context
			SimpleGreetings simpleGreetings= (SimpleGreetings) context.getBean("simpleGreetings");
			simpleGreetings.greet();
			
			NiceGreetings niceGreetings= (NiceGreetings) context.getBean("niceGreetings");
			niceGreetings.greet();
			
			//using bean aliasing.
			Greetings ngreetings = (Greetings)context.getBean("greetings");
			ngreetings.greet();
	}

}
