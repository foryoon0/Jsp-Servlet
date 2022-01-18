package com.green.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.DAO.CourseDAO;
import com.green.DAO.LectureDAO;
import com.green.VO.CourseVO;
import com.green.VO.LectureVO;




@WebServlet("/WCS")
public class WriteCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼 입력 페이지 연결		
		request.setCharacterEncoding("UTF-8");
		LectureDAO dao = LectureDAO.getInstance();
		List<LectureVO> lists = dao.selectLecture();
		
		request.setAttribute("LectureLists",lists);		
		
		request.getRequestDispatcher("COURSE/WriteCourse.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터베이스에 저장
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int lecture = Integer.parseInt(request.getParameter("lecture"));
		int credit = Integer.parseInt(request.getParameter("credit"));
		int week = Integer.parseInt(request.getParameter("week"));
		int start_hour = Integer.parseInt(request.getParameter("start_hour"));
		int end_hour = Integer.parseInt(request.getParameter("end_hour"));
		
		System.out.println("코드:" + id);
		System.out.println("교과명:" + name);
		System.out.println("담당강사:" + lecture);
		System.out.println("학점:" + credit);
		System.out.println("요일:" + week);
		System.out.println("시작시간:" + start_hour);
		System.out.println("종료시간:" + end_hour);
		
		
		CourseVO cVo = new CourseVO();
		
		cVo.setId(id);
		cVo.setName(name);
		cVo.setCredit(credit);
		cVo.setLecturer(lecture);
		cVo.setWeek(week);
		cVo.setStart_hour(start_hour);
		cVo.setEnd_hour(end_hour);
		
		
		CourseDAO dao = CourseDAO.getInstance();
		
		
		
		int result = dao.insertCourse(cVo);
		
		if(result==1) {
			request.setAttribute("message", "교과목 등록 완료");
			
		}else {
			request.setAttribute("message", "교과목 등록 실패");
		}
		
		response.sendRedirect("CLS");
		
	}
		
		
	}


