package com.mvc.biz.imple;

import java.util.List;


import com.mvc.biz.MyMvcBiz;
import com.mvc.dao.MyMvcDao;
import com.mvc.dao.MyMvcDaoImple;
import com.mvc.dto.MyMvcDto;

public class MyMvcBizImple implements MyMvcBiz {
	
	private MyMvcDao dao = new MyMvcDaoImple();

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

}
