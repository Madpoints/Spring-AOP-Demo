package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// pointcut declarations
	
	// match on all methods within a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// match on all getters within a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forDaoPackageGet() {}
	
	// match on all setters within a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forDaoPackageSet() {}
	
	// combine pointcut expressions
	@Pointcut("forDaoPackage() && !(forDaoPackageGet() || forDaoPackageSet())")
	private void forDaoPackageNoGetSet() {}
	
	@Before("forDaoPackageNoGetSet()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n**@Before advice on all methods in package**");
	}
	
	@Before("forDaoPackageNoGetSet()")
	public void analytics() {
		
		System.out.println("\n**Analyzing...**");
	}
}
