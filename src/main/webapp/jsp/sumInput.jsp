<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body {
		text-align: center;
	}
	label{
		width:50px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Calculation Test :D</h3>
	<form action="${cp }/sumCalculation" method="post">
		<label>start</label> <input type="text" name="start">
		<label>end</label> <input type="text" name="end">
		<button>Calc</button>
	</form>
</body>
</html>