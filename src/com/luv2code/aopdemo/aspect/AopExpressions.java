package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	// pointcut declarations
	
	// match on all methods within a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// match on all getters within a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forDaoPackageGet() {}
	
	// match on all setters within a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forDaoPackageSet() {}
	
	// combine pointcut expressions
	@Pointcut("forDaoPackage() && !(forDaoPackageGet() || forDaoPackageSet())")
	public void forDaoPackageNoGetSet() {}
	
}
