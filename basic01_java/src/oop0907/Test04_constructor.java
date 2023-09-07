package oop0907;

import java.util.GregorianCalendar;

public class Test04_constructor {

	public static void main(String[] args) {
		//생성자 함수(Constructor)
		//->클래스명과 동일한 함수
		//->new연산자와 함께 메모리 할당할 때 사용한다.
		//->오버로드가 가능하다.
		
		//소멸자 함수(Destructor) -> 자바에는 없음!!
		//가비지 콜렉팅(Garbage Collectiong)
		//->JVM이 자동으로 메모리 회수를 함.
		
		//new GregorianCalendar(); 달력정보
		
		GregorianCalendar today = new GregorianCalendar();
		System.out.println(today.YEAR);
		
//		if(today.isLeapYear(2023)) {
//			System.out.println("윤년");
//		} else {
//			System.out.println("평년");
//		}
		
		//문제1)서기1년~서기2023년까지 윤년의 갯수를 구하시오
		
		//1)GregorianCalendar클래스 활용(추천)
		int count=0;
		for(int y=1; y<=2023; y++) {
			if(today.isLeapYear(y)) {
				count++;
			}
		}
		System.out.println(count);
		
		//2)윤년 구하는 공식
		int count2=0;
		for(int y=1; y<=2023; y++) {
			if(y%4 == 0 && y%100 !=0 || y%400 == 0) {
				count2++;
		}
	}
		
		System.out.println(count2);
	}

}
