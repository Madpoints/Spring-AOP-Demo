package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// advices
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n**@Around on method: " +
									method + "**");
		
		// get time stamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object result = theProceedingJoinPoint.proceed();
		
		// get time stamp
		long end = System.currentTimeMillis();
		
		// compute and display the time difference
		System.out.println("**Duration: " + (end - begin)/1000.0 + " seconds**");
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		
		// display method
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n**@After (finally) on method: " +
									method + "**");
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		
		// display method
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n**@AfterThrowing on method: " +
							method + "**");
		
		// log exception
		System.out.println("\n**@AfterThrowing result: " +
				theExc + "**");
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		
		// display method
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n**@AfterReturning on method: " +
							method + "**");
		
		// display method call result
		System.out.println("\n**@AfterReturning result: " +
							result + "**");
		
		// post-process data
		
		// convert account names to upper
		convertAccountNamesToUpperCase(result);
		
		// display method call result
		System.out.println("\n**@AfterReturning result: " +
									result + "**");
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for (Account tempAccount : result) {
		
			// get upper case version of account name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update account name
			tempAccount.setName(theUpperName);
		}	
			
	}

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetSet()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n**@Before advice on all methods in package**");
		
		// display method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				// downcast and display Account related data
				Account theAccount = (Account) tempArg;
				
				System.out.println("account: " + theAccount);
				
			}
		}
		
	}
	
}
