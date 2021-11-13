package javaKing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/*RegisterDao > RegisterView > RegisterMain > StartUi*///순으로 진행

public class RegisterMain {

    RegisterDao regDao = new RegisterDao();
    RegisterView regView = new RegisterView();
    Connection conn;
    
    //입력메소드
    public void regmain() {
        try {
            conn = ConnectionProvider.getConnection();
            //회원정보입력
            regView.insertUser(conn);
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
}
