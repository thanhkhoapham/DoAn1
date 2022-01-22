package entity;

import java.sql.Date;

public class PhieuDangKy {
	private SinhVien sinhVien;
	private LopHocPhan lopHocPhan;
	
	private Date ngayDangKy;

	public PhieuDangKy(SinhVien sinhVien, LopHocPhan lopHocPhan, Date ngayDangKy) {
		super();
		this.sinhVien = sinhVien;
		this.lopHocPhan = lopHocPhan;
		this.ngayDangKy = ngayDangKy;
	}
	
	public PhieuDangKy() {
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public LopHocPhan getLopHocPhan() {
		return lopHocPhan;
	}

	public void setLopHocPhan(LopHocPhan lopHocPhan) {
		this.lopHocPhan = lopHocPhan;
	}

	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	@Override
	public String toString() {
		return "PhieuDangKy [sinhVien=" + sinhVien + ", lopHocPhan=" + lopHocPhan + ", ngayDangKy=" + ngayDangKy + "]";
	}
	
	
}
