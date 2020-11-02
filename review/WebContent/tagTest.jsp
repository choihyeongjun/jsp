<%@page import="common.Paging"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tagTest.jsp</title>
<style>
.pagination li {
  display: inline-block;
}
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;
}
</style>
</head>
<body>
<my:select sname="bearch" bg="cyan"/>
<my:login></my:login>
<% Paging paging=new Paging(); 
	paging.setPage(1);
	paging.setTotalRecord(144);
%>
<script>
	function goPage(p){
		location.href="     .do?p="+p;
	}
</script>
<my:paging paging="<%=paging %>" jsfunc="goPage"></my:paging>
</body>
</html>