/**
 * myscript.js
 */

 function bbsCheck(){ //게시판 유효성 검사
    //1)작성자 2글자 이상 입력
    let wname=document.getElementById("wname").value; //작성자 가져오기
    wname=wname.trim();
    if(wname.length<2){
        alert("작성자 이름은 2글자 이상 입력해 주세요");
        document.getElementById("wname").focus(); //작성자칸에 커서 생성
        return false; //전송하지 않음
    }//if end

    //2)제목 2글자 이상 입력
	let subject=document.getElementById("subject").value;
	subject=subject.trim();                               
	if(subject.length<2){
	    alert("제목 2글자 이상 입력해 주세요");
    	document.getElementById("subject").focus();     
    	return false;                                 
	}//if end 

    //3)내용 2글자 이상 입력
	let content=document.getElementById("content").value;
	content=content.trim();                               
	if(content.length<2){
	    alert("내용 2글자 이상 입력해 주세요");
    	document.getElementById("content").focus();    
    	return false;                                 
	}//if end    

    //4)비밀번호는 4글자이상이면서, 숫자형 기호만 입력
    let passwd=document.getElementById("passwd").value; 
    passwd=passwd.trim();
    if(passwd.length<4 || isNaN(passwd)){
        alert("비밀번호 4글자 이상 숫자로 입력해 주세요");
        document.getElementById("passwd").focus();
        return false;
    }//if end

	return true; //onsubmit이벤트에서 서버로 전송
    
 }//bbsCheck() end
 
 function pwCheck(){
	 let passwd=document.getElementById("passwd").value;
	 passwd=passwd.trim();
	 if(passwd.length<4 || isNaN(passwd)){
		 alert("비밀번호 4글자 이상 숫자로 입력해 주세요");
		 document.getElementById("passwd").focus();
		 return false;
	 }
	 
	 let message="진행된 내용은 복구되지 않습니다.\n계속 진행할까요?";
	 if(confirm(message)){ //confirm : 확인 취소가 나오는 함수 (확인 true, 취소 false)
		 return true;
	 } else{
		 return false;
	 }
 }
 
 function searchCheck(){ //검색어를 입력해야만 서버로 전송
	let word=document.getElementById("word").value;
	word=word.trim();
	if(word.length==0){
		alert("검색어를 입력해 주세요");
		return false;
	}
	
	return true; 
 }
 
 function loginCheck(){
    //1)아이디 5~10글자 이내인지 검사
    let id=document.getElementById("id").value;
    id=id.trim();
    if(!(id.length>=5 && id.length<=10)){
        alert("아이디 5~10글자이내 입력해 주세요");
        document.getElementById("id").focus();
        return false;
    }

    //2)비밀번호 5~10글자 이내인지 검사
    let passwd=document.getElementById("passwd").value;
    passwd=passwd.trim();
    if(!(passwd.length>=5 && passwd.length<=10)){
        alert("비밀번호 5~10글자이내 입력해 주세요");
        document.getElementById("passwd").focus();
        return false;
    }
  }
 
 function idCheck(){ //아이디 중복확인
	 
	 //모달창
	 //->부모창과 자식창이 한몸으로 구성되어 있음
	 //->참조 : https://www.w3schools.com/bootstrap/bootstrap_modal.asp
	 
	 //세창 만들기
	 //->부모창과 자식창이 별개로 구성되어 있음
	 //->모바일에 기반을 둔 frontend(SPA)단에서는 사용하지 말것!!
	 //->참조 : https://www.w3schools.com/jsref/met_win_open.asp
	 //window.open("파일명", "새창이름", "다양한옵션들")
	 window.open("idCheckForm.jsp", "idwin", "width=400, height=350");
	 
 }
 
 function emailCheck(){ //이메일 중복확인
	 window.open("emailCheckForm.jsp", "emailwin", "width=400, height=350");
 }
 
 function memberCheck(){ //회원가입 유효성 검사
	//1)아이디 5~10글자 인지?
	let id = document.getElementById("id").value;
	if(id.length<5 || id.length>10){
		alert("아이디는 5~10글자로 작성해주세요");
		document.getElementById("id").focus();
		return false;
	}
    //2)비밀번호 5~10글자 인지?
	let passwd = document.getElementById("passwd").value;
	if(passwd.length<5 || passwd.length>10){
		alert("비밀번호는 5~10글자로 작성해주세요");
		document.getElementById("passwd").focus();
		return false;
	}
    //3)비밀번호와 비밀번호확인이 서로 일치하는지?
	let repasswd = document.getElementById("repasswd").value;
	if(repasswd != passwd){
		alert("비밀번호가 일치하지 않습니다.");
		document.getElementById("repasswd").focus();
		return false;
	}
    //4)이름 두글자 이상 인지?
    let mname = document.getElementById("mname").value;
	if(mname.length < 2){
		alert("이름을 두글자 이상 작성해주세요.");
		document.getElementById("mname").focus();
		return false;
	}
    //5)이메일 5글자 인지?
    let email = document.getElementById("email").value;
	if(email.length<5){
		alert("이메일 주소는 5글자 이상 작성해주세요");
		document.getElementById("email").focus();
		return false;
	}
    //6)직업을 선택했는지?
    let job = document.getElementById("job").value;
	if(job == 0){
		alert("직업을 선택해주세요.");
		document.getElementById("job").focus();
		return false;
	}
	return true;
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 