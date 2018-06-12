package com.madpoints.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService happyFortuneService;
	
	// default constructor
	public TennisCoach() {
	}
	
	// define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Starting up...");
	}
	
	// define destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("Cleaning up...");
	}
	
	// spring will use any @Autowired method to resolve a dependency
	// regardless of its name
//	@Autowired
//	public void whatever(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	// configure dependency with @Autowired annotation
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return happyFortuneService.getFortune();
	}
	
}
