<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		// 4개의 parameter를 받아  4개의 영역에 속성으로 넣어줌
		// 속성 저장 : scope객체.setAttribute("속성명", 속성(객체));
		// scope 객체 : pageContext, request, session, application
		
		pageContext.setAttribute("pageAttribute", request.getParameter("pageParam"));
		request.setAttribute("requestAttribute", request.getParameter("requestParam"));
		session.setAttribute("sessionAttribute", request.getParameter("sessionParam"));
		application.setAttribute("applicationAttribute", request.getParameter("applicationParam"));
		
		
		request.getRequestDispatcher("/scope/scopePrint.jsp").forward(request, response);
		
	%>
