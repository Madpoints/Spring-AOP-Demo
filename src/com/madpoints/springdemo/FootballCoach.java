package com.madpoints.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Red-zone defense drill";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
