package oop0913;

class Father {//package생략되어 있다.
			  //oop0913패키지내에서만 사용가능
	
	//멤버변수 field
	public String name="아버지";
	public String addr="주소";
	
	//생성자함수 constructor
	public Father() {}

	public Father(String name, String addr) { 
		this.name = name;
		this.addr = addr;
	}
	
	

	//멤버함수 method
	public void disp() { 
		System.out.println(this.name);
		System.out.println(this.addr);
	}
}

class Son extends Father{
	public Son() {}
	public Son(String name, String addr) {
		super.name=name;
		super.addr=addr;
	}
}

class Daughter extends Father{
	
	String friend="절친";
	
	public Daughter() {}

	public Daughter(String name, String addr) {
		super(name,addr); //부모생성자 함수 호출
	}
}
