<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.String" required="false"%>

<font color="${color }">
	<c:forEach begin="1" end="${size == null ? 5 : size}">=</c:forEach>
</font>