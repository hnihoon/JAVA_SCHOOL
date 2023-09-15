package oop0915;

import java.io.FileReader;

public class Test06_input {

	public static void main(String[] args) {
		//2)char 기반 한글
		
		String filename = "D:/java202307/java/workspace/basic01_java/src/oop0915/data.txt";
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(filename);
			
			while(true) {
				int data = fr.read(); //2바이트 읽기
				if(data == -1) { //파일의 끝 End Of File
					break;
				}
				System.out.printf("%c",data);
			}//while
			
		}catch(Exception e) {
			System.out.println("파일 읽기 실패 : " + e);
		}finally {
			//자원 반납
			try {
				if(fr!=null) { fr.close();}
			} catch(Exception e) {
				
			}
			
		}
	}
}
