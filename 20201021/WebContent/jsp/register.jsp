<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp" />
<body>
<div align="center">
<div><h1>회원등록</h1></div><br />
<div>
	<form id="frm" name="frm" action="registerresult.jsp" method="post">
		<div>
			<table border="1">
				<tr>
				<th>아이디 : </th>
				<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
				<th>패스워드 : </th>
				<td><input type="password" id="pw" name="pw"></td>
				</tr>
				<tr>
				<th>이름 : </th>
				<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
				<th>취미 : </th>
				<td><input type="checkbox" id="hobby" name="hobby" value="등산">등산
				<input type="checkbox" id="hobby" name="hobby" value="운동">운동
				<input type="checkbox" id="hobby" name="hobby" value="달리기">달리기
				<input type="checkbox" id="hobby" name="hobby" value="스피닝">스피닝
				
				</td>
				</tr>
				
				<tr>
				<th>성별 : </th>
				<td><input type="radio" id="gender" name="gender" value="남자">남자
					<input type="radio" id="gender" name="gender" value="여자" checked>여자
				</td>
				</tr>
				
				
				
			</table>
		</div>
		<br/>
		<div>
			&nbsp;&nbsp;
			<input type="submit" value="등록하기"> &nbsp;&nbsp;
			<input type="reset" value="취 소"> &nbsp;&nbsp;
			<input type="button" onclick="location.href='main.jsp'"value="홈으로"> &nbsp;&nbsp;
		</div>
	</form>
</div>

</div>
</body>
<jsp:include page="tail.jsp" />
</html>