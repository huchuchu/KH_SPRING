package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Emp yoo = factory.getBean("jaesuk",Emp.class);
		Emp kang = factory.getBean("hodong", Emp.class);
		
		System.out.println(yoo);
		System.out.println(kang);
		
		
	}
	

}
