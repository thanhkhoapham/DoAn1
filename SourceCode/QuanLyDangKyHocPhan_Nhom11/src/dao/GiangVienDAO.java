package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ChuyenNganh;
import entity.GiangVien;

public class GiangVienDAO {
	private Connection con;
	private ChuyenNganhDAO cnDAO = new ChuyenNganhDAO();

	public GiangVienDAO() {
		con = ConnectDB.getInstance().getConnection();
	}

	public GiangVien timGiangVien(String magv) {
		GiangVien gv = null;
		try {
			PreparedStatement stmt = con.prepareStatement("select * from GiangVien where maGiangVien =?");
			stmt.setString(1, magv);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maGiangVien = rs.getString("maGiangVien");
				String tenGiangVien = rs.getString("tenGiangVien");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				String maChuyenNganh = rs.getString("maChuyenNganh");
				gv = new GiangVien(maGiangVien, tenGiangVien, ngaySinh, gioiTinh, diaChi, soDienThoai,
						cnDAO.timChuyenNganh(maChuyenNganh));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gv;
	}

	// Trả về danh sách tên các giảng viên trong chuyên ngành
	public List<String> layDsGiangVienTheoMaChNganh(String maChNganh) {
		List<String> ds = new ArrayList<String>();
		String sql = "select tenGiangVien from GiangVien where maChuyenNganh = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maChNganh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenGiangVien"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public String layMaGVTheoTen(String tenGV, String maCN) {
		String ma = "";
		String sql = "select maGiangVien from GiangVien where tenGiangVien = ? and maChuyenNganh = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tenGV);
			stmt.setString(2, maCN);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ma = rs.getString("maGiangVien");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ma;
	}

	public List<GiangVien> danhSachGiangVien() {
		List<GiangVien> dsGV = new ArrayList<GiangVien>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select [maGiangVien],[tenGiangVien], maChuyenNganh, [ngaySinh],[gioiTinh],[diaChi],[soDienThoai] from GiangVien");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				GiangVien giangVien = new GiangVien(rs.getString("maGiangVien"), rs.getString("tenGiangVien"),
						rs.getDate("ngaySinh"), rs.getString("GioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), new ChuyenNganh(rs.getString("maChuyenNganh")));
				dsGV.add(giangVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGV;
	}

	public String timTenChuyenNganhTheoMaGV(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select C.tenChuyenNganh from GiangVien G join [dbo].[ChuyenNganh] C"
							+ "	on G.maChuyenNganh=C.maChuyenNganh" + "	where G.maGiangVien= ?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = rs.getString("tenChuyenNganh");
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return ten;
	}

	public String timMaLop(String s) {
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select [maChuyenNganh] from [dbo].[ChuyenNganh] where [tenChuyenNganh]=N'" + s + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s = rs.getString("maChuyenNganh");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean themGiangVien(GiangVien gv) {
		try {
			PreparedStatement stmt = con.prepareStatement("insert into GiangVien values (?,N'" + gv.getTenGiangVien()
					+ "',?,N'" + gv.getGioiTinh() + "',N'" + gv.getDiaChi() + "',?,?)");
			stmt.setString(1, gv.getMaGiangVien());
			stmt.setDate(2, gv.getNgaySinh());
			stmt.setString(3, gv.getSoDienThoai());
			stmt.setString(4, gv.getChuyenNganh().getMaChuyenNganh());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean suaGiangVien(GiangVien gv) {
		try {
			PreparedStatement stmt = con.prepareStatement(
					"update [dbo].[GiangVien] set [maGiangVien] =?, [tenGiangVien]=N'" + gv.getTenGiangVien()
							+ "' ,[ngaySinh]=?," + "[gioiTinh]=N'" + gv.getGioiTinh() + "', [diaChi]=N'"
							+ gv.getDiaChi() + "', [soDienThoai]=?,[maChuyenNganh]=? where [maGiangVien]=?");
			stmt.setString(1, gv.getMaGiangVien());
			stmt.setDate(2, gv.getNgaySinh());
			stmt.setString(3, gv.getSoDienThoai());
			stmt.setString(4, gv.getChuyenNganh().getMaChuyenNganh());
			stmt.setString(5, gv.getMaGiangVien());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<GiangVien> danhSachGiangVienTheoTen(String ma) {
		List<GiangVien> dsGV = new ArrayList<GiangVien>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select [maGiangVien],[tenGiangVien], maChuyenNganh, [ngaySinh],[gioiTinh],[diaChi],[soDienThoai] from GiangVien "
							+ "where tenGiangVien like (N'%" + ma + "%')");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				GiangVien giangVien = new GiangVien(rs.getString("maGiangVien"), rs.getString("tenGiangVien"),
						rs.getDate("ngaySinh"), rs.getString("GioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), chuyenNganh);
				dsGV.add(giangVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGV;
	}

	public List<GiangVien> danhSachGiangVienTheoMa(String ma) {
		List<GiangVien> dsGV = new ArrayList<GiangVien>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select [maGiangVien],[tenGiangVien], maChuyenNganh, [ngaySinh],[gioiTinh],[diaChi],[soDienThoai] from GiangVien "
							+ "where maGiangVien=?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				GiangVien giangVien = new GiangVien(rs.getString("maGiangVien"), rs.getString("tenGiangVien"),
						rs.getDate("ngaySinh"), rs.getString("GioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), chuyenNganh);
				dsGV.add(giangVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGV;
	}

	public List<GiangVien> danhSachGiangVienTheoTenChuyenNganh(String ma) {
		List<GiangVien> dsGV = new ArrayList<GiangVien>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select * from [dbo].[GiangVien] G join [dbo].[ChuyenNganh] C on G.maChuyenNganh=C.maChuyenNganh "
							+ "where C.tenChuyenNganh like N'%" + ma + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				GiangVien giangVien = new GiangVien(rs.getString("maGiangVien"), rs.getString("tenGiangVien"),
						rs.getDate("ngaySinh"), rs.getString("GioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), chuyenNganh);
				dsGV.add(giangVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGV;
	}

	public boolean timMaGiangVien(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select maGiangVien from GiangVien where maGiangVien='" + ma + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = "" + rs.getString("maGiangVien");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ten.equals(ma))
			return true;
		return false;
	}

}
