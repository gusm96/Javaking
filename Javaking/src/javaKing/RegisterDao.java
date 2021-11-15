package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*RegisterDao > RegisterView > RegisterMain > StartUi*///순으로 진행

public class RegisterDao {
	
		
	//회원정보 DB생성메소드	users에 저장되어있는 값들을 불러와서 sql문에 대입해서 DB데이터를 생성한다.
	public int inputUsersDb(Connection conn, UserDto users) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "insert into users values(users_seq.nextval, ?, ?, ?, ?, ?, ?)";  		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUsername());
			pstmt.setString(2, users.getUserid());
			pstmt.setString(3,users.getPassword());
			pstmt.setString(4, users.getAddress());
			pstmt.setString(5, users.getPhone());
			pstmt.setString(6, users.getEmail());
						
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	//회원가입한 회원정보를 출력하는 list : 회원아이디를 받아서 진행한다.
	public void selectOneList(Connection conn, String userid){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "select * from users where userid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			//출력할 정보를 불러온다 (회원번호는 없음)
			if(rs.next()) {
				UserDto users = new UserDto(rs.getInt(1),rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
				//불러온 정보를 출력
				System.out.println(users);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	//중복되는 정보 확인을 위해 검색하는 메소드
	public int sameInfo(Connection conn, String input, int chk) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int sameInfoExist =0;
		
		try {
			if(chk == 0) {	//0 : 중복아이디검색
				String sql = "select * from users where userid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, input);	//사용자가 입력한 아이디와 같은 아이디를 검색해온다.
				rs = pstmt.executeQuery();
				if(rs.next()) {				//중복아이디가 존재하는 행이 있다면
					sameInfoExist = 1;
				}	
			}else {			//1 : 중복전화번호검색
				String sql = "select * from users where phone = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, input);	//사용자가 입력한 전화번호와 같은 아이디를 검색해온다.
				rs = pstmt.executeQuery();
				if(rs.next()) {				//중복전화번호가 존재하는 행이 있다면
					sameInfoExist = 1;
				}
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return sameInfoExist;				//중복정보가 존재하면 1, 아니면 0을 내보낸다.
	}
	
	
	

	
	
	
	
	
	
	
}
