package com.test04;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Engineer {
	
	@Resource(name="engineer_Dept")
	private String dept;
	
	@Autowired
	@Qualifier("kang")
	private Emp emp;
	
	public Engineer() {}

	public Engineer(String dept, Emp emp) {

		this.dept = dept;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return emp + "\t" + dept ;
	}
	
	

}
