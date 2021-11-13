package javaKing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javaKing.ConnectionProvider;

public class MenuMain {
	
	static Scanner scanner = new Scanner(System.in);

	
	public static int menuMain() {
		MenuDao menuDao = MenuDao.getInstance();

		Connection conn = null;

		List<MenuDto> list = null;
		int menuNum =0;

		try {
			conn = ConnectionProvider.getConnection();

			// 트랜젝션 일의 단위
			conn.setAutoCommit(false);

			// 메뉴 리스트를 확인
			list = menuDao.selectAllList(conn);

			System.out.println("메뉴를 선택합니다.\n");
			System.out.println("==================================================");
			System.out.println("1. 햄버거 세트 2. 햄버거 3. 사이드 메뉴 4. 음료");
			System.out.print("> ");
			int select = scanner.nextInt();
			System.out.println(menuDao.selectByMtype(conn, select));
			menuNum= menuDao.selectMenu(conn);
			System.out.println("--------------------------------------------------\n");

			System.out.println("==================================================");

			conn.commit();

		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
		return menuNum;
	}
	
	public
	
}
