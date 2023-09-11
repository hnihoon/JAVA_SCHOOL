package oop0911;

public class BbsDTO { //Data Transfer Object 전송객체
	//맴버변수 field
	private int bbsno; //글번호
	private String writer; //글작성자
	private String subject; //글제목
	
	//생성자함수 constructor
	public BbsDTO() {}
	
	//멤버함수 method
	public int getBbsno() {
		return this.bbsno;
	}
	
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}
	
	public String getWriter() {
		return this.writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
