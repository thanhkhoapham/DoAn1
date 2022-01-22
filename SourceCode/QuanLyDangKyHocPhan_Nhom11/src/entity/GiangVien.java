package entity;

import java.sql.Date;

public class GiangVien {
	private String maGiangVien;
	private String tenGiangVien;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	
	private ChuyenNganh chuyenNganh;
	
	public GiangVien() {
	}

	public GiangVien(String maGiangVien, String tenGiangVien, Date ngaySinh, String gioiTinh, String diaChi,
			String soDienThoai, ChuyenNganh chuyenNganh) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.chuyenNganh = chuyenNganh;
	}

	public GiangVien(String maGiangVien) {
		super();
		this.maGiangVien = maGiangVien;
	}

	public String getMaGiangVien() {
		return maGiangVien;
	}

	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	@Override
	public String toString() {
		return "GiangVien [maGiangVien=" + maGiangVien + ", tenGiangVien=" + tenGiangVien + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", chuyenNganh="
				+ chuyenNganh + "]";
	}
	
	
}
