package oop0913;

abstract class Travel { //추상클래스
	void view() {} 			//일반메소드
	abstract String travelWhere();	//추상메소드
}

class TypeA extends Travel {
	@Override
	String travelWhere() {
		return "제주도 올레길";
	}
}

class TypeB extends Travel {
	@Override
	String travelWhere() {
		return "여의도 벚꽃 축제";
	}
}

class TypeC extends Travel {
	@Override
	String travelWhere() {
		return "지리산 둘레길";
	}
}
