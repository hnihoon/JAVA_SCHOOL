package net.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.bbs.BbsDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class NoticeDAO {
	
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public NoticeDAO() {
		dbopen = new DBOpen();
	}

	public ArrayList<NoticeDTO> list(){
		ArrayList<NoticeDTO> list = null;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select noticeno, mname, subject, readcnt, regdt, indent" );
			sql.append(" from tb_notice" );
			sql.append(" order by grpno desc, ansnum asc " );
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<NoticeDTO>(); 
				do {
					NoticeDTO dto = new NoticeDTO();
					dto.setNoticeno(rs.getInt("noticeno"));
					dto.setMname(rs.getString("mname"));
					dto.setSubject(rs.getString("subject"));
					dto.setReadcnt(rs.getInt("readcnt"));
					dto.setRegdt(rs.getString("regdt"));
					dto.setIndent(rs.getInt("indent"));
					
					list.add(dto);
					
				} while(rs.next());
				
			}
		}catch(Exception e) {
			System.out.println("전체목록실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	public int create(NoticeDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" insert into tb_notice(noticeno, mname, subject, content, grpno) ");
			sql.append(" values(notice_seq.nextval, ?, ?, ?, (select nvl(max(noticeno), 0)+1 from tb_notice)) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			
			cnt=pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("추가실패:"+ e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
	public int count() {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" select count(*) as cnt " );
			sql.append(" from tb_notice " );
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			} 
			
		}catch(Exception e) {
			System.out.println("글자갯수실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return cnt;
	}
	
}
