package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//로그인 Dao

public class LoginDao {

	
	
	
	// 로그인할때 입력한 아이디가 DB에 존재하는지 확인하는 메소드
	public int sameId(Connection conn, String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int sameIdExist = 0;

		try {
			// 존재하는 아이디검색
			String sql = "select * from users where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // 사용자가 입력한 아이디와 같은 아이디를 검색해온다.
			rs = pstmt.executeQuery();
			if (rs.next()) { // 입력한 아이디가 존재하는 행이 있다면
				sameIdExist = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return sameIdExist; // 입력한 아이디가 존재하면 1, 아니면 0을 내보낸다.
	}

	
	
	
	// 로그인할때 입력한 패스워드가 (입력한 아이디에 맞는)DB에 존재하는지 확인하는 메소드
	public int samePw(Connection conn, String pw, String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int samePwExist = 0;

		try {
			// 존재하는 아이디검색
			String sql = "select * from users where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // 사용자가 입력한아이디 정보(패스워드)를 검색해온다.
			rs = pstmt.executeQuery();
			if (rs.next()) { // 사용자의 아이디와 일치하는 DB정보에서 패스워드를 추출한다.
				String existPw = rs.getString(4);
				if (existPw.equals(pw)) { // 추출한 패스워드와 사용자가 입력한 패스워드가 일치한다면
					samePwExist = 1; // 1반환
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return samePwExist; // 입력한 패스워드가 일치하면 1, 아니면 0을 내보낸다.
	}

	
	
	
	// 입력한 아이디에 속하는 주소를 DB에서 불러오는 메소드
	public String sameAddr(Connection conn, String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String addr = null;

		String sql = "select * from users where userid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				addr = rs.getString(5); // 사용자의 주소를 변수에 저장
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return addr;
	}
	
	// 입력한 아이디에 속하는 회원정보를 DB에서 불러오는 메소드
		public  UserDto logedInfo(Connection conn, String id) {

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			UserDto user = null;

			String sql = "select * from users where userid = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					user = new UserDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getString(6),rs.getString(7)); // 사용자의 주소를 변수에 저장
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			return user;
		}

	
	
	
//	// 입력한 아이디에 속하는 주소를 DB에서 불러오는 메소드
//	public String sameAddr2(Connection conn, String id) {
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		//Delivery del;
//		String addr = null;
//
//		String sql = "select * from users where userid = ?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				addr = rs.getString(5);
//				//del = new Delivery(rs.getString(3), rs.getString(5), rs.getString(6));
//				//inputDelivDb(conn, del); // 딜리버리DB로 주문자 정보 저장한다.
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//		return addr;
//	}

	
	
	
//	// 주문자정보DB에 정보를 저장하는 메소드
//	public void inputDelivDb(Connection conn, Delivery del) {
//
//		PreparedStatement pstmt = null;
//
//		String sql = "insert into delivery values(del_seq.nextVal, ?, ?, ?)";
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, del.getDname());
//			pstmt.setString(2, del.getDaddr());
//			pstmt.setString(3, del.getDphn());
//			pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(pstmt);
//		}
//
//	}

	
	
	
	// 새 주소를 DB에 업데이트하는 메소드
	public void updateAdrr(Connection conn, String addr, String id) {

		PreparedStatement pstmt = null;

		String sql = "update users set address=? where userid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}
	
}
