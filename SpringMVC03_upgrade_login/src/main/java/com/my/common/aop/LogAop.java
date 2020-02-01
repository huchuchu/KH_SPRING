package com.my.common.aop;




import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class LogAop {
	
	public void before(JoinPoint join) {
		
		//syso가 자원을 많이 잡아먹기때문에 대신 consol에 찍어줄 수 있음
		//clazz : 어떤타입의 class를 넣어줘라. or 이름 넣기
		//join.getTarget() 는 string object 둘 다 아니어서 스트링으로 만들어줌
		
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("-------logger start");
		Object args[] = join.getArgs(); 
		
		System.out.println("<<<<<"+args.length+">>>>>>");
		
		if(args !=null) {
			//logger.info(">>"+args[0]);
			logger.info("Method:\t"+join.getSignature().getName());
			
			for(int i=0; i< args.length; i++) {
		
				logger.info(i+"번째:\t"+args[i]);
			}
		}
		
		/*
		 * join.getTarger(): 대상객체
		 *     .getArgs(): 대상 파라미터(아규먼트)
		 *     .getSignature(): 대상 메소드 정보
		 * 
		 * */
		
		
	}
	
	public void after(JoinPoint join) {
		
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("-------------logger end------------");
		
		
		
		
		
		
	}
	
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("Error: \t"+join.getArgs());
		logger.info("Error: \t"+join.toString());
		
		
	}

}
