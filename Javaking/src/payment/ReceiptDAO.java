package payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptDAO {
	// 외부에서 인스턴스를 생성하지 못하도록 private
	private ReceiptDAO() {}
	// 내부에서 인스턴스 생성
	private static ReceiptDAO rdao = new ReceiptDAO();
	
	public static ReceiptDAO getInstance() {
		return rdao;
	}
	
	
	// 주문정보를 구하는 showReceipt() 
	// 배달정보, 결제정보를 매개변수로 받아온다.
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
	
	
	// dorder table에 받은 주문정보를 insert 해주는 메소드
	public static int insertReceipt (Connection conn ,ReceiptDto receipt) {
		
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		// sql 문
		String sql = "insert into dorder values (dorder_seq.nextVal, sysdate,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 파라미터 설정
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
