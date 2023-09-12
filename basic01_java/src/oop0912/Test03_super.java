package oop0912;

public class Test03_super {

	public static void main(String[] args) {
		//super 부모, 조상
		//superclasses 부모클래스
		//subclasses   자식클래스
		
		//super		: 자식클래스에서 부모클래스의 멤버에 접근할 떄
		//super()	: 자식클래스의 생성자 함수가 부모 클래스의 생성자 함수를 호출할때
		
		//this		: 멤버변수(field)와 일반 지역변수를 구분하기 위해
		//this()	: 자신의 생성자함수가 자신의 생성자함수를 호출할 때
		
		//School 클래스 생성 후 실습
		
		MiddleSchool ms = new MiddleSchool();
		ms.disp();
		
		HighSchool hs = new HighSchool();
		hs.disp();
	}

}
