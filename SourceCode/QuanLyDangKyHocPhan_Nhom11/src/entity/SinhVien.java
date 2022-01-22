package entity;

import java.sql.Date;

public class SinhVien {
	private String maSinhVien;
	private String tenSinhVien;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	
	private LopSinhVien lopSinhVien;
	private TaiKhoan taiKhoan;
	
	public SinhVien() {
	}
	
	

	public SinhVien(String maSinhVien, String tenSinhVien, Date ngaySinh, String gioiTinh, String diaChi,
			String soDienThoai, LopSinhVien lopSinhVien) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.lopSinhVien = lopSinhVien;
	}



	public SinhVien(String maSinhVien, String tenSinhVien, Date ngaySinh, String gioiTinh, String diaChi,
			String soDienThoai, LopSinhVien lopSinhVien, TaiKhoan taiKhoan) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.lopSinhVien = lopSinhVien;
		this.taiKhoan = taiKhoan;
	}

	public SinhVien(String maSinhVien) {
		super();
		this.maSinhVien = maSinhVien;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
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

	public LopSinhVien getLopSinhVien() {
		return lopSinhVien;
	}

	public void setLopSinhVien(LopSinhVien lopSinhVien) {
		this.lopSinhVien = lopSinhVien;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", lopSinhVien="
				+ lopSinhVien + ", taiKhoan=" + taiKhoan + "]";
	}
	
	
}
