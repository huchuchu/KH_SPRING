package com.test01;

public class Person implements Human {
	
	
	private String sayName;
	private String sayJob;
	

	public void setSayName(String sayName) {
		this.sayName = sayName;
	}
	public void setSayJob(String sayJob) {
		this.sayJob = sayJob;
	}

	@Override
	public String sayName(String name) {
		System.out.println("나의 이름은"+name+"입니다");
		return name;
	}

	@Override
	public String sayJob(String job) {
		System.out.println("나의 직업은"+job+"입니다");
		return "나의 직업은"+job+"입니다";
	}
	
	
	
	

}
