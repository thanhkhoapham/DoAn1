package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HocPhan;
import entity.KetQuaHocTap;

public class KetQuaHocTapDAO {
private Connection con;
	
	public KetQuaHocTapDAO() {
		con = ConnectDB.getInstance().getConnection();
	}
	
	public List<KetQuaHocTap> layDsKQHocTap(String maSV, int hocKy, String namHoc){
		List<KetQuaHocTap> dskqht = new ArrayList<KetQuaHocTap>();
		String sql = "select distinct kq.*"
				+ " from KetQuaHocTap kq join HocPhan hp on kq.maHocPhan = hp.maHocPhan join LopHocPhan lhp on hp.maHocPhan = lhp.maHocPhan"
				+ " where kq.maSinhVien =? and hp.hocKy = ? and lhp.namHoc = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maSV);
			stmt.setInt(2, hocKy);
			stmt.setString(3, namHoc);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHocPhan = rs.getString("maHocPhan");
				String lopHocPhan = rs.getString("maLopHocPhan");
				String diemThuongKy = rs.getString("diemThuongKy");
				String diemGiuaKy = rs.getString("diemGiuaKy");
				String diemCuoiKy = rs.getString("diemCuoiKy");
				String diemTongKet = rs.getString("diemTongKet");
				String xepLoai = rs.getString("xepLoai");
				
				KetQuaHocTap kq = new KetQuaHocTap(new HocPhan(maHocPhan), lopHocPhan, diemThuongKy, diemGiuaKy, diemCuoiKy, diemTongKet, xepLoai);
				dskqht.add(kq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dskqht;
	}
	
	public boolean themKQHocTap(String maSV, String maHP, String maLHP) {
		String sql = "insert into KetQuaHocTap (maSinhVien, maHocPhan, maLopHocPhan) values (?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maSV);
			stmt.setString(2, maHP);
			stmt.setString(3, maLHP);
			
			int n = stmt.executeUpdate();
			if (n>0) 
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Chỉ áp dụng khi hủy lớp học phần
	public boolean xoaKQHocTap(String maSV, String maHP) {
		String sql = "delete from KetQuaHocTap where maSinhVien = ? and maHocPhan = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maSV);
			stmt.setString(2, maHP);
			
			int n = stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
