<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello, world !_!</title>
<style>
	body { 
		text-align : center;
	}
	
	#first {
		color : red;
		font-size : 1.7em;
		font-weight: bold;
	}
	
	#second {
		color : light-blue;
	}
	
	#third {
		font-size : 1.5em;
		color : pink;
	}
	
	
</style>
</head>
<body>
	<span id = first>hello, world :D</span>
	<br>
	<%-- jsp 주석 --%>

	<!--  => 스크립플릿 : 자바코드를 작성하는 영역 -->
	
	
	<% Date date = new Date(); %>
	
	<!--  => 표현식 : 객체를 출력 -->
	<span id = second>현재 시간은 <span id = third><%= date %></span> 입니당 :-)</span>
</body>
</html>