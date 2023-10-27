package net.pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.bbs.BbsDTO;
import net.notice.NoticeDTO;
import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.Utility;

public class PdsDAO {

	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public PdsDAO() {
		dbopen=new DBOpen();
	}
	
	
	public int create(PdsDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" insert into tb_pds(PDSNO, WNAME ,SUBJECT ,PASSWD ,FILENAME ,FILESIZE, REGDATE) ");
			sql.append(" values(pds_seq.nextval, ?, ?, ?, ?, ?, sysdate) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getFilename());
			pstmt.setLong(5, dto.getFilesize());
			
			cnt=pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("추가실패:"+ e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
	public ArrayList<PdsDTO> list(){
		ArrayList<PdsDTO> list = null;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" SELECT PDSNO ,WNAME ,SUBJECT ,REGDATE ,PASSWD ,READCNT ,FILENAME ,FILESIZE " );
			sql.append(" from tb_pds" );
			sql.append(" order by REGDATE desc " );
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<PdsDTO>(); 
				do {
					PdsDTO dto = new PdsDTO();
					dto.setPdsno(rs.getInt("PDSNO"));
					dto.setWname(rs.getString("WNAME"));
					dto.setSubject(rs.getString("SUBJECT"));
					dto.setRegdate(rs.getString("REGDATE"));
					dto.setPasswd(rs.getString("PASSWD"));
					dto.setReadcnt(rs.getInt("READCNT"));
					dto.setFilename(rs.getString("FILENAME"));
					dto.setFilesize(rs.getInt("FILESIZE"));
					
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
	
	public PdsDTO read(int pdsno) {
		PdsDTO dto = null;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" SELECT PDSNO ,WNAME ,SUBJECT ,REGDATE ,PASSWD ,READCNT ,FILENAME ,FILESIZE " );
			sql.append(" from tb_pds " );
			sql.append(" where pdsno=? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, pdsno);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new PdsDTO();
				dto.setPdsno(rs.getInt("PDSNO"));
				dto.setWname(rs.getString("WNAME"));
				dto.setSubject(rs.getString("SUBJECT"));
				dto.setRegdate(rs.getString("REGDATE"));
				dto.setPasswd(rs.getString("PASSWD"));
				dto.setReadcnt(rs.getInt("READCNT"));
				dto.setFilename(rs.getString("FILENAME"));
				dto.setFilesize(rs.getLong("FILESIZE"));
			}
			
		} catch(Exception e) {
			System.out.println("상세보기실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}
	

	public void incrementCnt(int pdsno) {
		
		try {
			con=dbopen.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append(" update tb_pds " );
			sql.append(" set readcnt = readcnt+1 ");
			sql.append(" where pdsno = ? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, pdsno);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("상세보기실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
	}
	
	public int delete(int pdsno, String passwd, String saveDir) {
		int cnt=0;
		try {
			
			//테이블의 행이 삭제하기 전에, 삭제하고자 하는 파일명 가져오기
			String filename = "";
			PdsDTO oldDTO = read(pdsno);
			if(oldDTO != null) {
				filename = oldDTO.getFilename();
			}
			
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" delete from tb_pds ");
			sql.append(" where pdsno=? and passwd=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, pdsno);
			pstmt.setString(2, passwd);
			
			cnt=pstmt.executeUpdate();
			if(cnt==1) {
				Utility.deleteFile(saveDir, filename);
			}
		}catch(Exception e) {
			System.out.println("상세보기실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
}
























