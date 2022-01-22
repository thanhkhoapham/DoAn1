package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ChuyenNganh;
import entity.Khoa;

public class ChuyenNganhDAO {
	private Connection con;

	public ChuyenNganhDAO() {
		con = ConnectDB.getInstance().getConnection();
	}

	// Tìm chuyên ngành theo mã
	public ChuyenNganh timChuyenNganh(String maCN) {
		ChuyenNganh cn = null;
		try {
			PreparedStatement stmt = con.prepareStatement("select * from ChuyenNganh where maChuyenNganh =?");
			stmt.setString(1, maCN);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maChuyenNganh = rs.getString("maChuyenNganh");
				String tenChuyenNganh = rs.getString("tenChuyenNganh");
				String maKhoa = rs.getString("maKhoa");
				cn = new ChuyenNganh(maChuyenNganh, tenChuyenNganh, new Khoa(maKhoa));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

	// Trả về danh sách tên các chuyên ngành có trong khoa
	public List<String> layDsChuyenNganhTheoMaKhoa(String maKhoa) {
		List<String> ds = new ArrayList<String>();
		String sql = "select tenChuyenNganh from ChuyenNganh where maKhoa = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maKhoa);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenChuyenNganh"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public String layMaChNganhTheoTen(String tenChNganh) {
		String maChNganh = "";
		String sql = "select maChuyenNganh from ChuyenNganh where tenChuyenNganh = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tenChNganh);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				maChNganh = rs.getString("maChuyenNganh");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maChNganh;
	}

	// ====================
	public List<ChuyenNganh> danhSachChuyenNganh() {
		List<ChuyenNganh> list = new ArrayList<ChuyenNganh>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from chuyenNganh");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"), rs.getString("tenChuyenNganh"),
						new Khoa(rs.getString("maKhoa")));
				list.add(chuyenNganh);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ChuyenNganh> danhSachChuyenNganhTheoKhoa(String s) {
		List<ChuyenNganh> list = new ArrayList<ChuyenNganh>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from ChuyenNganh where maKhoa = ?");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"), rs.getString("tenChuyenNganh"),
						new Khoa(rs.getString("maKhoa")));
				list.add(chuyenNganh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean suaChuyenNganh(ChuyenNganh cn) {
		try {
			PreparedStatement stmt = con.prepareStatement("update ChuyenNganh set maChuyenNganh = '"
					+ cn.getMaChuyenNganh() + "',tenChuyenNganh = N'" + cn.getTenChuyenNganh()
					+ "', maKhoa=? where maChuyenNganh ='" + cn.getMaChuyenNganh() + "'");
			stmt.setString(1, cn.getKhoa().getMaKhoa());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ChuyenNganh> timTheoTen(String s) {
		List<ChuyenNganh> list = new ArrayList<ChuyenNganh>();
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from ChuyenNganh where tenChuyenNganh like N'%" + s + "%' ");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"), rs.getString("tenChuyenNganh"),
						new Khoa(rs.getString("maKhoa")));
				list.add(chuyenNganh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ChuyenNganh> timKiemDsChuyenNganh(String s) {
		List<ChuyenNganh> list = new ArrayList<ChuyenNganh>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from ChuyenNganh where maChuyenNganh = ?");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"), rs.getString("tenChuyenNganh"),
						new Khoa(rs.getString("maKhoa")));
				list.add(chuyenNganh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean themChuyenNganh(ChuyenNganh cn) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("insert into ChuyenNganh values (?,N'" + cn.getTenChuyenNganh() + "' ,?)");
			stmt.setString(1, cn.getMaChuyenNganh());
			stmt.setString(2, cn.getKhoa().getMaKhoa());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean timMa(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select maChuyenNganh from ChuyenNganh where maChuyenNganh='" + ma + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = "" + rs.getString("maChuyenNganh");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ten.equals(ma))
			return true;
		return false;
	}

}
