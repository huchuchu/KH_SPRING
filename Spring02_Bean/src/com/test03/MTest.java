package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		//경로에 있는 xml을 읽어서 IOC컨테이너를 생성 -> 객체 생성 
		
		UserDto dto = (UserDto)factory.getBean("myDto");
		System.out.println(dto.getPer());
		System.out.println(dto.getMyDate());
		System.out.println(dto.getUsername());
		
		UserService service = factory.getBean("myService", UserService.class);
		service.addUser(dto);
		
		
		
	}

}
