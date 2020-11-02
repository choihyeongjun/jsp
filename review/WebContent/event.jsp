<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>event.jsp</title>
</head>
<body>
<button type="button" id="btn1">이벤트처리</button><p id="info">상세소개</p>
<button type="button" id="btn2">이벤트처리</button><p id="info2">상세소개</p>
<button type="button" id="btn3">이벤트처리</button><p id="info3">상세소개3</p>
<script>
	//이벤트 핸들러
	//btn1.onclick=function(){info.style.display="none";};
	//btn1.addEventListener("click",btnHandler);
	//btn2.addEventListener("click",btnHandler);
	document.body.addEventListener("click",btnHandler);
	//function btnHandler(){info.style.display="none";};
	function btnHandler(){
		event.target.nextSibling.style.display="none";
		//event.stopPropagation();//전파중지
		/*if(event.target.id=="btn1"){
			info.style.display="none";
			
		}else
			{
			info2.style.display="none";
			}*/
	
	}
	
</script>
</body>
</html>