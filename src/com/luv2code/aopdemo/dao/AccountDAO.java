package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + ": Adding account " + 
							theAccount.getName() + ", status: " +
							theAccount.getStatus() + " to the db");
	}
}
