package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// advice
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetSet()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n**@Before advice on all methods in package**");
	}
	
}
