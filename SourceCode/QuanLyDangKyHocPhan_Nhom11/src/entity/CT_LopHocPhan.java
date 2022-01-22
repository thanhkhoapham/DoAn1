package entity;

import java.sql.Date;

public class CT_LopHocPhan {
	private LopHocPhan lopHocPhan;
	private GiangVien giangVien;
	private String hinhThuc;
	private String thu;
	private String tietHoc;
	private PhongHoc phongHoc;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	
	public CT_LopHocPhan() {
	}

	
	public CT_LopHocPhan(String hinhThuc, String thu, String tietHoc, PhongHoc phongHoc, Date ngayBatDau,
			Date ngayKetThuc) {
		super();
		this.hinhThuc = hinhThuc;
		this.thu = thu;
		this.tietHoc = tietHoc;
		this.phongHoc = phongHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}


	public CT_LopHocPhan(LopHocPhan lopHocPhan, GiangVien giangVien, String hinhThuc, String thu, String tietHoc,
			PhongHoc phongHoc, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.lopHocPhan = lopHocPhan;
		this.giangVien = giangVien;
		this.hinhThuc = hinhThuc;
		this.thu = thu;
		this.tietHoc = tietHoc;
		this.phongHoc = phongHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public LopHocPhan getLopHocPhan() {
		return lopHocPhan;
	}

	public void setLopHocPhan(LopHocPhan lopHocPhan) {
		this.lopHocPhan = lopHocPhan;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public String getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getTietHoc() {
		return tietHoc;
	}

	public void setTietHoc(String tietHoc) {
		this.tietHoc = tietHoc;
	}

	public PhongHoc getPhongHoc() {
		return phongHoc;
	}

	public void setPhongHoc(PhongHoc phongHoc) {
		this.phongHoc = phongHoc;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@Override
	public String toString() {
		return "CT_LopHocPhan [lopHocPhan=" + lopHocPhan + ", giangVien=" + giangVien + ", hinhThuc=" + hinhThuc
				+ ", thu=" + thu + ", tietHoc=" + tietHoc + ", phongHoc=" + phongHoc + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + "]";
	}
	
	
}
