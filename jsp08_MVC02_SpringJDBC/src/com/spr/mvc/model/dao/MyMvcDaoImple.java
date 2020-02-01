package com.spr.mvc.model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.spr.mvc.dto.MyMvcDto;


@Repository
public class MyMvcDaoImple  implements MyMvcDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<MyMvcDto> selectList() {
		List<MyMvcDto> list  = jdbcTemplate.query(selectListSql, new RowMapper<MyMvcDto>() {
			//jdbcTemplate: spring이 만들어놓은 java와 database를 연결시켜주는 객체 query(쿼리,쿼리에서 나온 값을 담는 rowmapper
			
			//new RowMapper<MyMvcDto>()에 값을 넣어주는 과정			
			@Override
			public MyMvcDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MyMvcDto dto = new MyMvcDto();
			dto.setSeq(rs.getInt(1));
			dto.setWriter(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegdate(rs.getDate(5));
			
				return dto;
			}			
		});
		return list;
	}

	@Override
	public MyMvcDto selectone(int seq) {
		
		//resultSetExtrator 도 사용가능 근데 이건 while에서 돌려야함 
		
		MyMvcDto dto = jdbcTemplate.queryForObject(selectOneSql, new Object[] {	seq	}, new MyMapper());
		
		
		return dto;
	}
	
	//람다식으로 하기~!
	public MyMvcDto lamdaSelectOne(int seq) {
	
		 MyMvcDto dto = jdbcTemplate.queryForObject(selectOneSql,new Object[] {seq}, (ResultSet rs, int rowNum)->{
			 MyMvcDto res = new MyMvcDto();
			 res.setSeq(rs.getInt(1));
			 res.setWriter(rs.getString(2));
			 res.setTitle(rs.getString(3));
			 res.setContent(rs.getString(4));
			 res.setRegdate(rs.getDate(5));
			 return res;
		 });
	
		return dto;
	}

	@Override
	public int insert(MyMvcDto dto) {
							//object 배열에 insertSql의 물음표에 들어갈 값을 넣는것
		int res = jdbcTemplate.update
	(insertSql, new Object[] {dto.getWriter(),dto.getTitle(),dto.getContent()});	
		return res;
	}

	@Override
	public int update(MyMvcDto dto) {
		
		int res = jdbcTemplate.update
				(updateSql, new Object[] {dto.getTitle(), dto.getContent(), dto.getSeq()});
		
		return res;
	}

	@Override
	public int delete(int seq) {
		
		int res = jdbcTemplate.update(deleteSql, new Object[] {seq});
		
		
		return res;
	}
	

	
	//innerclass
	public static final class MyMapper implements RowMapper<MyMvcDto>{

		@Override
		public MyMvcDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MyMvcDto dto = new MyMvcDto();
			dto.setSeq(rs.getInt(1));
			dto.setWriter(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegdate(rs.getDate(5));
			return dto;
		}
	}


	@Override
	public int multidelete(int[] chk) {
		int res =0;
		List<Object[]> list = new ArrayList<Object[]>();		
		
		
		for(int i : chk ) {
			list.add(new Object[]{i});
		}
		
		int cnt[] = jdbcTemplate.batchUpdate(deleteSql, list);
		
		for(int i : cnt) {
			if(i==-2) {
				res++;
			}
		}

		return res;
	}
	
}
