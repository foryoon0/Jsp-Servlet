package com.green.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.green.VO.LectureVO;




public class LectureDAO {
//  싱글턴 패턴
	private LectureDAO() {}
	private static LectureDAO dao = new LectureDAO();
	public static LectureDAO getInstance() {
		return dao;
	}
	

	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	

	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//-------------------------------------------------------
	// 강사님 전체 데이터를 읽어오는 메서드
	public List<LectureVO> selectAllProduct(){
		List<LectureVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM lecturer_tbl ORDER BY code DESC";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				LectureVO lVo = new LectureVO();
				lVo.setIdx(rs.getInt("idx"));
				lVo.setName(rs.getString("name"));
				lVo.setMajor(rs.getString("major"));
				lVo.setField(rs.getString("field"));

		
						
				list.add(lVo);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		return list;
	}
	
	//-------------------------------------------------------
		// 강사 불러오는 메서드
		
		public List<LectureVO> selectLecture(){
			List<LectureVO> list = new ArrayList<>();
			
			String sql = "SELECT * FROM lecturer_tbl ORDER BY idx ASC";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					LectureVO lVo = new LectureVO();
					lVo.setIdx(rs.getInt("idx"));
					lVo.setName(rs.getString("name"));
					lVo.setMajor(rs.getString("major"));
					lVo.setField(rs.getString("Field"));
			
					
					
					list.add(lVo);	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn,psmt,rs);
			}
			return list;
		}
		
	//---------------------------------------------------------
	// 강사 삽입을 위한 메소드
		
		public int insertLecture(LectureVO lVo) {
			int result =-1;
			
			String sql = "INSERT INTO lecturer_tbl VALUES (lecture_seq.nextval , ? , ? , ? )";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				

				psmt.setString(1, lVo.getName());
				psmt.setString(2, lVo.getMajor());
				psmt.setString(3, lVo.getField());

				
				
				result = psmt.executeUpdate();
				
			}catch(Exception e) {
			}finally {
				try {
					if(psmt!=null)psmt.close();
					if(conn!=null)conn.close();
				}catch(Exception e) {}
			}
			
			return result;
		}
		
	//-------------------------------------------------------------------------------------
	// 교과목 업데이트를 위한 메서드
		public void updateLecture(LectureVO lVo) {
			
			String sql = "UPDATE lecturer_tbl SET name = ? , major = ?, field = ? WHERE idx = ?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			try {
				System.out.println("시작");
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, lVo.getName());
				psmt.setString(2, lVo.getMajor());
				psmt.setString(3, lVo.getField());
				psmt.setInt(4, lVo.getIdx());				
				psmt.executeUpdate();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(psmt!=null)psmt.close();
					if(conn!=null)conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	

}
