package oop0906;

public class Test03_method {
	
	public static int test1(int a, int b) {
		int c=a+b;
//		return; 리턴값이 없다(void형)
		return c; //리턴값은 1개만 리턴할 수 있다.
				  //리턴값이 있는 경우 리턴값의 자료형을 void자리에 쓴다(int)
	}
	
	public static String test2(int a) {
		if(a%2 == 0) {
			return "짝수입니다.";
		} else {
			return "홀수입니다.";
		}
	}
	
	public static boolean test3(int y) {
		if(y%4==0 && y%100!=0 || y%400==0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static long test4(int n) {
		long sum = 1;
		for(int i = n; i>=1; i--) {
			sum*=i;
		}
		return sum;
	}
	
	public static long fact(int n) {
		if(n==0) {
			return 1;
		} else {
			return n*fact(n-1); //재귀적 함수 호출
		}
	}
	
	

	public static void main(String[] args) {
		//2. 리턴값이 있는 경우
		
		System.out.println(Math.abs(-3));	//3
		System.out.println(Math.max(5,7));	//7
		
		int result = test1(2,4);
		System.out.println(result);			//6
		
		//값 : 상수값, 변수값, 리턴값
		System.out.println(test1(5,7)+1);
		
		//짝수, 홀수 출력하기
		String str=test2(7);
		System.out.println(str);
				
				
		//윤년확인하기
		if(test3(202)) {
			System.out.println("윤년");
		}else {
		    System.out.println("평년");
		}//if end		
				
		//팩토리얼 구하기	(5*4*3*2*1)
		long f=test4(5);
		System.out.println(f);
		
//////////////////////////////////////////////////
		
		//3.재귀적 함수 호출
		//팩토리얼값 구하기
		System.out.println(fact(5));
		
	}

}
