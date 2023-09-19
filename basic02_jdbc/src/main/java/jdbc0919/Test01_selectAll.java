package jdbc0919;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01_selectAll {

	public static void main(String[] args) {
		//sungjuk 테이블 전체 행 조회하기
		
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
					
			//문자열 연결
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT sno, uname, kor, eng, mat, tot, aver, addr, wdate ");
			sql.append(" FROM sungjuk ");
			sql.append(" ORDER BY sno DESC ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			//pstmt.executeQuery();  SELECT 시(executeQuery())
			//pstmt.executeUpdate(); INSERT,UPDATE,DELETE 시
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //cursor가 있는지?
				System.out.println("자료있음~");
				
				do {
					System.out.print(rs.getInt("sno") + " ");
					System.out.print(rs.getString("uname") + " ");
					System.out.print(rs.getInt("kor") + " ");
					System.out.print(rs.getInt("eng") + " ");
					System.out.print(rs.getInt("mat") + " ");
					System.out.print(rs.getInt("tot") + " ");
					System.out.print(rs.getInt("aver") + " ");
					System.out.print(rs.getString("addr") + " ");
					System.out.print(rs.getString("wdate") + " ");
					System.out.println();

				}while(rs.next()); //다음 cursor가 있는지?
				
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

