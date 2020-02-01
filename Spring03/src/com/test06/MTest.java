package com.test06;

public class MTest {
	
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		
		TV tv1 = (TV)factory.getBean("Ig");
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
		
		TV tv2 = (TV)factory.getBean("Samsung");
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
		
		
		
	}
	
	
	

}
