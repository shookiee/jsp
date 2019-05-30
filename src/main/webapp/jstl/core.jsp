<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:set - 로그인 후 테스트 할 것 !_!</h2>
	<!-- var : 속성명	/	value : 값	/ scope : page(default), request, session, application-->
	<%
// 		UserVO USER_INFO = (UserVO) session.getAttribute("USER_INFO");
// 		pageContext.setAttribute("userId", USER_INFO.getAlias());
	%>
	<c:set var="userId" value="${USER_INFO.alias }" scope="request" />
	userId : ${userId }
	<br> requestScope.userId : ${requestScope.userId }
	<br>
	<br>

	<!--  target 대상 속성	/	property : 대상 속성의 필드	/	value : 대입값 -->
<%-- 	<c:set target="${USER_INFO }" property="alias" value="bear" /> --%>
	USER_INFO.alias : ${USER_INFO.alias }
	<br>
	<br>

	<h2>c:if *** c:if는 java의 if-else if-else 중에서 [if]에만 해당 (c:choose
		태그가 일반적인 if문)</h2>

	<%-- if(test) --%>
	<c:if test="${USER_INFO.userId == 'brown'}">
		userId는 brown 입니다 :D
	</c:if>

	<c:if test="${USER_INFO.userId == 'sally'}">
		userId는 sally 입니다 :D
	</c:if>
	
	
	<h2>c:choose 자바의 if - else if - else</h2>
	<%
		request.setAttribute("code", "03");
	
	%>
	<c:choose>
		<c:when test="${code eq '01' }">
			code is '01'
		</c:when>
		<c:when test="${code eq '02' }">
			code is '02'
		</c:when>
		<c:when test="${code eq '03' }">
			code is '03'
		</c:when>
		<c:otherwise>
			code is ${code }
		</c:otherwise>
	</c:choose>


	<h2>el 연산</h2>
	<%
		PageVO pageVO = new PageVO(1, 10);
		request.setAttribute("pageVO", pageVO);
	%>
	page + 2 : ${pageVO.page + 2 }
	
	
	
	<h2>c:forEach 일반 반복문</h2>
	<%-- for(int i =1; i <= 10;) --%>
	<c:forEach begin="1" end="10" step="1" var="i">
		${i } <br>
	</c:forEach>
</body>
</html>