package entity;

public class Khoa {
	private String maKhoa;
	private String tenKhoa;
	
	public Khoa() {
	}

	public Khoa(String maKhoa, String tenKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}
	
	public Khoa(String maKhoa) {
		super();
		this.maKhoa = maKhoa;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	@Override
	public String toString() {
		return "Khoa [maKhoa=" + maKhoa + ", tenKhoa=" + tenKhoa + "]";
	}
	
	
	
}
