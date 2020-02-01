package com.mvc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mvc.db.SqlMapConfig;
import com.mvc.dto.MyMvcDto;

public class MyMvcDaoImple extends SqlMapConfig implements MyMvcDao {

		private String namespace = "mvc.mapper.";
	
		//SqlSessionFactory : java와 db를 연결해주는 connectiom session 객체 
	@Override
	public List<MyMvcDto> selectList() {
		
		String resource = "com/mvc/db/mvc-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		SqlSession session = sqlSessionFactory.openSession();
		List<MyMvcDto> list = session.selectList("mvc.mapper.selectList");
		
		return list;
	}

	@Override
	public MyMvcDto selectone(int seq) {
		
		MyMvcDto dto = new MyMvcDto();
		//값을 여러개 넣어야 할 때 는 map 사용함
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", seq);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"selectOne",map);
		
		
		return dto;
	}

	@Override
	public int insert(MyMvcDto dto) {
		
		int res =0;
		SqlSession session = null;
		
		try {
			
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insert", dto);
			
			if(res>0) {
				session.commit();
			}
			
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

	@Override
	public int update(MyMvcDto dto) {
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"update", dto);
			
			if(res>0) {
				session.commit();
			}
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"delete", seq);
			
			if(res>0) {
				session.commit();
			}
			
			
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

}
