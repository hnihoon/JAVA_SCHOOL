package oop0906;

public class Test02_method {
	//메소드 작성 역역
	public static void test1() {
		System.out.println("JAVA");
	}
	
	public static void test2() {
		System.out.println("PYTHON");
		return; //함수를 호출한 시점으로 되돌아간다.
				//마지막 return명령어는 생략 가능
	}
	public static void test3(int a) {
		System.out.println(a);
		return;
	}
	public static void test4(int a, int b, int c) {
		System.out.println(a+b+c);
		return;
	}
	public static void test5(double a, double b) {
		System.out.println(a+b);
		return;
	}
	public static void test6(char ch, byte num) {
		for(int i=1; i<=num; i++) {
			System.out.println(i + " : " + ch);
		}
	}
	public static void main(String[] args) {
		//Method 메소드
		//함수, function, 프로시저
		
		//1. 리턴값이 없는 함수
		
		//1)전달값 (argument value)이 없는 경우
		test1();	//JAVA
		test2();	//PYTHON
		
		//2)전달값이 있는 경우
		test3(10);			//10
		test4(20, 30, 40);	//90
		test5(1.2, 3.4);	//4.6
		
		//문제1) #기호를 100번 출력하기
		byte num=100;
		char ch='#';
		test6(ch,num);		//1 : # ... 100 : #
	}
}
