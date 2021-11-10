package payment;

public class Receap {
		public String address;
		public String phoneNum;
		public String menu;
		public int menuNum;
		public int price;
		public int totalPrice;
		public String payment;
		
		
		
		// 持失切
		public Receap(String address, String phoneNum, String menu, int menuNum, int price, int totalPrice,
				String payment) {
			super();
			this.address = address;
			this.phoneNum = phoneNum;
			this.menu = menu;
			this.menuNum = menuNum;
			this.price = price;
			this.totalPrice = totalPrice;
			this.payment = payment;
		}
		// 持失切
		public Receap() {}
		
		
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
		public String getMenu() {
			return menu;
		}
		public void setMenu(String menu) {
			this.menu = menu;
		}
		public int getMenuNum() {
			return menuNum;
		}
		public void setMenuNum(int menuNum) {
			this.menuNum = menuNum;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
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
		@Override
		public String toString() {
			return "Receap [address=" + address + ", phoneNum=" + phoneNum + ", menu=" + menu + ", menuNum=" + menuNum
					+ ", price=" + price + ", totalPrice=" + totalPrice + ", payment=" + payment + "]";
		}
		
}
