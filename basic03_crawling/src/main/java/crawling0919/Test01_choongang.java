package crawling0919;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test01_choongang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//크롤링(Crawling) 또는 스크래핑(Scraping)
		//->개인 혹은 단체에서 필요한 데이터가 있는 웹(Web)페이지의 구조를 분석하고 파악하여 긁어옵니다.
		
		//연습) itwill 공지사항 : https://www.itwill.co.kr/cmn/board/BBSMSTR_000000000071/bbsList.do
		
		try {
			
			String URL = "https://www.itwill.co.kr/cmn/board/BBSMSTR_000000000071/bbsList.do";
			
			//웹페이지 소스 가져오기
			Jsoup.connect(URL);
			Document doc = Jsoup.connect(URL).get();
			System.out.println(doc.toString());
			
		} catch(Exception e) {
			System.out.println("크롤링 실패 : " + e);
		}
	}
}
