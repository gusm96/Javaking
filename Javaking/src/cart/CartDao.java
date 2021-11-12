package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import payment.JdbcUtil;

public class CartDao {

	private CartDao() {
	}

	private static CartDao dao = new CartDao();

	static public CartDao getInstance() {
		return dao;
	}

	public CartDto selectByCartno(Connection conn, int mid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CartDto cartlist = null;

		// �˻� ��� : �μ�����
		//CartDTO cartDTO = null;
		
		// Sql : Select
		String sql = "select * from menu where mid=?";
		// ��� -> 1 �Ǵ� 0��

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);// 1�� ù��°�� mid�� ���Ѵ�

			rs = pstmt.executeQuery();

			if (rs.next()) {
				cartlist = new CartDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return cartlist;
	}

}