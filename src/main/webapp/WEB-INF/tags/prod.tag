<%@tag import="kr.or.ddit.prod.model.ProdVO"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@tag import="kr.or.ddit.prod.service.IProdService"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="prod_lgu" type="java.lang.String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% 
	IProdService prodService;
	prodService = new ProdServiceImpl();
	String prod_lgu = (String)jspContext.getAttribute("prod_lgu");
	List<ProdVO> prodList = prodService.prodList(prod_lgu);
	
	request.setAttribute("prodList", prodList);
%>
<select>
<c:forEach items="${prodList }" var="prod">
	<option value="${prod.prod_id }">${prod.prod_name}&nbsp;</option>
</c:forEach>
</select>