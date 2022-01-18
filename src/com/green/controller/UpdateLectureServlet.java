package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.DAO.LectureDAO;
import com.green.VO.LectureVO;



@WebServlet("/ULS")
public class UpdateLectureServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String field = request.getParameter("field");
		
		System.out.println("얻값"+ idx);
		System.out.println("얻값"+ name);
		System.out.println("얻값"+ major);
		System.out.println("얻값"+ field);
		
		LectureVO lVo = new LectureVO();
		lVo.setIdx(idx);
		lVo.setName(name);
		lVo.setMajor(major);
		lVo.setField(field);
		
		LectureDAO dao = LectureDAO.getInstance();
		
		dao.updateLecture(lVo);
		
		response.sendRedirect("LLS");
	}
		
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("UTF-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String field = request.getParameter("field");
		
		
		System.out.println("idx : " + idx);
		System.out.println("name : " + name);
		System.out.println("major : " + major);
		System.out.println("field : " + field);

		
		LectureVO lVo = new LectureVO();
		lVo.setIdx(idx);
		lVo.setName(name);
		lVo.setMajor(major);
		lVo.setField(field);

		
		LectureDAO dao = LectureDAO.getInstance();
		dao.updateLecture(lVo);
		
		response.sendRedirect("LLS");
		
		
		
	}

}
