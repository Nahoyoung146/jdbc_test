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
					// System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getAge());
					System.out.println(list.get(i));
				}
				break;
			case 3:
				System.out.print("검색할 id 입력 : ");
				String inputid = input.next();
				// select * from newst where id=''
				NewStDTO dto = dao.selectOne(inputid);
				if (dto != null) {
					System.out.println(inputid + "님의 정보");
					System.out.println("id : " + dto.getId());
					System.out.println("name : " + dto.getName());
					System.out.println("age : " + dto.getAge());
				} else {
					System.out.println("존재하지 않는 id 입니다.\n다시 검색하세요!!!!");
				}
				break;
			case 4:
				// dao.insert(id,name,age)
				// dao.insert(dto);
				System.out.print("저장 id : ");
				String id = input.next();
				System.out.print("저장 name : ");
				String name = input.next();
				System.out.print("저장 age : ");
				int age = input.nextInt();
				int result = dao.insert(id, name, age);
				if (result == 0)
					System.out.println("문제가 발생했습니다!!!");
				else
					System.out.println("데이터 추가 완료!!!");
				break;
			case 5:
				NewStDTO d = new NewStDTO();
				System.out.print("수정할 id : ");
				id = input.next();
				System.out.print("수정 name : ");
				name = input.next();
				System.out.print("수정 age : ");
				age = input.nextInt();
				d.setId(id);
				d.setName(name);
				d.setAge(age);
				result = dao.update(d);
				if (result == 0)
					System.out.println("수정 실패!!!");
				else
					System.out.println("수정 완료!!!");
				break;
			case 6:
				System.out.print("삭제할 id : ");
				id = input.next();
				result = dao.delete(id);
				if (result == 0)
					System.out.println("문제가 발생했습니다!!!");
				else
					System.out.println("데이터 삭제 완료!!!");
				break;
			case 7:
				System.out.println("프로그램 종료");
				return;
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