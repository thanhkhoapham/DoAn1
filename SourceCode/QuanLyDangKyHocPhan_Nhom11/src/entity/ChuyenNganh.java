package entity;

public class ChuyenNganh {
	private String maChuyenNganh;
	private String tenChuyenNganh;
	private Khoa khoa;
	
	public ChuyenNganh() {
	}

	public ChuyenNganh(String maChuyenNganh, String tenChuyenNganh, Khoa khoa) {
		super();
		this.maChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
		this.khoa = khoa;
	}

	public ChuyenNganh(String maChuyenNganh) {
		super();
		this.maChuyenNganh = maChuyenNganh;
	}

	public String getMaChuyenNganh() {
		return maChuyenNganh;
	}

	public void setMaChuyenNganh(String maChuyenNganh) {
		this.maChuyenNganh = maChuyenNganh;
	}

	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}

	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	@Override
	public String toString() {
		return "ChuyenNganh [maChuyenNganh=" + maChuyenNganh + ", tenChuyenNganh=" + tenChuyenNganh + ", khoa=" + khoa
				+ "]";
	}
	
	
}
