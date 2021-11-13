package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {
	public static Scanner sc = new Scanner(System.in);
	LoginDao logDao = new LoginDao();
	public static String logId = null;
	
	//로그인한다
	public int login(Connection conn) {
		System.out.println("==================================================");
		System.out.println("로그인을 시작합니다.");
		System.out.println();
		System.out.println("아이디를 입력하세요. >");
		String id = sameId(conn);
		System.out.println("비밀번호를 입력하세요. >");
		String pw = rightPw(conn, id);
		System.out.println("로그인 성공!\n");
		logId = id;							//로그인에 성공한 아이디를 현 로그인상태 변수에 넣는다.
		
		
		int uid = returnId(conn, logId);	//현 로그인 한 아이디값이 매니저인지 아닌지 확인하는 메소드
		
		return uid;						
	}
	
	
	
	
	//일치하는 아이디 확인하는 메소드
	private String sameId(Connection conn) {
		String inputId = null;
		while(true) {
			inputId = sc.nextLine();
			
			int sameId = logDao.sameId(conn, inputId);
			if(sameId == 1) {
				break;	//존재하는 아이디가 맞으므로 while문에서 벗어난다.
			}else if (inputId.equalsIgnoreCase("x")) {
				StartUi.homeMenu();
			}
			else if(sameId ==0){
				System.out.println("존재하지 않는 아이디입니다.");
				System.out.println("*다시 입력하시거나 메인메뉴로 돌아가려면 X를 눌러주세요. >");
			}
		}return inputId;
	}
	
	
	
	
	//패스워드 일치하는지 확인하는 메소드
	private String rightPw(Connection conn, String id) {
		
		String inputPw = null;
		while(true) {
			inputPw = sc.nextLine();
			
			int rightPw = logDao.samePw(conn, inputPw, id);
			if(rightPw ==1) {
				break;
			}else if (inputPw.equalsIgnoreCase("x")) {
				StartUi.homeMenu();
			}else if(rightPw == 0) {
				System.out.println("맞는 비밀번호가 아닙니다. 다시 입력해주세요. >");
				System.out.println("*다시 입력하시거나 메인메뉴로 돌아가려면 X를 눌러주세요. >");
			}
		}return inputPw;
				
	}
	
	
	//회원번호를 리턴하는 메소드
	public int returnId(Connection conn, String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int uid = 1;	//id에 해당하는 고유번호값을 반환할 변수
		
		try {
			String sql = "select * from users where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				uid = rs.getInt(1);	//매니저가 로그인한것이면 매니저의 고유번호 0이 들어갈 것이다.
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uid;
	}
	


	
	//주소 물어보는 메소드
	public void rightAddr(Connection conn) {
		System.out.println("==================================================\n");
		System.out.println("회원님의 배달정보를 확인합니다.");
		
		String addr = logDao.sameAddr(conn, logId);
		
		System.out.println(logId +"님이 배달받으실 주소 : " + addr);
		System.out.println();
		
		System.out.println("맞으시면 Y, 변경하시려면 N을 눌러주세요. >");
		
		String choice = sc.nextLine();
		
		if(choice.equalsIgnoreCase("N")) {
			//주소가 틀리면 주소변경을 시행한다.
			System.out.println("변경할 주소를 입력해주세요 >");
			String newAddr = sc.nextLine();
			try {
				logDao.updateAdrr(conn, newAddr, logId);
				System.out.println("변경 중...");
				Thread.sleep(3000);
				System.out.println("변경완료!");
				System.out.println("위 주소로 배달하겠습니다.");
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	
	
}
