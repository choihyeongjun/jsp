<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eventJquery</title>
</head>
<body>
<input id="txtFruit"><button id="btn">추가</button>
<div id="result">
	<span>test</span>
	<p class="pf">사과</p>
	<p class="pf">바나나</p>
	
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script>//eventListener == bind
//그룹이벤트
//$("#result").on("click",mouseHandler);  //on 특정 한놈한테만 이벤트 걸어줄때 안적어주면 bind같음, bind 전체다
$("#result").on("click",".pf",mouseHandler);
$("#btn").bind("click",function(){
	$("#result").append('<p class="pf">'+txtFruit.value+"</p>");
})
function mouseHandler(){
	//this==event.target 부모에 태그 걸엇으면 달라짐

	$(event.target).css("color","red");
}

</script>
</body>
</html>