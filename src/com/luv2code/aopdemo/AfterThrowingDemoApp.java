package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;


public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get beans from containers
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get the accounts
		List<Account> theAccounts = null;
		
		try {
			// add boolean flag to simulate exception
			boolean tripWire = true;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
		
		} catch(Exception exc) {
			System.out.println("\n**Main caught exception: " + 
								exc + "**\n");
				
		}
		
		// display accounts
		System.out.println(theAccounts + "\n");
		
		// close context
		context.close();
	}

}
