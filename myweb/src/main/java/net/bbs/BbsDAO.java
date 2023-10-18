package net.bbs;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;import javax.imageio.plugins.tiff.GeoTIFFTagSet;

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
	
	public int updateproc(BbsDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			
			sql = new StringBuilder();
			sql.append(" update tb_bbs ");
			sql.append(" set wname=?, subject=?, content=?, ip=? " );
			sql.append(" where bbsno=? and passwd=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getIp());
			pstmt.setInt(5, dto.getBbsno());
			pstmt.setString(6, dto.getPasswd());
			
			cnt=pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("수정 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
	public int reply(BbsDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			sql = new StringBuilder();
			
			//1) 부모글 정보 가져오기 (select문)
			int grpno=0;  //부모글 그룹번호
			int indent=0; //부모글 들여쓰기
			int ansnum=0; //부모글 글순서
			sql.append(" select grpno, indent, ansnum " );
			sql.append(" from tb_bbs ");
			sql.append(" where bbsno=? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getBbsno());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				grpno = rs.getInt("grpno");     //그룹번호 : 부모글 그룹번호 그대로 가져오기
				indent = rs.getInt("indent")+1; //들여쓰기 : 부모글 들여쓰기+1
				ansnum = rs.getInt("ansnum")+1; //글순서 : 부모글 글순서+1
			}
			
			//2) 글순서 재조정하기 (update문)
			sql.delete(0, sql.length());	//1)단계에서 사용했던 sql값 지우기
			sql.append(" update tb_bbs ");
			sql.append(" set ansnum=ansnum + 1 ");
			sql.append(" where grpno=? and ansnum>=? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, grpno);
			pstmt.setInt(2, ansnum);
			pstmt.executeUpdate();
			
			//3) 답변글 추가하기 (insert문)
			sql.delete(0, sql.length());
			sql.append(" INSERT INTO tb_bbs(bbsno, wname, subject, content, passwd, ip, grpno, indent, ansnum) ");
			sql.append(" VALUES (bbs_seq.nextval, ?, ?, ?, ?, ? ,? ,? ,?) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getIp());
			pstmt.setInt(6, grpno);
			pstmt.setInt(7, indent);
			pstmt.setInt(8, ansnum);
			
			cnt=pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("답변쓰기 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
	public int count2(String col, String word) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			
			sql.append(" select count(*) as cnt ");
			sql.append(" from tb_bbs ");
			
			if(word.length()>=1) { //검색어가 존재한다면
				String search = "";
				if(col.equals("subject_content")) {
					search += " WHERE SUBJECT LIKE '%" + word + "%' ";
					search += " OR CONTENT LIKE '%" + word + "%' ";
				} else if(col.equals("subject")){
					search += " where subject like '%" + word + "%' ";
				} else if(col.equals("content")) {
					search += " where content like '%" + word + "%' ";
				} else if(col.equals("wname")) {
					search += " where wname like '%" + word + "%' ";
				}
				
				sql.append(search);
			}
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		}catch(Exception e) {
			System.out.println("상세보기실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return cnt;
	}
	
	public ArrayList<BbsDTO> list2(String col, String word){
		ArrayList<BbsDTO> list = null;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select bbsno, wname, subject, readcnt, regdt, indent" );
			sql.append(" from tb_bbs " );
			if(word.length()>=1) { //검색어가 존재한다면
				String search = "";
				if(col.equals("subject_content")) {
					search += " WHERE SUBJECT LIKE '%" + word + "%' ";
					search += " OR CONTENT LIKE '%" + word + "%' ";
				} else if(col.equals("subject")){
					search += " where subject like '%" + word + "%' ";
				} else if(col.equals("content")) {
					search += " where content like '%" + word + "%' ";
				} else if(col.equals("wname")) {
					search += " where wname like '%" + word + "%' ";
				}
				
				sql.append(search);
			}
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
	
	public ArrayList<BbsDTO> list3(String col, String word, int nowPage, int recordPerPage){
		ArrayList<BbsDTO> list = null;
		
		//페이지당 출력할 행의 갯수(10개를 기준)
		//1 페이지 : WHERE r>=1 AND r<=10;
		//2 페이지 : WHERE r>=11 AND r<=10;
		//3 페이지 : WHERE r>=21 AND r<=20;
		int startRow = (((nowPage-1) * recordPerPage) + 1);
		int endRow = nowPage * recordPerPage;
		
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			
			word = word.trim();
			
			if(word.length()==0) { //검색어가 존재하지 않는 경우
				sql.append(" select * ");
				sql.append("FROM ( ");
				sql.append(" select BBSNO, SUBJECT, WNAME, READCNT, INDENT, REGDT,rownum as r ");
				sql.append(" 	from( ");
				sql.append(" select BBSNO, SUBJECT, WNAME, READCNT, INDENT, REGDT ");
				sql.append(" from tb_bbs ");
				sql.append(" ORDER BY GRPNO DESC, ANSNUM ASC ");
				sql.append(") ");
				sql.append(") ");
				sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow);
				
			} else {  //검색어가 존재하는 경우
				sql.append(" select * ");
				sql.append("FROM ( ");
				sql.append(" select BBSNO, SUBJECT, WNAME, READCNT, INDENT, REGDT,rownum as r ");
				sql.append(" 	from( ");
				sql.append(" select BBSNO, SUBJECT, WNAME, READCNT, INDENT, REGDT ");
				sql.append(" from tb_bbs ");
					String search = "";
					if(col.equals("subject_content")) {
						search += " WHERE SUBJECT LIKE '%" + word + "%' ";
						search += " OR CONTENT LIKE '%" + word + "%' ";
					} else if(col.equals("subject")){
						search += " where subject like '%" + word + "%' ";
					} else if(col.equals("content")) {
						search += " where content like '%" + word + "%' ";
					} else if(col.equals("wname")) {
						search += " where wname like '%" + word + "%' ";
					}
				sql.append(search);
				sql.append(" ORDER BY GRPNO DESC, ANSNUM ASC ");
				sql.append(") ");
				sql.append(") ");
				sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow);
			}
			
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
	
}
