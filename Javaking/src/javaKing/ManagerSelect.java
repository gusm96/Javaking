package javaKing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManagerSelect {
	public static void admin() {
		Scanner sc = new Scanner(System.in);
		Connection conn =null;
		
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e1) {
			
		}
	
		while(true) {
			System.out.println("**********관리자메뉴**********");
			System.out.println("1. 회원 정보 리스트");
			System.out.println("2. 상품 메뉴 리스트");
			System.out.println("3. 상품 신메뉴 추가");
			System.out.println("4. 상품 메뉴 수정");
			System.out.println("5. 상품 메뉴 삭제");
			System.out.println("6. 나가기");
			System.out.print("> ");
			int select = Integer.parseInt(sc.nextLine());

			switch(select) {
			case 1: 
				ManagerMain.memberStart();
				break;
			case 2:
				ManagerMain.menuAll();
				break;
			case 3:
				ManagerMain.newMenu();
				break;
			case 4:
				ManagerMain.updateMenu();
				break;
			case 5:
				ManagerMain.deleteMenu();
				break;
			
			case 6:
				System.out.println("로그아웃 되었습니다.");
				
				StartUi.home();
			default :
				System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인후 선택해주세요.");
		}
	
		}
	}
	public static void main(String[] args) {
		admin();
	}
}
