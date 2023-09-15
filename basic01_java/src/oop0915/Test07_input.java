package oop0915;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test07_input {

	public static void main(String[] args) {
		//3) 메모장 파일의 내용을 엔터 단위로 가져오기
		
		String filename = "D:/java202307/java/workspace/basic01_java/src/oop0914/Buyer.java";
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			//1)파일 가져오기 (읽기모드)
			fr = new FileReader(filename);
			
			//2)엔터단위로 끊어서 읽기 위해 BufferedReader에 옮겨 담기
			br = new BufferedReader(fr);
			
			int num = 0;
			
			while(true) {
				String line = br.readLine(); //3)엔터(\n)를 기준으로 한줄씩 가져오기
				if(line == null) {
					break;
				}
				System.out.printf("%d %s\n", ++num, line);
				
				//20행마다 밑줄 긋기
				if(num%20 == 0) {
					System.out.println("_______________________________");
				}
			}

		} catch(Exception e) {
			System.out.println("파일 읽기 실패 : " + e);
		} finally {
			//자원 반납 순서 주의
			try {
				if(br!=null) { br.close();}
			} catch (Exception e) {
				
			}
			try {
				if(fr!=null) {fr.close();}
			} catch(Exception e) {
				
			}
		}
	}
}