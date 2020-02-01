package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		//프록시 객체 가 인터페이스 기준으로 만들어지기때문에 Person형으로 만들어야함!!
		Person w = factory.getBean("woman", Person.class);
		Person m = factory.getBean("man", Person.class);
		
		
	
		System.out.println("여학생 입장");
		w.classWork();
		System.out.println("===================");
		System.out.println("남학생입장");
		m.classWork();
	}
	
	

}
