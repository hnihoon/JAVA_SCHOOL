package oop0904;

public class Test02_print {//class 끝

	public static void main(String[] args) { //main 시작

		//단축키 : syso 입력 후 Ctrl + Space
		//System.out.println(); 콘솔창 출력 명령어
		
		//123을 콘솔창에 출력해주세요 라는 뜻
		System.out.println(123);
		System.out.println("SEOUL");
		
		//print는 한주롤 출력됨 ln은 줄바꿈을 의미함 
		System.out.print("국어");
		System.out.print("영어");
		System.out.print("수학");
		
		//출력하고 줄바꿈(엔터)
		System.out.println(123);
		System.out.println(456);
		System.out.println(789);
		
		System.out.println(); //콘솔창에서 줄바꿈
		
		//문자열 데이터 구분기호 ""
		System.out.println("JAVA");
		System.out.println("PYTHON");
		System.out.println(123);		//숫자형
		System.out.println("456");		//문자열형
		
		// " ' \ 등을 단순 기호로 인식하고자 할때
		System.out.println("\"");
		System.out.println("\'");
		System.out.println("\\");
		
		// +연산자
		System.out.println(123+456);		//579
		System.out.println("123"+"456");	//"123456"
		System.out.println(123+"456");		//"123456"
		System.out.println("123"+456);		//"123456"
		System.out.println("123+456");		//"123+456"
		
	}//main 끝
}//class 끝
