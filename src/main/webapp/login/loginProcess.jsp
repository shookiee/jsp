<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login Process</title>
</head>
<body>
	loginProcess.jsp<br><br>
	
	<%-- post 방식 한글 파라미터 --%>
	<% request.setCharacterEncoding("utf-8"); %>
	
	<h3>request 객체의 getParameter, getParameterValues</h3>
	request.getParameter("userId") : <%= request.getParameter("userId") %> <br>
	request.getParameterValues("userId") : 
											<% String[] userIds = request.getParameterValues("userId"); 
												for(String userId : userIds) { %>
													<%= userId %> <br>
												<%} %>
	request.getParameter("password") : <%= request.getParameter("password") %> <br><br><br>
	
	<img src = "<%= request.getContextPath() %>/img/jw_pikaboo.gif"><br><br><br>
	
	
	
	<h3>request 객체의 getParameterMap</h3>
	<% Map<String, String[]> parameterMap = request.getParameterMap();
		// parameter : userId, password
		String[] userIdsFromMap = parameterMap.get("userId");
		String[] passwords = parameterMap.get("password");
		
		for(String userId : userIdsFromMap) { %>
			userIdsFromMap : <%=userId %> <br>
		<%} %>
		
		<%for(String password : passwords) { %>
			passwordsFromMap : <%=password %> <br>
		<%} %>
		<br><br><br>
	
	<h3>request 객체의 getParameterNames()</h3>
	<% Enumeration<String> parameterNames = request.getParameterNames(); 
		while(parameterNames.hasMoreElements()) { %>
			parameterNames : <%=parameterNames.nextElement()%> <br>
		<%}%>
	
	
</body>
</html>