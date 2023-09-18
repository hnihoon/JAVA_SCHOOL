package oop0915;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Test09_sungjuk {

	public static void main(String[] args) {
		//문제1) 성적프로그램
		//-> 성적 입력 자료 (sungjuk.txt)를 가져와서, 성적 결과 파일 완성하기(result.txt)
		
		/*
		 * 1) 입력 데이터 파일 : sungjuk.txt
		 * 
		 * 2) 결과 파일 : result.txt
		 * 						성 / 적 / 결 /과
              -------------------------------------------------------
              이름     국어   영어  수학   평균  등수   결과
              -------------------------------------------------------                       
              라일락    100  100  100   100   1    합격 ********** 장학생
              진달래     50   55   60    55   4    불합격 *****
              개나리     95   95   35    75   3    재시험 *******
              무궁화     80   85   90    85   2    합격 *******
              홍길동     60   40   30    43   5    불합격 ****
              ------------------------------------------------------
		 */
			//※ 참조 oop0905
			
				String inName = "D:\\java202307\\java\\workspace\\sungjuk.txt";
				String outName = "D:\\java202307\\java\\workspace\\result.txt";
				
				FileReader fr = null;
				BufferedReader br = null;
				
				FileWriter fw = null;
				PrintWriter out = null;
				
				try {
					String[] name = new String[5];
					int[] kor = new int[5];
					int[] eng = new int[5];
					int[] mat = new int[5];
					
					int[] aver = new int[5];
					int[] rank = {1, 1, 1, 1, 1};
					int size = name.length; //5
					int i = 0;
					
					//2) 단계 : 데이터 입력 파일(sungjuk.txt)가져와서 내용을 읽기
					fr = new FileReader(inName); //sungjuk.txt 가져오기
					//엔터를 기준으로 끊어서 읽어 오기 위해 BufferedReader에 옮겨 담기
					br = new BufferedReader(fr); 
					String line = null;
					
					while(true) { //while 시작
						line = br.readLine(); //"무궁화,95,90,100"
						if(line == null) { //if 시작
							break;
						} //if 끝
						System.out.println(line);
						
						// , 를 기준으로 문자열 분리 후 1)단계에서 선언한 변수에 저장
						String[] word = line.split(",");
						name[i] = word[0].trim();					//무궁화
						kor[i] = Integer.parseInt(word[1].trim());	//95
						eng[i] = Integer.parseInt(word[2].trim());	//90
						mat[i] = Integer.parseInt(word[3].trim());	//100
						i++; //다음사람
					} //while 끝
					
					//3)단계 : 평균구하기
					for(i=0; i<size; i++) { //for시작
						aver[i]=(kor[i]+eng[i]+mat[i])/3;
					} //for 끝
					
					//4)단계 : 등수구하기
					for(int a=0; a<size; a++) { //for 시작
						for(int b=0; b<size; b++) { //내부for 시작
							if(aver[a]<aver[b]) rank[a] = rank[a]+1; //rank[a]++
						} //내부for 끝
					} //for 끝
					
					//5)단계 : result.txt 결과 출력하기
					fw = new FileWriter(outName, false);
					out = new PrintWriter(fw, true);
					
					out.println("성/적/결/과");
					out.println("------------------------------------------------------------------------------");
					out.println("이름     국어    영어    수학    평균    등수    결과");
					out.println("------------------------------------------------------------------------------");
					
					//※ 참조 oop0905.Test01_format 클래스
					// out,printf()
					
					//6)단계 : 5명의 데이터출력하기
					for(i=0; i<size; i++) {
						out.printf("%-3s %6d %6d %6d %6d %6d", name[i], kor[i], eng[i], mat[i], aver[i], rank[i]);
						
						if(kor[i]<40||eng[i]<40||mat[i]<40) {
							out.printf("%8s\t","재시험"); //5칸내에서 왼쪽정렬
						} else {
							out.printf("%8s\t","합격");
						}
						
						for(int star=0; star<aver[i]/10; star++) {
							out.print("*");
						}
						
						if(aver[i]>=95) {
							out.printf("\t%-6s\n", "장학생"); //10칸내에서 오른쪽정렬
						} else {
							out.println();
						}
					}
					
					
				} catch(Exception e) {
					System.out.println("성적 프로그램 읽고, 쓰기 실패 : " + e);
				} finally {
					try {
						if(br!=null) { br.close();}
					} catch(Exception e) {}
					try {
						if(fr!=null) { fr.close();}
					} catch(Exception e) {}
					try {
						if(out!=null) { out.close();}
					} catch(Exception e) {}
					try {
						if(fw!=null) { fw.close();}
					} catch(Exception e) {}
					
				}
	}
}