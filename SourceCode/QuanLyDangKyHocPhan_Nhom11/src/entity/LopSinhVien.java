package entity;

import java.util.List;

public class LopSinhVien {
	private String maLopSV;
	private String tenLopSV;
	
	private ChuyenNganh chuyenNganh;
	private List<SinhVien> dsSinhVien;
	
	public LopSinhVien() {
	}

	public LopSinhVien(String maLopSV, String tenLopSV, ChuyenNganh chuyenNganh, List<SinhVien> dsSinhVien) {
		super();
		this.maLopSV = maLopSV;
		this.tenLopSV = tenLopSV;
		this.chuyenNganh = chuyenNganh;
		this.dsSinhVien = dsSinhVien;
	}

	public LopSinhVien(String maLopSV) {
		super();
		this.maLopSV = maLopSV;
	}

	public LopSinhVien(String maLopSV, String tenLopSV, ChuyenNganh chuyenNganh) {
		super();
		this.maLopSV = maLopSV;
		this.tenLopSV = tenLopSV;
		this.chuyenNganh = chuyenNganh;
	}

	public String getMaLopSV() {
		return maLopSV;
	}

	public void setMaLopSV(String maLopSV) {
		this.maLopSV = maLopSV;
	}

	public String getTenLopSV() {
		return tenLopSV;
	}

	public void setTenLopSV(String tenLopSV) {
		this.tenLopSV = tenLopSV;
	}

	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public List<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(List<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	/**
	 * @param maLopSV
	 * @param chuyenNganh
	 */
	public LopSinhVien(String maLopSV, ChuyenNganh chuyenNganh) {
		super();
		this.maLopSV = maLopSV;
		this.chuyenNganh = chuyenNganh;
	}

	@Override
	public String toString() {
		return "LopSinhVien [maLopSV=" + maLopSV + ", tenLopSV=" + tenLopSV + ", chuyenNganh=" + chuyenNganh
				+ ", dsSinhVien=" + dsSinhVien + "]";
	}
	
	
}
