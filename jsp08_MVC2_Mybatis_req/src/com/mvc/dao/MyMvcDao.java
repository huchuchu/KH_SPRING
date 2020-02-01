package com.mvc.dao;

import java.util.List;

import com.mvc.dto.MyMvcDto;

public interface MyMvcDao {
	
	//원래 인터페이스 안의 상수는 항상 대문자!!
	String selectListSql =" SELECT * FROM MYMVCBOARD ORDER BY SEQ DESC ";
	String selectOneSql = "	SELECT * FROM MYMVCBOARD WHERE SEQ=? ";
	String insertSql=" INSERT INTO MYMVCBOARD(SEQ, WRITER, TITLE, CONTENT, REGDATE) VALUES(MYMVCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE )";
	String updateSql=" UPDATE MYMVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
	String deleteSql=" DELETE FROM MYMVCBOARD WHERE SEQ=? ";
	
	public List<MyMvcDto> selectList();
	
	public MyMvcDto selectone(int seq);
	
	public int insert(MyMvcDto dto);
	
	public int update(MyMvcDto dto);
	
	public int delete(int seq);
	
	

}
