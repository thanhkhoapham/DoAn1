package entity;

public class PhongHoc {
	private String maPhong;
	private String tenPhong;
	private String dayNha;
	
	public PhongHoc() {
	}

	public PhongHoc(String maPhong, String tenPhong, String dayNha) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.dayNha = dayNha;
	}

	public PhongHoc(String maPhong) {
		super();
		this.maPhong = maPhong;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}

	@Override
	public String toString() {
		return "PhongHoc [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", dayNha=" + dayNha + "]";
	}
	
	
}
