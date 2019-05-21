<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timesTables</title>
<style>
	body{
		text-align : center;
	}

	
	td { 
		border : 1px solid red; 	
		width : 250px;	
		height : 77px;		 
		collapse : collapse;	
		text-align : center; 
	}
	
	#first{
		color : pink;
		font-size : 1.7em;
	}

	#second{
		color : red;
		font-weight : bold;
	}

</style>
</head>
<body>
<!-- localhost/jsp/jsp/timesTables.jsp -->
<!-- 9*9단 출력 (2~9단) -->

<span id = first>shookie's <span id = second>JSP</span> TABLE :D</span>
<table>
<% for(int i = 1; i < 10; i++) {
%>
<tr>
<%	for(int j = 2; j < 10; j++) {
%>
<td>
	<%= j%> * <%= i %> = <%= j*i %>
	
<%
	}
%>
<%
}
%>
</table>
</body>
</html>