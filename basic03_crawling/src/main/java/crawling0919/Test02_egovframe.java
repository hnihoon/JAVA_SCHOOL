package crawling0919;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test02_egovframe {

	public static void main(String[] args) {
		
		//연습) 전자정부표준프레임워크 공지사항(1페이지) 웹페이지 소스 가져오기
		try {
			String URL = "https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=0";
			
			//웹페이지 소스 가져오기
			Document doc = Jsoup.connect(URL).get();
			System.out.println(doc.toString());
			
		} catch(Exception e) {
			System.out.println("크롤링 : " + e);
		}
	}
}
