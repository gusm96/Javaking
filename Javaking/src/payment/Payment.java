package payment;

import java.util.Scanner;

// 결제 방식을 정한다.
// 결제는 현금과 카드로 구분

public class Payment {
	// 변수
	static Scanner scanner = new Scanner(System.in);

	// 결제 방식을 묻는 메소드
	public static int select() {
		// 1. 카드 2. 현금
		System.out.println("\n==================================================");
		System.out.println("결제 방식을 선택해주세요.\n1. 신용/체크카드 2. 카카오페이 3. 만나서 현금");
		System.out.print("> ");
		int userChoice = scanner.nextInt();
		while (true) {
			if (userChoice <= 0 || userChoice > 3) {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("결제 방식을 선택해주세요.\n1. 신용/체크카드 2. 카카오페이 3. 만나서 현금");

				userChoice = scanner.nextInt();
			} else {
				if (userChoice == 1) {
					scanner.nextLine();
					System.out.println("신용/체크카드를 선택하였습니다.");
					System.out.println("카드번호를 입력해주세요.");
					System.out.print("> ");
					scanner.nextLine();

					System.out.println("CVC 3자리를 입력해주세요.");
					System.out.print("> ");
					scanner.nextInt();
					scanner.nextLine();
					System.out.println("카드 비밀번호를 입력하세요.");
					System.out.print("> ");
					scanner.nextLine();
					// 3초간 지연 시키기
					try {
						System.out.println("결제 진행중...");
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("결제 완료되었습니다.");
				} else if (userChoice == 2) {
					// 3초간 지연 시키기
					try {
						System.out.println("카카오페이로 결제를 진행...");
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("결제 완료되었습니다.");
				} else {
					// 3초간 지연 시키기
					System.out.println("만나서 현금 결제를 선택하였습니다.");
					try {
						System.out.println("주문 진행중...");
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("주문 완료되었습니다.");
					System.out.println("라이더가 도착하기전에 미리 현금을 준비해 주시길 바랍니다.");
				}
			}

			break;

		}
		return userChoice;

	}

	public static void receap(int userChoice) {
		System.out.println("\n==================================================");
		try {
			System.out.println("영수증 발급중...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n==================================================");

		System.out.println("주문 정보");
		// sql문 insert into dorder values (주
		if (userChoice == 1 || userChoice == 2) {
			// DB dorder 의 otype에 "미리결제" 로
			System.out.println("결제수단: 미리결제");
		} else {
			// DB dorder 의 otype에 "현금결제" 로
			System.out.println("결제수단: 만나서 현금결제");
		}
	}

	public static void main(String[] args) {
		receap(select());

	}
}
