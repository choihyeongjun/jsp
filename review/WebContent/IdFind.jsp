<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script>
		function findUsername(){
			var xhttp = new XMLHttpRequest();//xhr객체 생성
			  xhttp.onreadystatechange = function() {   //콜백함수 정의
			    if (this.readyState == 4 ) {//4 : 서버로부터 응답완료
			    	if(this.status==200){//200 정상 실행
			    		var obj=JSON.parse(this.responseText)
			     document.getElementById("result").innerHTML +=obj.name;
			    	}
			    	else{
			    		document.getElementById("result").innerHTML=
			    			"error:"+this.status;
			    	}
			    	
			    }
			    else{
			    	document.getElementById("result").innerHTML ="서강중";
			    }
			  };
			  
			  var param="userid="+userid.value;
			  xhttp.open("post", "server/findName.jsp");//서버 연결 준비 true 비동기 fasle 비동기
			  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  xhttp.send(param);//요청시작
			  console.log("요청시작");
			  
		}
		
	</script>
<body>
<input id="userid"><button type="button" id="btnFind" onclick="findUsername()">검색</button>
<div id="result"></div>
</body>
</html>