<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	//String id=request.getParameter("id");
	//String name=request.getParameter("name");
	//String[] hobby=request.getParameterValues("hobby");
	String gender=request.getParameter("gender");
	String url=request.getRequestURL().toString();
	String uri=request.getRequestURI();
	String contextPath=request.getContextPath();
	
	
%>
<body>
<jsp:include page="header.jsp" />
<div align="center">
	<h1>회원등록 결과</h1>
		<div>
			<table border="1">
			<tr>
				<th width="100">아 이 디</th>
				<c:if test="${param.id=='hong'}">
					<td width="200">홍길동 </td>
				</c:if>
					<c:if test="${param.id!='hong'}">
					<td width="200">${param.id}</td>
				</c:if>
				
				<td width="200">${param.id }</td>
			</tr>
			<tr>
				<th width="100">이름</th>
				<td width="200">${param.name} </td>
			</tr>
			<tr>
				<th width="100">취 미</th>
				<td width="200">
				${param.hobby} 
				</td>
				
			</tr>
			<tr>
				<th width="100">성 별</th>
				<td width="200"><%=gender %></td>
			</tr>
			</table>
		</div>
		<div>
			<br/>
			<button onclick="location.href='main.jsp'">홈으로</button>
		</div>
		<div>
		<br/>
		요청 URL: <%=url %><br/>
		요청 URI: <%=uri %><br/>
		
		컨택스트패스: <%=contextPath %><br/>
		
		
		</div>
</div>
<jsp:include page="tail.jsp" />
</body>
</html>