package oop0913;

public class Test04_interface {

	public static void main(String[] args) {
		//이터페이스 interface
		/*
		 * - 추상메소드로만 구성되어 있다.
		 * - 추상클래스보다 더 추상화 되어 있다.
		 * - 상속 : extends 확장, implements 구현
		 */
		
		//인터페이스 Creature 생성 후 실습
		
		//에러. 인터페이스는 직접 객체 생성 불가능
		//Creature creature = new Creature();
		
		//인터페이스에서의 다형성
		Creature creature = null;
		
		creature = new Tiger();
		creature.kind();
		creature.breathe();
		
		creature = new Salmon();
		creature.kind();
		creature.breathe();
		
		
		
	}
}
