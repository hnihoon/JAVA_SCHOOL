package oop0907;

class  Sungjuk{	//package 생략되어 있음
				//클래스명의 첫글자는 대문자로 한다.
	
	//멤버변수 : field
	public String name; //클래스 외부에서 접근 가능하다.
	int kor , eng, mat; //package 생략되어 있음
	private int aver;	//Sungjuk클래스 내부에서만 접근 가능하다
	
	//멤버함수 : method
	private void view() {}
	
		void calc() { //package 생략되어 있음
			aver=(kor+eng+mat)/3;
			view();
		}
		
		public void disp() {
			System.out.println(name);
			System.out.println(kor);
			System.out.println(eng);
			System.out.println(mat);
			System.out.println(aver);
		}
}
		
	
public class Test03_Sungjuk {
}
