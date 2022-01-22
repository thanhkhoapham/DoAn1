package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ChuyenNganh;
import entity.LopSinhVien;
import entity.SinhVien;

public class SinhVienDAO {
	private Connection con;

	public SinhVienDAO() {
		con = ConnectDB.getInstance().getConnection();
	}

	public SinhVien layThongTinSV(String uname) {
		SinhVien sv = null;
		try {
			PreparedStatement stmt = con.prepareStatement("select * from SinhVien where tenDangNhap = ?");
			stmt.setString(1, uname);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSinhVien = rs.getString("maSinhVien");
				String tenSinhVien = rs.getString("tenSinhVien");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				String lsv = rs.getString("maLop");
				LopSinhVien lopSinhVien = new LopSinhVien(lsv);
//				sv = new SinhVien(maSinhVien, tenSinhVien, ngaySinh, gioiTinh, diaChi, soDienThoai, lopSinhVien, null);
				sv = new SinhVien(maSinhVien, tenSinhVien, ngaySinh, gioiTinh, diaChi, soDienThoai, lopSinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sv;
	}

	public String timMaKhoaTheoMaSV(String ma) {
		String maKhoa = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select cn.maKhoa "
					+ "from [dbo].[SinhVien] sv join [dbo].[LopSinhVien] lsv on sv.maLop = lsv.maLop join [dbo].[ChuyenNganh] cn on lsv.maChuyenNganh = cn.maChuyenNganh "
					+ "where maSinhVien = ?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				maKhoa = rs.getString("maKhoa");
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return maKhoa;
	}

//==============
	public List<SinhVien> danhSachSinhVien() {
		List<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {

			PreparedStatement stmt = con.prepareStatement(
					"select [maSinhVien], [tenSinhVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], S.[maLop]"
							+ "from [dbo].[SinhVien] S join [dbo].[LopSinhVien] L on S.maLop=L.maLop");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SinhVien sinhVien = new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), new LopSinhVien(rs.getString("maLop")));
				dsSV.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSV;
	}

	public String timTenChuyenNganhTheoMaSV(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select C.tenChuyenNganh  from [dbo].[ChuyenNganh] C join"
					+ " [dbo].[LopSinhVien] L on C.maChuyenNganh=L.maChuyenNganh join"
					+ " [dbo].[SinhVien] S on L.maLop=S.maLop where S.maSinhVien=?");
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

	public String timTenLopHocTheoMaSV(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select L.tenLop from [dbo].[SinhVien] S"
					+ " join [dbo].[LopSinhVien] L on S.maLop=L.maLop" + " where S.maSinhVien= ? ");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = rs.getString("tenLop");
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return ten;
	}

