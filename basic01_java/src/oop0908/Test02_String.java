package oop0908;

import java.util.StringTokenizer;

public class Test02_String {

	public static void main(String[] args) {
		//문자열 관련 클래스
		
		String name = new String("HAPPY");
		String str = "HAPPY";
		
		System.out.println(name.length());
		System.out.println(str.length());
		
		if(str==name) {	//결과:다르다
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}
		
		//문자열의 내용을 비교하는 경우 == 연산자 사용하지 말고 cquals()함수를 이용할 것
		if(str.equals(name)) {  //결과:같다.
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}
		
		//문자열의 갯수가 0인가?
		if(str.isEmpty()) {
			System.out.println("빈믄지얄");
		} else {
			System.out.println("빈문자열 아님");
		}
		
		//특정 문자를 기준으로 문자열 분리하기
		str = new String("Gone With The Wind");
		System.out.println(str);
		
		String[] word= str.split("e");
		for(int i=0; i<word.length; i++) {
			System.out.println("#"+word[i] + "#");
		}
		
		//문제1) StringTokenizer 클래스 이용해서
		//참조 : https://docs.oracle.com/javase/8/docs/api/
		StringTokenizer stz = new StringTokenizer(str," ");
		
		while(stz.hasMoreTokens()) {	//토큰할 문자가 있는지?
			System.out.println(stz.nextToken()); //토큰한 문자열 가져오기
		}
////////////////////////////////////////////////////////////////////////
		
		String sl = "";
		System.out.println(sl.length());
		
		sl = sl + "ONE";
		System.out.println(sl.length());
		
		sl = sl + "TWO";
		System.out.println(sl.length());
		
		sl = sl + "THREE";
		System.out.println(sl.length());
		
		System.out.println(sl);
		
		sl = ""; //모든 문자열 지우기(빈 문자열 대입)
		System.out.println(sl.length());
		System.out.println("#" + sl + "#");
///////////////////////////////////////////////////////////////////////

		StringBuffer s2 = new StringBuffer();
		
		s2.append("SEOUL");
		System.out.println(s2.length() + s2.toString());
		
		s2.append("JEJU");
		System.out.println(s2.length() + s2.toString());
		
		s2.append("BUSAN");
		System.out.println(s2.length() + s2.toString());
		
		//모든 문자열 지우기
		s2.delete(3, s2.length());
		System.out.println(s2.length());	//0
		
		StringBuffer s3 = null;
		//NullPointerException
		//System.out.println(s3.length());
	}
}
