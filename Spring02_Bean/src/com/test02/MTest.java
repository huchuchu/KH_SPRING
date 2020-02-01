package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		
		Address han = (Address)factory.getBean("han");
		System.out.println(han);
		JobAddress jisu = (JobAddress)factory.getBean("jisu");
		System.out.println(jisu);
		
		Address hong = (Address)factory.getBean("hong");		
		JobAddress yumi = (JobAddress)factory.getBean("yumi");
		System.out.println(hong);
		System.out.println(yumi);
		
		//getBean("yumi", JobAddress.class)이렇게 써주면 따로 형변환 안해줘도 맞춰줌
		JobAddress yumi02 = factory.getBean("yumi", JobAddress.class);
		System.out.println("yumi02: "+yumi02);
		

		
	
	}

}
