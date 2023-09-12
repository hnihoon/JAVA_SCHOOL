package oop0911;

public class Test07_quiz {

	public static void main(String[] args) {
		
		//문제1)주민번호의 각 숫자의 합을 구하시오
		
		String jumin="8912301234567";
		
		//1)Character클래스
		char[] ch = new char[jumin.length()];
		int sum = 0;
		
		for(int i=0; i<jumin.length(); i++) {
			ch[i] = jumin.charAt(i);
			sum += Character.getNumericValue(ch[i]);
			System.out.println(sum);
		}
		
		//2)Integer클래스
		String[] ss = jumin.split("");
		int hap = 0;
		for(int i=0; i<ss.length; i++) {
			hap += Integer.parseInt(ss[i]);
		}
		System.out.println(hap);
		
		
		
	}

}