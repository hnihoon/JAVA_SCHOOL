package oop0913;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test01_poly {

	public static void main(String[] args) {
		//다형성 Polymorphism
		
		//객체 생성(Object, Instance)
//		GregorianCalendar now = new GregorianCalendar();
//		Integer inte = new Integer(3);
		
		//다형성
//		Calendar now = new GregorianCalendar();
//		Number inte = new Integer(3);
		
		//Father클래스 생성 후 실습
		
		//1)일반적인 방식으로 객체 생성
		//->new 연산자
		//->POJO(Plain Old Java Object)방식
		
		Father fa = new Father();
		fa.disp();
		
		Son son = new Son("손흥민", "영국");
		son.disp();
		
		Daughter dau = new Daughter("김연아", "한국");
		dau.disp();
		
		//2)다형성을 이용한 객체 생성
		//-> 자식클래스가 부모클래스에 대입 가능하다.
		Father father = new Son("개나리", "역삼동");
		father.disp();
		
		father = new Son("진달래", "서초동");
		father.disp();
		
		System.out.println(father.name);
		System.out.println(father.addr);
		//에러. 자식클래스에서 추가된 멤버는 다형성의 대상이 아니다
		//System.out.println(father.friend);
//////////////////////////////////////////////////////////////////////////		
		
		//부모클래스도 자식클래스에 대입가능하다
		//->단, 자식클래스의 모양으로 형변환해야 한다
		Father father2 = new Father();
		Son son2 = new Son();
		
		son=(Son)father; //Exception이 발생할 수도 있다.
		
		double a=2.4;
		int b=(int)a; //강제형변환
//////////////////////////////////////////////////////////////////////////

		//Object 타입은 자바 최상위 조상클래스로 모든 클래스가 들어갈 수 있음
		//예)
		Object obj = new Integer(3); //다형성. 자식클래스가 부모클래스에 대입
		System.out.println(obj.toString());
		
		obj = new Father();
		System.out.println(obj.toString());
	}
}
