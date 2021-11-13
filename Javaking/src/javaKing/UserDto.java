package javaKing;

public class UserDto {

	private int id;
	private String username;
	private String userid;
	private String password;
	private String address;
	private String phone;
	private String email;
	
	
	//생성자 초기화
	public UserDto(int id, String username, String userid, String password, String address, String phone, String email) {
		
		this.id = id;
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	
	//기본생성자(디폴트)
	public UserDto() {}
	
	//회원에게 출력할 용 생성자
	public UserDto(String username, String userid, String password, String address, String phone, String email) {
		
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	
	
	//getter/setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	//to String
	@Override
	public String toString() {
		return  "==================================================" + "\n회원번호 = " + id + "\n이름 = " + username
	            + "\n아이디 = " + userid + "\n비밀번호 = " + password + "\n주소 = " + address + "\n전화번호 = " + phone + "\n이메일 = "
	            + email;
	}

	
	
	
	
	
	
	
	
	
	
}
