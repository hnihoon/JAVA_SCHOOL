package net.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBClose;
import net.utility.DBOpen;

public class MemberDAO { //Data Access Object
						 //데이터베이스 비지니스 로직 구현
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public MemberDAO() {
		dbopen=new DBOpen();
	}
	
	public String loginProc(MemberDTO dto) {
		String mlevel=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select mlevel " );
			sql.append(" from member " );
			sql.append(" where id=? and passwd=? " );
			sql.append(" and mlevel in ('A1', 'B1', 'C1', 'D1') ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mlevel=rs.getString("mlevel");
			}
	
		} catch(Exception e) {
			System.out.println("로그인실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return mlevel;
	}
	
	public int duplecateID(String id) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select count(id) as cnt ");
			sql.append(" from member " );
			sql.append(" where id=? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return cnt;
	}
	
	public int duplecateEmail(String email) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select count(email) as cnt ");
			sql.append(" from member " );
			sql.append(" where email=? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, email);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("이메일 중복 확인 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return cnt;
	}
	
	public int create(MemberDTO dto) {
		int cnt = 0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" insert into member(ID ,PASSWD ,MNAME ,TEL ,EMAIL ,ZIPCODE ,ADDRESS1 ,ADDRESS2 ,JOB ,MLEVEL ,MDATE) ");
			sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ?, 'D1', sysdate )");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getZipcode());
			pstmt.setString(7, dto.getAddress1());
			pstmt.setString(8, dto.getAddress2());
			pstmt.setString(9, dto.getJob());
			
			cnt=pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("회원 가입 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
}
