package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV ig = factory.getBean("igTv", TV.class); //class이름과 똑같이 는데 첫글자만 소문자
		ig.powerOn();
		ig.volumeUp();
		ig.volumeDown();
		ig.powerOff();
		
		
	}

}
