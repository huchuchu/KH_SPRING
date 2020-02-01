package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvice {	
	
	@Before("execution(public * sayName(..))")
	public void beforeSaying(JoinPoint joinpoint) {
		System.out.println("당신의 이름은 무엇입니까?");
	}
	
	@After("execution(public * sayName(..))")
	public void afterSaying(JoinPoint joinpoint) {
		System.out.println("이름이 멋지시네요");
	}
	
	
	//afterReturning 정상적으로 다 실행되고나면 실행값 리턴값을 받을 수 있음 
	@AfterReturning(pointcut = "execution(public * sayName(..))", returning="test")
	public void afterReturnSaying(JoinPoint joinpoint, Object test) {
		System.out.println(test);
		System.out.println("직업이 무엇입니까?");
	}
	

}
