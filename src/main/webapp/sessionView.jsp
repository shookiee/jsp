<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
}
th, td, tr {
	border: 1px solid gray;
} 
</style>
</head>
<body>
<%-- application 속성 sessionMap 정보를 화면에 표현 --%>
<h2>sessionMap</h2>
<table>
	<tr>
		<th>session ID</th>
		<th>USER_INFO.name</th>
	</tr>
	
	<c:forEach items="${sessionMap }" var="sess">
		<tr>
			<td>${sess.key }</td>
			<td>${sess.value.getAttribute("USER_INFO").name }</td>
		</tr>
	</c:forEach>
</table>

<h2>sessionUserMap</h2>
<table>
	<tr>
		<th>사용자 아이디</th>
		<th>사용자 이름</th>
	</tr>
	
	<c:forEach items="${sessionUserMap }" var="seUser">
		<tr>
			<td>${seUser.key }</td>
			<td>${seUser.value.name }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>