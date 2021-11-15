package javaKing;

public class ReceiptDto {
	private int oid; // 주문번호
	private String address; // 주소
	private String phoneNum; // 전화번호
	private int totalPrice; // 총 결제금액
	private String payment; // 결제방식
	private int userid; // 현재 로그인되어 있는 회원의 회원번호
	
	
	public ReceiptDto(String address, String phoneNum, int totalPrice, String payment, int userid) {
		this.address = address;
		this.phoneNum = phoneNum;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.userid= userid;
	} 
	
	public ReceiptDto () {}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}