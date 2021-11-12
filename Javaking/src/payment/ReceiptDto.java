package payment;

public class ReceiptDto {
	public int oid; // �ֹ� ��ȣ
	public String address; // �� �ּ�
	public String phoneNum; // �� ��ȭ��ȣ
	public int totalPrice; // ��� �޴��� �ݾ��� �ջ��� �� �����ݾ�
	public String payment; // ���� ���
	
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