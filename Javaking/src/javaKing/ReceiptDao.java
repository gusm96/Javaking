package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceiptDao {

	private static ReceiptDao rdao = new ReceiptDao();

	public static ReceiptDao getInstance() {
		return rdao;
	}

	// 영수증 데이터를 전달 받아 DB table에 저장하는 메소드
	public void insertReceipt(Connection conn, ReceiptDto receipt) {
		PreparedStatement pstmt = null;

		// sql문
		String sql = "insert into dorder values (dorder_seq.nextVal, sysdate, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, receipt.getTotalPrice());
			pstmt.setString(2, receipt.getPayment());
			pstmt.setInt(3, receipt.getUserid());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(pstmt);
		}

	}

}
