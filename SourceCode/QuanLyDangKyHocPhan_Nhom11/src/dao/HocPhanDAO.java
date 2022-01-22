package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HocPhan;
import entity.Khoa;

public class HocPhanDAO {
	private Connection con;

	public HocPhanDAO() {
		con = ConnectDB.getInstance().getConnection();
	}

	public HocPhan timHPTheoMa(String mahp) {
		HocPhan hp = null;
		try {
			PreparedStatement stmt = con.prepareStatement("select * from HocPhan where maHocPhan = ?");
			stmt.setString(1, mahp);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String mahp1 = rs.getString("maHocPhan");
				String tenmh = rs.getString("tenMonHoc");
				int hocKy = rs.getInt("hocKy");
				int sotc = rs.getInt("soTinChi");
				String hpyeucau = rs.getString("hocPhanYeuCau");
				String khoa = rs.getString("maKhoa");
				boolean bb = rs.getBoolean("batBuoc");

				hp = new HocPhan(mahp1, tenmh, hocKy, sotc, bb, hpyeucau, new Khoa(khoa));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hp;
	}

	public List<HocPhan> layDsHocPhan(int hk, String maKhoa) {
		List<HocPhan> dshp = new ArrayList<HocPhan>();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from HocPhan where hocKy = ? and maKhoa = ?");
			stmt.setInt(1, hk);
			stmt.setString(2, maKhoa);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String mahp = rs.getString("maHocPhan");
				String tenmh = rs.getString("tenMonHoc");
				int hocKy = rs.getInt("hocKy");
				int sotc = rs.getInt("soTinChi");
				String hpyeucau = rs.getString("hocPhanYeuCau");
				String khoa = rs.getString("maKhoa");
				boolean bb = rs.getBoolean("batBuoc");

				HocPhan hp = new HocPhan(mahp, tenmh, hocKy, sotc, bb, hpyeucau, new Khoa(khoa));
				dshp.add(hp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dshp;
	};

	// Kiểm tra học phần đã được đăng ký hay chưa
	public boolean kiemTraHocPhanDaDangKy(String maHP, String maSV) {
		int c = 0;

		try {
			PreparedStatement stmt = con.prepareStatement(
					"select count(*) c from PhieuDangKy p join LopHocPhan l on p.maLopHocPhan = l.maLopHocPhan where l.maHocPhan = ? and maSinhVien = ?");
			stmt.setString(1, maHP);
			stmt.setString(2, maSV);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				c = rs.getInt("c");
			}
			if (c > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean kiemTraHocPhanDaHoc(String maHP, String maSV) {
		String sql = "select diemTongKet from KetQuaHocTap where maSinhVien = ? and maHocPhan = ?";
		int kq = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maSV);
			stmt.setString(2, maHP);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq = rs.getRow();
			}
			if (kq > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public String layMaTheoTenHP(String tenMH) {
		String ma = "";
		String sql = "select maHocPhan from HocPhan where tenMonHoc = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tenMH);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ma = rs.getString("maHocPhan");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ma;
	}

//================
	public List<HocPhan> danhSachHocPhan() {
		List<HocPhan> list = new ArrayList<HocPhan>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from HocPhan");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"));
				HocPhan hocPhan = new HocPhan(rs.getString("maHocPhan"), rs.getString("tenMonHoc"), rs.getInt("hocKy"),
						rs.getInt("soTinChi"), rs.getBoolean("batBuoc"), rs.getString("hocPhanYeuCau"), khoa);
				list.add(hocPhan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String timHocPhanTheoTen(String ma) {
		String kq = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select top 1 maHocPhan from HocPhan where tenMonHoc like N'%" + ma + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq += rs.getString("maHocPhan");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public String timTenTheoMaKhoa(String ma) {
		String kq = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select maKhoa from Khoa where tenKhoa like N'%" + ma + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq += rs.getString("maKhoa");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public String timTenKhoaTheoMaKhoa(String ma) {
		String kq = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select tenKhoa from Khoa where maKhoa like N'%" + ma + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq += rs.getString("tenKhoa");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public String timHocPhanTheoMa(String ma) {
		String kq = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select tenMonHoc from HocPhan where maHocPhan=?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq += rs.getString("tenMonHoc");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public boolean themHocPhan(HocPhan hp) {
		try {

			PreparedStatement stmt = con.prepareStatement(
					"insert into [dbo].[HocPhan] values (?, N'" + hp.getTenMonHoc() + "', ?, ?, ?, ?, ?)");
			stmt.setString(1, hp.getMaHocPhan());
			stmt.setInt(2, hp.getHocKy());
			stmt.setInt(3, hp.getSoTinChi());
			stmt.setBoolean(4, hp.isBatBuoc());
			stmt.setString(5, hp.getHocPhanYeuCau());
			stmt.setString(6, hp.getKhoa().getMaKhoa());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean suaHocPhan(HocPhan hp) {
		try {
			int i = 0;
			if (hp.isBatBuoc())
				i = 1;
			PreparedStatement stmt = con.prepareStatement("update [dbo].[HocPhan] set [maHocPhan]='" + hp.getMaHocPhan()
					+ "', [tenMonHoc] =N'" + hp.getTenMonHoc() + "', [hocKy]=" + hp.getHocKy() + "," + "[soTinChi]="
					+ hp.getSoTinChi() + ", " + "[batBuoc]=" + i + ", " + "[hocPhanYeuCau]=?, " + "[maKhoa]='"
					+ hp.getKhoa().getMaKhoa() + "' " + "where [maHocPhan]='" + hp.getMaHocPhan() + "'");

			stmt.setString(1, hp.getHocPhanYeuCau());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<HocPhan> danhSachHocPhanTheoMa(String ma) {
		List<HocPhan> list = new ArrayList<HocPhan>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from HocPhan where maHocPhan=?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"));
				HocPhan hocPhan = new HocPhan(rs.getString("maHocPhan"), rs.getString("tenMonHoc"), rs.getInt("hocKy"),
						rs.getInt("soTinChi"), rs.getBoolean("batBuoc"), rs.getString("hocPhanYeuCau"), khoa);
				list.add(hocPhan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<HocPhan> danhSachHocPhanTheoTen(String ma) {
		List<HocPhan> list = new ArrayList<HocPhan>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from HocPhan where tenMonHoc like N'%" + ma + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"));
				HocPhan hocPhan = new HocPhan(rs.getString("maHocPhan"), rs.getString("tenMonHoc"), rs.getInt("hocKy"),
						rs.getInt("soTinChi"), rs.getBoolean("batBuoc"), rs.getString("hocPhanYeuCau"), khoa);
				list.add(hocPhan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// ==============
	public List<HocPhan> danhSachHocPhanTheoKhoa(String ma) {
		List<HocPhan> list = new ArrayList<HocPhan>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select h.* from HocPhan h join Khoa k on h.maKhoa=k.maKhoa where k.tenKhoa like (N'%" + ma + "%')"
							+ "");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"));
				HocPhan hocPhan = new HocPhan(rs.getString("maHocPhan"), rs.getString("tenMonHoc"), rs.getInt("hocKy"),
						rs.getInt("soTinChi"), rs.getBoolean("batBuoc"), rs.getString("hocPhanYeuCau"), khoa);
				list.add(hocPhan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean kiemTraKhoa(String ten) {
		String sql = "select tenKhoa from Khoa where tenKhoa like (N'%" + ten + "%')";
		String kq = "";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq = "" + rs.getString("tenKhoa");
			}
			if (kq.equals(ten))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

//	public String timHocPhanTheoMa(String ma) {
//		String a = "";
//		try {
//			PreparedStatement stmt = con
//					.prepareStatement("select tenMonHoc from HocPhan where hocPhanYeuCau like ('%" + ma + "%')");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				a = "" + rs.getString("tenMonHoc");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return a;
//
//	}
	public String timMaKhoaTheoTenKhoa(String ma) {
		String kq = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select maKhoa from Khoa where tenKhoa like N'%" + ma + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq += rs.getString("maKhoa");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public String timMaHpTheoTenHp(String ma) {
		String kq = "";
		try {
			PreparedStatement stmt = con
					.prepareStatement("select maHocPhan from HocPhan where tenMonHoc like (N'%" + ma + "%')");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				kq += rs.getString("maHocPhan");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public boolean timMaTrung(String ma) {
		String ten = "";
		try {
			PreparedStatement stmt = con.prepareStatement("select maHocPhan from HocPhan where maHocPhan='" + ma + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ten = "" + rs.getString("maHocPhan");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ten.equals(ma))
			return true;
		return false;
	}
}
