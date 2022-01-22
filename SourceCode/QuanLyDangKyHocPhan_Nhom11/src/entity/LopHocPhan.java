package entity;

public class LopHocPhan {
	private String maLopHocPhan;
	private String tenLopHocPhan;
	private String lopTinChi;
	private int siSoToiDa;
	private int siSoDangKy;
	private String namHoc;
	private String trangThai;

	private HocPhan hocPhan;
	private NhanVienPDT nguoiMoLop;

	public LopHocPhan(String maLopHocPhan, String tenLopHocPhan, String lopTinChi, int siSoToiDa, int siSoDangKy,
			String namHoc, String trangThai, HocPhan hocPhan, NhanVienPDT nguoiMoLop) {
		super();
		this.maLopHocPhan = maLopHocPhan;
		this.tenLopHocPhan = tenLopHocPhan;
		this.lopTinChi = lopTinChi;
		this.siSoToiDa = siSoToiDa;
		this.siSoDangKy = siSoDangKy;
		this.namHoc = namHoc;
		this.trangThai = trangThai;
		this.hocPhan = hocPhan;
		this.nguoiMoLop = nguoiMoLop;
	}

	/**
	 * @param siSoToiDa
	 * @param trangThai
	 */
	public LopHocPhan(int siSoToiDa, String trangThai) {
		super();
		this.siSoToiDa = siSoToiDa;
		this.trangThai = trangThai;
	}

	/**
	 * @param tenLopHocPhan
	 * @param siSoToiDa
	 * @param trangThai
	 */
	public LopHocPhan(String tenLopHocPhan, int siSoToiDa, String trangThai) {

		this.tenLopHocPhan = tenLopHocPhan;
		this.siSoToiDa = siSoToiDa;
		this.trangThai = trangThai;
	}

	public LopHocPhan(String maLopHocPhan, String tenLopHocPhan, String lopTinChi, int siSoToiDa, int siSoDangKy,
			String namHoc, String trangThai, HocPhan hocPhan) {
		super();
		this.maLopHocPhan = maLopHocPhan;
		this.tenLopHocPhan = tenLopHocPhan;
		this.lopTinChi = lopTinChi;
		this.siSoToiDa = siSoToiDa;
		this.siSoDangKy = siSoDangKy;
		this.namHoc = namHoc;
		this.trangThai = trangThai;
		this.hocPhan = hocPhan;
	}

	public LopHocPhan(String maLopHocPhan) {
		super();
		this.maLopHocPhan = maLopHocPhan;
	}

	public LopHocPhan() {
	}

	public String getMaLopHocPhan() {
		return maLopHocPhan;
	}

	public void setMaLopHocPhan(String maLopHocPhan) {
		this.maLopHocPhan = maLopHocPhan;
	}

	public String getTenLopHocPhan() {
		return tenLopHocPhan;
	}

	public void setTenLopHocPhan(String tenLopHocPhan) {
		this.tenLopHocPhan = tenLopHocPhan;
	}

	public String getLopTinChi() {
		return lopTinChi;
	}

	public void setLopTinChi(String lopTinChi) {
		this.lopTinChi = lopTinChi;
	}

	public int getSiSoToiDa() {
		return siSoToiDa;
	}

	public void setSiSoToiDa(int siSoToiDa) {
		this.siSoToiDa = siSoToiDa;
	}

	public int getSiSoDangKy() {
		return siSoDangKy;
	}

	public void setSiSoDangKy(int siSoDangKy) {
		this.siSoDangKy = siSoDangKy;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public HocPhan getHocPhan() {
		return hocPhan;
	}

	public void setHocPhan(HocPhan hocPhan) {
		this.hocPhan = hocPhan;
	}

	public NhanVienPDT getNguoiMoLop() {
		return nguoiMoLop;
	}

	public void setNguoiMoLop(NhanVienPDT nguoiMoLop) {
		this.nguoiMoLop = nguoiMoLop;
	}

	@Override
	public String toString() {
		return "LopHocPhan [maLopHocPhan=" + maLopHocPhan + ", tenLopHocPhan=" + tenLopHocPhan + ", lopTinChi="
				+ lopTinChi + ", siSoToiDa=" + siSoToiDa + ", siSoDangKy=" + siSoDangKy + ", namHoc=" + namHoc
				+ ", trangThai=" + trangThai + ", hocPhan=" + hocPhan + ", nguoiMoLop=" + nguoiMoLop + "]";
	}

}
