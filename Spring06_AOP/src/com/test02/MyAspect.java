package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Object returnVal = null;
		
		System.out.println("출석체크");
		
		try {
			
			returnVal = invocation.proceed();
			
		} catch (Exception e) {
			System.out.println("쉬는날이다");
		}
		 System.out.println("집에간다");
		
		return returnVal;
	}
 
}
