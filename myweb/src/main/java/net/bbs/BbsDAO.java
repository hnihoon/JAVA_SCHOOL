package net.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class BbsDAO { //Data Access Object 데이터베이스 관련 작업

	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public BbsDAO() {
		dbopen = new DBOpen();
	}
	
	public int create(BbsDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" insert into tb_bbs(bbsno, wname, subject, content, passwd, ip, grpno) ");
			sql.append(" values(bbs_seq.nextval, ?, ?, ?, ?, ?, (select nvl(max(bbsno), 0)+1 from tb_bbs)) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getIp());
			
			cnt=pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("추가실패:"+ e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
	public ArrayList<BbsDTO> list(){
		ArrayList<BbsDTO> list = null;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select bbsno, wname, subject, readcnt, regdt, indent" );
			sql.append(" from tb_bbs " );
			sql.append(" order by grpno desc, ansnum asc " );
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<BbsDTO>(); 
				do {
					BbsDTO dto = new BbsDTO();
					dto.setBbsno(rs.getInt("bbsno"));
					dto.setWname(rs.getString("wname"));
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
	
	public int count() {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" select count(*) as cnt " );
			sql.append(" from tb_bbs " );
			
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
	
	public BbsDTO read(int bbsno) {
		BbsDTO dto = null;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select bbsno, wname, subject, content, readcnt, regdt, ip, grpno, indent, ansnum " );
			sql.append(" from tb_bbs " );
			sql.append(" where bbsno=? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new BbsDTO();
				dto.setBbsno(rs.getInt("bbsno"));
				dto.setWname(rs.getString("wname"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setRegdt(rs.getString("regdt"));
				dto.setIp(rs.getString("ip"));
				dto.setGrpno(rs.getInt("grpno"));
				dto.setIndent(rs.getInt("indent"));
				dto.setAnsnum(rs.getInt("ansnum"));
			}
			
		} catch(Exception e) {
			System.out.println("상세보기실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}
	
	public void incrementCnt(int bbsno) {
		
		try {
			con=dbopen.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append(" update tb_bbs " );
			sql.append(" set readcnt = readcnt+1 ");
			sql.append(" where bbsno = ? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("상세보기실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
	}
	
	public int delete(BbsDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" delete from tb_bbs ");
			sql.append(" where bbsno=? and passwd=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getBbsno());
			pstmt.setString(2, dto.getPasswd());
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("상세보기실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
}
