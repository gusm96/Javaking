package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMemberDao {
	public static Scanner sc = new Scanner(System.in);

	private ManagerMemberDao() {}
	private static ManagerMemberDao dao = new ManagerMemberDao();
	static public ManagerMemberDao getInstance() {
		return dao;
	}
	//회원 정보 출력
	public static List<UserDto> memberAllList(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		List<UserDto> result = new ArrayList<UserDto>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from Users";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new UserDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
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
	
	public UserDto MemberDetail(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDto result = null;
		String sql = "select * from Users where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();	
			if (rs.next()) {
				result = new UserDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return result;
	}
}
