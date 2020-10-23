package co.hj.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="hj";
	private String password="hj";
	
	public Connection conn; //db연결객체
	public DAO() {
		try {
			Class.forName(driver); //드라이버 로드
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("DB연결 성공");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
