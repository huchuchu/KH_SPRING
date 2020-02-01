package com.test04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developer {
	
	
	@Autowired
	@Qualifier("developer_Dept")
	private String dept;
	
	@Autowired
	@Qualifier("yoo")
	private Emp emp;
	
	public Developer() {}

	public Developer(String dept, Emp emp) {

		this.dept = dept;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return emp +"\t"+ dept;
	}
	
	
	
	

}
