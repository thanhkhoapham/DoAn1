package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVienPDT;

public class NhanVienDAO {
	private Connection con;

	public NhanVienDAO() {
		con = ConnectDB.getInstance().getConnection();
	}

	public NhanVienPDT layThongTinNV(String uname) {
		NhanVienPDT nv = null;
		try {
			PreparedStatement stmt = con.prepareStatement("select * from NhanVienPDT where tenDangNhap = ?");
			stmt.setString(1, uname);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				String tenNhanVien = rs.getString("tenNhanVien");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");

				nv = new NhanVienPDT(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, diaChi, soDienThoai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nv;
	}

	public List<NhanVienPDT> danhSachNhanVien() {
		List<NhanVienPDT> dsNV = new ArrayList<NhanVienPDT>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select [maNhanVien],[tenNhanVien],[ngaySinh],[gioiTinh],[diaChi],[soDienThoai] from [dbo].[NhanVienPDT]");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVienPDT nhanVienPDT = new NhanVienPDT(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"));
				dsNV.add(nhanVienPDT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNV;
	}

	public boolean themNhanVien(NhanVienPDT nv, String tk) {
		try {
			String sql1 = "insert into TaiKhoan values (?,1,1)";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1, tk);
			String sql = "insert into [dbo].[NhanVienPDT] values (?,N'" + nv.getTenNhanVien() + "',?,N'"
					+ nv.getGioiTinh() + "',N'" + nv.getDiaChi() + "',?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setDate(2, nv.getNgaySinh());
			stmt.setString(3, nv.getSoDienThoai());
			stmt.setString(4, tk);
			int m = stmt1.executeUpdate();
			int n = stmt.executeUpdate();
			if (n > 0 && m > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean suaNhanVien(NhanVienPDT nv) {

		try {
			PreparedStatement stmt = con.prepareStatement("update NhanVienPDT set [tenDangNhap]= '" + nv.getMaNhanVien()
					+ "' , [maNhanVien]= '" + nv.getMaNhanVien() + "' , [tenNhanVien]= N'" + nv.getTenNhanVien()
					+ "', [ngaySinh]=?, [gioiTinh]=N'" + nv.getGioiTinh() + "' , [diaChi]= N'" + nv.getDiaChi()
					+ "', [soDienThoai]=? " + "where [maNhanVien]= '" + nv.getMaNhanVien() + "'");
			stmt.setDate(1, nv.getNgaySinh());
			stmt.setString(2, nv.getSoDienThoai());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<NhanVienPDT> danhSachNhanVienTheoMa(String ma) {
		List<NhanVienPDT> dsNV = new ArrayList<NhanVienPDT>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select [maNhanVien],[tenNhanVien],[ngaySinh],[gioiTinh],[diaChi],[soDienThoai] from [dbo].[NhanVienPDT]"
							+ " where maNhanVien=?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVienPDT nhanVienPDT = new NhanVienPDT(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"));
				dsNV.add(nhanVienPDT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNV;
	}

	public List<NhanVienPDT> danhSachNhanVienTheoTen(String ma) {
		List<NhanVienPDT> dsNV = new ArrayList<NhanVienPDT>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select [maNhanVien],[tenNhanVien],[ngaySinh],[gioiTinh],[diaChi],[soDienThoai] from [dbo].[NhanVienPDT]"
							+ " where tenNhanVien like ('%" + ma + "%')");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVienPDT nhanVienPDT = new NhanVienPDT(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),
						rs.getDate("ngaySinh"), rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"));
				dsNV.add(nhanVienPDT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNV;
	}

	public boolean timMaNhanVien(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select maNhanVien from NhanVienPDT where maNhanVien='" + ma + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = "" + rs.getString("maNhanVien");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ten.equals(ma))
			return true;
		return false;
	}
}
