package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String code;
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// simulate exception
		if (tripWire) {
			throw new RuntimeException("**ERROR**");
			
		}
	
		List<Account> myAccounts = new ArrayList<>();
		
		// sample accounts 
		Account temp1 = new Account("Duke", "Silver");
		Account temp2 = new Account("April", "Gold");
		Account temp3 = new Account("Leslie", "Platinum");
		
		// add accounts to list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": Adding account to the db");
	}
	
	public boolean isVip() {
		
		System.out.println(getClass() + " Checking VIP status");
		
		return true;
	}

	public String getName() {
		
		System.out.println("Getting name..");
		
		return name;
	}

	public void setName(String name) {
		
		System.out.println("Setting name..");
		
		this.name = name;
	}

	public String getCode() {
		
		System.out.println("Getting code..");
		
		return code;
	}

	public void setCode(String code) {
		
		System.out.println("Setting code..");
		
		this.code = code;
	}

}

