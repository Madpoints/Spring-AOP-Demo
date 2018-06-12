package com.madpoints.springdemo;

public class FortuneOfTheDay implements FortuneService {

	private String[] fortunes = {"Be prepared for several bone tremors", 
			"You will be perceived as a disgrace by those around you",
			"You will be in an accident involving a screen door and a randy man"};

	@Override
	public String getFortune() {
		
		int random = (int )(Math.random() * 3);

		return fortunes[random];
	}

}
