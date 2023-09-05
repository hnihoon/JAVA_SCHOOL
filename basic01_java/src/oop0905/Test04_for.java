package oop0905;

public class Test04_for {//class 시작

	public static void main(String[] args) {//main시작
		//반복문
		
		//1. for문
		for(int a=1; a<=3; a++) { //for시작
			System.out.println("JAVA");
		}//for 끝
		//for문에 선언된 변수는 for문에서만 사용가능하다
		//System.out.println(a);에러
		
		int b=0;
		for(b=1; b<=3; b++) {//for시작
			System.out.println("PYTHON");
		}//for끝
		
		System.out.println(b);
		
		//2. while문
		int i=0;
		while(i<=3) {//while시작
			System.out.println("SEOUL");
			i++;
		}//while끝
		
		//3. do~while문
		int j=0;
		do {
			System.out.println("JEJU");
			j++;
		} while(j<=3);
		
		//4. break와 continue문
		for(int a=1; a<10; a++) {//for 시작
			if(a==5) { //if 시작
				break;	//반복문을 빠져나감
			}//if 끝
			System.out.println(a+" ");
		}//for 끝
		System.out.println();	//줄바꿈
		
		for(int a=1; a<10; a++) {//for 시작
			if(a==5) {//if 시작
				continue;	//반복문 계속 실행
			}//if 끝
			System.out.println(a+" ");
		}//for 끝
	}//main 끝

}//class 끝
