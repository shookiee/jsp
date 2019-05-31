<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timesTables</title>
<style>
body {
	text-align: center;
}

td {
	border: 1px solid red;
	width: 250px;
	height: 77px;
	collapse: collapse;
	text-align: center;
}

#first {
	color: pink;
	font-size: 1.7em;
}

#second {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<!-- localhost/jsp/jsp/timesTables.jsp -->
	<!-- 9*9단 출력 (2~9단) -->

	<span id=first>shookie's <span id=second>JSTL</span> TABLE :D
	</span>



	
	<c:set var="dan" value="${param.dan == null ? 9 : param.dan}">
	</c:set>

	<c:set var="gob" value="${param.gob == null ? 9 : param.gob }">
	</c:set>
	
	
		
	<table>
		<c:forEach begin="2" end="${dan }" step="1" var="j">
		<tr>
			<c:forEach begin="1" end="${gob }" step="1" var="i">
			<td> ${j } * ${i } = ${j*i }
			</c:forEach>
		
		</c:forEach>
		
	
	
	</table>
</body>
</html>