	public String timMaLop(String s) {
		String ten = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select distinct maLop from [dbo].[LopSinhVien] where tenLop =N'" + s + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = rs.getString("maLop");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}

	public boolean themSinhVien(SinhVien sv, String tk) throws SQLException {
		try {
			String sql1 = "insert into TaiKhoan values (?,1,3)";
			String sql = "insert into SinhVien values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1, sv.getMaSinhVien());
			stmt.setString(1, sv.getMaSinhVien());
			stmt.setString(2, sv.getTenSinhVien());
			stmt.setString(3, sv.getLopSinhVien().getMaLopSV());
			stmt.setDate(4, sv.getNgaySinh());
			stmt.setString(5, sv.getGioiTinh());
			stmt.setString(6, sv.getDiaChi());
			stmt.setString(7, sv.getSoDienThoai());
			stmt.setString(8, tk);
			int m = stmt1.executeUpdate();
			int n = stmt.executeUpdate();
			if (n > 0 && m > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean suaSinhVien(SinhVien sv) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("update [dbo].[SinhVien] set [maSinhVien]='" + sv.getMaSinhVien()
							+ "', [tenSinhVien]=?,[maLop]=?,[ngaySinh]=?,[gioiTinh]=?,[diaChi]=?,[soDienThoai]=?"
							+ " where [maSinhVien]= '" + sv.getMaSinhVien() + "'");
			stmt.setString(1, sv.getTenSinhVien());
			stmt.setString(2, sv.getLopSinhVien().getMaLopSV());
			stmt.setDate(3, sv.getNgaySinh());
			stmt.setString(4, sv.getGioiTinh());
			stmt.setString(5, sv.getDiaChi());
			stmt.setString(6, sv.getSoDienThoai());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<SinhVien> danhSachSinhVienTheoMaLop(String ma) {
		List<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {

			PreparedStatement stmt = con.prepareStatement(
					"select [maSinhVien], [tenSinhVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], S.[maLop] "
							+ "from [dbo].[SinhVien] S join [dbo].[LopSinhVien] L on S.maLop=L.maLop "
							+ "where S.maLop = ?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				SinhVien sinhVien = new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), new LopSinhVien(rs.getString("maLop")));
				dsSV.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSV;
	}

	public List<SinhVien> danhSachSinhVienTheoTen(String ma) {
		List<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {

			PreparedStatement stmt = con.prepareStatement(
					"select [maSinhVien], [tenSinhVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], S.[maLop] "
							+ "from [dbo].[SinhVien] S join [dbo].[LopSinhVien] L on S.maLop=L.maLop "
							+ "where S.tenSinhVien like (N'%" + ma + "%')");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				SinhVien sinhVien = new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), new LopSinhVien(rs.getString("maLop")));

				dsSV.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSV;
	}

	public List<SinhVien> danhSachSinhVienTheoMa(String ma) {
		List<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {

			PreparedStatement stmt = con.prepareStatement(
					"select [maSinhVien], [tenSinhVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai],  S.[maLop]"
							+ " from [dbo].[SinhVien] S join [dbo].[LopSinhVien] L on S.maLop=L.maLop where maSinhVien=?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				SinhVien sinhVien = new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), new LopSinhVien(rs.getString("maLop")));
				dsSV.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSV;
	}

	public List<SinhVien> danhSachSinhVienTheoTenChuyenNganh(String ma) {
		List<SinhVien> dsSV = new ArrayList<SinhVien>();
		try {

			PreparedStatement stmt = con.prepareStatement(
					"select [maSinhVien], [tenSinhVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], S.[maLop]"
							+ " from [dbo].[SinhVien] S join [dbo].[LopSinhVien] L on S.maLop=L.maLop"
							+ " join [dbo].[ChuyenNganh] C on C.maChuyenNganh=L.maChuyenNganh"
							+ " where C.tenChuyenNganh like (N'%" + ma + "%')");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				SinhVien sinhVien = new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"), new LopSinhVien(rs.getString("maLop")));
				dsSV.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSV;
	}

	public LopSinhVien layThongTinBoiMa(String ma) {
		LopSinhVien lopSinhVien = null;
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from [dbo].[LopSinhVien] " + "where [maLop] ='" + ma + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"));
				lopSinhVien = new LopSinhVien(rs.getString("maLop"), rs.getString("tenLop"),
						new ChuyenNganh(rs.getString("maChuyenNganh")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lopSinhVien;
	}

	public boolean timMaTrung(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select maSinhVien from SinhVien where maSinhVien='" + ma + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = "" + rs.getString("maSinhVien");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ten.equals(ma))
			return true;
		return false;
	}
	
	public List<SinhVien> timSinhVienQuaTenVaMaso(String mssv, String tensv) {
		List<SinhVien> ds = new ArrayList<>();
		String sql = "select * from SinhVien where maSinhVien = ? or tenSinhVien = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, mssv);
			stmt.setString(2, tensv);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSinhVien = rs.getString("maSinhVien");
				String tenSinhVien = rs.getString("tenSinhVien");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				String lopSinhVien = rs.getString("maLop");
				
				SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, ngaySinh, gioiTinh, diaChi, soDienThoai, layThongTinBoiMa(lopSinhVien));
				ds.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
