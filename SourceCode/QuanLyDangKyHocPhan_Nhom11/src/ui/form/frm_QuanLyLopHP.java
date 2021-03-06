package ui.form;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

import com.toedter.calendar.JDateChooser;

import dao.ChuyenNganhDAO;
import dao.GiangVienDAO;
import dao.HocPhanDAO;
import dao.KhoaDAO;
import dao.LopHocPhanDAO;
import dao.NhanVienDAO;
import dao.PhieuDangKyDAO;
import dao.PhongHocDAO;
import entity.CT_LopHocPhan;
import entity.GiangVien;
import entity.HocPhan;
import entity.Khoa;
import entity.LopHocPhan;
import entity.NhanVienPDT;
import entity.PhongHoc;

import javax.swing.JCheckBox;

public class frm_QuanLyLopHP extends JPanel {
	private DefaultTableModel modelHP;
	private JTable tableHP;
	private DefaultTableModel modelLHP;
	private JTable tableLHP;
	private JTextField txtMaLHP;
	private JTextField txtTenLHP;
	private JTextField txtLopTC;
	private JTextField txtSiSo;
	private JComboBox<String> cmbKhoa;
	private JComboBox<String> cmbHocKy;
	private JComboBox<String> cmbNamHoc;
	private JComboBox<String> cmbDayNha;
	private JComboBox<String> cmbDayNhaTH;
	private JComboBox<String> cmbPhongHocTH;
	private JComboBox<String> cmbPhongHocLT;
	private JComboBox<String> cmbTenGiangVien;
	private JComboBox<String> cmbTenGiangVienTH;
	private JComboBox<String> cmbChuyenNganh;
	private JComboBox<String> cmbChuyenNganhGVTH;
	private JDateChooser dateBatDau;

	private KhoaDAO khoaDAO = new KhoaDAO();
	private HocPhanDAO hpDAO = new HocPhanDAO();
	private LopHocPhanDAO lopHocPhanDAO = new LopHocPhanDAO();
	private PhongHocDAO phongHocDAO = new PhongHocDAO();
	private ChuyenNganhDAO chuyenNganhDAO = new ChuyenNganhDAO();
	private GiangVienDAO giangVienDAO = new GiangVienDAO();
	private NhanVienDAO nvDAO = new NhanVienDAO();
	private PhieuDangKyDAO phieuDangKyDAO = new PhieuDangKyDAO();

	private Date date1;
	private JComboBox cmbTietHocTH;
	private JDateChooser dateBatDauTH;
	private JDateChooser dateKetThucTH;
	private JPanel pnlButton;
	private JButton btnThemLHP;
	private JButton btnCapNhatLHP;
	private JButton btnHuyLop;
	private JComboBox cmbNgayHocTH;
	private JCheckBox chkThucHanh;
	private JDateChooser dateKetThuc;
	private JComboBox cmbTietHoc;
	private JComboBox cmbNgayHoc;
	private JPanel pnlLyThuyet;
	private JTabbedPane tabHinhThuc;
	private JPanel pnlChiTietLHP;
	private Date ngayKThuc;
	private Date ngayBDau;
	private Date ngayBDauTH;
	private Date ngayKThucTH;

	public frm_QuanLyLopHP(String uname) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		NhanVienPDT nv = nvDAO.layThongTinNV(uname);

		JPanel pnlDsHP = new JPanel();
		pnlDsHP.setBorder(
				new TitledBorder(null, "Danh s??ch h???c ph???n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDsHP.setBounds(30, 10, 576, 319);
		add(pnlDsHP);
		pnlDsHP.setLayout(null);

		JLabel lblChonKhoa = new JLabel("Ch???n khoa");
		lblChonKhoa.setBounds(20, 20, 66, 30);
		pnlDsHP.add(lblChonKhoa);

		cmbKhoa = new JComboBox<String>();
		cmbKhoa.setBounds(94, 20, 197, 30);
		pnlDsHP.add(cmbKhoa);

		JLabel lblChonHK = new JLabel("Ch???n h???c k???");
		lblChonHK.setBounds(301, 20, 79, 30);
		pnlDsHP.add(lblChonHK);

		cmbHocKy = new JComboBox();
		cmbHocKy.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));
		cmbHocKy.setBounds(381, 20, 79, 30);
		pnlDsHP.add(cmbHocKy);

