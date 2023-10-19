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
	
}
