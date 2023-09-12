package oop0912;

public class School {
	String name="학교";
	
	public School() {
		System.out.println("School()...");
	}
}

class MiddleSchool extends School {

	public MiddleSchool() {
		//상속관계에서 부모 생성자 함수 호출 명령어
		super();//생략가능하다
		System.out.println("MiddleSchool()...");
	}
	
	public void disp() {
		System.out.println(name); //학교 : 부모가 물려준 값 그대로
	}
}

class HighSchool extends School {
	
	String name="고등학교";

	public HighSchool() {
		super(); //생략가능하다
		System.out.println("HighSchool()...");
	}
	
	public void disp() {
		String name="강남고등학교";
		System.out.println(name); //강남고등학교
		System.out.println(this.name); //고등학교
		System.out.println(super.name); //학교
	}
}