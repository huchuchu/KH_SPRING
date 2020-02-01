package com.mvc.my.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.my.model.dto.MyMvcDto;

import common.JDBCTemplate;


@Repository
public class MyMvcDaoImple extends JDBCTemplate implements MyMvcDao{

	@Override
	public List<MyMvcDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MyMvcDto> list = new ArrayList<MyMvcDto>();
		
		try {
			pstm = con.prepareStatement(selectListSql);
			System.out.println("03 query 준비");
			
			rs = pstm.executeQuery();
			System.out.println("04 query 실행 및 리턴 ");
			
			while(rs.next()) {
				MyMvcDto dto = new MyMvcDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			System.out.println("0304 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return list;
	}

	@Override
	public MyMvcDto selectone(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMvcDto dto = null;
		
		try {
			pstm = con.prepareStatement(selectOneSql);
			pstm.setInt(1, seq);
			System.out.println("03 query준비"+ selectOneSql);
			
			rs = pstm.executeQuery();
			System.out.println("04 query 실행및 리턴");
			
			while(rs.next()) {	//rs.next(); 만 써도 됨!!
				dto = new MyMvcDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			System.out.println("0304 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05 db종료");
		}
				
		return dto;
	}

	@Override
	public int insert(MyMvcDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(insertSql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getWriter());
			pstm.setString(3, dto.getContent());
			System.out.println("03 query 준비");
			
			res = pstm.executeUpdate();
			System.out.println("04 query 실행 리턴");
			
		} catch (SQLException e) {
			System.out.println("0304 오류");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	@Override
	public int update(MyMvcDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(updateSql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03 query 준비");
			
			res = pstm.executeUpdate();
			System.out.println("04 query 실행 및 리턴");
			
			
		} catch (SQLException e) {
			System.out.println("0304 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			
		}	
		return res;
	}

	@Override
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(deleteSql);
			pstm.setInt(1, seq);
			System.out.println("03 query 준비");
			res = pstm.executeUpdate();
			System.out.println("04 query 실행 및 리턴");
						
		} catch (SQLException e) {
			System.out.println("0304 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}

}
