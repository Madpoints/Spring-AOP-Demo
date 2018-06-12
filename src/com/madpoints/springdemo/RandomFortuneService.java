package com.madpoints.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {"Expect to feel several bone tremors", 
			"You will be perceived by all around you to be a disgrace",
			"You will be in an accident involving a screen door and a randy man"};

	@Override
	public String getFortune() {
		
		int index = (int )(Math.random() * 3);

		return fortunes[index];
	}

}
