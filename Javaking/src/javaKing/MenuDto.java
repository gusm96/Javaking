package javaKing;

public class MenuDto {
	
	// 변수
	private int mid;
	private String mname;
	private int mprice;
	private int mtype;
	private int mcount;

	// 생성자: 변수 초기화
	public MenuDto(int mid, String mname, int mprice, int mtype) {
		
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.mtype = mtype;
		
	}

	public MenuDto() {
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMprice() {
		return mprice;
	}

	public void setMprice(int mprice) {
		this.mprice = mprice;
	}

	public int getMtype() {
		return mtype;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}

	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}

//	@Override
//	public String toString() {
//		String menuType;
//		if (mtype == 1) {
//			menuType = "햄버거 세트";
//		} else if (mtype == 2) {
//			menuType = "햄버거";
//		} else if (mtype == 3) {
//			menuType = "사이드 메뉴";	
//		} else {
//			menuType = "음료";
//		}
//
//		return "\n[" + menuType + "]\n" + mid + "번 메뉴\n" + "메뉴이름\t" + mname + "\n" + "가격 \t" + mprice + "\n";
//
//	}

	@Override
	public String toString() {
	
		return  mid + "번 메뉴\n" + "메뉴이름\t" + mname + "\n" + "가격 \t" + mprice + "\n";

	}
}