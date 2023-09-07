package oop0907;

public class Test05_constructor {

	public static void main(String[] args) {
		//생성자함수 연습
		//※ School클래스 생성 후 진행.
		
		//new School(); //rorcp(Object) 또는 Instance
		
		School one = new School();
		System.out.println(one.hashCode());
		
		one.calc();
		one.disp();
		
		String a = "ITWILL";
		String b = new String(); //빈문자열
		String c = null;		 //메모리 할당은 하지 않고 b라는 참조변수 선언만 해놓음
		
		System.out.println(a.length());
		System.out.println(b.length());
//		System.out.println(c.length()); //NullPointerException
		
		System.out.println("null"); //문자열 상수
	}

}
