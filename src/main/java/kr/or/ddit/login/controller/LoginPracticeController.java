package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/loginPractice")
//public class LoginPracticeController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//   
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
//		rd.forward(request, response);
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
//		
//		if(userId.equals("shookie") && password.equals("shookie1234")) {
//			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
//			rd.forward(request, response);
//		} else {
//			response.sendRedirect(request.getContextPath() + "/loginPractice");
//		}
//	}
//
//}
