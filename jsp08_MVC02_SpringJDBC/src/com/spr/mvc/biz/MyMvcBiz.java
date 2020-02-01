package com.spr.mvc.biz;

import java.util.List;

import com.spr.mvc.dto.MyMvcDto;

public interface MyMvcBiz {
	
	public List<MyMvcDto> selectList();
	
	public MyMvcDto selectone(int seq);
	
	public int insert(MyMvcDto dto);
	
	public int update(MyMvcDto dto);
	
	public int delete(int seq);
	
	public int multidelete(int chk[]);
	
	

}
