package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyAspect {
	
	//pointcut으로 사용 할 empty method
	//"execution(public * * (..))" 이름을 대신하여 myClass()를 쓰겠다
	//@Pointcut("execution(public * * (..))")
	//public void myClass() {	}
	
	//execution(public void com.test06.Woman.classWork()가 호출되면 연결해줘 
	@Before("execution(public void com.test06.Woman.classWork())")
	public void before(JoinPoint join) {
		System.out.println("출석체크");
	}
	
	//어떤 메소드던지, 파라미터가 몇개던지 public void Man가 호출되면 연결해줘
	@After("execution(public void Man.*(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다");
	}
	
	

}
