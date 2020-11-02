<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jselector2.jsp</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script>
$(function(){
//모든 li 태그중에서 첫번째
	//$("li:first").css("color","red");
	//첫번째 자식들
	//$("li:first-child").css("color","red");
	$("li:nth-child(2)").css("color","red");
});
</script>
</head>
<body>
<h3>필터링</h3>
<ul>
	<li>자바</li>
	<li>JSP
</ul>
<ul>
	<li>스프링</li>
	<li>먼데슈벌
</ul>
</body>
</html>