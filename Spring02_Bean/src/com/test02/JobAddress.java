package com.test02;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobAddress {
	
	@Resource(name="han")
	private Address addr;
	
	@Resource(name="josu")
	private String jobName;
	
	public JobAddress() {
		
		this.addr = new Address("홍길동", "서울시 강남구","010-1234-5678");
		this.jobName = "도적";
	}
	
	
	public JobAddress(Address addr, String jobName) {

		this.addr = addr;
		this.jobName = jobName;
	}
	
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	@Override
	public String toString() {
		return "JobAddress [addr=" + addr + ", jobName=" + jobName + "]";
	}
	

	
}
