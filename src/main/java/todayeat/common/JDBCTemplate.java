package todayeat.common;

import java.sql.*;

public class JDBCTemplate {
	
	private static JDBCTemplate instance;
	private static Connection conn;
	
	// JDBCTemplate 생성 - 싱글톤 패턴
	public static JDBCTemplate getInstance() {
		if(instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}
	
	public Connection createConnection() {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "TODAYEAT";
		String password = "TODAYEAT";
		
		try {
			if(conn == null || conn.isClosed()) {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, user, password);
				conn.setAutoCommit(false);	// 오토커밋 해제
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	// conn 자원 해제
	public void close(Connection conn) {
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 커밋 메소드
	public void commit(Connection conn) {
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 롤백 메소드
	public void rollback(Connection conn) {
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
