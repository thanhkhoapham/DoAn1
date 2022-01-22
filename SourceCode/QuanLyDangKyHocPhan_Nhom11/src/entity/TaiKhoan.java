package entity;

public class TaiKhoan {
	private String tenDangNhap;
	private String matKhau;
	private int loaiTaiKhoan;
	
	
	public TaiKhoan() {
	}


	public TaiKhoan(String tenDangNhap, String matKhau, int loaiTaiKhoan) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
	}


	public TaiKhoan(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}


	public TaiKhoan(String tenDangNhap) {
		super();
		this.tenDangNhap = tenDangNhap;
	}


	public String getTenDangNhap() {
		return tenDangNhap;
	}


	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}


	public String getMatKhau() {
		return matKhau;
	}


	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	public int getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}


	public void setLoaiTaiKhoan(int loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}


	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", loaiTaiKhoan=" + loaiTaiKhoan + "]";
	}
	
	
}
