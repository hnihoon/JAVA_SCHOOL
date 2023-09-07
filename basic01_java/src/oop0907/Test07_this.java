package oop0907;

public class Test07_this {

	public static void main(String[] args) {
		//this
		//->클래스가 자신을 가리키는 대명사
		//->일반지역변수와 멤버변수를 구분하기 위함
		
		//※ Jumsu 클래스 생성 후 테스트 합니다
		
		//new Jumsu("개나리");
		//new Jumsu();
		
		Jumsu one = new Jumsu();
		one.disp();
		
		Jumsu two = new Jumsu("김연아", 50, 60, 70);
		two.disp();
		
		Jumsu three = new Jumsu("무궁화", 10, 20, 100);
		three.disp();
		
		//객체가 참조하고 있는 주소
		System.out.println(one.hashCode());
		System.out.println(two.hashCode());
		System.out.println(three.hashCode());
		
		//이클립스 코딩툴에서 생성자 함수를 자동으로 코딩할 수 있다.
		//※ Exam 클래스 생성후 테스트 합니다.
	}
}
