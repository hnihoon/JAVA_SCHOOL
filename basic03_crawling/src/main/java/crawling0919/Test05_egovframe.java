package crawling0919;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test05_egovframe {

	public static void main(String[] args) {
		
		//연습) 전자정부표준프레임워크 공지사항(1~23페이지) 제목만 크롤링 해서
		//	   
		
		try {
			
			String fileName = "D:\\java202307\\java\\workspace\\egovframe.txt";
			FileWriter fw = new FileWriter(fileName, true); //추가모드
			PrintWriter out = new PrintWriter(fw, true);
			
			
			String URL = "https://www.egovframe.go.kr/home/ntt/nttList.do";
			String params = "?searchKey=&searchValue=&menuNo=74&bbsId=6";
			
			for(int p=0; p<=220; p+=10) {
				String page = "&pagerOffset" + p;
				Document doc = Jsoup.connect(URL+params + page).get();
				
				Elements elements = doc.select(".lnk");
				
				for(Element element : elements) {
					System.out.println(element.text());
					out.println(element.text());
				}
			}
			
			out.close();
			fw.close();
		} catch(Exception e) {
			System.out.println("크롤링 실패 : " + e);
		}
	}
}
