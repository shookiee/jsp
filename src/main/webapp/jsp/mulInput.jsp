<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body {
		text-align: center;
	}
	label{
		width:50px;
	}
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/jsp/mulCalculation" method="post">
		<label>param1 : </label><input type="text" name="param1"> <br>
		<label>param2 : </label><input type="text" name="param2"> <br>
		<button>calc</button>	
	</form>
</body>
</html>