package Na_db_common;

import java.util.Scanner;

import Na_db_service.DBService;
import Na_db_service.DBServiceimpl;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DBService st = new DBServiceimpl();
		while (true) {
			System.out.println("1. new st 이동");
			System.out.println("2. 다른 사용자 이동");
			System.out.println("3. 종료");
			int num = input.nextInt();
			switch (num) {
			case 1:
				st.display();
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
	}
}