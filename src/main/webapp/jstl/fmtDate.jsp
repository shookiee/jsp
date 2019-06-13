<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>formatDate</h2>
<c:set var="dt" value="<%=new Date() %>"/>
dt : ${dt }<br>
dt : <fmt:formatDate value="${dt }"/><br>
dt(pattern="yyyy-MM-dd") : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/><br>
dt(dateStyle="FULL") : <fmt:formatDate value="${dt }" type="date" dateStyle="FULL"/><br>
dt(dateStyle="MEDIUM") : <fmt:formatDate value="${dt }" type="date" dateStyle="MEDIUM"/><br>
dt(dateStyle="SHORT") : <fmt:formatDate value="${dt }" type="date" dateStyle="SHORT"/><br>
dt(type="time") : <fmt:formatDate value="${dt }" type="time"/><br>
dt(type="both") : <fmt:formatDate value="${dt }" type="both"/><br><br><br>

<h3>formatDate_DE</h3>
<fmt:setLocale value="de_DE"/>
dt : ${dt }<br>
dt : <fmt:formatDate value="${dt }"/><br>
<br>
<hr>

<h2>parseDate (string -> date / 2019. 6. 13 -> date)</h2>
<fmt:setLocale value="ko_KR"/>
<c:set value="2019.6.13" var="dtStr"/>
dtStr : ${dtStr } <br>
dtStr : <fmt:parseDate value="${dtStr }" pattern="yyyy.MM.dd"/><br>



</body>
</html>