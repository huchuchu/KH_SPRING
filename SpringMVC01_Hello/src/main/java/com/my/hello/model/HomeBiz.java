package com.my.hello.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeBiz {
	
	@Autowired
	private HomeDao dao;
	

	public String getHello() {
		
		return dao.getHello()+", spring";
	}
	
	
	

}
