<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>redirect target</title>
</head>
<body>
	<% 
	System.out.println("userId parameter redirectTarget : " + request.getParameter("userId"));
	%>
	
	redirectTarget.jsp
</body>
</html>