<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	pageContext.setAttribute("num", 1000000);
 --%>
 
<h2>formatNumber (number -> string / 100000 -> 100,000)</h2>
<c:set value="1357.37" var="num"/>
num : ${num } <br>

<fmt:setLocale value="ko_KR"/>
ko : <fmt:formatNumber value="${num }"/><br>
<!-- type : number, currency, or percentage: percent -->
ko : <fmt:formatNumber value="${num }" type="currency"/><br>
ko : <fmt:formatNumber value="${num }" type="percent"/><br>

<fmt:setLocale value="de_DE"/>
de : <fmt:formatNumber value="${num }"/><br>
de : <fmt:formatNumber value="${num }" type="currency"/><br>
de : <fmt:formatNumber value="${num }" type="percent"/><br><br><br>

<h2>parseNumber (string -> number / 100,000 -> 100000)</h2>
<fmt:setLocale value="ko"/>
<c:set value="1,000,000" var="numStr"/>
numStr : ${numStr }<br>
parseNumber numStr : <fmt:parseNumber value="${numStr }" pattern="0,000"/>


</body>
</html>