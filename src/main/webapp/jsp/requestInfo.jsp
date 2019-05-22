<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request Info</title>
</head>
<body>
	<%-- 스크립틀릿 <% %> : 자바 로직을 작성하는 공간 --%>
	<%-- 표현식 <%= %> : 자바 로직을 작성하는 공간 --%>
	
	<%
		String msg = "test";
		msg += "_append";
		
		// jsp의 내장객체, 묵시적 객체
		// (implict_이미 선언되어 있는 객체이기 때문에 별도의 선언 없이 사용가능한 객체의 하나)
	
	%>
		request.getRemoteAddr() : <%= request.getRemoteAddr() %> <br>  
		request.getLocalAddr() : <%= request.getLocalAddr() %> <br>  
		request.getContentType() : <%= request.getContentType() %> <br>  
		request.getContextPath() : <%= request.getContextPath() %> <br> 
		request.getMethod(): <%= request.getMethod()%> <br>
		request.getRequestURI(): <%= request.getRequestURI()%> <br> 
		request.getProtocol(): <%= request.getProtocol()%> <br>
		
		<img src = "<%= request.getContextPath() %>/img/jw_pikaboo.gif"><br>
		
		
		<%-- 파라미터 받기 --%>
		request.getParameter("rangersName") : <%= request.getParameter("rangersName") %> <br>
		
</body>
</html>