<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSourceFactory"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// DB 작업에 필요한 객체 변수 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String DATASOURCE_CONTEXT = "java:comp/env/jdbc/oracleDB";

	try {
		
		// 1. bs 가져오기
		InitialContext context = new InitialContext();
		DataSource bs = (DataSource)context.lookup(DATASOURCE_CONTEXT);
		

		// 2. 접속 => Connection 객체 생성
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 20; i++) {
			conn = bs.getConnection();
			conn.close();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("duration : " + (endTime-startTime));
		
// 		bs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		// 6. 사용했던 자원들을 모두 반납
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e2) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e2) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e2) {
			}

	}
%>