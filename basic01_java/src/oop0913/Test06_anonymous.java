package oop0913;

interface IMessage{ //interface 시작
	public void msgPrint(); //추상메소드
} //interface 끝

class Message implements IMessage{//class 시작
	@Override
	public void msgPrint() { //method 시작
		System.out.println("Message 클래스");
	}//method 끝
}//class 끝

public class Test06_anonymous { //class 시작

	public static void main(String[] args) { //main 시작
		//익명 내부 객체 Anonymous class
		
		//인터페이스 직접 객체 생성할 수 없다.
//		IMessage msg = new IMessage(); 에러.
		
		//1)구현클래스
		Message msg = new Message();
		msg.msgPrint();
		
		//2)다형성
		IMessage imess = new Message();
		imess.msgPrint();
		
		//3)익명객체
		//->필요한 곳에서 일시적으로 생성
		//->이벤트가 발생할 때만 실행
		//->모바일 응용 앱, JavaScript, jQuery등에서 많이 사용
		//->$("button").click(){}
		IMessage mess = new IMessage() {
			@Override
			public void msgPrint() {
				System.out.println("익명 내부 객체");
			}
		};
		
		mess.msgPrint();
		
	}//main 끝

}//class 끝
