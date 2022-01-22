package ui.form;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import dao.PhieuDangKyDAO;
import dao.SinhVienDAO;
import entity.CT_LopHocPhan;
import entity.HocPhan;
import entity.LopHocPhan;
import entity.PhieuDangKy;
import ui.UI_DangNhap;

public class frm_XemCacMonDangKy extends JPanel{
	
	private JComboBox<String> cboHocKy;
	private JButton btnChon;
	private DefaultTableModel modelLHP;
	private JTable tableLHP;
	private JScrollPane scroll;
	private DefaultTableModel modelCTLHP;
	private JTable tableCTLHP;
	private JScrollPane scroll2;
	private JButton btnHuyLopHP;

	private PhieuDangKyDAO phieuDangKyDAO = new PhieuDangKyDAO();
	private HocPhanDAO hocPhanDAO = new HocPhanDAO();
	private SinhVienDAO sinhVienDAO = new SinhVienDAO();
	private LopHocPhanDAO lopHocPhanDAO = new LopHocPhanDAO();
	private KetQuaHocTapDAO kqDAO = new KetQuaHocTapDAO();
	private JComboBox<String> cmbNamHoc;
	
	public frm_XemCacMonDangKy(String uname) {
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
		
		b1.add(Box.createHorizontalStrut(400));
		b1.add(lblChonHK = new JLabel("Chọn học kỳ: "));
		b1.add(cboHocKy = new JComboBox<>());
		cboHocKy.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cmbNamHoc = new JComboBox<>());
		cmbNamHoc.setModel(new DefaultComboBoxModel(new String[] {"2020 - 2021"}));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnChon = new JButton("Chọn"));
		b1.add(Box.createHorizontalStrut(400));
		
		JPanel pnlDsLHP, pnlCTLopHP, pnlDsDaDangKy;
		pnlDsLHP = new JPanel();
		pnlCTLopHP = new JPanel();
		
		b2.add(pnlDsLHP);
		pnlDsLHP.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học phần"));
		
		String[] tieuDe = {"STT", "Mã học phần","Mã lớp học phần", "Tên lớp học phần", "Lớp tín chỉ", "Số tín chỉ", "Bắt buộc", "Sĩ số tối đa", "Sĩ số đăng ký", "Ngày đăng ký", "Trạng thái"};
		modelLHP = new DefaultTableModel(tieuDe, 0);
		tableLHP = new JTable(modelLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableLHP.getTableHeader().setReorderingAllowed(false);
		tableLHP.setPreferredScrollableViewportSize(new Dimension(1100, 250));
		tableLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlDsLHP.add(scroll = new JScrollPane(tableLHP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b4.add(pnlCTLopHP);
		pnlCTLopHP.setBorder(BorderFactory.createTitledBorder("Chi tiết lớp học phần"));
		
		String[] tieuDe2 = {"STT", "Hình thức", "Thứ", "Tiết", "Phòng học", "Giảng viên", "Ngày bắt đầu", "Ngày kết thúc"};
		modelCTLHP = new DefaultTableModel(tieuDe2, 0);
		tableCTLHP = new JTable(modelCTLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableCTLHP.getTableHeader().setReorderingAllowed(false);
		tableCTLHP.setPreferredScrollableViewportSize(new Dimension(1100, 80));
		tableCTLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlCTLopHP.add(scroll2 = new JScrollPane(tableCTLHP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b6.add(btnHuyLopHP = new JButton("Hủy lớp học phần"));
		btnHuyLopHP.setIcon(new ImageIcon("img/delete.png"));
		
		String maSV = sinhVienDAO.layThongTinSV(uname).getMaSinhVien();
		
		btnHuyLopHP.setEnabled(false);
		
		btnChon.addActionListener(e ->{
			String hk = cboHocKy.getItemAt(cboHocKy.getSelectedIndex());
			String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
			int hocKy = Integer.parseInt(hk);
			loadTBHocPhan(hocKy, namhoc, maSV);
			xoaTBCTLopHocPhan();
		});
		
		btnHuyLopHP.addActionListener(e ->{
			int index = tableLHP.getSelectedRow();
			if(index>=0 && index<tableLHP.getRowCount()) {
				String maLHP = tableLHP.getValueAt(index, 2).toString();
				LopHocPhan lophp = lopHocPhanDAO.timLopTheoMa(maLHP);
				String trThaiCu = lophp.getTrangThai();
				int siSoToiDa = lophp.getSiSoToiDa();
				
				if (JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy đăng ký môn này không?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (trThaiCu.compareTo("Chấp nhận mở lớp") != 0) {
						if (trThaiCu.compareTo("Đã khóa") != 0) {
							lopHocPhanDAO.huyDangKyLHP(maLHP, maSV);
							
							String maHP = tableLHP.getValueAt(tableLHP.getSelectedRow(), 1).toString();
							kqDAO.xoaKQHocTap(maSV, maHP);

							int siSoMoi = lopHocPhanDAO.laySiSoMoi(maLHP);
							String trThaiMoi = lopHocPhanDAO.capNhatTrangThaiLHP(siSoMoi, siSoToiDa);
							lopHocPhanDAO.capNhatThongTinLHP(lophp, siSoMoi, trThaiMoi);
							JOptionPane.showInternalMessageDialog(null, "Hủy đăng ký thành công!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showInternalMessageDialog(null, "Lớp học phần này đã khóa, không thể hủy!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
						
					}else {
							JOptionPane.showInternalMessageDialog(null, "Lớp học phần này đã chấp nhận mở, không thể hủy!!", "Lỗi", JOptionPane.ERROR_MESSAGE);	
					}
					
					String hk = cboHocKy.getItemAt(cboHocKy.getSelectedIndex());
					String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
					int hocKy = Integer.parseInt(hk);
					loadTBHocPhan(hocKy, namhoc, maSV);
					xoaTBCTLopHocPhan();
					btnHuyLopHP.setEnabled(false);
				}
			}
			
		});
		
		tableLHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableLHP.getSelectedRow();
				if(index>=0 && index<tableLHP.getRowCount()) {
					String maLhp = tableLHP.getValueAt(index, 2).toString();
					loadTBCTLopHocPhan(maLhp);
					btnHuyLopHP.setEnabled(true);
				}
				
			}
		});
		
		String hk = cboHocKy.getItemAt(0);
		String namhoc = cmbNamHoc.getItemAt(0);
		int hocKy = Integer.parseInt(hk);
		loadTBHocPhan(hocKy, namhoc, maSV);
		
		setTBLopHocPhanColumnWidth();
		tableRenderer();
	}
	
	private void setTBLopHocPhanColumnWidth() {	
		TableColumn column = null;
		for (int i = 0; i < tableLHP.getColumnCount(); i++) {
			column = tableLHP.getColumnModel().getColumn(i);
			if(i==3) {
				column.setPreferredWidth(200);
			}
		}
	}
	
	private void xoaTBLopHocPhan() {
		while (modelLHP.getRowCount()>0) {
			modelLHP.removeRow(0);
		}
	}
	
	private void loadTBHocPhan(int hocKy, String namhoc, String maSV) {
		xoaTBLopHocPhan();
		List<PhieuDangKy> dsPhieuDangKy = phieuDangKyDAO.layDsPhieuDangKy(maSV);
		int i = 1;

		for (PhieuDangKy phieuDangKy : dsPhieuDangKy) {
			LopHocPhan lopHocPhan = phieuDangKy.getLopHocPhan();
			HocPhan hocPhan = hocPhanDAO.timHPTheoMa(lopHocPhan.getHocPhan().getMaHocPhan());
			
			if (hocPhan.getHocKy() == hocKy && lopHocPhan.getNamHoc().equals(namhoc)) {
				String batBuoc = "";
				if (hocPhan.isBatBuoc()) {
					batBuoc = "x";
				}
				java.util.Date ngayDangKy = new java.util.Date(phieuDangKy.getNgayDangKy().getTime());
				SimpleDateFormat sdm = new SimpleDateFormat("dd-MM-yyyy");

				String[] rowData = {i+"", hocPhan.getMaHocPhan(), lopHocPhan.getMaLopHocPhan(), lopHocPhan.getTenLopHocPhan(), lopHocPhan.getLopTinChi(),
						hocPhan.getSoTinChi()+"", batBuoc, lopHocPhan.getSiSoToiDa()+"", lopHocPhan.getSiSoDangKy()+"", sdm.format(ngayDangKy), lopHocPhan.getTrangThai()};
				modelLHP.addRow(rowData);
				tableLHP.setModel(modelLHP);
				i++;
			}
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
	
	private void tableRenderer() {
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
	
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableLHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Mã học phần").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Mã lớp học phần").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Tên lớp học phần").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Lớp tín chỉ").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Số tín chỉ").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Bắt buộc").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Sĩ số tối đa").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Sĩ số đăng ký").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Ngày đăng ký").setCellRenderer(centerCellRenderer);
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
}
