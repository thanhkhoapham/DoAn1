package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.GiangVien;
import entity.LopHocPhan;

public class ThongKeDao {
	private Connection con;

	public ThongKeDao() {
		con = ConnectDB.getInstance().getConnection();
	}

	public List<LopHocPhan> inDanhSachTinhTrang() {

		List<LopHocPhan> ds = new ArrayList<LopHocPhan>();
		try {
			PreparedStatement stmt = con
					.prepareStatement("select trangThai, soLuong = COUNT(*) from LopHocPhan group by trangThai");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LopHocPhan hp = new LopHocPhan(rs.getInt("soLuong"), rs.getString("trangThai"));
				ds.add(hp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public List<LopHocPhan> inDanhSachLHP() {

		List<LopHocPhan> ds = new ArrayList<LopHocPhan>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select distinct tenLopHocPhan,trangthai, soLuong = COUNT(*) from LopHocPhan group by trangThai,tenLopHocPhan\r\n"
							+ "	");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LopHocPhan hp = new LopHocPhan(rs.getString("tenLopHocPhan"), rs.getInt("soLuong"),
						rs.getString("trangThai"));
				ds.add(hp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
