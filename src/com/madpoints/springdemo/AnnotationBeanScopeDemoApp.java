package com.madpoints.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nAre they the same object? " + result);
		System.out.println("\nMemory location theCoach: " + theCoach);
		System.out.println("\nMemory location alphaCoach: " + alphaCoach + "\n");		
		
		// close context
		context.close();		
		
	}

}
