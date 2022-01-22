package entity;

public class KetQuaHocTap {
	private SinhVien sinhVien;
	private HocPhan hocPhan;
	
	private String maLopHP;
	private String diemThuongKy;
	private String diemGiuaKy;
	private String diemCuoiKy;
	private String diemTongKet;
	private String xepLoai;
	
	public KetQuaHocTap() {
	}

	public KetQuaHocTap(SinhVien sinhVien, HocPhan hocPhan, String diemThuongKy, String diemGiuaKy, String diemCuoiKy,
			String diemTongKet, String xepLoai) {
		super();
		this.sinhVien = sinhVien;
		this.hocPhan = hocPhan;
		this.diemThuongKy = diemThuongKy;
		this.diemGiuaKy = diemGiuaKy;
		this.diemCuoiKy = diemCuoiKy;
		this.diemTongKet = diemTongKet;
		this.xepLoai = xepLoai;
	}
	
	

	

	public KetQuaHocTap(HocPhan hocPhan, String maLopHP, String diemThuongKy, String diemGiuaKy, String diemCuoiKy,
			String diemTongKet, String xepLoai) {
		super();
		this.hocPhan = hocPhan;
		this.maLopHP = maLopHP;
		this.diemThuongKy = diemThuongKy;
		this.diemGiuaKy = diemGiuaKy;
		this.diemCuoiKy = diemCuoiKy;
		this.diemTongKet = diemTongKet;
		this.xepLoai = xepLoai;
	}

	public SinhVien getMaSinhVien() {
		return sinhVien;
	}

	public void setMaSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public HocPhan getHocPhan() {
		return hocPhan;
	}

	public void setHocPhan(HocPhan hocPhan) {
		this.hocPhan = hocPhan;
	}

	public String getDiemThuongKy() {
		return diemThuongKy;
	}

	public void setDiemThuongKy(String diemThuongKy) {
		this.diemThuongKy = diemThuongKy;
	}

	public String getDiemGiuaKy() {
		return diemGiuaKy;
	}

	public void setDiemGiuaKy(String diemGiuaKy) {
		this.diemGiuaKy = diemGiuaKy;
	}

	public String getDiemCuoiKy() {
		return diemCuoiKy;
	}

	public void setDiemCuoiKy(String diemCuoiKy) {
		this.diemCuoiKy = diemCuoiKy;
	}

	public String getDiemTongKet() {
		return diemTongKet;
	}

	public void setDiemTongKet(String diemTongKet) {
		this.diemTongKet = diemTongKet;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	public String getMaLopHP() {
		return maLopHP;
	}

	public void setMaLopHP(String maLopHP) {
		this.maLopHP = maLopHP;
	}

	@Override
	public String toString() {
		return "KetQuaHocTap [sinhVien=" + sinhVien + ", hocPhan=" + hocPhan + ", maLopHP=" + maLopHP
				+ ", diemThuongKy=" + diemThuongKy + ", diemGiuaKy=" + diemGiuaKy + ", diemCuoiKy=" + diemCuoiKy
				+ ", diemTongKet=" + diemTongKet + ", xepLoai=" + xepLoai + "]";
	}

	
}
