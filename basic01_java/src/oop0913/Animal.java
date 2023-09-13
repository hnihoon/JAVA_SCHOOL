package oop0913;

abstract class Animal { //추상클래스 : abstract class 클래스명 {}
	String name;
	void view() {} //일반메소드
	abstract void disp();   // 추상메소드(미완성)
}

//추상클래스는 부모역할만 주로 한다
//추상클래스를 상속받은 자식클래스는 반드시 추상메소드를 환성해야 한다.
class Elephant extends Animal{
	@Override
	void disp() {
		System.out.println("점보");
	}

}

class Tuna extends Animal{
	@Override
	void disp() {
		System.out.println("니모");
	}
}

