<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- scope 객체에 저장한 속성명 -->
	userId : ${userId}<br>
	
	<!-- 특정 scope 객체에 있는 속성을 명시적으로 가져올 경우 -->
	requestScope.userId : ${requestScope.userId }<br>
	sessuibScope.userId : ${sessionScope.userId }<br>
	
	<%//session.removeAttribute("userId"); %>
	
	<h3>el로 파라미터 접근 - param.파라미터명</h3>
	param.userId : ${param.userId} <br>
	
	
	
	
</body>
</html>