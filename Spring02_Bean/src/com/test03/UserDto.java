package com.test03;

import java.util.Date;
import java.util.Properties;

public class UserDto {
	
	
	private String username;
	private Properties per;
	private Date myDate;
	
	public UserDto() {	}
	
	public UserDto(String username) {
		this.username = username;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Properties getPer() {
		return per;
	}
	public void setPer(Properties per) {
		this.per = per;
	}
	public Date getMyDate() {
		return myDate;
	}
	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	
	
	

}
