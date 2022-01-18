package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.DAO.CourseDAO;
import com.green.VO.CourseLectureVO;



@WebServlet("/CLS")
public class CourseListServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseDAO dao = CourseDAO.getInstance();
		List<CourseLectureVO> lists = dao.selectCourseList();
		
		request.setAttribute("CourseLectureLists",lists);		
		
		request.getRequestDispatcher("COURSE/CourseList.jsp").forward(request, response);
	}	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

