package com.luv2code.aopdemo;

public class Account {
	
	private String name;
	private String status;
	
	public Account() {
	}
	
	public Account(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", status=" + status + "]";
	}

}
