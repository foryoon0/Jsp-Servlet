package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.green.DAO.LectureDAO;
import com.green.VO.LectureVO;


@WebServlet("/WLS")
public class WriteLectureServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼 입력 페이지 연결		
		LectureDAO dao = LectureDAO.getInstance();
		List<LectureVO> lists = dao.selectLecture();
		
		request.setAttribute("LectureLists",lists);		
		
		request.getRequestDispatcher("COURSE/WriteLecture.jsp").forward(request,response);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		

		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String field = request.getParameter("field");
		
		
		System.out.println("교과명:" + name);
		System.out.println("담당강사:" + major);
		System.out.println("학점:" + field);

		
		LectureVO lVo = new LectureVO();
		

		lVo.setName(name);
		lVo.setMajor(major);
		lVo.setField(field);

		
		LectureDAO dao = LectureDAO.getInstance();
		
		
		
		int result = dao.insertLecture(lVo);
		
		if(result==1) {
			request.setAttribute("message", "강사 등록 완료");
			
		}else {
			request.setAttribute("message", "강사 등록 실패");
		}
		
		response.sendRedirect("LLS");
		
	}
		
		
	}

