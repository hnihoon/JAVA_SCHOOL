package oop0915;

import java.io.FileInputStream;

public class Test05_input {

	public static void main(String[] args) {
		//파일 입출력(.txt)
		//파일 : .txt .pdf .xls .ppt .csv .jpg ...
		
		//byte형 : 1바이트 할당
		//char형 : 2바이트 할당
	
		//1)byte 기반 -> 한글 깨짐
		
		//data.txt 생성 후 실습
		
		String filename = "D:/java202307/java/workspace/basic01_java/src/oop0915/data.txt";
		
		FileInputStream fis = null;
	
		try {
			
			fis = new FileInputStream(filename);
			
			while(true) {
				int data = fis.read();//1바이트 읽기
				if(data == -1) { //파일의 끝인지? End Of File
					break;
				}
				//System.out.println(data);
				System.out.printf("%c",data);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//자원반납
			try {
				if(fis!=null) { fis.close(); } 
			}catch(Exception e){
				
			}
		}
	}

}
