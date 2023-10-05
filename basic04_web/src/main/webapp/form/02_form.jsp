<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_form.jsp</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <style>
 	.divtd{
 	margin: 0px 15px 0px 15px
 	}
 </style>
<script>
	function validate(){
		//이름 5~20글자 이내에서 입력해야만 서버로 전송(02_ok.jsp)
		//let uname = document.getElementById("uname").value;
		let uname = $("#uname").val();
		uname = uname.trim();
		if(uname.length<5 || uname.length>20){
			alert("이름 5~20글자 이내에서 입력해주세요");
			return false;		
		}
		
		return true;
	}
</script>
</head>
<body>

	<h3>* 성적 입력 *</h3>
	<div class="divtd">
	<form name="sungjukfrm" id="sungjukfrm" action="02_ok.jsp" method="get" onsubmit="return validate()">
		이름 : <input type="text" name="uname" id="uname" maxlength="20" placeholder="이름" required class="form-control">
		<hr>
		국어 : <input type="number" name="kor" id="kor" min="0" max="100" size="5" class="form-control">
		<hr>
		영어 : <input type="number" name="eng" id="eng" min="0" max="100" size="5" class="form-control">
		<hr>
		수학 : <input type="number" name="mat" id="mat" min="0" max="100" size="5" class="form-control">
		<hr>
		<input type="submit" value="전송"  class="btn btn-danger">
		<input type="reset" value="취소" class="btn btn-success">
	</form>
	</div>
	<!-- 
		● <form> 관련 다양한 속성들
		  사용자가 입력한 정보를 서버로 전송하기 위한 양식
		  name  	: 폼이름. 서버에서 식별하기 위한 이름
		  id		: 폼아이디. 서버에서 식별하기 위한 이름
		  action	: 사용자가 요청한 정보를 서버가 받아서 처리할 결과 페이지
		  method	: 폼 전송방식. get 또는 post 방식. 생략시 기본은 get방식
		  enctype	: 폼에서 파일을 첨부해서 서버로 전송하고자 할때 "multipart/form-data" 추가
		
		
		● [폼 전송방식]
		
		  1) method=get방식
		  	 - 생략시 기본값
		  	 - 사용자가 입력 요청한 정보가 URL 그대로 노출
		  	 - 한글 안깨짐
		  	 - ok.jsp?서버로전송되는값들
		  	 - 형식)요청페이지(또는 명령어)?변수=값&변수=값&변수&값
		  	 	  예) ok.jsp?uname=무궁화&kor=10&eng=20&mat=30
		  
		  2) method=post방식
		  	 - 사용자가 요청한 정보가 URL에 노출되지 않고 패키지화 되어서 서버로 전송
		  	 - Tomcat 9이하 버전에서는 한글 깨짐
		  	 - 예) 비번, 주민번호, 카드번호 등
		  
		  ※ 전송방식 put, delete는 <form>에서는 지원하지 않음  
	 -->
</body>
</html>