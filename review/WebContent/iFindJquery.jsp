<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script>
	function findUsername(){
	//	$("#result").load("server/ajax_info.txt");
		var param={userid:userid.value};
	/*	$.get("server/findName.jsp",param,function(data){
			//var obj=JSON.parse(data);
			result.innerHTML+=data.name;//자바 스크립트 표현법 //j쿼리 표현 $("#result").html(data)
		},"json")
		$.getJSON("server/findName.jsp",param,function(data){
			result.innerHTML+=data.name;
		})*/
		
	/*	$.ajax("server/findName.jsp",{
			data: param,
			dataType:"json",
			method:"get",
			//async:false,
			success: function(data){
				result.innerHTML+=data.name;
				
			},
			error:function(xhr,status){
				result.innerHTML+=status;
			}
			
		});//동기 비동기 제어방법
		console.log("요청시작");
	}*/
	$.ajax({
		url:"server/findName.jsp",
		data: param,
		dataType:"json",
		method:"get"
		
	}).done(function(data){//성공
		result.innerHTML+=data.name;
	})
		.fail(function(xhr,status){ //실패
			result.innerHTML+=status;
		})
		.always(function(){//항상
			result.innerHTML+="무조건무조건이야~";
		});
}
</script>
</head>
<body>
<input id="userid">
<button type="button" id="btnFind" onclick="findUsername()">검색</button>
<div id="result"></div>
</body>
</html>