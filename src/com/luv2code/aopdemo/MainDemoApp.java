package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get beans from containers
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call business methods
		Account theAccount = new Account();
		theAccountDAO.addAccount(theAccount, theAccountDAO.isVip());
		
		theAccountDAO.setName("Jim");
		theAccountDAO.setCode("Good Standing");
		
		String name = theAccountDAO.getName();
		String status = theAccountDAO.getCode();
		
		theMembershipDAO.addMember();
		theMembershipDAO.daysToRenew();
		
		// close context
		context.close();
	}

}
