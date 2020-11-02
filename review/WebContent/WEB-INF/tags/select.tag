<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="sname" required="true"%>
<%@ attribute name="bg" required="true"%>
<c:if test="${empty bg}">
	<c:set value="yellow" var="bg">
	</c:set>
</c:if>
<select name="${sname}" style="background-color: ${bg}">
	<option>제목
	<option>내용
</select>
