package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.CT_LopHocPhan;
import entity.GiangVien;
import entity.HocPhan;
import entity.LopHocPhan;
import entity.PhongHoc;
import entity.SinhVien;

public class LopHocPhanDAO {
	private Connection con;
	private PhongHocDAO phDAO = new PhongHocDAO();
	private GiangVienDAO gvDAO = new GiangVienDAO();
	
	public LopHocPhanDAO() {
		con = ConnectDB.getInstance().getConnection();
	}
	
	public List<LopHocPhan> layDsLopHocPhanTheoMaHP(String mahp, String namhoc) {
		List<LopHocPhan> dslhp = new ArrayList<LopHocPhan>();

		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from LopHocPhan where maHocPhan = ? and namHoc = ?");
			stmt.setString(1, mahp);
			stmt.setString(2, namhoc);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maLopHocPhan = rs.getString("maLopHocPhan");
				String tenLopHocPhan = rs.getString("tenLopHocPhan");
				String lopTinChi = rs.getString("lopTinChi");
				int siSoToiDa = rs.getInt("siSoToiDa");
				int siSoDangKy = rs.getInt("siSoDangKy");
				String namHoc = rs.getString("namHoc");
				String trangThai = rs.getString("trangThai");

				LopHocPhan lhp = new LopHocPhan(maLopHocPhan, tenLopHocPhan, lopTinChi, siSoToiDa, siSoDangKy, namHoc,
						trangThai, new HocPhan(mahp));
				
				dslhp.add(lhp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dslhp;
	}
	
	public List<CT_LopHocPhan> layDsCTLopHoc(String maLhp) {
		List<CT_LopHocPhan> dsct = new ArrayList<CT_LopHocPhan>();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from CT_LopHocPhan where maLopHocPhan = ?");
			stmt.setString(1, maLhp);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String hinhThuc = rs.getString("hinhThuc");
				String thu = rs.getString("thu");
				String tietHoc = rs.getString("tietHoc");
				String ph = rs.getString("maPhong");
				Date ngayBatDau = rs.getDate("ngayBatDau");
				Date ngayKetThuc = rs.getDate("ngayKetThuc");
				String gv = rs.getString("maGiangVien");

				PhongHoc phongHoc = phDAO.timPhongHoc(ph);
				GiangVien giangVien = gvDAO.timGiangVien(gv);

				CT_LopHocPhan ct = new CT_LopHocPhan(hinhThuc, thu, tietHoc, phongHoc, ngayBatDau, ngayKetThuc);
				
				ct.setGiangVien(giangVien);
				dsct.add(ct);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsct;
	}
	
	// Trả về true khi đăng ký thành công
		public boolean dangKyHocPhan(String maLHP, String maSV, int hocKy, String namHoc) {
			try {
				PreparedStatement stmt = con.prepareStatement("insert into PhieuDangKy values (?, ?, ?, ?, ?)");
				stmt.setString(1, maLHP);
				stmt.setString(2, maSV);
				stmt.setInt(4, hocKy);
				stmt.setString(5, namHoc);

				long millis = System.currentTimeMillis();
				java.sql.Date currentDate = new java.sql.Date(millis);
				stmt.setDate(3, currentDate);

				int rs = stmt.executeUpdate();
				if (rs > 0) {
					return true;
				}
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, "Đăng ký thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
			return false;
		}

		public int laySiSoDangKy(String maLHP) {
			int ss = 0;
			String sql = "select count(*) c from PhieuDangKy where maLopHocPhan = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maLHP);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					ss = rs.getInt("c");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ss;
		}

		public int laySiSoMoi(String maLHP) {
			int ss = 0;
			String sql = "select count(*) c from PhieuDangKy where maLopHocPhan = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maLHP);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					ss = rs.getInt("c");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ss;
		}

		public LopHocPhan timLopTheoMa(String maLHP) {
			LopHocPhan lophp = null;

			String sql = "select * from LopHocPhan where maLopHocPhan = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maLHP);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maLopHocPhan = rs.getString("maLopHocPhan");
					String tenLopHocPhan = rs.getString("tenLopHocPhan");
					String lopTinChi = rs.getString("lopTinChi");
					int siSoToiDa = rs.getInt("siSoToiDa");
					int siSoDangKy = rs.getInt("siSoDangKy");
					String namHoc = rs.getString("namHoc");
					String trangThai = rs.getString("trangThai");
					HocPhan hocphan = new HocPhan(rs.getString("maHocPhan"));

					lophp = new LopHocPhan(maLopHocPhan, tenLopHocPhan, lopTinChi, siSoToiDa, siSoDangKy, namHoc, trangThai,
							hocphan);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lophp;
		}

		public String capNhatTrangThaiLHP(int siSoDK, int siSoToiDa) {
			String trThai = "Chờ đăng ký";
			if (siSoDK >= 0.5 * siSoToiDa) {
				trThai = "Chấp nhận mở lớp";
			}
			return trThai;
		}

		public void capNhatThongTinLHP(LopHocPhan lhp, int siSoDK, String trangThaiNew) {
			String sql = "update LopHocPhan set siSODangKy = ?, trangThai = ? where maLopHocPhan = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, siSoDK);
				stmt.setString(2, trangThaiNew);
				stmt.setString(3, lhp.getMaLopHocPhan());

				int n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public boolean huyDangKyLHP(String maLHP, String maSV) {
			String sql = "delete from PhieuDangKy where maLopHocPhan = ? and maSinhVien = ?";

			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maLHP);
				stmt.setString(2, maSV);

				int n = stmt.executeUpdate();
				if (n > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return false;
		}

		public boolean kiemTraLHPCoThucHanh(String malhp) {
			String sql = "select count(*) c from CT_LopHocPhan where maLopHocPhan = ? group by maLopHocPhan";
			int c = 0;
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, malhp);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					c = rs.getInt("c");
				}
				if (c > 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return false;
		}

		public CT_LopHocPhan layCTLopLyThuyet(String malhp) {
			CT_LopHocPhan ct = null;
			String sql = "select * from CT_LopHocPhan where maLopHocPhan = ? and hinhThuc = ?";

			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, malhp);
				stmt.setString(2, "Lý thuyết");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maLopHocPhan = rs.getString("maLopHocPhan");
					String maGiangVien = rs.getString("maGiangVien");
					String hinhThuc = rs.getString("hinhThuc");
					String thu = rs.getString("thu");
					String tietHoc = rs.getString("tietHoc");
					String maPhong = rs.getString("maPhong");
					Date ngayBatDau = rs.getDate("ngayBatDau");
					Date ngayKetThuc = rs.getDate("ngayKetThuc");
					ct = new CT_LopHocPhan(new LopHocPhan(maLopHocPhan), new GiangVien(maGiangVien), hinhThuc, thu, tietHoc,
							new PhongHoc(maPhong), ngayBatDau, ngayKetThuc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ct;
		}

		public CT_LopHocPhan layCTLopThucHanh(String malhp) {
			CT_LopHocPhan ct = null;
			String sql = "select * from CT_LopHocPhan where maLopHocPhan = ? and hinhThuc = ?";

			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, malhp);
				stmt.setString(2, "Thực hành");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maLopHocPhan = rs.getString("maLopHocPhan");
					String maGiangVien = rs.getString("maGiangVien");
					String hinhThuc = rs.getString("hinhThuc");
					String thu = rs.getString("thu");
					String tietHoc = rs.getString("tietHoc");
					String maPhong = rs.getString("maPhong");
					Date ngayBatDau = rs.getDate("ngayBatDau");
					Date ngayKetThuc = rs.getDate("ngayKetThuc");
					ct = new CT_LopHocPhan(new LopHocPhan(maLopHocPhan), new GiangVien(maGiangVien), hinhThuc, thu, tietHoc,
							new PhongHoc(maPhong), ngayBatDau, ngayKetThuc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ct;
		}
		
		public boolean themLopHocPhan(LopHocPhan lhp) {
			String sql = "insert into LopHocPhan ([maLopHocPhan],[tenLopHocPhan],[maHocPhan],"
					+ "[lopTinChi],[siSoToiDa],[siSoDangKy],[trangThai],[namHoc],[nguoiMoLop]) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, lhp.getMaLopHocPhan());
				stmt.setString(2, lhp.getTenLopHocPhan());
				stmt.setString(3, lhp.getHocPhan().getMaHocPhan());
				stmt.setString(4, lhp.getLopTinChi());
				stmt.setInt(5, lhp.getSiSoToiDa());
				stmt.setInt(6, 0);
				stmt.setString(7, lhp.getTrangThai());
				stmt.setString(8, lhp.getNamHoc());
				stmt.setString(9, lhp.getNguoiMoLop().getMaNhanVien());
				
				
				int i = stmt.executeUpdate();
				if (i>0) 
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean themCTLopHocPhan(CT_LopHocPhan ct) {
			String sql = "insert into CT_LopHocPhan values (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, ct.getLopHocPhan().getMaLopHocPhan());
				stmt.setString(2, ct.getGiangVien().getMaGiangVien());
				stmt.setString(3, ct.getHinhThuc());
				stmt.setString(4, ct.getThu());
				stmt.setString(5, ct.getTietHoc());
				stmt.setString(6, ct.getPhongHoc().getMaPhong());
				stmt.setDate(7, ct.getNgayBatDau());
				stmt.setDate(8, ct.getNgayKetThuc());
				
				int i = stmt.executeUpdate();
				if (i>0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public void xoaCTLopHP(String maLHP) {
			String sql = "delete from CT_LopHocPhan where maLopHocPhan = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maLHP);
				int n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void xoaLopHP(String maLHP) {
			String sql = "delete from LopHocPhan where maLopHocPhan = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maLHP);
				int n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public boolean capNhatLopHP(String malhp, String tenlhpnew, String loptcnew, int siSonew) {
			String sql = "update LopHocPhan set tenLopHocPhan = ?, lopTinChi = ?, siSoToiDa = ? where maLopHocPhan = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, tenlhpnew);
				stmt.setString(2, loptcnew);
				stmt.setInt(3, siSonew);
				stmt.setString(4, malhp);
				
				int i = stmt.executeUpdate();
				if (i>0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean capNhatCTLopHP(CT_LopHocPhan ct) {
			String sql = "update CT_LopHocPhan set thu = ?, tietHoc = ?, maPhong = ?, maGiangVien = ?, ngayBatDau = ?, ngayKetThuc = ?"
					+ " where maLopHocPhan = ? and hinhThuc = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, ct.getThu());
				stmt.setString(2, ct.getTietHoc());
				stmt.setString(3, ct.getPhongHoc().getMaPhong());
				stmt.setString(4, ct.getGiangVien().getMaGiangVien());
				stmt.setDate(5, ct.getNgayBatDau());
				stmt.setDate(6, ct.getNgayKetThuc());
				stmt.setString(7, ct.getLopHocPhan().getMaLopHocPhan());
				stmt.setString(8, ct.getHinhThuc());
				
				int i = stmt.executeUpdate();
				if (i>0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		//Trả về danh sách tên các môn học bị trùng lịch
		public List<String> kiemTraTrungLichHoc(LopHocPhan lhp, SinhVien sv, int hocKy, String namHoc) {
			List<String> kq = new ArrayList<>();
			List<CT_LopHocPhan> dsct = layDsCTLopHoc(lhp.getMaLopHocPhan());
			
			for (CT_LopHocPhan ct : dsct) {
				String sql = "select * from PhieuDangKy p join LopHocPhan lhp on p.maLopHocPhan = lhp.maLopHocPhan join CT_LopHocPhan ct on lhp.maLopHocPhan = ct.maLopHocPhan where ct.thu = ? and p.maSinhVien = ? and p.hocKy = ? and p.namHoc = ?";
				try {
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, ct.getThu());
					stmt.setString(2, sv.getMaSinhVien());
					stmt.setInt(3, hocKy);
					stmt.setString(4, namHoc);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						String tiet = rs.getString("tietHoc");
						if (!tiet.trim().equals("")) {
							kq.add(rs.getString("tenLopHocPhan"));
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return kq;
		}
		
		public static void main(String[] args) {
			LopHocPhanDAO dao = new LopHocPhanDAO();
			List<String> ds = dao.kiemTraTrungLichHoc(new LopHocPhan("LHP003"), new SinhVien("SV999"), 2, "2020 - 2021");
			if (ds.size()>0) {
				for (String string : ds) {
					System.out.println(string);
				}
			}else {
				System.err.println("vcl");
			}
			
		}
		
		//Xóa phần chi tiết thực hành
				public void xoaCTLopHP_TH(String maLHP) {
					String sql = "delete from CT_LopHocPhan where maLopHocPhan = ? and hinhThuc = ?";
					try {
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, maLHP);
						stmt.setString(2, "Thực hành");
						int n = stmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
}
