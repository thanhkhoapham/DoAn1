package entity;

public class HocPhan {
	private String maHocPhan;
	private String tenMonHoc;
	private int hocKy;
	private int soTinChi;
	private boolean batBuoc;
	private String hocPhanYeuCau;
	
	private Khoa khoa;
	
	public HocPhan() {
	}

	public HocPhan(String maHocPhan, String tenMonHoc, int hocKy, int soTinChi, boolean batBuoc, String hocPhanYeuCau,
			Khoa khoa) {
		super();
		this.maHocPhan = maHocPhan;
		this.tenMonHoc = tenMonHoc;
		this.hocKy = hocKy;
		this.soTinChi = soTinChi;
		this.batBuoc = batBuoc;
		this.hocPhanYeuCau = hocPhanYeuCau;
		this.khoa = khoa;
	}

	public HocPhan(String maHocPhan) {
		super();
		this.maHocPhan = maHocPhan;
	}

	public String getMaHocPhan() {
		return maHocPhan;
	}

	public void setMaHocPhan(String maHocPhan) {
		this.maHocPhan = maHocPhan;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getHocKy() {
		return hocKy;
	}

	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	public boolean isBatBuoc() {
		return batBuoc;
	}

	public void setBatBuoc(boolean batBuoc) {
		this.batBuoc = batBuoc;
	}

	public String getHocPhanYeuCau() {
		return hocPhanYeuCau;
	}

	public void setHocPhanYeuCau(String hocPhanYeuCau) {
		this.hocPhanYeuCau = hocPhanYeuCau;
	}

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	@Override
	public String toString() {
		return "HocPhan [maHocPhan=" + maHocPhan + ", tenMonHoc=" + tenMonHoc + ", hocKy=" + hocKy + ", soTinChi="
				+ soTinChi + ", batBuoc=" + batBuoc + ", hocPhanYeuCau=" + hocPhanYeuCau + ", khoa=" + khoa + "]";
	}
	
	
}
