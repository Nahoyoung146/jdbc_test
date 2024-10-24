package jdbc_test;

import java.sql.*;

class DB {
	Connection con; // 접속을 해주는 역할
	PreparedStatement ps; // 명령어를 전송해주는 역할, 전송 개체
	ResultSet rs; // 명령어의 결과를 받아오는 역할

	public DB() {
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
	}

	public void getList() {
		String sql = "select * from newst";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Ex01 {
	public static void main(String[] args) {
		DB db = new DB();
		db.getList();
	}
}