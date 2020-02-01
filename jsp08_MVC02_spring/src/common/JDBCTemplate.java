package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01.드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("01. 드라이버 연결 실패 ");
			e.printStackTrace();
		}
		
		
		
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String id="kh";
			String pw="kh";
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("02.계정연결 성공");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("02.계정연결 실패");
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static void close (Statement stmt) {
		if(stmt !=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close (ResultSet rs) {

		if(rs !=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close (Connection con) {
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void commit(Connection con) {
		if(con != null) { 				//nullpointexception 을 방지하기위해서 
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection con) {
		if(con !=null) {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
	
	