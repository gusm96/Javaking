package payment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import payment.ConnectionProvider;
import payment.Payment;

public class Cart {
	static Scanner scanner = new Scanner(System.in);

	public static int addCart() {
		int totalPrice = 0;
		CartDao cartDao = CartDao.getInstance();

		Connection conn = null;
		List<CartDto> list = new ArrayList<CartDto>();

		try {
			conn = ConnectionProvider.getConnection();

			// Ʈ������ ���� ����
			conn.setAutoCommit(false); // Ʈ�������� ��Ʈ�� �ϰڴ�!

			int mid;
			while (true) {
				System.out.println("�޴� ��ȣ�� �Է��ϼ���./������ ������ 0���� ��������");
				System.out.print("> ");
				mid = scanner.nextInt();
				if (mid != 0) {
					list.add(cartDao.selectByCartno(conn, mid));
				} else {
					break;
				}
			}

			for (CartDto cart : list) {
				System.out.println("�޴�: " + cart.mname + "\t����: " + cart.mnum + "\t�ݾ�: " + cart.mprice * cart.mnum);

			}
			for (int i = 0; i < list.size(); i++) {

				totalPrice += list.get(i).mprice * list.get(i).mnum;
			}

			System.out.println("�����ݾ�: " + totalPrice);

			System.out.println("=============================");
			System.out.println("1. ����ϱ� 2. �����ϱ�");
			System.out.print("> ");
			int select;
			select = scanner.nextInt();
			while (select <= 0 || select > 2) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				System.out.println("�ٽ� �Է��� �ּ���.");
				System.out.print("> ");
				select = scanner.nextInt();
			}
			if (select == 1) {
				// ��Ҹ޼ҵ�
				
			} else if (select == 2) {
				// �����޼ҵ�
				Payment.receipt(Payment.select());
			}

		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}

		return totalPrice;
	}
	
}