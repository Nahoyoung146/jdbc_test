package Na_db_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Na_db_common.DBConnect;
import Na_db_dao.NewStDAO;
import Na_db_dto.NewStDTO;

public class DBServiceimpl implements DBService {
	NewStDAO dao;

	public DBServiceimpl() {
		dao = new NewStDAO();
	}

	public void display() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("1. 모든 데이터 확인(service)");
			System.out.println("2. 모든 데이터 확인(dao)");
			System.out.println("3. 검색 데이터 확인");
			System.out.println("4. 데이터 추가");
			System.out.println("5. 데이터 수정");
			System.out.println("6. 데이터 삭제");
			System.out.println("7. 종료");
			int num = input.nextInt();
			switch (num) {
			case 1:
				Connection con = DBConnect.getConnect2();
				String sql = "select * from newst";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString("id"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("--- dao 연동 출력 ---");
				// dao.getList();
				ArrayList<NewStDTO> list = dao.getList2();
				System.out.println("아이디\t이름\t나이");
				System.out.println("---------------------------");
				for (int i = 0; i < list.size(); i++) {
					NewStDTO d = list.get(i);
					System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getAge());
				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}
		}

		/*
		 * System.out.println("disp 연동"); Connection con=null;
		 * System.out.println("연동 전 con : " + con); //DBConnect db = new DBConnect();
		 * //con = db.getConnect(); con = DBConnect.getConnect2();
		 * System.out.println("연동 후 con : " + con);
		 */
	}
}