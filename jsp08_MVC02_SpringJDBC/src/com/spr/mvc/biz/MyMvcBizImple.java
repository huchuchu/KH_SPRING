package com.spr.mvc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.mvc.dto.MyMvcDto;
import com.spr.mvc.model.dao.MyMvcDao;


@Service
public class MyMvcBizImple implements MyMvcBiz {
	
	@Autowired
	private MyMvcDao dao;

	@Override
	public List<MyMvcDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MyMvcDto selectone(int seq) {
		
		return dao.selectone(seq);
	}

	@Override
	public int insert(MyMvcDto dto) {
		
		return dao.insert(dto);
	}

	@Override
	public int update(MyMvcDto dto) {
	
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		
		return dao.delete(seq);
	}

	@Override
	public int multidelete(int[] chk) {
		
		return dao.multidelete(chk);
	}

}
