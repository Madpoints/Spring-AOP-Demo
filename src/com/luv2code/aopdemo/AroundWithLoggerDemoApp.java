package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;


public class AroundWithLoggerDemoApp {
	
	// setup logger
	private static Logger myLogger =
					Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get beans from containers
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		// call and display fortune service
		myLogger.info("Main app - Calling fortune service");
		myLogger.info("Todays traffic fortune: " + theFortuneService.getFortune());
		myLogger.info("Finished");
		
		// close context
		context.close();
	}

}
