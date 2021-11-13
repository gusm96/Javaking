package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMenuDao {

	public static Scanner sc = new Scanner(System.in);

	private ManagerMenuDao() {
	}

	private static ManagerMenuDao dao = new ManagerMenuDao();

	static public ManagerMenuDao getInstance() {
		return dao;
	}
	// Sql : Select
	public List<MenuDto> selectByMtype(Connection conn, int mtype) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MenuDto> menu = new ArrayList<MenuDto>();
		String sql = "select * from menu where mType=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mtype);
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

	// Sql : insert
	public int insertMenu(Connection conn, MenuDto menu) {

		PreparedStatement pstmt = null;
		int resultCnt = 0;
		String sql = "insert into menu(mid,mname,mprice,mtype) values (menu_seq.nextVal, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMname());
			pstmt.setInt(2, menu.getMprice());
			pstmt.setInt(3, menu.getMtype());
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}

	// Sql : update
	public int updateMenu(Connection conn, int mid, int mprice) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		String sql = "update menu set mprice=? where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mprice);
			pstmt.setInt(2, mid);
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}

	// Sql : delete
	public int deleteMenu(Connection conn, int mid) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		String sql = "delete from menu where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}
