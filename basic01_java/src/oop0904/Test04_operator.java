package oop0904;

public class Test04_operator {

	public static void main(String[] args) {
//		연산자
//		산술,비교(관계),논리연산자
//		삼항,대입,증감연산자
		
		System.out.println(5/3);	//1
		System.out.println(5%3);	//2
		
		
		System.out.println(3/5);	//0정수값과의 연산은 결과값도 정수형으로 반환된다.
		System.out.println(3%5);	//3
		
		System.out.println(3.0/5.0); //0.6
		System.out.println(3/5.0);	 //0.6
		System.out.println(3.0/5);	 //0.6
		System.out.println(3/5.);	 //0.6
		////////////////////////////////////////////////////////////////
		
		/*
		 * 2진수  : 0 1
		 * 8진수  : 0 1 2 3 4 5 6 7 
		 * 10진수 : 0 1 2 3 4 5 6 7 8 9
		 * 16진수 : 0 1 2 3 4 5 6 7 8 9 a b c d e f
		 * 
		 * 						128 64 32 16 8 4 2 1
		 * 10진수 5를 2진수 변환					   1 0 1
		 * 10진수 3을 2진수 변환					   0 1 1
		 * 10진수 9를 2진수 변환					 1 0 0 1
		 * 10진수 35를 2진수 변환				1  0 0 0 1 1
		 */
		
		
//		bit연산자
		
//		1)비트곱, 비트합 연산자
		System.out.println(5&3);	//1
		System.out.println(5|3);	//7

//		논리곱 : 비트가 둘다 1인 경우 1
//		논리합 : 비트가 둘중 한개라도 1인 경우 1
		/*		  논리곱			  논리합
		 * 5 -> 00000101		00000101
		 * 3 -> 00000011		00000011	
		 *     ----------      ----------
		 *     	00000001		00000111
		 */		
		
//		2) 비트 부정 연산자 : 비트를 반전시킴 0=>1 , 1=>0
		System.out.println(~5);	//1의 보수 연산자
//		~00000101
//		 11111010
		
//		3) shift 연산자 : 비트를 이동시킴
		System.out.println(16<<3);	//128
		System.out.println(16<<3);	//2
		
		/*
		 * 16을 2진수 변환
		 * 		00010000		00010000
		 * 		  <<3			   3>>
		 * 		10000000		00000010
		 * 	   ----------      ----------
		 * 		  128			    2
		 */
		
	}//main 끝
}//class 끝
