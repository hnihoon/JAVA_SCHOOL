package jdbc0918;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.ldap.ManageReferralControl;

public class Test04_delete {

	public static void main(String[] args) {
		//sungjuk 테이블 행 추가 연습
		
		try {
			
			String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
			String user 	= "system";
			String password = "1234";
			String driver 	= "oracle.jdbc.driver.OracleDriver"; //objdbc8.jar
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");
			
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM sungjuk WHERE sno=84");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println("행 삭제 실패!!");
			} else {
				System.out.println("행 삭제 성공!!");
			}
			
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println("오라클 JDBC 실패 : " + e);
		}
		
	}
}
