package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ChuyenNganh;
import entity.Khoa;

public class KhoaDAO {
	private Connection con;

	public KhoaDAO() {
		con = ConnectDB.getInstance().getConnection();
	}

	public List<String> layDanhSachTenKhoa() {
		List<String> dsTenKhoa = new ArrayList<>();
		String sql = "select tenKhoa from Khoa";
		String tenKhoa = "";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tenKhoa = rs.getString("tenKhoa");
				dsTenKhoa.add(tenKhoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTenKhoa;
	}

	public String layMaKhoaTheoTen(String tenKhoa) {
		String maKhoa = "";
		String sql = "select maKhoa from Khoa where tenKhoa = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tenKhoa);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				maKhoa = rs.getString("maKhoa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maKhoa;
	}

	// ====================
	public List<Khoa> danhSachKhoa() {
		List<Khoa> list = new ArrayList<Khoa>();
		try {
			PreparedStatement stmt = con.prepareStatement("select maKhoa,tenKhoa from [dbo].[Khoa]");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"), rs.getString("tenKhoa"));
				list.add(khoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean themKhoa(Khoa kh) {
		try {
			PreparedStatement stmt = con.prepareStatement("insert into Khoa values (?,N'" + kh.getTenKhoa() + "')");
			stmt.setString(1, kh.getMaKhoa());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean suaKhoa(Khoa kh) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("update Khoa set maKhoa =?, tenKhoa =N'" + kh.getTenKhoa() + "' where maKhoa=?");
			stmt.setString(1, kh.getMaKhoa());
			stmt.setString(2, kh.getMaKhoa());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Khoa> timTheoTen(String s) {
		List<Khoa> list = new ArrayList<Khoa>();
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from [dbo].[Khoa] where tenKhoa like N'%" + s + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"), rs.getString("tenKhoa"));
				list.add(khoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String timTenKhoaTheoMa(String s) {
		String kq = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select tenKhoa from Khoa where maKhoa = ?");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				kq = rs.getString("tenKhoa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public String timMaKhoaTheoTen(String s) {
		String kq = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select maKhoa from Khoa where tenKhoa like (N'%" + s + "%')");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				kq = rs.getString("maKhoa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public List<Khoa> timKhoa(String s) {
		List<Khoa> list = new ArrayList<Khoa>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from [dbo].[Khoa] where maKhoa =?");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"), rs.getString("tenKhoa"));
				list.add(khoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean timMaKhoa(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select maKhoa from Khoa where maKhoa='" + ma + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = "" + rs.getString("maKhoa");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ten.equals(ma))
			return true;
		return false;
	}
}