		JButton btnLocDSHP = new JButton("Ch???n");
		btnLocDSHP.setBounds(481, 20, 82, 30);
		pnlDsHP.add(btnLocDSHP);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 69, 553, 240);
		pnlDsHP.add(scrollPane);

		String[] tieuDe = { "STT", "M?? h???c ph???n", "T??n m??n h???c", "S??? t??n ch???", "B???t bu???c" };
		modelHP = new DefaultTableModel(tieuDe, 0);
		tableHP = new JTable(modelHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableHP.getTableHeader().setReorderingAllowed(false);
		tableHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableHP);

		JPanel pnlDsLHP = new JPanel();
		pnlDsLHP.setBorder(
				new TitledBorder(null, "Danh s??ch l???p h???c ph???n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDsLHP.setBounds(616, 10, 703, 319);
		add(pnlDsLHP);
		pnlDsLHP.setLayout(null);

		JLabel lblChonNamHoc = new JLabel("Ch???n n??m h???c");
		lblChonNamHoc.setBounds(230, 20, 87, 30);
		pnlDsLHP.add(lblChonNamHoc);

		cmbNamHoc = new JComboBox();
		cmbNamHoc.setBounds(327, 20, 113, 30);
		cmbNamHoc.setModel(new DefaultComboBoxModel(new String[] { "2020 - 2021", "2021 - 2022" }));
		pnlDsLHP.add(cmbNamHoc);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 68, 683, 241);
		pnlDsLHP.add(scrollPane_1);

		String[] tieuDe2 = { "STT", "M?? l???p h???c ph???n", "T??n l???p h???c ph???n", "L???p t??n ch???", "S?? s??? t???i ??a",
				"S?? s??? ????ng k??", "Tr???ng th??i" };
		modelLHP = new DefaultTableModel(tieuDe2, 0);
		tableLHP = new JTable(modelLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableLHP.getTableHeader().setReorderingAllowed(false);
		tableLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tableLHP);

		JPanel pnlText = new JPanel();
		pnlText.setBorder(
				new TitledBorder(null, "Th??ng tin l???p ph???n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlText.setBounds(30, 339, 1062, 320);
		add(pnlText);
		pnlText.setLayout(null);

		JLabel lblMaLop = new JLabel("M?? l???p h???c ph???n");
		lblMaLop.setBounds(33, 20, 108, 30);
		pnlText.add(lblMaLop);

		txtMaLHP = new JTextField();
		txtMaLHP.setBounds(139, 26, 96, 19);
		pnlText.add(txtMaLHP);
		txtMaLHP.setColumns(10);

		JLabel lblTenLopHP = new JLabel("T??n l???p h???c ph???n");
		lblTenLopHP.setBounds(283, 20, 102, 30);
		pnlText.add(lblTenLopHP);

		txtTenLHP = new JTextField();
		txtTenLHP.setBounds(395, 26, 193, 19);
		pnlText.add(txtTenLHP);
		txtTenLHP.setColumns(10);

		JLabel lblLopTC = new JLabel("L???p t??n ch???");
		lblLopTC.setBounds(653, 20, 69, 30);
		pnlText.add(lblLopTC);

		txtLopTC = new JTextField();
		txtLopTC.setBounds(732, 26, 96, 19);
		pnlText.add(txtLopTC);
		txtLopTC.setColumns(10);

		JLabel lblSiSo = new JLabel("S?? s???");
		lblSiSo.setBounds(877, 20, 45, 30);
		pnlText.add(lblSiSo);

		txtSiSo = new JTextField();
		txtSiSo.setBounds(921, 26, 96, 19);
		pnlText.add(txtSiSo);
		txtSiSo.setColumns(10);

		pnlChiTietLHP = new JPanel();
		pnlChiTietLHP.setBorder(
				new TitledBorder(null, "Chi ti???t l???p h???c ph???n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChiTietLHP.setBounds(10, 66, 1042, 244);
		pnlText.add(pnlChiTietLHP);
		pnlChiTietLHP.setLayout(null);

		tabHinhThuc = new JTabbedPane(JTabbedPane.TOP);
		tabHinhThuc.setBounds(10, 25, 1022, 209);
		pnlChiTietLHP.add(tabHinhThuc);

		pnlLyThuyet = new JPanel();
		JPanel pnlThucHanh = new JPanel();
		tabHinhThuc.addTab("L?? thuy???t", pnlLyThuyet);
		pnlLyThuyet.setLayout(null);

		JLabel lblNgayHoc = new JLabel("Ng??y h???c");
		lblNgayHoc.setBounds(24, 20, 75, 30);
		pnlLyThuyet.add(lblNgayHoc);

		cmbNgayHoc = new JComboBox();
		cmbNgayHoc.setBounds(110, 20, 170, 30);
		cmbNgayHoc.setModel(new DefaultComboBoxModel(
				new String[] { "Th??? hai", "Th??? ba", "Th??? t??", "Th??? n??m", "Th??? s??u", "Th??? b???y", "Ch??? nh???t" }));
		pnlLyThuyet.add(cmbNgayHoc);

		JLabel lblTietHoc = new JLabel("Ti???t h???c");
		lblTietHoc.setBounds(340, 20, 59, 30);
		pnlLyThuyet.add(lblTietHoc);

		cmbTietHoc = new JComboBox();
		cmbTietHoc.setBounds(410, 20, 87, 30);
		cmbTietHoc.setModel(new DefaultComboBoxModel(new String[] { "1 - 3", "4 - 6", "7 - 9", "10 - 12", "13 - 15" }));
		pnlLyThuyet.add(cmbTietHoc);

		JLabel lblDayNha = new JLabel("D??y nh??");
		lblDayNha.setBounds(594, 20, 45, 30);
		pnlLyThuyet.add(lblDayNha);

		cmbDayNha = new JComboBox();
		cmbDayNha.setBounds(657, 20, 59, 30);
		pnlLyThuyet.add(cmbDayNha);

		JLabel lblPhongHoc = new JLabel("Ph??ng h???c");
		lblPhongHoc.setBounds(807, 20, 66, 30);
		pnlLyThuyet.add(lblPhongHoc);

		cmbPhongHocLT = new JComboBox();
		cmbPhongHocLT.setBounds(883, 20, 87, 30);
		pnlLyThuyet.add(cmbPhongHocLT);

		JLabel lblGiangVien = new JLabel("Gi???ng vi??n");
		lblGiangVien.setBounds(24, 80, 75, 30);
		pnlLyThuyet.add(lblGiangVien);

		cmbChuyenNganh = new JComboBox();
		cmbChuyenNganh.setBounds(110, 80, 170, 30);
		pnlLyThuyet.add(cmbChuyenNganh);

		cmbTenGiangVien = new JComboBox();
		cmbTenGiangVien.setBounds(410, 80, 352, 30);
		pnlLyThuyet.add(cmbTenGiangVien);

		JLabel lblNgBatDau = new JLabel("Ng??y b???t ?????u");
		lblNgBatDau.setBounds(24, 140, 92, 30);
		pnlLyThuyet.add(lblNgBatDau);

		dateBatDau = new JDateChooser();
		dateBatDau.setBounds(110, 140, 170, 30);
		dateBatDau.setDateFormatString("dd-MM-yyyy");
		pnlLyThuyet.add(dateBatDau);

		JLabel lblNgKetThuc = new JLabel("Ng??y k???t th??c");
		lblNgKetThuc.setBounds(316, 140, 87, 30);
		pnlLyThuyet.add(lblNgKetThuc);

		dateKetThuc = new JDateChooser();
		dateKetThuc.setBounds(410, 140, 170, 30);
		dateKetThuc.setDateFormatString("dd-MM-yyyy");
		pnlLyThuyet.add(dateKetThuc);

		chkThucHanh = new JCheckBox("C?? th???c h??nh");
		chkThucHanh.setBounds(785, 140, 144, 30);
		pnlLyThuyet.add(chkThucHanh);

		pnlThucHanh.setLayout(null);

		JLabel lblNgayHocTH = new JLabel("Ng??y h???c");
		lblNgayHocTH.setBounds(24, 20, 75, 30);
		pnlThucHanh.add(lblNgayHocTH);

		cmbNgayHocTH = new JComboBox();
		cmbNgayHocTH.setBounds(110, 20, 170, 30);
		cmbNgayHocTH.setModel(new DefaultComboBoxModel(new String[] { "Th??? hai", "Th??? ba", "Th??? t??", "Th??? n??m", "Th??? s??u", "Th??? b???y", "Ch??? nh???t" }));
		pnlThucHanh.add(cmbNgayHocTH);

		JLabel lblTietHocTH = new JLabel("Ti???t h???c");
		lblTietHocTH.setBounds(340, 20, 59, 30);
		pnlThucHanh.add(lblTietHocTH);

		cmbTietHocTH = new JComboBox();
		cmbTietHocTH.setBounds(410, 20, 87, 30);
		cmbTietHocTH.setModel(new DefaultComboBoxModel(new String[] { "1 - 3", "4 - 6", "7 - 9", "10 - 12", "13 - 15" }));
		pnlThucHanh.add(cmbTietHocTH);

		JLabel lblDayNhaTH = new JLabel("D??y nh??");
		lblDayNhaTH.setBounds(594, 20, 45, 30);
		pnlThucHanh.add(lblDayNhaTH);

		cmbDayNhaTH = new JComboBox();
		cmbDayNhaTH.setBounds(657, 20, 59, 30);
		pnlThucHanh.add(cmbDayNhaTH);

		JLabel lblPhongHocTH = new JLabel("Ph??ng h???c");
		lblPhongHocTH.setBounds(807, 20, 66, 30);
		pnlThucHanh.add(lblPhongHocTH);

		cmbPhongHocTH = new JComboBox();
		cmbPhongHocTH.setBounds(883, 20, 87, 30);
		pnlThucHanh.add(cmbPhongHocTH);

		JLabel lblGiangVienTH = new JLabel("Gi???ng vi??n");
		lblGiangVienTH.setBounds(24, 80, 75, 30);
		pnlThucHanh.add(lblGiangVienTH);

		cmbChuyenNganhGVTH = new JComboBox();
		cmbChuyenNganhGVTH.setBounds(110, 80, 170, 30);
		pnlThucHanh.add(cmbChuyenNganhGVTH);

		cmbTenGiangVienTH = new JComboBox();
		cmbTenGiangVienTH.setBounds(410, 80, 352, 30);
		pnlThucHanh.add(cmbTenGiangVienTH);

		JLabel lblNgBatDauTH = new JLabel("Ng??y b???t ?????u");
		lblNgBatDauTH.setBounds(24, 140, 92, 30);
		pnlThucHanh.add(lblNgBatDauTH);

		dateBatDauTH = new JDateChooser();
		dateBatDauTH.setBounds(110, 140, 170, 30);
		dateBatDauTH.setDateFormatString("dd-MM-yyyy");
		pnlThucHanh.add(dateBatDauTH);

		JLabel lblNgKetThucTH = new JLabel("Ng??y k???t th??c");
		lblNgKetThucTH.setBounds(316, 140, 87, 30);
		pnlThucHanh.add(lblNgKetThucTH);

		dateKetThucTH = new JDateChooser();
		dateKetThucTH.setBounds(410, 140, 170, 30);
		dateKetThucTH.setDateFormatString("dd-MM-yyyy");
		pnlThucHanh.add(dateKetThucTH);

		pnlButton = new JPanel();
		pnlButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlButton.setBounds(1124, 345, 195, 314);
		add(pnlButton);
		pnlButton.setLayout(null);

		btnThemLHP = new JButton("M??? l???p");
		btnThemLHP.setBounds(40, 100, 120, 50);
		pnlButton.add(btnThemLHP);

		btnCapNhatLHP = new JButton("C???p nh???t");
		btnCapNhatLHP.setBounds(40, 170, 120, 50);
		pnlButton.add(btnCapNhatLHP);

		btnHuyLop = new JButton("H???y l???p");
		btnHuyLop.setBounds(40, 240, 120, 50);
		pnlButton.add(btnHuyLop);
		
		JButton btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setBounds(40, 30, 120, 50);
		pnlButton.add(btnLamMoi);

		// ===================================================================
		btnHuyLop.setEnabled(false);
		btnCapNhatLHP.setEnabled(false);
		btnThemLHP.setEnabled(false);
		napCmbKhoa();
		napCmbDayNhaLT();
		napCmbDayNhaTH();

		btnLocDSHP.addActionListener(e -> {
			String tenKhoa = cmbKhoa.getItemAt(cmbKhoa.getSelectedIndex());
			String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex());
			int hocKy = Integer.parseInt(hk);
			napTBHocPhan(tenKhoa, hocKy);
			napCmbChuyenNganhGV();
			
			emptyTextField();
			resetFormLT();
			resetFormTH();
			chkThucHanh.setSelected(false);
			btnThemLHP.setEnabled(false);
			btnHuyLop.setEnabled(false);
			btnCapNhatLHP.setEnabled(false);
		});

		tableHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
				int index = tableHP.getSelectedRow();
				if (index >= 0 && index < tableHP.getRowCount()) {
					String maHp = tableHP.getValueAt(index, 1).toString();
					emptyTextField();
					resetFormLT();
					resetFormTH();
					txtTenLHP.setText(tableHP.getValueAt(index, 2).toString());
					napTBLopHocPhan(maHp, namhoc);
					chkThucHanh.setSelected(false);
					btnThemLHP.setEnabled(true);
					btnHuyLop.setEnabled(false);
					btnCapNhatLHP.setEnabled(false);
				}
				
			}

		});

		cmbNamHoc.addActionListener(e -> {
			String namHoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
			int index = tableHP.getSelectedRow();
			if (index >= 0 && index < tableHP.getRowCount()) {
				String maHp = tableHP.getValueAt(index, 1).toString();
				napTBLopHocPhan(maHp, namHoc);
			}
		});

		tableLHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableLHP.getSelectedRow();
				if (index >= 0 && index < tableLHP.getRowCount()) {
					String maLHP = tableLHP.getValueAt(index, 1).toString();
					String trThai = tableLHP.getValueAt(index, 6).toString();
					
					LopHocPhan lhp = lopHocPhanDAO.timLopTheoMa(maLHP);
					
					//Ch???n c???p nh???t c??c l???p h???c ph???n c?? tr???ng th??i "???? kh??a"
					if (trThai.equals("???? kh??a")) {
						btnThemLHP.setEnabled(false);
						btnHuyLop.setEnabled(false);
						btnCapNhatLHP.setEnabled(false);
					}else {
						btnThemLHP.setEnabled(false);
						btnHuyLop.setEnabled(true);
						btnCapNhatLHP.setEnabled(true);
					}
					
					napFormLopHocPhan(lhp);
				}
			}

			private void napFormLopHocPhan(LopHocPhan lhp) {
				txtMaLHP.setEditable(false);
				txtMaLHP.setText(lhp.getMaLopHocPhan());
				txtTenLHP.setText(lhp.getTenLopHocPhan());
				txtLopTC.setText(lhp.getLopTinChi());
				txtSiSo.setText(lhp.getSiSoToiDa() + "");
				if (lopHocPhanDAO.kiemTraLHPCoThucHanh(lhp.getMaLopHocPhan())) {
					napCmbLT(lhp);
					napCmbTH(lhp);
					chkThucHanh.setSelected(true);
				} else {
					napCmbLT(lhp);
					resetFormTH();
					chkThucHanh.setSelected(false);
				}
			}

			private void napCmbLT(LopHocPhan lhp) {
				CT_LopHocPhan ct = lopHocPhanDAO.layCTLopLyThuyet(lhp.getMaLopHocPhan());
				
				// N???p cmb ng??y h???c
				String[] str = { "Th??? hai", "Th??? ba", "Th??? t??", "Th??? n??m", "Th??? s??u", "Th??? b???y", "Ch??? nh???t" };
				for (int i = 0; i < str.length; i++) {
					if (ct.getThu().equals(str[i])) {
						cmbNgayHoc.setSelectedIndex(i);
					}
				}
				// N???p cmb ti???t h???c
				String[] str2 = { "1 - 3", "4 - 6", "7 - 9", "10 - 12", "13 - 15" };
				for (int j = 0; j < str2.length; j++) {
					if (ct.getTietHoc().equals(str2[j])) {
						cmbTietHoc.setSelectedIndex(j);
					}
				}
				// N???p cmb ph??ng h???c
				napCmbDayNhaLT();
				PhongHoc ph2 = phongHocDAO.timPhongHoc(ct.getPhongHoc().getMaPhong());
				napCmbPhongHoc(ph2.getDayNha());
				List<String> strDayNha = phongHocDAO.layDSDayNha("L?? thuy???t");
				for (int i = 0; i < strDayNha.size(); i++) {
					if (ph2.getDayNha().equals(strDayNha.get(i))) {
						cmbDayNha.setSelectedIndex(i);
					}
				}
				List<String> strPhongHoc = phongHocDAO.layDSPhongHoc(ph2.getDayNha());
				for (int i = 0; i < strPhongHoc.size(); i++) {
					if (ph2.getTenPhong().equals(strPhongHoc.get(i))) {
						cmbPhongHocLT.setSelectedIndex(i);
					}
				}
				// N???p cmb gi???ng vi??n
				GiangVien gv = giangVienDAO.timGiangVien(ct.getGiangVien().getMaGiangVien());
				napCmbGiangVien(gv.getChuyenNganh().getTenChuyenNganh());
				String maKhoa = khoaDAO.layMaKhoaTheoTen(cmbKhoa.getItemAt(cmbKhoa.getSelectedIndex()));
				List<String> dsChNganh = chuyenNganhDAO.layDsChuyenNganhTheoMaKhoa(maKhoa);
				for (int i = 0; i < dsChNganh.size(); i++) {
					if (gv.getChuyenNganh().getTenChuyenNganh().equals(dsChNganh.get(i))) {
						cmbChuyenNganh.setSelectedIndex(i + 1);
					}
				}
				List<String> dsGV = giangVienDAO.layDsGiangVienTheoMaChNganh(gv.getChuyenNganh().getMaChuyenNganh());
				for (int i = 0; i < dsGV.size(); i++) {
					if (gv.getTenGiangVien().equals(dsGV.get(i))) {
						cmbTenGiangVien.setSelectedIndex(i + 1);
					}
				}
				//N???p ng??y
				String dateBD = ct.getNgayBatDau()+"";
				String dateKT = ct.getNgayKetThuc()+"";
				java.util.Date ngBatDau, ngKetThuc;
				try {
					ngBatDau = new SimpleDateFormat("yyyy-MM-dd").parse(dateBD);
					dateBatDau.setDate(ngBatDau);
					dateBatDau.setToolTipText(String.valueOf(ngBatDau));
					
					ngKetThuc = new SimpleDateFormat("yyyy-MM-dd").parse(dateKT);
					dateKetThuc.setDate(ngKetThuc);
					dateKetThuc.setToolTipText(String.valueOf(ngKetThuc));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			private void napCmbTH(LopHocPhan lhp) {
				CT_LopHocPhan ct2 = lopHocPhanDAO.layCTLopThucHanh(lhp.getMaLopHocPhan());
				
				// N???p cmb ng??y h???c
				String[] str = { "Th??? hai", "Th??? ba", "Th??? t??", "Th??? n??m", "Th??? s??u", "Th??? b???y", "Ch??? nh???t" };
				for (int i = 0; i < str.length; i++) {
					if (ct2.getThu().equals(str[i])) {
						cmbNgayHocTH.setSelectedIndex(i);
					}
				}
				// N???p cmb ti???t h???c
				String[] str2 = { "1 - 3", "4 - 6", "7 - 9", "10 - 12", "13 - 15" };
				for (int j = 0; j < str2.length; j++) {
					if (ct2.getTietHoc().equals(str2[j])) {
						cmbTietHocTH.setSelectedIndex(j);
					}
				}
				// N???p cmb ph??ng h???c
				napCmbDayNhaTH();
				PhongHoc ph2 = phongHocDAO.timPhongHoc(ct2.getPhongHoc().getMaPhong());
				napCmbPhongHocTH(ph2.getDayNha());
				List<String> strDayNha = phongHocDAO.layDSDayNha("Th???c h??nh");
				for (int i = 0; i < strDayNha.size(); i++) {
					if (ph2.getDayNha().equals(strDayNha.get(i))) {
						cmbDayNhaTH.setSelectedIndex(i);
					}
				}
				List<String> strPhongHoc = phongHocDAO.layDSPhongHoc(ph2.getDayNha());
				for (int i = 0; i < strPhongHoc.size(); i++) {
					if (ph2.getTenPhong().equals(strPhongHoc.get(i))) {
						cmbPhongHocTH.setSelectedIndex(i);
					}
				}
				// N???p cmb gi??ng vi??n
				GiangVien gv = giangVienDAO.timGiangVien(ct2.getGiangVien().getMaGiangVien());
				napCmbGiangVienTH(gv.getChuyenNganh().getTenChuyenNganh());
				String maKhoa = khoaDAO.layMaKhoaTheoTen(cmbKhoa.getItemAt(cmbKhoa.getSelectedIndex()));
				List<String> dsChNganh = chuyenNganhDAO.layDsChuyenNganhTheoMaKhoa(maKhoa);
				for (int i = 0; i < dsChNganh.size(); i++) {
					if (gv.getChuyenNganh().getTenChuyenNganh().equals(dsChNganh.get(i))) {
						cmbChuyenNganhGVTH.setSelectedIndex(i + 1);
					}
				}
				List<String> dsGV = giangVienDAO.layDsGiangVienTheoMaChNganh(gv.getChuyenNganh().getMaChuyenNganh());
				for (int i = 0; i < dsGV.size(); i++) {
					if (gv.getTenGiangVien().equals(dsGV.get(i))) {
						cmbTenGiangVienTH.setSelectedIndex(i + 1);
					}
				}
				//N???p ng??y
				String dateBD = ct2.getNgayBatDau()+"";
				String dateKT = ct2.getNgayKetThuc()+"";
				java.util.Date ngBatDau, ngKetThuc;
				try {
					ngBatDau = new SimpleDateFormat("yyyy-MM-dd").parse(dateBD);
					dateBatDauTH.setDate(ngBatDau);
					dateBatDauTH.setToolTipText(String.valueOf(ngBatDau));
					
					ngKetThuc = new SimpleDateFormat("yyyy-MM-dd").parse(dateKT);
					dateKetThucTH.setDate(ngKetThuc);
					dateKetThucTH.setToolTipText(String.valueOf(ngKetThuc));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
			
		});

		cmbDayNha.addActionListener(e -> {
			String dayNha = cmbDayNha.getItemAt(cmbDayNha.getSelectedIndex());
			napCmbPhongHoc(dayNha);
		});

		cmbDayNhaTH.addActionListener(e -> {
			String dayNha = cmbDayNhaTH.getItemAt(cmbDayNhaTH.getSelectedIndex());
			napCmbPhongHocTH(dayNha);
		});

		cmbChuyenNganh.addActionListener(e -> {
			String tenChNganh = cmbChuyenNganh.getItemAt(cmbChuyenNganh.getSelectedIndex());
			napCmbGiangVien(tenChNganh);
		});

		cmbChuyenNganhGVTH.addActionListener(e -> {
			String tenChNganh = cmbChuyenNganhGVTH.getItemAt(cmbChuyenNganhGVTH.getSelectedIndex());
			napCmbGiangVienTH(tenChNganh);
		});

		chkThucHanh.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tabHinhThuc.addTab("Th???c h??nh", pnlThucHanh);
				} else {
					tabHinhThuc.remove(1);
				}
			}
		});
		
		btnLamMoi.addActionListener(e ->{
			emptyTextField();
			resetFormLT();
			resetFormTH();
			chkThucHanh.setSelected(false);
			btnThemLHP.setEnabled(true);
			btnHuyLop.setEnabled(false);
			btnCapNhatLHP.setEnabled(false);
		});
		
		btnThemLHP.addActionListener(e ->{
			int index = tableHP.getSelectedRow();

			if (index>=0 && index<tableHP.getRowCount()) {
				if (kiemTraLHP()) {
					if (kiemTraCTLHP()) {			
							String maLHP = txtMaLHP.getText();
							String tenLHP = txtTenLHP.getText();
							String lopTC = txtLopTC.getText();
							int siSoToiDa = Integer.parseInt(txtSiSo.getText());
							String namHoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
							String maHP = tableHP.getValueAt(index, 1).toString();
							
							LopHocPhan lopHocPhan = new LopHocPhan(maLHP, tenLHP, lopTC, siSoToiDa, 0, namHoc, "Ch??? ????ng k??", new HocPhan(maHP));
							lopHocPhan.setNguoiMoLop(nv);
							lopHocPhanDAO.themLopHocPhan(lopHocPhan);
							
							String thu = cmbNgayHoc.getItemAt(cmbNgayHoc.getSelectedIndex()).toString();
							String tietHoc = cmbTietHoc.getItemAt(cmbTietHoc.getSelectedIndex()).toString();
							String phongHoc = cmbPhongHocLT.getItemAt(cmbPhongHocLT.getSelectedIndex()).toString();
							
							String tengiangVien = cmbTenGiangVien.getItemAt(cmbTenGiangVien.getSelectedIndex()).toString();
							String tenCN = cmbChuyenNganh.getItemAt(cmbChuyenNganh.getSelectedIndex());
							String magiangVien = giangVienDAO.layMaGVTheoTen(tengiangVien, chuyenNganhDAO.layMaChNganhTheoTen(tenCN));
							
							java.util.Date dateBD = dateBatDau.getDate();
							java.util.Date dateKT = dateKetThuc.getDate();
							ngayBDau = new java.sql.Date(dateBD.getTime());
							ngayKThuc = new java.sql.Date(dateKT.getTime());
							
							PhongHoc ph = phongHocDAO.timPhongHocTheoTen(phongHoc);
							
							CT_LopHocPhan ct1 = new CT_LopHocPhan(lopHocPhan, new GiangVien(magiangVien), "L?? thuy???t", thu, tietHoc, ph, ngayBDau, ngayKThuc);
							lopHocPhanDAO.themCTLopHocPhan(ct1);
							
							if (chkThucHanh.isSelected()) {							
									String thuTH = cmbNgayHocTH.getItemAt(cmbNgayHocTH.getSelectedIndex()).toString();
									String tietHocTH = cmbTietHocTH.getItemAt(cmbTietHocTH.getSelectedIndex()).toString();
									String phongHocTH = cmbPhongHocTH.getItemAt(cmbPhongHocTH.getSelectedIndex()).toString();
									
									String tengiangVienTH = cmbTenGiangVienTH.getItemAt(cmbTenGiangVienTH.getSelectedIndex()).toString();
									String tenCNTH = cmbChuyenNganhGVTH.getItemAt(cmbChuyenNganhGVTH.getSelectedIndex());
									String magiangVienTH = giangVienDAO.layMaGVTheoTen(tengiangVienTH, chuyenNganhDAO.layMaChNganhTheoTen(tenCNTH));
									
									java.util.Date dateBDTH = dateBatDauTH.getDate();
									java.util.Date dateKTTH = dateKetThucTH.getDate();
									ngayBDauTH = new java.sql.Date(dateBD.getTime());
									ngayKThucTH = new java.sql.Date(dateKT.getTime());
									PhongHoc ph_ThucHanh = phongHocDAO.timPhongHocTheoTen(phongHocTH);
									CT_LopHocPhan ct2 = new CT_LopHocPhan(lopHocPhan, new GiangVien(magiangVienTH), "Th???c h??nh", thuTH, tietHocTH, ph_ThucHanh, ngayBDauTH, ngayKThucTH);
									lopHocPhanDAO.themCTLopHocPhan(ct2);
							}
							
							JOptionPane.showMessageDialog(null, "M??? l???p th??nh c??ng!", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
							String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
							int i = tableHP.getSelectedRow();
							String maHp = tableHP.getValueAt(i, 1).toString();
							napTBLopHocPhan(maHp, namhoc);
							
							emptyTextField();
							resetFormLT();
							resetFormTH();
							chkThucHanh.setSelected(false);
							btnThemLHP.setEnabled(true);
							btnHuyLop.setEnabled(false);
							btnCapNhatLHP.setEnabled(false);
						
					}
				}				
			}else {
				JOptionPane.showMessageDialog(null, "Ch??a ch???n h???c ph???n!", "L???i", JOptionPane.ERROR_MESSAGE);
			}		
		});
		
		btnHuyLop.addActionListener(e ->{
			int index = tableLHP.getSelectedRow();
			if (index>=0 && index<tableLHP.getRowCount()) {
				String malhp = tableLHP.getValueAt(index, 1).toString();
				String trthai = tableLHP.getValueAt(index, 6).toString();
				if (JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n h???y l???p h???c ph???n n??y kh??ng?", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (!trthai.equals("???? kh??a")) {
						if (!trthai.equals("Ch???p nh???n m??? l???p")) {
							phieuDangKyDAO.xoaPhieuDangKy(malhp);
							lopHocPhanDAO.xoaCTLopHP(malhp);
							lopHocPhanDAO.xoaLopHP(malhp);
							
							JOptionPane.showMessageDialog(null, "H???y l???p th??nh c??ng!", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
							String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
							int i = tableHP.getSelectedRow();
							String maHp = tableHP.getValueAt(i, 1).toString();
							napTBLopHocPhan(maHp, namhoc);
							
							emptyTextField();
							resetFormLT();
							resetFormTH();
							chkThucHanh.setSelected(false);
							btnThemLHP.setEnabled(true);
							btnHuyLop.setEnabled(false);
							btnCapNhatLHP.setEnabled(false);
						}else {
							JOptionPane.showMessageDialog(null, "L???p h???c ph???n ???? ch???p nh???n m???, kh??ng th??? h???y!", "L???i", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "L???p h???c ph???n ??ang kh??a, kh??ng th??? h???y!", "L???i", JOptionPane.ERROR_MESSAGE);
					}	
				}
			}
		});
		
		btnCapNhatLHP.addActionListener(e ->{
			int index = tableHP.getSelectedRow();
			
			if (index>=0 && index<tableHP.getRowCount()) {
				if (kiemTraLHP()) {
					if (kiemTraCTLHP()) {
							String maLHP = txtMaLHP.getText();
							String tenLHP = txtTenLHP.getText();
							String lopTC = txtLopTC.getText();
							int siSoToiDa = Integer.parseInt(txtSiSo.getText());
							lopHocPhanDAO.capNhatLopHP(maLHP, tenLHP, lopTC, siSoToiDa);
							
							String thu = cmbNgayHoc.getItemAt(cmbNgayHoc.getSelectedIndex()).toString();
							String tietHoc = cmbTietHoc.getItemAt(cmbTietHoc.getSelectedIndex()).toString();
							String phongHoc = cmbPhongHocLT.getItemAt(cmbPhongHocLT.getSelectedIndex()).toString();
							
							String tengiangVien = cmbTenGiangVien.getItemAt(cmbTenGiangVien.getSelectedIndex()).toString();
							String tenCN = cmbChuyenNganh.getItemAt(cmbChuyenNganh.getSelectedIndex());
							String magiangVien = giangVienDAO.layMaGVTheoTen(tengiangVien, chuyenNganhDAO.layMaChNganhTheoTen(tenCN));
							
							java.util.Date dateBD = dateBatDau.getDate();
							java.util.Date dateKT = dateKetThuc.getDate();
							ngayBDau = new java.sql.Date(dateBD.getTime());
							ngayKThuc = new java.sql.Date(dateKT.getTime());
							
							PhongHoc ph = phongHocDAO.timPhongHocTheoTen(phongHoc);
							
							CT_LopHocPhan ct1 = new CT_LopHocPhan(new LopHocPhan(maLHP), new GiangVien(magiangVien), "L?? thuy???t", thu, tietHoc, ph, ngayBDau, ngayKThuc);
							lopHocPhanDAO.capNhatCTLopHP(ct1);
							
							if (chkThucHanh.isSelected()) {
								String thuTH = cmbNgayHocTH.getItemAt(cmbNgayHocTH.getSelectedIndex()).toString();
								String tietHocTH = cmbTietHocTH.getItemAt(cmbTietHocTH.getSelectedIndex()).toString();
								String phongHocTH = cmbPhongHocTH.getItemAt(cmbPhongHocTH.getSelectedIndex()).toString();
								
								String tengiangVienTH = cmbTenGiangVienTH.getItemAt(cmbTenGiangVienTH.getSelectedIndex()).toString();
								String tenCNTH = cmbChuyenNganhGVTH.getItemAt(cmbChuyenNganhGVTH.getSelectedIndex());
								String magiangVienTH = giangVienDAO.layMaGVTheoTen(tengiangVienTH, chuyenNganhDAO.layMaChNganhTheoTen(tenCNTH));
								
								java.util.Date dateBDTH = dateBatDauTH.getDate();
								java.util.Date dateKTTH = dateKetThucTH.getDate();
								ngayBDauTH = new java.sql.Date(dateBD.getTime());
								ngayKThucTH = new java.sql.Date(dateKT.getTime());
								PhongHoc ph_ThucHanh = phongHocDAO.timPhongHocTheoTen(phongHocTH);
								CT_LopHocPhan ct2 = new CT_LopHocPhan(new LopHocPhan(maLHP), new GiangVien(magiangVienTH), "Th???c h??nh", thuTH, tietHocTH, ph_ThucHanh, ngayBDauTH, ngayKThucTH);
								
								if (lopHocPhanDAO.layDsCTLopHoc(maLHP).size()<2) {
									lopHocPhanDAO.themCTLopHocPhan(ct2);
								}else {
									lopHocPhanDAO.capNhatCTLopHP(ct2);
								}
							}else {
								if (lopHocPhanDAO.layDsCTLopHoc(maLHP).size()>1) {
									lopHocPhanDAO.xoaCTLopHP_TH(maLHP);
								}
							}
							
							JOptionPane.showMessageDialog(null, "C???p nh???t th??nh c??ng!", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
							String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
							int i = tableHP.getSelectedRow();
							String maHp = tableHP.getValueAt(i, 1).toString();
							napTBLopHocPhan(maHp, namhoc);
							
							emptyTextField();
							resetFormLT();
							resetFormTH();
							chkThucHanh.setSelected(false);
							btnThemLHP.setEnabled(true);
							btnHuyLop.setEnabled(false);
							btnCapNhatLHP.setEnabled(false);
						
					}
				}			
			}else {
				JOptionPane.showMessageDialog(null, "Ch??a ch???n h???c ph???n!", "L???i", JOptionPane.ERROR_MESSAGE);
			}
		});

		setTBHocPhanColumnWidth();
		setTBLopHocPhanColumnWidth();
		tableRenderer();
		tableDesign(tableHP);
		tableDesign(tableLHP);
	}
	

	private void emptyTextField() {
		txtMaLHP.setText("");
		txtTenLHP.setText("");
		txtLopTC.setText("");
		txtSiSo.setText("");
		txtMaLHP.setEditable(true);
	}

	private void setTBHocPhanColumnWidth() {
		TableColumn column = null;
		for (int i = 0; i < tableHP.getColumnCount(); i++) {
			column = tableHP.getColumnModel().getColumn(i);
			if (i == 2) {
				column.setPreferredWidth(200);
			}
		}
	}

	private void setTBLopHocPhanColumnWidth() {
		TableColumn column = null;
		for (int i = 0; i < tableLHP.getColumnCount(); i++) {
			column = tableLHP.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(10);
			}
			if (i == 2) {
				column.setPreferredWidth(150);
			}
		}
	}

	private void tableRenderer() {
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("M?? h???c ph???n").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("T??n m??n h???c").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("S??? t??n ch???").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("B???t bu???c").setCellRenderer(centerCellRenderer);

		tableLHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("M?? l???p h???c ph???n").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("T??n l???p h???c ph???n").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("L???p t??n ch???").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("S?? s??? t???i ??a").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("S?? s??? ????ng k??").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Tr???ng th??i").setCellRenderer(centerCellRenderer);
	}
	
	private void resetFormLT() {
		cmbNgayHoc.setSelectedIndex(0);
		cmbTietHoc.setSelectedIndex(0);
		cmbDayNha.setSelectedIndex(0);
		cmbChuyenNganh.setSelectedIndex(0);
		String dateBD = LocalDate.now()+"";
		String dateKT = LocalDate.now()+"";
		java.util.Date ngBatDau, ngKetThuc;
		try {
			ngBatDau = new SimpleDateFormat("yyyy-MM-dd").parse(dateBD);
			dateBatDau.setDate(ngBatDau);
			dateBatDau.setToolTipText(String.valueOf(ngBatDau));
			
			ngKetThuc = new SimpleDateFormat("yyyy-MM-dd").parse(dateKT);
			dateKetThuc.setDate(ngKetThuc);
			dateKetThuc.setToolTipText(String.valueOf(ngKetThuc));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
	
	private void resetFormTH() {
		cmbNgayHocTH.setSelectedIndex(0);
		cmbTietHocTH.setSelectedIndex(0);
		cmbDayNhaTH.setSelectedIndex(0);
		cmbChuyenNganhGVTH.setSelectedIndex(0);
		String dateBD = LocalDate.now()+"";
		String dateKT = LocalDate.now()+"";
		java.util.Date ngBatDau, ngKetThuc;
		try {
			ngBatDau = new SimpleDateFormat("yyyy-MM-dd").parse(dateBD);
			dateBatDauTH.setDate(ngBatDau);
			dateBatDauTH.setToolTipText(String.valueOf(ngBatDau));
			
			ngKetThuc = new SimpleDateFormat("yyyy-MM-dd").parse(dateKT);
			dateKetThucTH.setDate(ngKetThuc);
			dateKetThucTH.setToolTipText(String.valueOf(ngKetThuc));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	private void napCmbKhoa() {
		List<String> str = khoaDAO.layDanhSachTenKhoa();
		String[] tenKhoa = new String[str.size()];

		for (int i = 0; i < str.size(); i++) {
			tenKhoa[i] = str.get(i);
		}
		cmbKhoa.setModel(new DefaultComboBoxModel<>(tenKhoa));
	}

	private void napCmbDayNhaLT() {
		List<String> str = phongHocDAO.layDSDayNha("L?? thuy???t");
		String[] dayNha = new String[str.size()];

		for (int i = 0; i < str.size(); i++) {
			dayNha[i] = str.get(i);
		}
		cmbDayNha.setModel(new DefaultComboBoxModel<>(dayNha));
	}

	private void napCmbDayNhaTH() {
		List<String> str = phongHocDAO.layDSDayNha("Th???c h??nh");
		String[] dayNha = new String[str.size()];

		for (int i = 0; i < str.size(); i++) {
			dayNha[i] = str.get(i);
		}
		cmbDayNhaTH.setModel(new DefaultComboBoxModel<>(dayNha));
	}

	private void napCmbPhongHoc(String dayNha) {
		List<String> str = phongHocDAO.layDSPhongHoc(dayNha);
		String[] phHoc = new String[str.size()];

		for (int i = 0; i < str.size(); i++) {
			phHoc[i] = str.get(i);
		}
		cmbPhongHocLT.setModel(new DefaultComboBoxModel<>(phHoc));
	}

	private void napCmbPhongHocTH(String dayNha) {
		List<String> str = phongHocDAO.layDSPhongHoc(dayNha);
		String[] phHoc = new String[str.size()];

		for (int i = 0; i < str.size(); i++) {
			phHoc[i] = str.get(i);
		}
		cmbPhongHocTH.setModel(new DefaultComboBoxModel<>(phHoc));
	}

	private void napCmbChuyenNganhGV() {
		String maKhoa = khoaDAO.layMaKhoaTheoTen(cmbKhoa.getItemAt(cmbKhoa.getSelectedIndex()));
		List<String> dsChNganh = chuyenNganhDAO.layDsChuyenNganhTheoMaKhoa(maKhoa);
		String[] chNganh = new String[dsChNganh.size() + 1];
		chNganh[0] = "==Ch???n chuy??n ng??nh==";
		for (int i = 0; i < dsChNganh.size(); i++) {
			chNganh[i + 1] = dsChNganh.get(i);
		}
		cmbChuyenNganh.setModel(new DefaultComboBoxModel<>(chNganh));
		cmbChuyenNganhGVTH.setModel(new DefaultComboBoxModel<>(chNganh));
	}

	private void napCmbGiangVien(String tenChNganh) {
		String maChNganh = chuyenNganhDAO.layMaChNganhTheoTen(tenChNganh);
		List<String> dsGV = giangVienDAO.layDsGiangVienTheoMaChNganh(maChNganh);
		String[] giVien = new String[dsGV.size() + 1];
		giVien[0] = "==Ch???n gi???ng vi??n==";
		for (int i = 0; i < dsGV.size(); i++) {
			giVien[i + 1] = dsGV.get(i);
		}
		cmbTenGiangVien.setModel(new DefaultComboBoxModel<>(giVien));
	}

	private void napCmbGiangVienTH(String tenChNganh) {
		String maChNganh = chuyenNganhDAO.layMaChNganhTheoTen(tenChNganh);
		List<String> dsGV = giangVienDAO.layDsGiangVienTheoMaChNganh(maChNganh);
		String[] giVien = new String[dsGV.size() + 1];
		giVien[0] = "==Ch???n gi???ng vi??n==";
		for (int i = 0; i < dsGV.size(); i++) {
			giVien[i + 1] = dsGV.get(i);
		}
		cmbTenGiangVienTH.setModel(new DefaultComboBoxModel<>(giVien));
	}

	private void xoaTBHocPhan() {
		while (modelHP.getRowCount() > 0) {
			modelHP.removeRow(0);
		}
	}

	private void napTBHocPhan(String tenKhoa, int hocKy) {
		xoaTBHocPhan();
		String maKhoa = khoaDAO.layMaKhoaTheoTen(tenKhoa);
		List<HocPhan> dshp = hpDAO.layDsHocPhan(hocKy, maKhoa);
		int i = 1;
		for (HocPhan hp : dshp) {
			String batBuoc = "";
			if (hp.isBatBuoc()) {
				batBuoc = "x";
			}
			String[] rowData = { i + "", hp.getMaHocPhan(), hp.getTenMonHoc(), hp.getSoTinChi() + "", batBuoc };
			modelHP.addRow(rowData);
			tableHP.setModel(modelHP);
			i++;
		}
	}

	private void xoaTBLopHocPhan() {
		while (modelLHP.getRowCount() > 0) {
			modelLHP.removeRow(0);
		}
	}

	private void napTBLopHocPhan(String maHp, String namhoc) {
		xoaTBLopHocPhan();
		List<LopHocPhan> dslhp = lopHocPhanDAO.layDsLopHocPhanTheoMaHP(maHp, namhoc);
		int i = 1;
		for (LopHocPhan lopHocPhan : dslhp) {
			String[] rowData = { i + "", lopHocPhan.getMaLopHocPhan(), lopHocPhan.getTenLopHocPhan(),
					lopHocPhan.getLopTinChi(), lopHocPhan.getSiSoToiDa() + "", lopHocPhan.getSiSoDangKy() + "",
					lopHocPhan.getTrangThai() };
			modelLHP.addRow(rowData);
			tableLHP.setModel(modelLHP);
			i++;
		}
	}
	
	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(25);
		tb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}
	
	private void showMes(JTextField tf, String mes) {
		JOptionPane.showMessageDialog(this, mes, "L???i", JOptionPane.ERROR_MESSAGE);
		tf.requestFocus();
	}
	
	private boolean kiemTraLHP() {
		if (txtMaLHP.getText().trim().equals("")) {
			showMes(txtMaLHP, "M?? l???p h???c ph???n kh??ng ???????c ????? tr???ng!!");
			return false;
		}
		if (txtTenLHP.getText().trim().equals("")) {
			showMes(txtTenLHP, "T??n l???p kh??ng ???????c ????? tr???ng!!");
			return false;
		}
		if (txtLopTC.getText().trim().equals("")) {
			showMes(txtLopTC, "M?? l???p t??n ch??? kh??ng ???????c ????? tr???ng!!");
			return false;
		}
		if (txtSiSo.getText().trim().equals("")) {
			showMes(txtSiSo, "S?? s??? kh??ng ???????c ????? tr???ng!!");
			return false;
		}
		if (!txtSiSo.getText().trim().matches("[0-9]+")) {
			showMes(txtSiSo, "S?? s??? ph???i l?? s??? nguy??n d????ng > 30!!");
			return false;
		}else if (Integer.parseInt(txtSiSo.getText().trim())<30) {
			showMes(txtSiSo, "S?? s??? ph???i l?? s??? nguy??n d????ng > 30!!");
			return false;
		}
		
		return true;
	}
	
	private boolean kiemTraCTLHP() {
		if (cmbChuyenNganh.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Ch??a ch???n chuy??n ng??nh gi???ng vi??n", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (cmbTenGiangVien.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Ch??a ch???n gi???ng vi??n", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		java.util.Date dateBD = dateBatDau.getDate();
		java.util.Date dateKT = dateKetThuc.getDate();
		
		//Ng b???t ?????u > ng k???t th??c
		if (dateBD.compareTo(dateKT)>0) {
			JOptionPane.showMessageDialog(this, "Ng??y k???t th??c ph???i sau ng??y b???t ?????u", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private boolean kiemTraCTLHP_TH() {
		if (cmbChuyenNganhGVTH.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Ch??a ch???n chuy??n ng??nh gi???ng vi??n th???c h??nh", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (cmbTenGiangVienTH.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Ch??a ch???n gi???ng vi??n th???c h??nh", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		java.util.Date dateBD = dateBatDauTH.getDate();
		java.util.Date dateKT = dateKetThuc.getDate();
		//Ng b???t ?????u > ng k???t th??c
		if (dateBD.compareTo(dateKT)>0) {
			JOptionPane.showMessageDialog(this, "Ng??y k???t th??c ph???i sau ng??y b???t ?????u", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
}
