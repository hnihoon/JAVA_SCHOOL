package oop0906;

import java.util.Arrays;

public class Test01_sort {

	public static void main(String[] args) {
		//정렬 Sort
		/*
		 * 	- 정렬 유형 : 오름차순, 내림차순
		 *    삽입 정렬 : insertion sort
		 *    선택 정렬 : selection sort
		 *    버블 정렬 : buble sort
		 *    
		 *  - 선택 정렬 : selection sort 알고리즘
		 *    9 8 7 6 5 -> 5 6 7 8 9
		 *    
		 *    맨 앞의 숫자를 순서대로 비교해서 가장 낮은 숫자로 비교해서 바꿈
		 *    9 8 7 6 5
		 *    8 9 7 6 5		=> 8>7
		 *    7 9 8 6 5		=> 7>6
		 *    6 9 8 7 5		=> 6>5
		 *    5 9 8 7 6		=> 첫번째 숫자 5
		 *    ------------------------ step1
		 *    두번째 숫자를 순서대로 비교해서 가장 낮은 숫자로 바꿈
		 *    5 9 8 7 6  	=> 9>8
		 *    5 8 9 7 6		=> 8>7
		 *    5 7 9 8 6		=> 7>6
		 *    5 6 9 8 7		=> 두번째 숫자 6
		 *    ------------------------ step2
		 *    5 6 9 8 7		=> 9>8
		 *    5 6 8 9 7		=> 8>7
		 *    5 6 7 9 8 	=> 세번째 숫자 7
		 *    ------------------------ step3
		 *    5 6 7 9 8		=> 9>8
		 *    5 6 7 8 9		=>네번째 숫자 8
		 *    
		 *  - 버블 정렬 : bubble sort 알고리즘
		 * 	  9 8 7 6 5 -> 5 6 7 8 9
		 *    
		 *    9 8 7 6 5
		 *    8 9 7 6 5
		 *    8 7 9 6 5
		 *    8 7 6 9 5
		 *    8 7 6 5 9
		 *    ------------------------ step1
		 *    8 7 6 5 9
		 *    7 8 6 5 9
		 *    7 6 8 5 9
		 *    7 6 5 8 9
		 *    ------------------------ step2
		 *    7 6 5 8 9
		 *    6 7 5 8 9
		 *    6 5 7 8 9
		 *    ------------------------ step3
		 *    6 5 7 8 9
		 *    5 6 7 8 9
		 * 
		 */
		
		int[] su = {9,8,7,6,5};
		
		//숫자형 데이터를 오름차순 정렬
		Arrays.sort(su);
		System.out.println("Arrays.sort를 활용한 방법(오름차순)");
		System.out.println("---------------------------");
		for(int i=0; i<su.length; i++) {
			System.out.println(su[i]);
			//출력결과 5 6 7 8 9
		}
		
		//1)select sort
		System.out.println("select sort를 활용한 방법(오름차순)");
		System.out.println("---------------------------");
		for(int a=0; a<su.length; a++) {
			for(int b=a+1; b<su.length; b++) {
				if(su[a]>su[b]) {
					int tmp=su[a];
					su[a]=su[b];
					su[b]=tmp;
				}
			}
		}
		for(int i=0; i<su.length; i++) {
			System.out.println(su[i]);
			//출력결과 5 6 7 8 9
		}
		
		//2)bubble sort
		System.out.println("bubble sort를 활용한 방법(내림차순)");
		System.out.println("---------------------------");

		for(int a=3; a>=0; a--) {
			for(int b=0; b<=a; b++) {
				if(su[b]<su[b+1]) { //내림차순
					int tmp=su[b+1];
					su[b+1]=su[b];
					su[b]=tmp;
				}
			}
		}
		for(int idx=0; idx<su.length; idx++) {
			System.out.println(su[idx]);
		}
		
	}
}
