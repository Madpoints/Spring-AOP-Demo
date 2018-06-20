package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get beans from containers
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// display accounts
		System.out.println(theAccounts + "\n");
		
		// close context
		context.close();
	}

}
