package jdbc0919;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test05_selectJoin {

	public static void main(String[] args) {
		//문제) 학번 g1001이 수강신청한 과목을 과목코드별로 조회하시오
        /*     
            g1001      d001     HTML
            g1001      p001     JAVA
            g1001      p002     Oracle
            g1001      p003     JSP
            g1001      p004     Python
            g1001      p005     AJAX      
        */
		
		String hakno="g1001";
		
		Connection con = null;  		//DB연결
		PreparedStatement pstmt = null;	//SQL문으로 변환
		ResultSet rs = null;  			//SELECT 시 결과보관
		
		try {
			
			String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
			String user 	= "system";
			String password = "1234";
			String driver 	= "oracle.jdbc.driver.OracleDriver"; //objdbc8.jar
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select su.hakno, su.gcode, gw.gname ");
			sql.append(" from tb_sugang su inner join tb_gwamok gw\r\n" );
			sql.append(" on su.gcode = gw.gcode ");
			sql.append(" where su.hakno= ? ");
			sql.append(" ORDER BY SU.gcode ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, hakno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				System.out.println("자료있음~");
				
				do {
//					System.out.print(rs.getString(1) + " ");  
//					System.out.print(rs.getString(2) + " ");
//					System.out.print(rs.getString(3) + " ");
					System.out.print(rs.getString("hakno") + " ");
					System.out.print(rs.getString("gcode") + " ");
					System.out.print(rs.getString("gname") + " ");
					System.out.println();
					
				}while(rs.next()); 
				
			} else {
				System.out.println("자료없음!");
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

