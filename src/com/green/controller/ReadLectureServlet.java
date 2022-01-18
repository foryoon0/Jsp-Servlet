package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.DAO.CourseDAO;
import com.green.VO.ReadCourseVO;

@WebServlet("/RLS")
public class ReadLectureServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
		
		CourseDAO dao = CourseDAO.getInstance();
		List<ReadCourseVO> lists = dao.selectLectureList(idx);
		request.setAttribute("ReadCourse",lists);		
		
		CourseDAO dao2 = CourseDAO.getInstance();
		ReadCourseVO rVo = dao2.selectReadCourse(idx);
		
		request.setAttribute("rVo", rVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("COURSE/ReadLecture.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
