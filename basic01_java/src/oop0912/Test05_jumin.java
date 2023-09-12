package oop0912;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test05_jumin {

	public static void main(String[] args) {
		//문제1) 주민번호 유효성 검사
		//Jumin 클래스 생성해서 실습
		
		Jumin id = new Jumin("8912301234567");
		
		
		if(id.validate()) {
			System.out.println("주민번호가 맞다.");
		} else {
			System.out.println("주민번호가 틀리다.");
		}
		
		id.disp();
	}
}
