package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Developer jae = factory.getBean("developer", Developer.class);
		Engineer ho = factory.getBean("engineer", Engineer.class);
		
		System.out.println(jae);
		System.out.println(ho);
		
		
		
		
	}

}
