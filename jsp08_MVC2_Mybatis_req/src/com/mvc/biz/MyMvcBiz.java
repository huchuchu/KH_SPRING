package com.mvc.biz;

import java.util.List;

import com.mvc.dto.MyMvcDto;

public interface MyMvcBiz {
	
	public List<MyMvcDto> selectList();
	
	public MyMvcDto selectone(int seq);
	
	public int insert(MyMvcDto dto);
	
	public int update(MyMvcDto dto);
	
	public int delete(int seq);
	
	

}
