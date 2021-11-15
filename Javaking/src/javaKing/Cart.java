package javaKing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javaKing.ConnectionProvider;
import javaKing.Payment;

public class Cart {
	static Scanner scanner = new Scanner(System.in);
	MenuMain menuMain = new MenuMain();
	Payment payment = new Payment();

	public void addCart(List<CartDto> list, int menuNum) {
		CartDao cartDao = CartDao.getInstance();

		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();

			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!
			if (menuNum != 0) {
				list.add(cartDao.selectByCartno(conn, menuNum));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
	}

	public void showCart(List<CartDto> list) {
		int totalPrice = 0;
		// Men 리스트를 출력해주는 for each문
		System.out.println("\n==================================================\n");
		for (CartDto cart : list) {
			System.out.println("메뉴: " + cart.getMname() + "\t수량: " + cart.getMcount() + "\t금액: "
					+ cart.getMprice() * cart.getMcount());
		}
		for (int i = 0; i < list.size(); i++) {
			totalPrice += list.get(i).getMprice() * list.get(i).getMcount();
		}
		System.out.println("\n--------------------------------------------------\n");
		System.out.println("최종금액: " + totalPrice);

		System.out.println("\n==================================================\n");
		System.out.println("1. 취소하기 2. 결제하기");
		System.out.print("> ");
		int select = scanner.nextInt();
		while (select <= 0 || select > 2) {
			System.out.println("잘못 입력하였습니다.");
			System.out.println("다시 입력해 주세요.");
			System.out.print("> ");
			select = scanner.nextInt();
		}
		if (select == 1) {
			// 취소메소드
			try {
				System.out.println("메뉴 선택화면으로 들아갑니다...");
				Thread.sleep(3000);
				menuMain.menuMain();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (select == 2) {
			// 결제메소드
			int pay = payment.selectPayment();
			payment.printReceipt(pay, list, totalPrice);
		}
	}
}
