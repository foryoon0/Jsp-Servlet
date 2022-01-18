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

import com.green.VO.CourseVO;



@WebServlet("/RCS")
public class ReadCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id값:" + id);
		
	
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO cVo = dao.selectCourseByCode(id);
		
		request.setAttribute("cVo", cVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("COURSE/ReadCourse.jsp");
		dispatcher.forward(request, response);
   	}
		
		


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
