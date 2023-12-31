package oop0911;

import java.util.Arrays;

public class Test03_ox {

	public static void main(String[] args) {
		//문제1) 성적프로그램 OX표시하기
		// 		Jumsu클래스 생성 후 실습
		
		/*
		 * ** 시험결과 **
			====================================
			번호  이름   1  2  3  4  5  점수  등수      
			------------------------------------    
			1   홍길동  O  X  O  O  O   80   2    
			2   무궁화  O  O  O  O  O  100   1
			3   라일락  X  X  X  X  O   20   5
			4   진달래  X  O  X  O  O   60   3
			5   봉선화  O  O  X  X  X   40   4
			------------------------------------
			- 맞은문제 O, 틀린문제 X표시
			- 점수: O당 20점씩
			- 등수: 점수를 기준으로 높은사람이 1등
		 */
		
		Jumsu[] jum = {new Jumsu(1, "홍길동", 3,2,3,3,3)
					   ,new Jumsu(2, "무궁화", 3,3,3,3,3)
					   ,new Jumsu(3, "라일락", 1,1,1,2,3)
					   ,new Jumsu(4, "진달래", 1,3,2,3,3)
					   ,new Jumsu(5, "봉선화", 3,3,2,2,2)
		
		};
		
		for(int i=0; i<jum.length; i++) {
			for(int j=0; j<jum.length; j++) {
				if(jum[i].score<jum[j].score) {
					jum[i].rank = jum[i].rank+1;
				}
			}
		}
		
		System.out.println("** 시험결과 **");
		System.out.println("====================================");
		System.out.println("번호  이름   1  2  3  4  5   점수  등수");
		System.out.println("------------------------------------");
		for(int i=0; i<jum.length; i++) {
			jum[i].disp();
			System.out.println();
		}
		System.out.println("------------------------------------");

	}
}
