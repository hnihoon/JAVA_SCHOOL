package oop0913;

class Unit {
	int currentHP;
	int x, y;
}

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attack(Unit u);
}

interface Fightable extends Movable, Attackable{
	//인터페이스간의 상속은 다중상속이 가능하다.
}

//클래스 입장에서 클래스는 단일상속만 가능하고, 인터페이스는 다중구현이 가능하다.
//방법1)
class Fight extends Unit implements Fightable {
	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attack(Unit u) {
		
	}
}

//방법2)
class Tetris extends Unit implements Movable, Attackable{
	@Override
	public void attack(Unit u) {
		
	}

	@Override
	public void move(int x, int y) {
		
	}
}

public class Test05_interface {

	public static void main(String[] args) {
		//클래스와 인터페이스 상속
		
	}
}
