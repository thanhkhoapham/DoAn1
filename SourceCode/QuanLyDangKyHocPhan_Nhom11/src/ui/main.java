package ui;

import java.util.Iterator;
import java.util.List;

import dao.HocPhanDAO;
import dao.SinhVienDAO;
import entity.SinhVien;

public class main {
	public static void main(String[] args) {
		SinhVienDAO dao = new SinhVienDAO();

//		System.out.println(dao.timMaTrung("SV13001"));
		HocPhanDAO hocPhanDAO = new HocPhanDAO();

		System.out.println(hocPhanDAO.timTenKhoaTheoMaKhoa("CNTT"));
	}
}
