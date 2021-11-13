package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaKing.JdbcUtil;

// Data Access Object : Sql 처리만 하는 클래스
public class MenuDao {
	Scanner sc = new Scanner(System.in);

	private MenuDao() {
	}

	private static MenuDao dao = new MenuDao();

	static public MenuDao getInstance() {
		return dao;
	}

	// 전체 리스트 구하는 메소드 : select -> Connection을 전달 받고, List<Menu>
	public List<MenuDto> selectAllList(Connection conn) {

		Statement stmt = null;
		ResultSet rs = null;
		List<MenuDto> result = new ArrayList<MenuDto>();

		try {
			// 결과 생성
			stmt = conn.createStatement();

			String sql = "select * from menu";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return result;
	}

	// 메뉴종류를 검색 메소드 : select -> Connection을 전달 받고, 메뉴 번호, menu
	public List<MenuDto> selectByMtype(Connection conn, int mtype) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : 메뉴정보
		List<MenuDto> menu = new ArrayList<MenuDto>();

		String sql = "select * from menu where mtype=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mtype);
			// Sql : Select

			// 결과 -> 1 또는 0행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menu.add(new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return menu;
	}

	// 메뉴선택 받아서 리턴, 그리고 수량 받아서 DB에 업데이트하기.
	public int selectMenu(Connection conn) {

		MenuDto menu = new MenuDto();
		System.out.println("메뉴를 선택하세요. >");
		int userChoice = sc.nextInt();
		System.out.println("수량을 선택하세요. >");
		int count = sc.nextInt();

		PreparedStatement pstmt = null;

		// Sql : update
		String sql = "update menu set mcount =? where mid =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setInt(2, userChoice);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		menu = chkUpdate(conn, userChoice);

		System.out.println(menu);
		// resetMenu(conn, userChoice);

		System.out.println(userChoice + "를 선택하셨습니다. 선택하신 값이 장바구니로 넘어갑니다.");
		System.out.println("1. 장바구니보기 2. 추가주문하기");
		System.out.print(" >");
		int select = sc.nextInt();

		while(true){
			if(select == 1)
			Cart.addCart();
		}

		return userChoice;
	}

	// 업데이트 후 리셋하는 메소드
//	public void resetMenu(Connection conn, int mid) {
//		
//		MenuDto menu = new MenuDto();
//	
//		PreparedStatement pstmt = null;
//
//		// Sql : update
//		String sql = "update menu set mcount =1 where mid =?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mid);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JdbcUtil.close(pstmt);
//		}
//		
//	}

	// 업데이트 된 메뉴 확인해보기
	public MenuDto chkUpdate(Connection conn, int mid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : 메뉴정보
		MenuDto menu = null;

		String sql = "select * from menu where mid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			// Sql : Select

			// 결과 -> 1 또는 0행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				menu = new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return menu;

	}

}