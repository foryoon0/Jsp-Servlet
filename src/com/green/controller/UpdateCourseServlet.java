package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.DAO.CourseDAO;
import com.green.VO.CourseVO;



@WebServlet("/UCS")
public class UpdateCourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 교과목수정 페이지로 연결
		
		String id = request.getParameter("id");
		System.out.println("수정할 페이지 id값: " + id);
	
		
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO cVo = dao.selectCourseByCode2(id);
		
		request.setAttribute("cVo", cVo);
		
		request.getRequestDispatcher("COURSE/UpdateCourse.jsp").forward(request, response);
	
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int credit = Integer.parseInt(request.getParameter("credit"));
		int lecturer = Integer.parseInt(request.getParameter("lecturer"));
		int week = Integer.parseInt(request.getParameter("week"));
		int start_hour = Integer.parseInt(request.getParameter("start_hour"));
		int end_hour = Integer.parseInt(request.getParameter("end_hour"));
		

		
		CourseVO cVo = new CourseVO();
		cVo.setId(id);
		cVo.setName(name);
		cVo.setCredit(credit);
		cVo.setLecturer(lecturer);
		cVo.setWeek(week);
		cVo.setStart_hour(start_hour);
		cVo.setEnd_hour(end_hour);
		
		
		CourseDAO dao = CourseDAO.getInstance();
		dao.updateCourse(cVo);
		
		response.sendRedirect("CLS");
		
		
	}

}
