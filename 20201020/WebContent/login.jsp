<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%!		//�ڹٺ��� ���� �� �޼ҵ� ����
	String id;
	String pw;
	String msg;
	public void method(){};
	
%>
<%               //�̺κп� �ڹ��ڵ带 ����
	id=request.getParameter("id");
	pw=request.getParameter("pw");
	
	if(id.equals("hong"))
		msg="ȫ�浿 �� ȯ���մϴ�.";
	else
		msg="��ϵ� ȸ���� �ƴմϴ�.";

%>

<body>
<div align="center">
	<h1><%= msg %></h1>
	
</div>
</body>
</html>