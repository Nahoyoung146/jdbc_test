package Na_db_common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 명령어 사용을 위한 준비 단계
			System.out.println("드라이브 로드 성공");
			String id, pwd, url;
			id = "c##ghdud024";
			pwd = "ghdud1532";
			url = "jdbc:oracle:thin:@localhost:1521:xe"; // orcl
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getConnect2() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 명령어 사용을 위한 준비 단계
			System.out.println("드라이브 로드 성공");
			String id, pwd, url;
			id = "c##ghdud024";
			pwd = "ghdud1532";
			url = "jdbc:oracle:thin:@localhost:1521:xe"; // orcl
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}