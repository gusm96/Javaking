package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptDao {
	
	private ReceiptDao() {}
	
	private static ReceiptDao rdao = new ReceiptDao();
	
	public static ReceiptDao getInstance() {
		return rdao;
	}
	
	// 주문 번호를 입력해 
	
	public static int insertReceipt (Connection conn , ReceiptDto receipt) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		// sql문
		String sql = "insert into dorder values (dorder_seq.nextVal, sysdate, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, receipt.getTotalPrice());
			pstmt.setString(2, receipt.getPayment());
			pstmt.setInt(3, receipt.getUserid());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
}
