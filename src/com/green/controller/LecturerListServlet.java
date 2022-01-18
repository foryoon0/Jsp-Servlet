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


@WebServlet("/LLS")
public class LecturerListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강사리스트 페이지로 연결
		
		LectureDAO dao = LectureDAO.getInstance();
		List<LectureVO> lists = dao.selectLecture();
		
		request.setAttribute("LectureLists",lists);		
		
		request.getRequestDispatcher("COURSE/LecturerList.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
