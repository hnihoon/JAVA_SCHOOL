package oop0904;

public class Test03_datatype {//class 시작

	public static void main(String[] args) {//main 시작
//		자료형 Datatype
//		기본 자료형
//		참조 자료형(클래스)
		
//		1. 정수형 : 소수점이 없는 값
		byte a=1;	//1바이트
		short c=5;	//2바이트
		int b=3;	//4바이트	(기본)
		long d=7;	//8바이트
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
//		int c=9; 에러. 변수의 자료형은 중복 선언할 수 업삳.
		
//		2. 실수형
//		소수점이 있는 값
		float e=1.5f;	//4바이트. 접미사 f 반드시 추가
		double f=1.5;	//8바이트. 접미사 d 생략가능 (기본)
		
		System.out.println(e);
		System.out.println(f);
		
		System.out.println(3);		//정수형 int
		System.out.println(3.0);	//실수형 double
		System.out.println(3.);		//실수형
		///////////////////////////////////////////////
		
//		3. 문자형
//		-> 작은따옴표 ' 로 감싸고, 문자 1개만 저장할 수 있다.
		char ch='R';	//2바이트
		System.out.println(ch);
		
		ch='가';
		System.out.println(ch);
		
//		ch='SKY'; 에러
//		ch='';	  에러
		
//		4. 문자열형
//		큰따옴표 " 로 감싼다
		String str="KOREA";	//참조형 (클래스)
		System.out.println(str);
		
		str="A";
		
		str="";		//글자갯수0개
		System.out.println("#"+str+"#");
		
		str=" ";	//글자갯수1개(공백도 문자로 봄)
		System.out.println("#"+str+"#");
		
//		5. 논리형
//		맞다(true), 틀리다(false)
		boolean flag=true;
		System.out.println(flag);
		
		flag=false;
		System.out.println(flag);
		
		System.out.println(true);	//boolean형
		System.out.println("true");	//String형
		
		//연습 성적 프로그램
		String name="무궁화";
		int kor=80, eng=95, mat=100;
		
		//평균구하기
		double aver=(kor+eng+mat)/3;
		
		//출력하기
		System.out.println("이름:"+name);
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+mat);
		System.out.println("평균:"+aver);
	}//main 끝

}//class 끝
