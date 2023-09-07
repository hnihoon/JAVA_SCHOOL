package opp0907;

public class Test01_main {
	
	public static void test() {	//test()함수 정의
		System.out.println("JAVA");
		
		//main(); main()함수는 사용자가 임의로 호출할 수 없다.

		//Java Virtual Marchine(JVM)
        //->자바 가상 머신이 클래스를 실행할 때 main() 함수를 먼저 호출하고 그 이후가 실행된다
	}
	
	public static void main(String[] args) {
		//main()함수가 호추로디는 시점과 값을 전달하는 예제
		
		test();//함수호출
	}
}
