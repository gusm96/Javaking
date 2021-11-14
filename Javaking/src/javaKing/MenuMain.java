package javaKing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaKing.ConnectionProvider;

public class MenuMain {
	
	static Scanner scanner = new Scanner(System.in);
	
	public void menuMain() {
		Cart cart = new Cart();
		MenuDao menuDao = MenuDao.getInstance();
		Connection conn = null;

		List<MenuDto> list = null;
		List<CartDto> cartList = new ArrayList<CartDto>();
		int menuNum =0;

		try {
			conn = ConnectionProvider.getConnection();

			// 트랜젝션 일의 단위
			conn.setAutoCommit(false);

			// 메뉴 리스트를 확인
			list = menuDao.selectAllList(conn);
			while(true) {
				System.out.println("메뉴를 선택합니다.\n");
				System.out.println("==================================================");
				System.out.println("1. 햄버거 세트 2. 햄버거 3. 사이드 메뉴  4. 음료");
				System.out.print("> ");
				int select = scanner.nextInt();
				System.out.println(menuDao.selectByMtype(conn, select));
				System.out.println("메뉴를 선택하세요. >");
				menuNum = scanner.nextInt();
				System.out.println("수량을 선택하세요. >");
				int count = scanner.nextInt();
				menuDao.selectMenu(conn,menuNum,count);
				conn.commit();
				try {
					System.out.println("장바구니에 담는중...");
					cart.addCart(cartList,menuNum);
					Thread.sleep(3000);
					System.out.println("선택하신 메뉴를 장바구니에 담았습니다.");
					System.out.println("1. 계속 주문하기 2. 장바구니 보기");
					System.out.print("> ");
					int userChoice = scanner.nextInt();
					
					if(userChoice == 2){
						cart.showCart(cartList);
						break;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			System.out.println("--------------------------------------------------\n");

			System.out.println("==================================================");

			
		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
		
	}
	
}
