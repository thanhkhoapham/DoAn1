package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LopHocPhan;
import entity.PhieuDangKy;
import entity.SinhVien;

public class PhieuDangKyDAO {
	private Connection con;
	private LopHocPhanDAO lopHocPhanDAO = new LopHocPhanDAO();
	
	public PhieuDangKyDAO() {
		con = ConnectDB.getInstance().getConnection();
	}
	
	public List<PhieuDangKy> layDsPhieuDangKy(String maSV) {
		List<PhieuDangKy> dsPhieuDangKy = new ArrayList<PhieuDangKy>();
		String sql = "select * from PhieuDangKy where maSinhVien = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maSV);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maLHP = rs.getString("maLopHocPhan");
				String maSinhVien = rs.getString("maSinhVien");
				Date ngayDangKy = rs.getDate("ngayDangKy");
				LopHocPhan lhp = lopHocPhanDAO.timLopTheoMa(maLHP);
				
				PhieuDangKy pdk = new PhieuDangKy(new SinhVien(maSV), lhp, ngayDangKy);
				dsPhieuDangKy.add(pdk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhieuDangKy;
	}
	
	public void xoaPhieuDangKy(String maLHP) {
		String sql = "delete from PhieuDangKy where maLopHocPhan = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maLHP);
			
			int n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
