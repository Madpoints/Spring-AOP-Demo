package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	// advice
	
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
