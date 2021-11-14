package javaKing;

import java.sql.Connection;
import java.sql.SQLException;


public class LoginMain {
		MenuMain menuMain = new MenuMain();
	    LoginDao logDao = new LoginDao();
	    LoginView logView = new LoginView();
	    ManagerMain manager = new ManagerMain();
	    Connection conn;
	    
	    //입력메소드
	    public void logmain() {
	        try {
	            conn = ConnectionProvider.getConnection();
	            //로그인화면
	            //로그인 실행, 매니저가 로그인했다면 0이 변수에 들어갈것이고 일반회원은 그 외의 값이 들어갈 것이다.
	            int log = logView.login(conn);
	            
	            if(log >0) {	//일반회원이 로그인 한 경우,
	            	logView.rightAddr(conn);
	            	menuMain.menuMain();
	            }else {
	            	//매니저의 메뉴가 실행될 것이다.
	            	manager.adminMenu();
	            	System.out.println("매니저 메뉴 실행 화면입니다.");
	            }
	            
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
