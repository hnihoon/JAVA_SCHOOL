package crawling0919;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test03_egovframe {

	public static void main(String[] args) {
		
		//연습) 전자정부표준프레임워크 공지사항(1~23페이지) 웹페이지 소스 가져오기
		
		/*
		    https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=0
			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=10
			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=20
			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=30`
			
			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=220
			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=210
		 */
		
		try {
			String URL = "https://www.egovframe.go.kr/home/ntt/nttList.do";
			String params = "?searchKey=&searchValue=&menuNo=74&bbsId=6";
			//공지사항 HTML 페이지 1~23
			for(int p=0; p<=220; p+=10) {
				String page = "&pagerOffset" + p;
//				System.out.println(params + page);
				Document doc = Jsoup.connect(URL+params + page).get();
				System.out.println(doc.toString());
			}
			
		} catch(Exception e) {
			System.out.println("크롤링 실패 : " + e);
		}
	}
}
