package payment;

public class ReceiptDto {
	public int oid; // 주문 번호
	public String address; // 고객 주소
	public String phoneNum; // 고객 전화번호
	public int totalPrice; // 모든 메뉴의 금액을 합산한 총 결제금액
	public String payment; // 결제 방법
	
	public ReceiptDto(int oid, String address, String phoneNum, int totalPrice, String payment) {
		this.oid = oid;
		this.address = address;
		this.phoneNum = phoneNum;
		this.totalPrice = totalPrice;
		this.payment = payment;
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
	
	
}