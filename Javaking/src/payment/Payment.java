package payment;

import java.util.Scanner;

// ���� ����� ���Ѵ�.
// ������ ���ݰ� ī��� ����

public class Payment {
	// ����
	static Scanner scanner = new Scanner(System.in);

	// ���� ����� ���� �޼ҵ�
	public static int select() {
		// 1. ī�� 2. ����
		System.out.println("\n==================================================");
		System.out.println("���� ����� �������ּ���.\n1. �ſ�/üũī�� 2. īī������ 3. ������ ����");
		System.out.print("> ");
		int userChoice = scanner.nextInt();
		while (true) {
			if (userChoice <= 0 || userChoice > 3) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				System.out.println("���� ����� �������ּ���.\n1. �ſ�/üũī�� 2. īī������ 3. ������ ����");

				userChoice = scanner.nextInt();
			} else {
				if (userChoice == 1) {
					scanner.nextLine();
					System.out.println("�ſ�/üũī�带 �����Ͽ����ϴ�.");
					System.out.println("ī���ȣ�� �Է����ּ���.");
					System.out.print("> ");
					scanner.nextLine();

					System.out.println("CVC 3�ڸ��� �Է����ּ���.");
					System.out.print("> ");
					scanner.nextInt();
					scanner.nextLine();
					System.out.println("ī�� ��й�ȣ�� �Է��ϼ���.");
					System.out.print("> ");
					scanner.nextLine();
					// 3�ʰ� ���� ��Ű��
					try {
						System.out.println("���� ������...");
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("���� �Ϸ�Ǿ����ϴ�.");
				} else if (userChoice == 2) {
					// 3�ʰ� ���� ��Ű��
					try {
						System.out.println("īī�����̷� ������ ����...");
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("���� �Ϸ�Ǿ����ϴ�.");
				} else {
					// 3�ʰ� ���� ��Ű��
					System.out.println("������ ���� ������ �����Ͽ����ϴ�.");
					try {
						System.out.println("�ֹ� ������...");
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("�ֹ� �Ϸ�Ǿ����ϴ�.");
					System.out.println("���̴��� �����ϱ����� �̸� ������ �غ��� �ֽñ� �ٶ��ϴ�.");
				}
			}

			break;

		}
		return userChoice;

	}

	public static void receap(int userChoice) {
		System.out.println("\n==================================================");
		try {
			System.out.println("������ �߱���...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n==================================================");

		System.out.println("�ֹ� ����");
		// sql�� insert into dorder values (��
		if (userChoice == 1 || userChoice == 2) {
			// DB dorder �� otype�� "�̸�����" ��
			System.out.println("��������: �̸�����");
		} else {
			// DB dorder �� otype�� "���ݰ���" ��
			System.out.println("��������: ������ ���ݰ���");
		}
	}

	public static void main(String[] args) {
		receap(select());

	}
}
