package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.TaiKhoan;

public class TaiKhoanDAO {
	private Connection con;

	public TaiKhoanDAO() {
		con = ConnectDB.getInstance().getConnection();
	}

	public int dangNhap(TaiKhoan taiKhoan) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from TaiKhoan where tenDangNhap = ? and matKhau = ?");
			stmt.setString(1, taiKhoan.getTenDangNhap());
			stmt.setString(2, taiKhoan.getMatKhau());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int loaiTK = rs.getInt("loaiTaiKhoan");
				return loaiTK;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean doiMatKhau(TaiKhoan tknew, String uname) {
		try {
			PreparedStatement stmt = con.prepareStatement("update TaiKhoan set matKhau = ? where tenDangNhap = ?");
			stmt.setString(1, tknew.getMatKhau());
			stmt.setString(2, uname);

			int i = stmt.executeUpdate();
			if (i > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean dangKy(TaiKhoan tk) {
		try {
			PreparedStatement stmt = con.prepareStatement("insert into TaiKhoan values(?, ?, ?)");
			stmt.setString(1, tk.getTenDangNhap());
			stmt.setString(2, tk.getMatKhau());
			stmt.setInt(3, tk.getLoaiTaiKhoan());

			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
