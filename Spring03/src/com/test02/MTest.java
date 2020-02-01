package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		BirthDto jisu = (BirthDto)factory.getBean("jisu");
		System.out.println(jisu);
		
		BirthDto yumi = factory.getBean("yumi", BirthDto.class);
		System.out.println(yumi);
		
		
		
	}
	

}
