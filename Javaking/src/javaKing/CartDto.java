package javaKing;

public class CartDto {

	private int mid;
	private String mname;
	private int mprice;
	private int mcount;
	private String mtype;

	public CartDto(int mid, String mname, int mprice, int mcount, String mtype) {
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.mcount = mcount;
		this.mtype = mtype;
	}

	public CartDto() {
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

	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}


}