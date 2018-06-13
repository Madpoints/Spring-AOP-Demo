package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// all related advices for logging
	
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n**@Before advice on add*()**");
	}
}
