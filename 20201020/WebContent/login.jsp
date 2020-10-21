<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%!		//자바변수 선언 및 메소드 선언
	String id;
	String pw;
	String msg;
	public void method(){};
	
%>
<%               //이부분에 자바코드를 쓴다
	id=request.getParameter("id");
	pw=request.getParameter("pw");
	
	if(id.equals("hong"))
		msg="홍길동 님 환영합니다.";
	else
		msg="등록된 회원이 아닙니다.";

%>

<body>
<div align="center">
	<h1><%= msg %></h1>
	
</div>
</body>
</html>