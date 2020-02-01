package com.muldel.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldel.dto.MDBoardDto;

public class MDBoardDao {

	public List<MDBoardDto> selectList(){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		String sql = " SELECT * FROM MDBOARD ORDER BY REGDATE DESC";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03.query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				MDBoardDto dto = new MDBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}		
		
		return list;
	}
	
	public MDBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MDBoardDto dto = null;
		
		String sql = " SELECT * FROM MDBOARD WHERE SEQ = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				dto = new MDBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		
		return dto;
	}
	
	public int multiDelete(String[] seq) { //들어올 때는 게시글 번호 자체로 들어옴 
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " DELETE FROM MDBOARD WHERE SEQ = ? ";
		// 결과값 받을 배열
		int[] cnt = null;
		
		
		
		try {
			pstm = con.prepareStatement(sql);
			
			for(int i = 0 ; i < seq.length; i++) {
				pstm.setString(1, seq[i]);
				
				// 메모리에 적재 후, 
				// executeBatch() 메소드가 호출 될 때
				// 한꺼번에 실행!!
				pstm.addBatch();
				System.out.println("삭제할 번호 : "+seq[i]);
			}
			System.out.println("03.query 준비");
		
			// int[]로 리턴
			//cnt에는 row삭제의 성공 실패 여부가 배열로 담김 (성공:-2 실패-3)
			cnt = pstm.executeBatch();
			System.out.println("04.query 실행 및 리턴");
			
			
			for(int i = 0 ; i < cnt.length ; i++) {
				if(cnt[i] == -2) {
					res++;
				}
			}
			
			if(res == seq.length) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println ("05.db 종료");
		}
		
		return res;
	}
	
	public int insert(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO MDBOARD "
				+ " VALUES(MDBOARDSEQ.NEXTVAL,?,?,?,SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03.query 준비 : " + sql);
		
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			
			if(res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		
		return res;
	}
	public int update(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE MDBOARD "
				+ " SET TITLE = ?, CONTENT = ? "
				+ " WHERE SEQ = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03.query 준비 : " + sql);
		
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			
			if(res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		
		return res;
	}
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " DELETE FROM MDBOARD "
				+ " WHERE SEQ = ? ";
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비 : " + sql);
		
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			
			if(res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		
		return res;
	}
}











