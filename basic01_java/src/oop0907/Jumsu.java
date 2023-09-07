package oop0907;

class Jumsu {
	//멤버변수 field
	private String name = "손흥민";
	private int kor, eng, mat;
	private int aver;
	
	//생성자 함수 construntor
	public Jumsu() {}
	
	public Jumsu(String n) {
		name = n;
	}

	public Jumsu(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Jumsu(String name, int kor, int eng, int mat, int aver) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.aver = (kor+eng+mat)/3;
	}

	//멤버함수 method
	public void disp() {
		//지역변수의 우선순위가 가장 높다
		String name="박지성";
		System.out.println(name); //박지성
		
		System.out.println(this.name); //손흥민
		System.out.println(this.kor);
		System.out.println(this.eng);
		System.out.println(this.mat);
		System.out.println(this.aver);
		
		
		
		
	}
	
}

