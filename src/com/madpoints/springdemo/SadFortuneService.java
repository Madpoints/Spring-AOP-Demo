package com.madpoints.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You will be perceived as a disgrace by those around you";
	}

}
