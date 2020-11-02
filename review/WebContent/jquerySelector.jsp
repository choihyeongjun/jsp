<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.back{
		font-size:1.2em;
		background-color: blue;
		
	}
</style>

<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script>
$(function(){
	$("td").bind("click",function(){
		//$(this).prevAll().last().css("backgroundColor","cyan");
	//	$(this).parent().children().first().css("backgroundColor","cyan");
		//$(this).parent().children().eq(1).css("backgroundColor","red");
		//$(this).toggleClass("back");
		//클릭한 행의 전체 td 값 조회
		var tds=$(this).parent().children();
		var str="";
		for(var i=0;i<tds.length;i++){
			console.log($(tds[0]).text());
		}
		//tds.each
		altert(str);
		str="";
		tds.each(function(index,ele){
			str+=ele.text();
		})
		
	});
});
</script>
</head>
<body>
<div>탐색자</div>
	<table border="1">
		<tr><td>1</td><td>2</td><td>3</td></tr>
		<tr><td>4</td><td>5</td><td>6</td></tr>
		<tr><td>7</td><td>8</td><td>9</td></tr>
				
	</table>
</body>
</html>