package com.test03;

import org.omg.CORBA.portable.ApplicationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		//기존 방식
		//1.
		//Resource res = new FileSystemResource("src/com/test03/beans.xml");
		
		//2.
		//Resource res = new ClassPathResource("com/test03/beans.xml");
		//BeanFactory factory = new XmlBeanFactroy(res);
		
		//3.
		
		
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		MessageBean bean01 = (MessageBean) factory.getBean("bean01");
		bean01.sayHello("Spring");
		
		MessageBean bean02 = (MessageBean) factory.getBean("bean02");
		bean02.sayHello("스프링");
	}
}

/*
 * 1. ApplicationContext (ClassPathXmlApplicationContext)
 * BeanFactory <-ApplicationContext <- ClassPathXmlApplicationContext
 * 
 * xml의 경로를 읽어서 contaioner를 만들어주겠다
 * 그 후 xml에서 만들어놓은 객체를 가져와 사용함
 * 
 * 
 * ApplicationContext : 스프링 컨테이너의 인스턴스
 * ClassPathXmlApplicationContext : xml 형식의 독립형 어플리케이션
 * 지정된 classpath에서 ~.xml 을 읽어서 생성
 * 
 *
 *2. contents, context, container
 *		contents : 기능
 *		context  : 기능 구현하기위한 정보
 *		container : 담고있는 객체
 * */

