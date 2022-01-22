package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PhongHoc;

public class PhongHocDAO {
	private Connection con;
	
	public PhongHocDAO() {
		con = ConnectDB.getInstance().getConnection();
	}
	
	//Tìm phòng học theo mã
		public PhongHoc timPhongHoc(String maphong) {
			PhongHoc p = null;
			try {
				PreparedStatement stmt = con.prepareStatement("select * from PhongHoc where maPhong =?");
				stmt.setString(1, maphong);
				
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maPhong = rs.getString("maPhong");
					String tenPhong = rs.getString("tenPhong");
					String dayNha = rs.getString("dayNha");
					p = new PhongHoc(maPhong, tenPhong, dayNha);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}
		
		//TÌm phòng học theo tên
		public PhongHoc timPhongHocTheoTen(String tenphong) {
			PhongHoc p = null;
			try {
				PreparedStatement stmt = con.prepareStatement("select * from PhongHoc where tenPhong =?");
				stmt.setString(1, tenphong);
				
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maPhong = rs.getString("maPhong");
					String tenPhong = rs.getString("tenPhong");
					String dayNha = rs.getString("dayNha");
					p = new PhongHoc(maPhong, tenPhong, dayNha);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}
		
		public String timDayNha(String tenPhong) {
			String dn = "";
			String sql = "select dayNha from PhongHoc where tenPhong = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, tenPhong);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					dn = rs.getString("dayNha");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dn;
		}
		
		public List<String> layDSDayNha(String loaiPhong){
			List<String> ds = new ArrayList<String>();
			String sql = "select distinct dayNha from PhongHoc where loaiPhong = ? order by dayNha";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, loaiPhong);
				
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					ds.add(rs.getString("dayNha"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ds;
		}
		
		public List<String> layDSPhongHoc(String dayNha){
			List<String> ds = new ArrayList<String>();
			String sql = "select tenPhong from PhongHoc where dayNha = ? order by tenPhong";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, dayNha);
				
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					ds.add(rs.getString("tenPhong"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ds;
		}
}
