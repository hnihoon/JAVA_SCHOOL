package oop0913;

import oop0913.WebProgram.Language;
import oop0913.WebProgram.Smart;

public class Test07_inner { 

	public static void main(String[] args) { 
		//내부클래스 inner class
		//->클래스 내부에서 선언된 클래스
		
		//WebProgram클래스 생성 후 실습
		
		WebProgram web = new WebProgram();
		web.print();
		
		//에러. 내부클래스는 직접 접근할 수 없다.
		//Language lang = new Language();
		//Smart sm = new Smart();
		
		//내부클래스는 외부에서 단계적으로 접근할 수 있다.
		Language lang = new WebProgram().new Language();
		lang.display();
		
		Smart sm = new WebProgram().new Smart();
		sm.display();
/////////////////////////////////////////////////////////////////
		
		/* 
		 * 안드로이드 (구글사에서 만든 모바일 전용 OS)
		 * class R{
		 * 
		 * 		class id{
		 * 
		 *		}	
		 * 
		 * 	}
		 */
	} 
} 