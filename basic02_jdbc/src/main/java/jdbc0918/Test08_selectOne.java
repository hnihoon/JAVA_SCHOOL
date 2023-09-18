package jdbc0918;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.ldap.ManageReferralControl;

public class Test08_selectOne {

	public static void main(String[] args) {
		
		int sno = 101;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select문을 실행한 결과(테이블)을 저장
		
		try {
			
			String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
			String user 	= "system";
			String password = "1234";
			String driver 	= "oracle.jdbc.driver.OracleDriver"; //objdbc8.jar
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * ");
			sql.append(" FROM sungjuk ");
			sql.append(" WHERE sno = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, sno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("자료있음");
				
				//1)칼럼 순서 접근
				System.out.println(rs.getInt(1)); 		//1번 칼럼. sno
				System.out.println(rs.getString(2)); 	//2번 칼럼. uname
				System.out.println(rs.getInt(3)); 		//3번 칼럼. kor	
				System.out.println(rs.getInt(4)); 		//4번 칼럼. eng	
				System.out.println(rs.getInt(5)); 		//5번 칼럼. mat	
				System.out.println(rs.getInt(6)); 		//6번 칼럼. tot	
				System.out.println(rs.getInt(7)); 		//7번 칼럼. aver	
				System.out.println(rs.getString(8)); 		//8번 칼럼. addr	
				System.out.println(rs.getString(9)); 		//9번 칼럼. wdate
				
				//2)칼럼명으로 접근
				System.out.println(rs.getInt("sno")); 		//1번 칼럼. sno
				System.out.println(rs.getString("uname")); 	//2번 칼럼. uname
				System.out.println(rs.getInt("kor")); 		//3번 칼럼. kor	
				System.out.println(rs.getInt("eng")); 		//4번 칼럼. eng	
				System.out.println(rs.getInt("mat")); 		//5번 칼럼. mat	
				System.out.println(rs.getInt("tot")); 		//6번 칼럼. tot	
				System.out.println(rs.getInt("aver")); 		//7번 칼럼. aver	
				System.out.println(rs.getString("addr")); 		//8번 칼럼. addr	
				System.out.println(rs.getString("wdate")); 		//9번 칼럼. wdate
				
			} else {
				System.out.println("자료없음");
			}
			
			
		}catch(Exception e) {
			System.out.println("오라클 JDBC 조회 실패 : " + e);
		} finally {//자원반납(순서주의)
			try {
				if(rs!=null) {rs.close();}
			} catch(Exception e) {}
			
			try {
				if(pstmt!=null) {pstmt.close();}
			}catch(Exception e) {}
			
			try {
				if(con!=null) {con.close();}
			} catch(Exception e) {}
		} 
		
	}
}
