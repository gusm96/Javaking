package payment;

public class CartDto {

	public int mid;
	public String mname;
	public int mprice;
	public int mnum;
	public String mtype;

	public CartDto(int mid, String mname, int mprice, int mnum, String mtype) {
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.mnum = mnum;
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

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	@Override
	public String toString() {
		return "CartDTO [mid=" + mid + ", mname=" + mname + ", mprice=" + mprice + ", mnum=" + mnum + ", mtype=" + mtype
				+ "]";
	}

}