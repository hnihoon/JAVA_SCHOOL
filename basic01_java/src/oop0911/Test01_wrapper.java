package oop0911;

import java.lang.*; //자바의 기본 패키지. 생략가능
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test01_wrapper {

	public static void main(String[] args) {
		//Wrapper class 포장클래스
		//->기본자료형을 참조형화 해 놓은 클래스들
		//->대부분 java.lang 패키지에 선언되어 있음
		/*
		 * 기본형 			참조형(클래스)
		 * boolean		Boolean	
		 * byte			Byte
		 * short		Short
		 * int			Integer
		 * long			Long
		 * float		Float
		 * double		Double
		 * char			Character
		 */
////////////////////////////////////////////////////////
		
		boolean boo1 = true;
		Boolean boo2 = new Boolean("false"); //Deprecated 절판
		Boolean boo3 = true; //Wrapper클래스는 new 키워드 생략 사용 가능
		
		System.out.println(boo1);
		System.out.println(boo2);
		System.out.println(boo3);
		System.out.println(boo3.toString()); //"true"
////////////////////////////////////////////////////////

		byte by1 = 3;
		Byte by2 = new Byte("5");
		Byte by3 = 7;
		
		System.out.println(by1);
		System.out.println(by2);
		System.out.println(by3);
		System.out.println(by3.toString()); //"7"
//////////////////////////////////////////////////////////////////
		
		int in1 = 2;
		Integer in2 = new Integer(4);
		Integer in3 = 6;
		
		System.out.println(in1);
		System.out.println(in2);
		System.out.println(in3);
		
		System.out.println(in2.toString()); //"4"
		System.out.println(in3.doubleValue()); //6.0
		
		System.out.println(Integer.toBinaryString(15)); //2진수 "1111"
		System.out.println(Integer.toOctalString(15));  //8진수 "17"
		System.out.println(Integer.toHexString(15));  //16진수 "f"
		
		System.out.println(Integer.sum(2, 4)); //6
		System.out.println(Integer.max(2, 4)); //4
		System.out.println(Integer.min(2, 4)); //2
		
		System.out.println(Integer.parseInt("123")); //"123" -> 123변환
		
		//NumberFormatException 에러 발생
		//System.out.println(Integer.parseInt("KOREA"));
//////////////////////////////////////////////////////////////////

		long lo1 = 3L;
		Long lo2 = new Long(5);
		Long l3 = 7L;
		
		double dou1 = 2.4;
		Double dou2 = new Double("3.5");
		Double dou3 = 6.7;

		//문제1)실수형값들 중에서 정수의 합을 구하시오( 2+3+6)
		int hap = (int)dou1 + dou2.intValue() + dou3.intValue();
		System.out.println(hap); //11
//////////////////////////////////////////////////////////////////

		char ch1 = 'R';
		Character ch2 = new Character('a');
		Character ch3 = 'm';
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		
		System.out.println(Character.isWhitespace(' ')); //공백인가
		System.out.println(Character.toLowerCase('R')); //대소문자 반전
		System.out.println(Character.toUpperCase('a')); //대소문자 반전
		
		//문제2) 대소문자를 바꿔서 출력하시오 (Character클래스와 charAt()함수 이용)
		//출력결과 : gONE wITH tHE wIND!!
		String str = "Gone With The Wind!!";
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch)) {
				System.out.print(Character.toLowerCase(ch));
			} else if(Character.isLowerCase(ch)) {
				System.out.print(Character.toUpperCase(ch));
			} else {
				System.out.print(ch);
			}
		}
	}

}
