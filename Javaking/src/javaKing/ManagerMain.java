package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManagerMain {
	static Scanner sc = new Scanner(System.in);

	public void adminMenu() {
	
		while(true) {
			System.out.println("*****************관리자메뉴*****************");
			System.out.println("1. 회원 정보 리스트");
			System.out.println("2. 상품 메뉴 리스트");
			System.out.println("3. 상품 신메뉴 추가");
			System.out.println("4. 상품 메뉴 가격 수정");
			System.out.println("5. 상품 메뉴 삭제");
			System.out.println("6. 나가기");
			System.out.print("> ");
			int select = sc.nextInt();

			switch(select) {
			case 1: 
				memberStart();
				break;
			case 2:
				menuAll();
				break;
			case 3:
				newMenu();
				break;
			case 4:
				updateMenu();
				break;
			case 5:
				deleteMenu();
				break;
			
			case 6:
				System.out.println("로그아웃 되었습니다.");
				System.out.println("\n==================================================\n");
				StartUi.home();
			default :
				System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인후 선택해주세요.");
		}
	
		}
	}
	// 회원 정보 리스트 전체출력 메소드
	public void memberStart() {

		ManagerMemberDao memberDao = ManagerMemberDao.getInstance();
		Connection conn = null;
		List<UserDto> list = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			list = memberDao.memberAllList(conn);

			System.out.println("회원 정보 리스트");
			for (UserDto member : list) {
				System.out.println("회원번호: " + member.getId() + "\t아이디: " + member.getUserid());
			}
			System.out.println("==================================================");
			System.out.println("상세보기할 회원번호를 입력해주세요.");
			System.out.print("> ");
			int id = sc.nextInt();

			UserDto memberDto = memberDao.MemberDetail(conn, id);
			System.out.println(memberDto.getUserid() + "님의 회원정보: \n" + memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//상품 메뉴 출력 메소드
	public void menuAll() {
		ManagerMenuDao menuDao = ManagerMenuDao.getInstance();
		Connection conn = null;
		List<MenuDto> list = null;
		try {
			conn = ConnectionProvider.getConnection();
			System.out.println("1. 세트메뉴 2. 햄버거 3. 사이드  4. 음료");
			System.out.print("> ");
			int sMtype = sc.nextInt();		
			conn.setAutoCommit(false);
			list = menuDao.selectByMtype(conn, sMtype);

			System.out.println("상품 메뉴 리스트");
			for (MenuDto menu : list) {
				System.out.println(menu.toString());
			}

			System.out.println("==================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//상품 신메뉴 추가 메소드
	public  void newMenu() {
		ManagerMenuDao menuDao = ManagerMenuDao.getInstance();
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			System.out.println("신메뉴 번호종류 선택");
			System.out.println("1. 세트메뉴 2. 햄버거 3. 사이드  4. 음료");
			System.out.print("> ");
			int sMtype = sc.nextInt();
			sc.nextLine();
			conn.setAutoCommit(false);

			System.out.println("메뉴명을 입력해주세요.");
			System.out.print("> ");
			String mname = sc.nextLine();
			System.out.println("메뉴가격을 입력해주세요.");
			System.out.print("> ");
			int mprice = sc.nextInt();
			MenuDto menuDto = new MenuDto(0, mname, mprice, sMtype);
			menuDao.insertMenu(conn, menuDto);
			conn.commit();
			System.out.println("입력이 완료되었습니다.");
			System.out.println("==================================================");
		} catch (SQLException e) {
			System.out.println("입력 실패");
			e.printStackTrace();
		}
	}
	//상품 메뉴 수정메소드
	public  void updateMenu() {
		ManagerMenuDao menuDao = ManagerMenuDao.getInstance();
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			menuAll();
			System.out.println("수정할 메뉴 번호를 입력하세요.");
			System.out.print("> ");
			int mid = sc.nextInt();
			System.out.println("수정할 금액을 입력하세요.");
			System.out.print("> ");
			int mprice = sc.nextInt();

			menuDao.updateMenu(conn, mid, mprice);
			conn.setAutoCommit(false);
			conn.commit(); 
			System.out.println("수정이 완료되었습니다.");
			System.out.println("==================================================");
		} catch (SQLException e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		}
	}
	//상품 삭제 메소드
	public void deleteMenu() {
		ManagerMenuDao menuDao = ManagerMenuDao.getInstance();
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			menuAll();
			System.out.println("삭제할 메뉴 번호를 입력하세요.");
			System.out.print("> ");
			int mid = sc.nextInt();
			menuDao.deleteMenu(conn, mid);
			conn.setAutoCommit(false); 
			conn.commit(); 
			System.out.println("삭제가 완료되었습니다.");
			System.out.println("==================================================");
		} catch (SQLException e) {
			System.out.println("삭제 실패");
			e.printStackTrace();

		}
	}

}
