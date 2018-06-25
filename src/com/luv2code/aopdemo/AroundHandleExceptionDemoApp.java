package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	// setup logger
	private static Logger myLogger =
					Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get beans from containers
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		// call and display fortune service
		myLogger.info("Main app - Calling fortune service");
		
		boolean tripWire = true;
		String fortune = theFortuneService.getFortune(tripWire);
		
		myLogger.info("Todays traffic fortune: " + fortune);
		myLogger.info("Finished");
		
		// close context
		context.close();
	}

}
