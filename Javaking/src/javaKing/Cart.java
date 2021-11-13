package javaKing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaKing.ConnectionProvider;
import javaKing.Payment;

public class Cart {
	static Scanner scanner = new Scanner(System.in);

	public static void addCart(int userChoice) {
		int totalPrice = 0;
		CartDao cartDao = CartDao.getInstance();

		Connection conn = null;
		List<CartDto> list = new ArrayList<CartDto>();

		try {
			conn = ConnectionProvider.getConnection();

			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!

			int mid;
			if (userChoice == 2) {

				mid = MenuMain.menuMain();
				while (true) {
					if (mid != 0) {
						list.add(cartDao.selectByCartno(conn, mid));
						for (CartDto cart : list) {
							System.out.println("메뉴: " + cart.getMname() + "\t수량: " + cart.getMcount() + "\t금액: "
									+ cart.getMprice() * cart.getMcount());

						}
					} else {
						break;
					}

				}
			} else if (userChoice == 1) {

				for (int i = 0; i < list.size(); i++) {

					totalPrice += list.get(i).getMprice() * list.get(i).getMcount();
				}

				System.out.println("최종금액: " + totalPrice);

				System.out.println("=============================");
				System.out.println("1. 취소하기 2. 결제하기");
				System.out.print("> ");
				int select;
				select = scanner.nextInt();
				while (select <= 0 || select > 2) {
					System.out.println("잘못 입력하였습니다.");
					System.out.println("다시 입력해 주세요.");
					System.out.print("> ");
					select = scanner.nextInt();
				}
				if (select == 1) {
					// 취소메소드

				} else if (select == 2) {
					// 결제메소드
					Payment.receipt(LoginView.logId, Payment.select(), totalPrice);
				}
			}

		} catch (

		SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}

	}
}
