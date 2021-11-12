package payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptDAO {
	// �ܺο��� �ν��Ͻ��� �������� ���ϵ��� private
	private ReceiptDAO() {}
	// ���ο��� �ν��Ͻ� ����
	private static ReceiptDAO rdao = new ReceiptDAO();
	
	public static ReceiptDAO getInstance() {
		return rdao;
	}
	
	
	// �ֹ������� ���ϴ� showReceipt() 
	// �������, ���������� �Ű������� �޾ƿ´�.
	public static ReceiptDto showReceipt(Connection conn, int orderid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ReceiptDto receipt = null;
		
		String sql = "select * from dorder where doid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				receipt = new ReceiptDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return receipt;
		
	}
	
	
	// dorder table�� ���� �ֹ������� insert ���ִ� �޼ҵ�
	public static int insertReceipt (Connection conn ,ReceiptDto receipt) {
		
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		// sql ��
		String sql = "insert into dorder values (dorder_seq.nextVal, sysdate,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// sql �Ķ���� ����
			pstmt.setInt(1, receipt.getTotalPrice());
			pstmt.setString(2, receipt.getPayment());
			pstmt.setInt(3, 1);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
}
