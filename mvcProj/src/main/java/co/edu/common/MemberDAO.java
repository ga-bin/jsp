package co.edu.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MemberDAO {
	// oracle db정보
		private String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		private String oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String connectedId = "hr";
		private String connectedPwd = "hr";
		
		// 공통적으로 사용할 필드
		protected Connection conn;
		protected Statement stmt;
		protected PreparedStatement pstmt;
		protected ResultSet rs;
		
		
		public void connect() {
			try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
			} catch(ClassNotFoundException e) {
				System.out.println("jdbc_driver 로딩 실패");
			} catch(SQLException e) {
				System.out.println("db연결 실패");
				
			}
		}
		
		
		public void disconnect() {
			if (rs != null)
				try {
					rs.close();
					if (stmt != null) stmt.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		// 입력처리
		public void insertMember(MemberVO vo) {			
			try {
				String sql = "insert into member1 (id, name, passwd, mail) values(?, ?, ?, ?)";
				connect();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getPasswd());
				pstmt.setString(4, vo.getMail());
				int r = pstmt.executeUpdate();
				
				System.out.println(r+ "건 입력.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();
			}
			
		}
}
