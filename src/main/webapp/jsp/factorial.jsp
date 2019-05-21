<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>factorial</title>
<style>
	div {
		border : 1px solid light-blue;
		margin-left: 47%;
	}
	span {
		margin-left: 45%;
		color : pink;
		font-size : 2.0em;
	}
	
</style>
</head>
<body>
	<%!// 메서드 선언
	public String hello() {
		return "hello :D";
	}%>

	<%!public int fac(int num) {
		if(num == 0) 
			return 1;
		else return fac(num-1) * num;
		
	}%>
	
	<span>hello() : <%=hello()%></span><br><br>
	<hr>
	<br>
	<div> 
	fac(0) : <%=fac(0)%><br> 
	fac(1) : <%=fac(1)%><br> 
	fac(2) : <%=fac(2)%><br> 
	fac(3) : <%=fac(3)%><br> 
	fac(4) : <%=fac(4)%><br> 
	fac(5) : <%=fac(5)%><br> 
	fac(6) : <%=fac(6)%><br> 
	fac(7) : <%=fac(7)%><br> 
	fac(8) : <%=fac(8)%><br>
	</div>
</body>
</html>