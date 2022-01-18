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

import com.green.VO.CourseLectureVO;
import com.green.VO.CourseVO;
import com.green.VO.LectureVO;
import com.green.VO.ReadCourseVO;



public class CourseDAO {
	//  싱글턴 패턴
	private CourseDAO() {}
	private static CourseDAO dao = new CourseDAO();
	public static CourseDAO getInstance() {
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
	// 전체 데이터를 읽어오는 메서드
	public List<CourseVO> selectAllCoruse(){
		List<CourseVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM course_tbl ORDER BY code DESC";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CourseVO cVo = new CourseVO();
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getInt("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
		
				
				
				list.add(cVo);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		return list;
	}
	
	//-------------------------------------------------------
	// 조인 된 데이터를 메인에 넣기 위해 데이터를 읽어오는 메서드
	
	public List<CourseLectureVO> selectCourseList(){
		List<CourseLectureVO> list = new ArrayList<>();
		
		String sql = "SELECT C.id, C.name, C.credit, L.name as lecname, C.week FROM course_tbl C, lecturer_tbl L WHERE C.lecturer = L.idx";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CourseLectureVO clVo = new CourseLectureVO();
				clVo.setId(rs.getString("id"));
				clVo.setName(rs.getString("name"));
				clVo.setCredit(rs.getInt("credit"));
				clVo.setLecname(rs.getString("lecname"));
				clVo.setWeek(rs.getInt("week"));
				
				list.add(clVo);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		return list;
	}
	//------------------------------------------------------------------
	// 교과목 정보 상세보기를 위해 데이터를 읽어오는 메서드
	public CourseVO selectCourseByCode(int id) {
		CourseVO cVo = null;
		String sql = "SELECT * FROM course_tbl WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				cVo = new CourseVO();
				
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));
				cVo.setLecturer(rs.getInt("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
				

				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		return cVo;
	}
	
	
	
	
	
	//---------------------------------------------------------
	// 교과목 삽입을 위한 메소드
	
	public int insertCourse(CourseVO cVo) {
		int result =-1;
		
		String sql = "INSERT INTO course_tbl VALUES ( ? , ? , ? , ? , ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, cVo.getLecturer());
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			
			
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
	
	//-------------------------------------------------------
	// 조인 된 데이터를 ReadLecture에 넣기 위해 데이터를 읽어오는 메서드
		
		public ReadCourseVO selectReadCourse(int idx){
			ReadCourseVO rVo = null;
			String sql = "SELECT L.idx, L.name,  L.major, L.field, C.name AS cname FROM course_tbl C, lecturer_tbl L WHERE C.lecturer = L.idx and idx=?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, idx);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					rVo = new ReadCourseVO();
					
					rVo.setIdx(rs.getInt("idx"));
					rVo.setName(rs.getString("name"));
					rVo.setMajor(rs.getString("major"));
					rVo.setField(rs.getString("field"));
					rVo.setCname(rs.getString("cname"));
				
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn,psmt,rs);
			}
			return rVo;
		}
		
	//-------------------------------------------------------
	// 조인 된 데이터를 리스트로 만들어오는 메소드
		
		public List<ReadCourseVO> selectLectureList(int idx){
			List<ReadCourseVO> list = new ArrayList<>();
			
			String sql = "SELECT L.idx, L.name,  L.major, L.field, C.name AS cname FROM course_tbl C, lecturer_tbl L WHERE C.lecturer = L.idx and idx=?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, idx);
				
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					ReadCourseVO rcVo = new ReadCourseVO();
			
					rcVo.setIdx(rs.getInt("idx"));
					rcVo.setName(rs.getString("name"));
					rcVo.setMajor(rs.getString("major"));
					rcVo.setField(rs.getString("field"));
					rcVo.setCname(rs.getString("cname"));
				
					
					list.add(rcVo);	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn,psmt,rs);
			}
			return list;
		}
	
		//------------------------------------------------------------------
		// 요일을 가져오는 메서드
		public CourseVO selectWeek(int id) {
			CourseVO cVo = null;
			String sql = "SELECT WEEK FROM COURSE_TBL WHERE ID=?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, id);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					cVo = new CourseVO();
					
					cVo.setWeek(rs.getInt("week"));
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn,psmt,rs);
			}
			return cVo;
		}
		
		
		//------------------------------------------------------------------------------------
		//교과목 삭제를 위한메서드
		
		public void deleteCourseByCode(int id) {
			
			String sql = "DELETE FROM course_tbl WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			try {

				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, id);
				
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
		
		
		//------------------------------------------------------------------
		// 교과목 정보 상세보기를 위해 데이터를 읽어오는 메서드
		public CourseVO selectCourseByCode2(String id) {
			CourseVO cVo = null;
			String sql = "SELECT * FROM course_tbl WHERE id=?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					cVo = new CourseVO();
					
					cVo.setId(rs.getString("id"));
					cVo.setName(rs.getString("name"));
					cVo.setLecturer(rs.getInt("lecturer"));
					cVo.setWeek(rs.getInt("week"));
					cVo.setCredit(rs.getInt("credit"));
					cVo.setStart_hour(rs.getInt("start_hour"));
					cVo.setEnd_hour(rs.getInt("end_hour"));
					

					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn,psmt,rs);
			}
			return cVo;
		}
		
		
		//-------------------------------------------------------
		//교과목 업데이트를 위한 메서드
		
			public void updateCourse(CourseVO cVo) {
				
				String sql = "UPDATE course_tbl SET name = ?, credit = ?, lecturer = ?, week = ?, start_hour = ?, end_hour = ? WHERE id = ?";
				
				Connection conn = null;
				PreparedStatement psmt = null;
				
				try {
					System.out.println("시작");
					conn = getConnection();
					psmt = conn.prepareStatement(sql);

					psmt.setString(1, cVo.getName());
					psmt.setInt(2, cVo.getCredit());
					psmt.setInt(3, cVo.getLecturer());	
					psmt.setInt(4, cVo.getWeek());	
					psmt.setInt(5, cVo.getStart_hour());	
					psmt.setInt(6, cVo.getEnd_hour());	
					psmt.setString(7, cVo.getId());	
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