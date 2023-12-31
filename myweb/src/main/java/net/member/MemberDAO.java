package net.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.bbs.BbsDTO;
import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.MyAuthenticator;

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
	
///////////////////////////////내가 작성한 이메일 관련 코드 시작 ///////////////////////////////

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
	
///////////////////////////////내가 작성한 이메일 관련 코드 끝 ///////////////////////////////
	
/////////////////////////강사님이 작성해주신 이메일 관련 코드 시작 //////////////////////////////
	
	public boolean findID(MemberDTO dto) {
		boolean flag = false;
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
			
			//1) 아이디 가져오기
			String id=rs.getString("id");
			
			//2) 임시비밀번호
			//	[임시비밀번호발급]
			//	->대문자, 소문자, 숫자를 이용해서 랜덤하게 10글자를 만들기
			String[] ch = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
					, "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"
					, "1","2","3","4","5","6","7","8","9","0"
			}; //ch[0]~ch[61]
			
			//ch배열에서 랜덤하게 10글자 뽑아서 가져오기
			StringBuilder imsiPW = new StringBuilder();//임시비밀번호
			for(int i=0; i<10; i++) {
				int num=(int)(Math.random()*ch.length);
				imsiPW.append(ch[num]);
			}
			
			//발급 받은 임시 비밀번호로 테이블 수정하기
			sql=new StringBuilder();
			sql.append(" update MEMBER " );
			sql.append(" set passwd=? ");
			sql.append(" where mname=? and email=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, imsiPW.toString());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getEmail());
			
			int cnt = pstmt.executeUpdate();
			if(cnt==1) { //임시 비밀번호 테이블이 수정되었다면
				//아아디(id)와 임시비밀번호(imsiPW)를 웹 메일 전송하기
				
				//메일내용
				String content="※ 임시 비밀번호로 로그인 한 후, 회원 정보 수정에서 비밀번호를 변경하시기 바랍니다.";
				content += "<hr>";
				content += "<table border='1'>";
				content += "<tr>";
				content += "	<th>아이디</th>";
				content += "	<td>" + id + "</td>";
				content += "</tr>";
				content += "<tr>";
				content += "	<th>임시비밀번호</th>";
				content += "	<td>" + imsiPW.toString() + "</td>";
				content += "</tr>";
				content += "</table>";
				
				String mailServer = "mw-002.cafe24.com"; 
				Properties props = new Properties();
				props.put("mail.smtp.host", mailServer);
				props.put("mail.smtp.auth", true);
				
				Authenticator myAuth = new MyAuthenticator();
				
				Session sess = Session.getInstance(props, myAuth);
				
				InternetAddress[] address = { new InternetAddress(dto.getEmail())};
				Message msg = new MimeMessage(sess);
				msg.setRecipients(Message.RecipientType.TO, address);
				msg.setFrom(new InternetAddress("webmaster@itwill.co.kr"));
				msg.setSubject("MyWeb 아이디/비밀번호 입니다.");
				msg.setContent(content, "text/html; charset=UTF-8");
				msg.setSentDate(new Date());
				Transport.send(msg);
				
				flag=true;
			}
			
		}
	}catch(Exception e) {
		System.out.println("상세보기실패 : " + e);
	} finally {
		DBClose.close(con, pstmt);
	}
	return flag;
}

/////////////////////////강사님이 작성해주신 이메일 관련 코드 끝 //////////////////////////////
	
/////////////////////////////회원정보수정 관련 코드 시작 //////////////////////////////////
	
	public MemberDTO read(String id) {
		MemberDTO dto = null;
		try {
			con = dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select ID ,PASSWD ,MNAME ,TEL ,EMAIL ,ZIPCODE ,ADDRESS1 ,ADDRESS2 ,JOB ,MLEVEL ,MDATE  " );
			sql.append(" from member " );
			sql.append(" where id=? " );
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setMname(rs.getString("mname"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress1(rs.getString("address1"));
				dto.setAddress2(rs.getString("address2"));
				dto.setJob(rs.getString("job"));
				dto.setMlevel(rs.getString("mlevel"));
				dto.setMdate(rs.getString("mdate"));
			}
			
		} catch(Exception e) {
			System.out.println("상세보기실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}
	
}