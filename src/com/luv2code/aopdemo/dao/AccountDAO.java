package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String status;
	
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

	public String getStatus() {
		
		System.out.println("Getting status..");
		
		return status;
	}

	public void setStatus(String status) {
		
		System.out.println("Setting status..");
		
		this.status = status;
	}

}

