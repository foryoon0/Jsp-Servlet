package com.green.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/DBTestServlet")

public class DBTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		Connection conn = null;
	 
	 try {
		 Context initContext = new InitialContext();
		 Context envContext  = (Context)initContext.lookup("java:/comp/env");
		 DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		 conn = ds.getConnection();

		 if(conn==null) {
			 System.out.println("연결 실패");
		 }else {
			 System.out.println("연결 성공");
		 }
	 
		  
		  }catch(Exception e){
			  
		  }finally{
			  try{
	
				  if(conn!=null) conn.close();
			  
			  }catch(Exception e)
			  {
				  e.printStackTrace();
			  	}
			 }
		}
		
	}
	