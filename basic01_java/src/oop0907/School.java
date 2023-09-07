package oop0907;

class School {	//package생략
				//School클래스 oop0907패키지내에서만 가능
	
	//멤버변수 field
	private String name;
	private int kor,eng,mat;
	private int aver;
	
	//생성자함수 constructor
	//->클래스명과 동일한 함수
	public School() {	//기본생성자
						//dufault constructor
						//자동으로 생성된다
		System.out.println("School() 호출됨...");
	}
	
	//멤버함수 method
	void calc() { //package 생략되어 있음
		aver=(kor+eng+mat)/3;
	}
	
	public void disp() {
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
		System.out.println(aver);
	}
}
