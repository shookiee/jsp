<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="https://search.naver.com/search.naver">
	<c:param name="query" value="어피치" var="test"/>
</c:import>
${test}