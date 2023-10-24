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
	
	public String idemailCheck(MemberDTO dto) {
		String id=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select id " );
			sql.append(" from member " );
			sql.append(" where mname=? and email=?");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getEmail());
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				id=rs.getString("id");
			}
	
		} catch(Exception e) {
			System.out.println("로그인실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return id;
	}
	
	public String getRandomString(int length) {
	    String str = "";
	    for (int i = 0; i < length; i++)
	    {
	        int category = ((int) (Math.random() * 100) % 3);
	        // 랜덤 숫자
	        if (category == 0)
	        {
	            int num = (int) (Math.random() * 10);
	            str = str.concat(String.valueOf(num));
	        } // 랜덤 소문자
	        else if (category == 1)
	        {
	            int startnum = 97;
	            int num = ((int) (Math.random() * 100) % 26);
	            char character = (char)(startnum + num);
	            str = str.concat(String.valueOf(character));
	        } // 랜덤 대문자
	        else
	        {
	            int startnum = 65;
	            int num = ((int) (Math.random() * 100) % 26);
	            char character = (char)(startnum + num);
	            str = str.concat(String.valueOf(character));
	        }
	    }
	    return str;
	}
	
	public void incrementCnt(String random, String id) {
		
		try {
			con=dbopen.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append(" update MEMBER " );
			sql.append(" set passwd=? ");
			sql.append(" where id=? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, random);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("상세보기실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
	}
}
