<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Thread.sleep(2000);
	HashMap<String,String> map=new HashMap<>();
	//1.파라미터
	
	map.put("choi","최기자");
	map.put("park","박길동");
	map.put("kim","김기자");
	
	String userid=request.getParameter("userid");
	String name =map.get(userid);

%>
<%-- 이게 주석이다 --%>
{"result":true,"name":"<%=name %>"}