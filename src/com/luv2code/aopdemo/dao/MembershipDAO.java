package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMember() {
		
		System.out.println(getClass() + ": Adding a membership to the db");
	}
}
