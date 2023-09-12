package oop0912;

public class Parent extends Object{
	int one, two;

	public Parent() {}

	public Parent(int one, int two) {
		this.one = one;
		this.two = two;
	}
}

class Child extends Parent{
	int three;

	public Child() {
		super(); //생략가능
	}

	public Child(int one, int two, int three) {
		super(one, two);
		this.three = three;
		
		//이런 식으로도 가능은 하다
		//super.one=a;
		//super.two=b;
	}
	
}
