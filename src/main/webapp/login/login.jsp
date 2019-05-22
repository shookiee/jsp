<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>log-in page</title>
<style>
	label {
		display : inline-block;
		width : 80px;
		height : 30px;
	}
</style>
</head>
<body>

	<!-- 어디로 요청을 보낼지 -> form태그 action 속성
		 어떻게 보낼지 (http method) -> form태그 method 속성(get-default/post)-->
	<%-- /login/login.jsp -> /login/loginProcess.jsp --%>
	<form action = "<%= request.getContextPath() %>/login/loginProcess.jsp" method = "post"> <%-- form method의 default = get 방식 --%>
		<label>userId :</label> <input type = "text" name = "userId" value = "pikaboo"/> <br>
		<label>userId :</label> <input type = "text" name = "userId" value = "까꿍"/> <br>
		<label>password :</label> <input type = "password" name = "password" value = "pass1234"/> <br>
		<input type = "submit" value = "로그인" />
	</form>	


</body>
</html>