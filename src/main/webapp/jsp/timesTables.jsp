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

<%  
	String param1 = request.getParameter("i");
	String param2 = request.getParameter("j");
%>
<table>
<% for(int j = 1; j < Integer.parseInt(param2); j++) {
%>
<tr>
<%	for(int i = 2; i <= Integer.parseInt(param1); i++) {
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