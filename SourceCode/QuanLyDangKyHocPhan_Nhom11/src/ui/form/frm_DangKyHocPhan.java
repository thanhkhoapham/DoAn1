package ui.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.HocPhanDAO;
import dao.KetQuaHocTapDAO;
import dao.LopHocPhanDAO;
import dao.SinhVienDAO;
import entity.CT_LopHocPhan;
import entity.HocPhan;
import entity.LopHocPhan;
import entity.SinhVien;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class frm_DangKyHocPhan extends JPanel{
	private JComboBox<String> cmbHocKy;
	private DefaultTableModel modelHP;
	private JTable tableHP;
	private JScrollPane scroll;
	private DefaultTableModel modelLHP;
	private JTable tableLHP;
	private JScrollPane scroll2;
	private DefaultTableModel modelCTLHP;
	private JTable tableCTLHP;
	private JScrollPane scroll3;
	private JButton btnDangKy;
	private JButton btnXemDSHP;
	private JButton btnChon;
	private JComboBox<String> cmbPhuongThucDK;
	private JComboBox<String> cmbNamHoc;
	
	private HocPhanDAO hocPhanDAO = new HocPhanDAO();
	private LopHocPhanDAO lopHocPhanDAO = new LopHocPhanDAO();
	private SinhVienDAO sinhVienDAO = new SinhVienDAO();
	private KetQuaHocTapDAO kqDAO = new KetQuaHocTapDAO();
	
	

	public frm_DangKyHocPhan(String uname) {
		
		Box b, b1, b2, b3, b4, b5, b6, b7;
		add(b = Box.createVerticalBox());
		
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b7 = Box.createHorizontalBox());
		
		b.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JLabel lblChonHK;
		
//		b1.add(Box.createHorizontalGlue());
		b1.add(Box.createHorizontalStrut(400));
//		b1.add(cmbPhuongThucDK = new JComboBox<>());
//		cmbPhuongThucDK.setModel(new DefaultComboBoxModel(new String[] {"Đăng ký mới", "Đăng ký học lại", "Học cải thiện"}));
//		b1.add(Box.createHorizontalStrut(150));
		b1.add(lblChonHK = new JLabel("Chọn học kỳ: "));
		b1.add(cmbHocKy = new JComboBox<>());
		cmbHocKy.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cmbNamHoc = new JComboBox<>());
		cmbNamHoc.setModel(new DefaultComboBoxModel(new String[] {"2020 - 2021"}));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnChon = new JButton("Chọn"));
		b1.add(Box.createHorizontalStrut(400));
		
		JPanel pnlDsHP, pnlDsLHP, pnlCTLopHP, pnlDsDaDangKy;
		pnlDsHP = new JPanel();
		pnlDsLHP = new JPanel();
		pnlCTLopHP = new JPanel();
	
		b2.add(pnlDsHP);
		pnlDsHP.setBorder(BorderFactory.createTitledBorder("Danh sách học phần"));
		
		String[] tieuDe = {"STT", "Mã học phần", "Tên môn học", "Số tín chỉ", "Bắt buộc", "Học phần yêu cầu"};
		modelHP = new DefaultTableModel(tieuDe, 0);
		tableHP = new JTable(modelHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableHP.getTableHeader().setReorderingAllowed(false);
		tableHP.setPreferredScrollableViewportSize(new Dimension(1100, 150));
		tableHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlDsHP.add(scroll = new JScrollPane(tableHP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b4.add(pnlDsLHP);
		pnlDsLHP.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học phần"));
		
		String[] tieuDe2 = {"STT", "Mã lớp học phần", "Tên lớp học phần", "Lớp tín chỉ", "Sĩ số tối đa", "Sĩ số đăng ký", "Trạng thái"};
		modelLHP = new DefaultTableModel(tieuDe2, 0);
		tableLHP = new JTable(modelLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableLHP.getTableHeader().setReorderingAllowed(false);
		tableLHP.setPreferredScrollableViewportSize(new Dimension(1100, 80));
		tableLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlDsLHP.add(scroll2 = new JScrollPane(tableLHP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b6.add(pnlCTLopHP);
		pnlCTLopHP.setBorder(BorderFactory.createTitledBorder("Chi tiết lớp học phần"));
		
		String[] tieuDe3 = {"STT", "Hình thức", "Thứ", "Tiết", "Phòng học", "Giảng viên", "Ngày bắt đầu", "Ngày kết thúc"};
		modelCTLHP = new DefaultTableModel(tieuDe3, 0);
		tableCTLHP = new JTable(modelCTLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableCTLHP.getTableHeader().setReorderingAllowed(false);
		tableCTLHP.setPreferredScrollableViewportSize(new Dimension(1100, 65));
		tableCTLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlCTLopHP.add(scroll3 = new JScrollPane(tableCTLHP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b7.add(btnDangKy = new JButton("Đăng ký môn học", new ImageIcon("img/dangky.png")));
		btnDangKy.setEnabled(false);
		
		SinhVien sv = sinhVienDAO.layThongTinSV(uname);
		String maSV = sv.getMaSinhVien();
		
		btnChon.addActionListener(e ->{
//			String hinhThucDK = cmbPhuongThucDK.getItemAt(cmbPhuongThucDK.getSelectedIndex());
			String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex());
			String namHoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
			int hocKy = Integer.parseInt(hk);
			loadTBHocPhan(hocKy, maSV);
			xoaTBLopHocPhan();
			xoaTBCTLopHocPhan();
			btnDangKy.setEnabled(false);
		});
		
		tableHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xoaTBCTLopHocPhan();
				String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
				int index = tableHP.getSelectedRow();
				if(index>=0 && index<tableHP.getRowCount()) {
					String maHp = tableHP.getValueAt(index, 1).toString();
					loadTBLopHocPhan(maHp, namhoc);
					btnDangKy.setEnabled(false);
				}
				
			}
		});
		
		tableLHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableLHP.getSelectedRow();
				if(index>=0 && index<tableLHP.getRowCount()) {
					String maLhp = tableLHP.getValueAt(index, 1).toString();
					loadTBCTLopHocPhan(maLhp);
					btnDangKy.setEnabled(true);
				}
				
			}
		});
		
		btnDangKy.addActionListener(e ->{
			int index = tableLHP.getSelectedRow();
			if(index>=0 && index<tableLHP.getRowCount()) {
				String maLhp = tableLHP.getValueAt(index, 1).toString();
				LopHocPhan lophp = lopHocPhanDAO.timLopTheoMa(maLhp);
				String trangThaiCu = lophp.getTrangThai();
				int siSoToiDa = lophp.getSiSoToiDa();
				int siSoDangKy = lophp.getSiSoDangKy();
				String hpYC = tableHP.getValueAt(tableHP.getSelectedRow(), 5).toString();
				String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
				String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex());
				int hocKy = Integer.parseInt(hk);
				if (modelCTLHP.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Lớp học phần này chưa có chi tiết đầy đủ, không thể đăng ký", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}else {
					if (JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng ký môn này không?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (!hpYC.equals("")) {
							String maHPYC = hocPhanDAO.layMaTheoTenHP(hpYC);
							if (hocPhanDAO.kiemTraHocPhanDaHoc(maHPYC, maSV)) {
								if (siSoDangKy < siSoToiDa) {
									if (trangThaiCu.compareTo("Đã khóa") != 0) {
										if (trangThaiCu.compareTo("Chờ hủy lớp") != 0) {
											if (lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc).size()==0) {
												lopHocPhanDAO.dangKyHocPhan(maLhp, maSV, hocKy, namhoc);
												
												String maHP = tableHP.getValueAt(tableHP.getSelectedRow(), 1).toString();
												String maLHP = tableLHP.getValueAt(tableHP.getSelectedRow(), 1).toString();
												kqDAO.themKQHocTap(maSV, maHP, maLHP);
												
												JOptionPane.showMessageDialog(null, "Đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
												int siSoMoi = lopHocPhanDAO.laySiSoMoi(maLhp);
												
												String trThaiMoi = lopHocPhanDAO.capNhatTrangThaiLHP(siSoMoi, siSoToiDa);
												
												lopHocPhanDAO.capNhatThongTinLHP(lophp, siSoMoi, trThaiMoi);

												loadTBHocPhan(hocKy, maSV);
												xoaTBLopHocPhan();
												xoaTBCTLopHocPhan();
												btnDangKy.setEnabled(false);
											}else {
												String s = "";
												for (String string : lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc)) {
													s += "\n- "+string ;
												}
												JOptionPane.showMessageDialog(null, "Trùng lịch học, không thể đăng ký!\n\nCác môn bị trùng:" + s, "Lỗi", JOptionPane.ERROR_MESSAGE);
											}
										}else {
											JOptionPane.showMessageDialog(null, "Lớp học phần này đang chờ hủy, không thể đăng ký!", "Lỗi", JOptionPane.ERROR_MESSAGE);
										}	
									}else {
											JOptionPane.showMessageDialog(null, "Lớp học phần này đang khóa, không thể đăng ký!", "Lỗi", JOptionPane.ERROR_MESSAGE);											
									}
								} else {
								JOptionPane.showInternalMessageDialog(null, "Lớp học phần này đã đủ sinh viên, đăng ký thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Đăng ký thất bại, bạn phải học môn '"+hpYC+"' trước!", "Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							if (siSoDangKy < siSoToiDa) {
								if (trangThaiCu.compareTo("Đã khóa") != 0) {
									if (trangThaiCu.compareTo("Chờ hủy lớp") != 0) {
										if (lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc).size()==0) {
											lopHocPhanDAO.dangKyHocPhan(maLhp, maSV, hocKy, namhoc);
											
											String maHP = tableHP.getValueAt(tableHP.getSelectedRow(), 1).toString();
											String maLHP = tableLHP.getValueAt(tableLHP.getSelectedRow(), 1).toString();								
											kqDAO.themKQHocTap(maSV, maHP, maLHP);
											
											JOptionPane.showMessageDialog(null, "Đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
											int siSoMoi = lopHocPhanDAO.laySiSoMoi(maLhp);
											
											String trThaiMoi = lopHocPhanDAO.capNhatTrangThaiLHP(siSoMoi, siSoToiDa);
											
											lopHocPhanDAO.capNhatThongTinLHP(lophp, siSoMoi, trThaiMoi);

											loadTBHocPhan(hocKy, maSV);
											xoaTBLopHocPhan();
											xoaTBCTLopHocPhan();
											btnDangKy.setEnabled(false);
										} else {
											String s = "";
											for (String string : lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc)) {
												s += "\n- "+string ;
											}
											JOptionPane.showMessageDialog(null, "Trùng lịch học, không thể đăng ký!\n\nCác môn bị trùng:" + s, "Lỗi", JOptionPane.ERROR_MESSAGE);
										}
									}else {
										JOptionPane.showMessageDialog(null, "Lớp học phần này đang chờ hủy, không thể đăng ký!", "Lỗi", JOptionPane.ERROR_MESSAGE);
									}	
									}else {
										JOptionPane.showMessageDialog(null, "Lớp học phần này đang khóa, không thể đăng ký!", "Lỗi", JOptionPane.ERROR_MESSAGE);
									}
								} else {
								JOptionPane.showInternalMessageDialog(null, "Lớp học phần này đã đủ sinh viên, đăng ký thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						}
					}	
				}	
		}
		});
		
		int hk = Integer.parseInt(cmbHocKy.getItemAt(0).toString());
		loadTBHocPhan(hk, maSV);
		
		tableDesign(tableHP);
		tableDesign(tableLHP);
		tableDesign(tableCTLHP);
		setTBHocPhanColumnWidth();
		setTBLopHocPhanColumnWidth();
		tableRenderer();
	}
	
	private void xoaTBHocPhan() {
		while (modelHP.getRowCount()>0) {
			modelHP.removeRow(0);
		}
	}
	
	private void loadTBHocPhan(int hocky, String maSV) {
		xoaTBHocPhan();
		String khoaSV = sinhVienDAO.timMaKhoaTheoMaSV(maSV);
		List<HocPhan> dshp = new ArrayList<HocPhan>();
		
		dshp = hocPhanDAO.layDsHocPhan(hocky, khoaSV);
		int i = 1;
		for (HocPhan hocPhan : dshp) {	
			if (!hocPhanDAO.kiemTraHocPhanDaDangKy(hocPhan.getMaHocPhan(), maSV)) {
				String batBuoc = "";
				HocPhan hocPhanYC = null;
				String hpYc = "";
				if (hocPhan.isBatBuoc()) {
					batBuoc = "x";
				}
				if (hocPhan.getHocPhanYeuCau() != null) {
					hocPhanYC = hocPhanDAO.timHPTheoMa(hocPhan.getHocPhanYeuCau());
					hpYc = hocPhanYC.getTenMonHoc();
				}
				String[] rowData = {i+"", hocPhan.getMaHocPhan(), hocPhan.getTenMonHoc(),
						hocPhan.getSoTinChi()+"", batBuoc, hpYc};
				modelHP.addRow(rowData);
				tableHP.setModel(modelHP);
				i++;
			}
		}
		
		
	}
	
	private void xoaTBLopHocPhan() {
		while (modelLHP.getRowCount()>0) {
			modelLHP.removeRow(0);
		}
	}
	
	private void loadTBLopHocPhan(String maHp, String namhoc) {
		xoaTBLopHocPhan();
		List<LopHocPhan> dslhp = lopHocPhanDAO.layDsLopHocPhanTheoMaHP(maHp, namhoc);
		int i = 1;
		for (LopHocPhan lopHocPhan : dslhp) {
//			lopHocPhanDAO.capNhatSiSo(lopHocPhan.getMaLopHocPhan());
//			System.out.println(lopHocPhan);
			String[] rowData = {i+"", lopHocPhan.getMaLopHocPhan(), lopHocPhan.getTenLopHocPhan(), lopHocPhan.getLopTinChi()
					, lopHocPhan.getSiSoToiDa()+"", lopHocPhan.getSiSoDangKy()+"", lopHocPhan.getTrangThai()};
			modelLHP.addRow(rowData);
			tableLHP.setModel(modelLHP);
			i++;
		}
		if (modelLHP.getRowCount()==0) {
			JOptionPane.showMessageDialog(null, "Học phần này hiện tại chưa có lớp, vui lòng quay lại sau!", "", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void xoaTBCTLopHocPhan() {
		while (modelCTLHP.getRowCount()>0) {
			modelCTLHP.removeRow(0);
		}
	}
	
	private void loadTBCTLopHocPhan(String maLhp) {
		xoaTBCTLopHocPhan();
		List<CT_LopHocPhan> dsct = lopHocPhanDAO.layDsCTLopHoc(maLhp);
		int i = 1;
		for (CT_LopHocPhan ct : dsct) {
			java.util.Date ngayBatDau = new java.util.Date(ct.getNgayBatDau().getTime());
			java.util.Date ngayKetThuc = new java.util.Date(ct.getNgayKetThuc().getTime());
			
			SimpleDateFormat sdm = new SimpleDateFormat("dd-MM-yyyy");
				
			String[] rowData = {i+"", ct.getHinhThuc(), ct.getThu(), ct.getTietHoc(), ct.getPhongHoc().getTenPhong(), ct.getGiangVien().getTenGiangVien(),
					sdm.format(ngayBatDau), sdm.format(ngayKetThuc)};
			modelCTLHP.addRow(rowData);
			tableCTLHP.setModel(modelCTLHP);
			i++;
		}
		
	}
	
	private void setTBLopHocPhanColumnWidth() {	
		TableColumn column = null;
		for (int i = 0; i < tableLHP.getColumnCount(); i++) {
			column = tableLHP.getColumnModel().getColumn(i);
			if(i==2) {
				column.setPreferredWidth(300);
			}
		}
	}
	
	private void setTBHocPhanColumnWidth() {	
		TableColumn column = null;
		for (int i = 0; i < tableHP.getColumnCount(); i++) {
			column = tableHP.getColumnModel().getColumn(i);
			if(i==2 || i==5) {
				column.setPreferredWidth(250);
			}
		}
	}
	
	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
		
		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		tableHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("Mã học phần").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("Tên môn học").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("Số tín chỉ").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("Bắt buộc").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("Học phần yêu cầu").setCellRenderer(centerCellRenderer);
		
		tableLHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Mã lớp học phần").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Tên lớp học phần").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Lớp tín chỉ").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Sĩ số tối đa").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Sĩ số đăng ký").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Trạng thái").setCellRenderer(centerCellRenderer);
		
		tableCTLHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Hình thức").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Thứ").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Tiết").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Phòng học").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Giảng viên").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Ngày bắt đầu").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Ngày kết thúc").setCellRenderer(centerCellRenderer);
	}
	
	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(25);
		tb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}
}
