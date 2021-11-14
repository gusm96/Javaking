package javaKing;


import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/*RegisterDao > RegisterView > RegisterMain > StartUi*///순으로 진행

public class RegisterView {
	public static Scanner sc = new Scanner(System.in);
	RegisterDao regDao = new RegisterDao();
	
	
		//회원정보 입력메소드
		public void insertUser (Connection conn) {
			
			System.out.println("회원정보입력을 시작합니다.\n");
			System.out.print("이름: >");
			String name = getString();
			System.out.print("아이디: >");	
			String id = catchSameInput(conn, 0);	//중복체크확인하기
			System.out.print("비밀번호: >");
			String pw = getString();
			System.out.print("주소: >");
			String address = getString();
			System.out.println("전화번호: ");	
			System.out.print("000-0000-0000형식으로 입력하세요. >");
			String phone = catchSameInput(conn, 1); //중복체크확인하기
			System.out.print("이메일: >");			//그냥 넘어가도 되는지 확인하기
			String email = getString();
			
			UserDto users = new UserDto(0, name, id, pw, address, phone, email);
			
			int insertCnt = regDao.inputUsersDb(conn, users);	//입력된 값을 디비에 저장
			
			if(insertCnt > 0) {
				System.out.println("회원가입 성공! 환영합니다!\n");
			}else {
				System.out.println("입력 실패되었습니다.");
			}
			
			System.out.println(name + "님의 회원정보입니다.");
			regDao.selectOneList(conn, id);
			
			
		}
		
		//정보입력값에 공백을 없애는 메소드
		private String getString() {
			String result = null;
			while(true) {
				result = sc.nextLine();
				result = result.trim();
				if(result.length()==0) {
					System.out.println("공백없이 입력해주세요.");
				}else {
					break;
				}
			}
			return result;
		}
	
		//중복정보를 걸러주는 메소드
		private String catchSameInput(Connection conn, int chk) {
				
			String input = null;	
			if (chk == 0) {
				while(true) {
					input = sc.nextLine();
					
					int sameinfo = regDao.sameInfo(conn, input, chk);
						if(sameinfo == 1) {
							System.out.println("이미 사용중인 아이디입니다. 다시 입력해주세요.");
							//System.out.println("다시 입력해주시거나, 메인 메뉴로 돌아가려면 0을 눌러주세요. >");
							
						}else {
							System.out.println(input+"은(는) 사용가능한 아이디입니다.");
							break;
						}
					}return input;
				
			}else {
				while(true) {
					input = sc.nextLine();
					
					int sameinfo = regDao.sameInfo(conn, input, chk);
						if(sameinfo == 1) {
							System.out.println("이미 사용중인 전화번호입니다. 다시 입력해주세요.");
							//System.out.println("다시 입력해주시거나, 메인 메뉴로 돌아가려면 0을 눌러주세요. >");
						}else {
							System.out.println(input+"은(는) 사용가능한 전화번호입니다.");
							break;
						}
					}return input;
			}
			
		}
	
		
	
	
	
	
	
	
	
	
}
