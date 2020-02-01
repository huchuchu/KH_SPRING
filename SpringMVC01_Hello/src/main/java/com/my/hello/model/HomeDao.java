package com.my.hello.model;

import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	
	public String getHello() {
		
		return "HELLO";
	}

}
