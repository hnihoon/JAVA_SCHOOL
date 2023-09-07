package oop0907;

public class Score {
	//멤버변수 field
	private String name;
	private int kor,eng,mat;
	private int aver;
	
	//생성자함수 constructor
	public Score() {
		System.out.println("Score() 호출됨");
	}

	public Score(String n) {
		name = n;
	}

	public Score(int k, int e, int m) {
		kor = k;
		eng = e;
		mat = m;
	}

	public Score(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		mat = m;
	}
	
	//멤버함수 method
	void calc() { //package 생략되어 있음
		aver=(kor+eng+mat)/3;
	}
	
	public void disp() {
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
		System.out.println(aver);
	}
	
}
