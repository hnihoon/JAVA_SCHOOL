package net.sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBClose;
import net.utility.DBOpen;

public class SungjukDAO { //Data Access Object
						  //데이터베이스 관련(sungjuk테이블) 비지니스 로직 구현

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;
	
	public SungjukDAO() {
		dbopen = new DBOpen();
	}
	
	public int insert(String uname, int kor, int eng, int mat, int aver, String addr) {
		int cnt = 0; //성공 또는 실패 여부 반환
		try {
			con = dbopen.getConnection(); //오라클 데이터베이스 연결
			
			sql = new StringBuilder();
			sql.append(" INSERT INTO SUNGJUK(sno, uname, kor ,eng, mat, aver, addr, wdate) ");
			sql.append(" VALUES(sungjuk_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, uname);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setInt(5, aver);
			pstmt.setString(6, addr);
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("행추가 실패 : " + e);
		}finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
	public int create(SungjukDTO dto) {
		int cnt = 0; //성공 또는 실패 여부 반환
		try {
			con = dbopen.getConnection(); //오라클 데이터베이스 연결
			
			sql = new StringBuilder();
			sql.append(" INSERT INTO SUNGJUK(sno, uname, kor ,eng, mat, aver, addr, wdate) ");
			sql.append(" VALUES(sungjuk_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getUname());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getAver());
			pstmt.setString(6, dto.getAddr());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("행추가 실패 : " + e);
		}finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
}
