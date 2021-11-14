package javaKing;

import java.util.Scanner;

public class StartUi {
	
	//실행테스트
	public static void main(String[] args) {
		home();
	}
	
	
	
	public static void home() {
		System.out.println("JavaKing에 오신것을 환영합니다.");
		homeMenu();
		
	}
	
	public static void homeMenu() {
		RegisterMain regmain = new RegisterMain();
		LoginMain logMain = new LoginMain();

		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.println("==================================================");
			
			System.out.println("1.로그인  2.회원가입  3.프로그램종료");
			System.out.println("실행할 메뉴를 선택하세요.");
			System.out.print("> ");
			int userChoice = Integer.parseInt(sc.nextLine());
			System.out.println("==================================================");
			
			
			switch(userChoice) {
			
			case 1 : 
				logMain.logmain();
				break;
			case 2 : 
				regmain.regmain();
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
				sc.close();
				return;
			default : 
				System.out.println("존재하지 않는 메뉴입니다. \n다시 선택해주세요.");
				
			}	
		}	
	}
	
	
	
	
}
