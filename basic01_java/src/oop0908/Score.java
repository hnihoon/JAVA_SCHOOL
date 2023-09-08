package oop0908;

public class Score {//package 생략되어 있다 
					//oop0908패키지내에서만 접근 가능
			
	//멤버변수 field
	private String name;
	private int kor, eng, mat;
	private int aver;
	
	public Score() {
		
	}
	
	//생성자함수 constructor
	public Score(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public void calc() {
		this.aver = (kor+eng+mat)/3;
	}
	
	public void disp() {
		System.out.println(this.name);
		System.out.println(this.kor);
		System.out.println(this.eng);
		System.out.println(this.mat);
		System.out.println(this.aver);
	}
}
