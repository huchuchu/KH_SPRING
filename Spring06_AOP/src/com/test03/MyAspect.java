package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	
	//JoinPoint 두개있음
	public void before(JoinPoint join) {
		System.out.println("출석체크하기");
		
	}
	
	public void after(JoinPoint join) {
		System.out.println("집에 간다");
	}
	
}
