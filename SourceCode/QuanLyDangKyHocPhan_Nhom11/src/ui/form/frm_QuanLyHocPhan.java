package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.ConnectDB;
import dao.HocPhanDAO;
import entity.HocPhan;
import entity.Khoa;

public class frm_QuanLyHocPhan extends JPanel implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private Connection con;
	private DefaultTableModel HocPhanModel;
	private JPanel panel;
	private JComboBox cmbTimKiem;
	private JTable tblHocPhan;
	private JScrollPane scrollPane;
	private JScrollPane scrDanhSach;
	private JTextField txtMaHocPhan;
	private JTextField txtTenHocPhan;
	private AbstractButton btnLamMoi;
	private JButton btnLuu;
	private JButton btnSua;
	private JComponent pnlThongTin;
	private JComboBox cmbHocKy;
	private JComboBox cmbSoTinChi;
	private JRadioButton rdBatBuoc;
	private JPanel pnlChucNang;
	private JButton btnThem;
	private HocPhanDAO hocPhanDAO;
	private JComboBox cbbHocPhanBatBuoc;
	private JLabel lblChonKhoa;
	private JComboBox cbbKhoa;
	private JTextField textField;
	private JComboBox cbbThemKhoa;

	public frm_QuanLyHocPhan() {
		setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(406, 10, 190, 25);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cmbTimKiem = new JComboBox();
		cmbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Tất cả học phần", "Theo mã ", "Theo tên" }));
		cmbTimKiem.setBounds(596, 10, 150, 25);
		add(cmbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("Tìm nhanh");
		lblNewLabel_6.setBounds(276, 0, 130, 40);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setIcon(new ImageIcon("img/search.png"));
		add(lblNewLabel_6);

		tblHocPhan = new JTable();
		// table
		hocPhanDAO = new HocPhanDAO();
		this.hocPhanDAO = new HocPhanDAO();
		String[] headers = "STT;Mã học phần;Tên môn học;Học kỳ;Số tín chỉ;Bắt buộc;Học phần yêu cầu;Mã khoa".split(";");
		HocPhanModel = new DefaultTableModel(headers, 20);
		tblHocPhan = new JTable(HocPhanModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblHocPhan.setModel(new DefaultTableModel(headers, 20));
		scrDanhSach = new JScrollPane(tblHocPhan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrDanhSach.setBounds(20, 50, 1310, 455);
		scrDanhSach.setBorder(
				new TitledBorder(null, "DANH SÁCH HỌC PHẦN", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tblHocPhan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		tblHocPhan.getColumnModel().getColumn(0).setPreferredWidth(42);
		tblHocPhan.getColumnModel().getColumn(1).setPreferredWidth(88);
		tblHocPhan.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblHocPhan.getColumnModel().getColumn(3).setPreferredWidth(66);
		tblHocPhan.getColumnModel().getColumn(4).setPreferredWidth(64);
		tblHocPhan.getColumnModel().getColumn(5).setPreferredWidth(92);
		add(scrDanhSach);
		scrDanhSach.setViewportView(tblHocPhan);

		pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlChucNang.setBounds(1020, 515, 303, 135);
		add(pnlChucNang);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("img/library.png"));
		btnThem.setBounds(15, 10, 130, 50);
		pnlChucNang.add(btnThem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("img/reset.png"));
		btnLamMoi.setBounds(160, 10, 130, 50);
		pnlChucNang.add(btnLamMoi);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("img/update.png"));
		btnLuu.setBounds(160, 75, 129, 50);
		pnlChucNang.add(btnLuu);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("img/exchange.png"));
		btnSua.setBounds(15, 75, 130, 50);
		pnlChucNang.add(btnSua);

		pnlThongTin = new JPanel();
//		pnlThongTin.setBackground(new Color(248, 248, 255));
		pnlThongTin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlThongTin.setBounds(20, 515, 990, 135);
		add(pnlThongTin);
		pnlThongTin.setLayout(null);

		JLabel lblTnHcPhn = new JLabel("Tên học phần");
		lblTnHcPhn.setBounds(34, 84, 110, 25);
		pnlThongTin.add(lblTnHcPhn);
		lblTnHcPhn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("Mã học phần");
		lblNewLabel.setBounds(34, 34, 110, 25);
		pnlThongTin.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtMaHocPhan = new JTextField();
		txtMaHocPhan.setEditable(false);
		txtMaHocPhan.setBounds(142, 34, 197, 25);
		pnlThongTin.add(txtMaHocPhan);
		txtMaHocPhan.setColumns(10);

		txtTenHocPhan = new JTextField();
		txtTenHocPhan.setBounds(142, 84, 197, 25);
		pnlThongTin.add(txtTenHocPhan);
		txtTenHocPhan.setColumns(10);

		JLabel lblHcK = new JLabel("Học kỳ");
		lblHcK.setBounds(370, 34, 78, 25);
		pnlThongTin.add(lblHcK);
		lblHcK.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblSTnCh = new JLabel("Số tín chỉ");
		lblSTnCh.setBounds(370, 84, 78, 25);
		pnlThongTin.add(lblSTnCh);
		lblSTnCh.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cmbHocKy = new JComboBox();
		cmbHocKy.setBounds(450, 34, 105, 25);
		pnlThongTin.add(cmbHocKy);
		cmbHocKy.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));

		cmbSoTinChi = new JComboBox();
		cmbSoTinChi.setBounds(450, 84, 105, 25);
		pnlThongTin.add(cmbSoTinChi);
		cmbSoTinChi.setModel(new DefaultComboBoxModel(new String[] { "2", "3", "4", "5" }));

		rdBatBuoc = new JRadioButton("Bắt buộc");
		rdBatBuoc.setBounds(814, 88, 97, 21);
		pnlThongTin.add(rdBatBuoc);

		JLabel lblHcPhnYu = new JLabel("Học phần yêu cầu");
		lblHcPhnYu.setBounds(580, 34, 130, 25);
		pnlThongTin.add(lblHcPhnYu);
		lblHcPhnYu.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lbKhoa = new JLabel("Khoa");
		lbKhoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbKhoa.setBounds(580, 84, 49, 25);
		pnlThongTin.add(lbKhoa);

		cbbHocPhanBatBuoc = new JComboBox();
		cbbHocPhanBatBuoc.setBounds(700, 38, 211, 21);
		pnlThongTin.add(cbbHocPhanBatBuoc);

		lblChonKhoa = new JLabel("Chọn Khoa");
		lblChonKhoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChonKhoa.setBounds(20, 10, 90, 25);
		add(lblChonKhoa);

		cbbKhoa = new JComboBox();
		cbbKhoa.setBounds(120, 12, 146, 21);
		add(cbbKhoa);

		cbbThemKhoa = new JComboBox();
		cbbThemKhoa.setBounds(639, 84, 146, 21);
		pnlThongTin.add(cbbThemKhoa);
//		setBackground(new Color(255, 255, 255));

		tableCenter();
		con = ConnectDB.getInstance().getConnection();
		napDanhSachHocPhan(hocPhanDAO.danhSachHocPhan());

		btnLuu.setEnabled(false);
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		cmbTimKiem.addActionListener(this);
		cbbKhoa.addActionListener(this);
		cbbThemKhoa.addActionListener(this);

		tableDesign(tblHocPhan);
		tableRenderer();

		napComboboxHocPhan();
		napComboboxKhoa();
		napComboboxThemKhoa();

		tblHocPhan.getColumnModel().getColumn(2).setPreferredWidth(300);
		tblHocPhan.getColumnModel().getColumn(6).setPreferredWidth(300);
		tblHocPhan.getColumnModel().getColumn(5).setPreferredWidth(50);

		tblHocPhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<HocPhan> list = hocPhanDAO.danhSachHocPhan();
				int row = tblHocPhan.getSelectedRow();

				if (row >= 0 && row <= list.size()) {
					HocPhan gv = list.get(row);

					String maHP = (String) tblHocPhan.getModel().getValueAt(row, 1);
					String tenMonHoc = (String) tblHocPhan.getModel().getValueAt(row, 2);
					String hocKy = (String) tblHocPhan.getModel().getValueAt(row, 3);
					String soTinChi = (String) tblHocPhan.getModel().getValueAt(row, 4);
					String batBuoc = (String) tblHocPhan.getModel().getValueAt(row, 5);
					String maKhoa = (String) tblHocPhan.getModel().getValueAt(row, 7);

					String tenKhoa = hocPhanDAO.timTenKhoaTheoMaKhoa(maKhoa);
					txtMaHocPhan.setText(maHP);
					txtTenHocPhan.setText(tenMonHoc);

					napHocPhanBatBuoc(maKhoa, tenMonHoc);
					for (int i = 0; i < cmbHocKy.getItemCount(); i++)
						if (hocKy.equals(cmbHocKy.getItemAt(i).toString())) {
							cmbHocKy.setSelectedIndex(i);
							break;
						}
					for (int i = 0; i < cmbSoTinChi.getItemCount(); i++)
						if (soTinChi.equals(cmbSoTinChi.getItemAt(i).toString())) {
							cmbSoTinChi.setSelectedIndex(i);
							break;
						}
					for (int j = 0; j < cbbThemKhoa.getItemCount(); j++) {
						if (tenKhoa.equals(cbbThemKhoa.getItemAt(j).toString())) {
							cbbThemKhoa.setSelectedIndex(j);
							break;
						}
					}
					String hocPhanYeuCau = (String) tblHocPhan.getModel().getValueAt(row, 6);
					for (int i = 0; i < cbbHocPhanBatBuoc.getItemCount(); i++) {
						if (hocPhanYeuCau.equals(cbbHocPhanBatBuoc.getItemAt(i).toString())) {
							cbbHocPhanBatBuoc.setSelectedIndex(i);
							break;
						}
					}
					if (batBuoc.equalsIgnoreCase("x"))
						rdBatBuoc.setSelected(true);
					else
						rdBatBuoc.setSelected(false);
				}
			}
		});

	}

	protected void napHocPhanBatBuoc(String ma, String tenMonHoc) {
		String sql = "select tenMonHoc from HocPhan where  maKhoa = '" + ma + "'";
		List<String> ds = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenMonHoc"));
			}
			String[] mang = new String[ds.size() + 1];
			mang[0] = "-- Chọn học phần --";
			for (int i = 0; i < ds.size(); i++) {
				mang[i + 1] = ds.get(i);
			}
			cbbHocPhanBatBuoc.setModel(new DefaultComboBoxModel(mang));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void napComboboxThemKhoa() {
		String sql = "select tenKhoa from Khoa order by tenKhoa";
		List<String> ds = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenKhoa"));
			}
			String[] mang = new String[ds.size() + 1];
			mang[0] = "Tất cả khoa";
			for (int i = 0; i < ds.size(); i++) {
				mang[i + 1] = ds.get(i);
			}
			cbbThemKhoa.setModel(new DefaultComboBoxModel(mang));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void napComboboxKhoa() {
		String sql = "select tenKhoa from Khoa order by tenKhoa";
		List<String> ds = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenKhoa"));
			}
			String[] mang = new String[ds.size() + 1];
			mang[0] = "Tất cả khoa";
			for (int i = 0; i < ds.size(); i++) {
				mang[i + 1] = ds.get(i);
			}
			cbbKhoa.setModel(new DefaultComboBoxModel(mang));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void xoaBang() {
		while (HocPhanModel.getRowCount() > 0) {
			HocPhanModel.removeRow(0);
		}
	}

	private void napDanhSachHocPhan(List<HocPhan> list) {
		xoaBang();
		int i = 1;
		for (HocPhan hp : list) {
			String batbuoc = "";
			if (hp.isBatBuoc())
				batbuoc += "x";
			else
				batbuoc += "";
			String[] row = { i + "", hp.getMaHocPhan(), hp.getTenMonHoc(), hp.getHocKy() + "", hp.getSoTinChi() + "",
					batbuoc, hocPhanDAO.timHocPhanTheoMa(hp.getHocPhanYeuCau()), hp.getKhoa().getMaKhoa() };
			HocPhanModel.addRow(row);
			tblHocPhan.setModel(HocPhanModel);
			i++;
		}
	}

	private void tableCenter() {
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tblHocPhan.getColumn("STT").setCellRenderer(cellRenderer);
		tblHocPhan.getColumn("Mã học phần").setCellRenderer(cellRenderer);
		tblHocPhan.getColumn("Tên môn học").setCellRenderer(cellRenderer);
		tblHocPhan.getColumn("Học kỳ").setCellRenderer(cellRenderer);
		tblHocPhan.getColumn("Số tín chỉ").setCellRenderer(cellRenderer);
		tblHocPhan.getColumn("Bắt buộc").setCellRenderer(cellRenderer);
		tblHocPhan.getColumn("Học phần yêu cầu").setCellRenderer(cellRenderer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			lamMoi();
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
		}
		if (o.equals(btnLuu)) {
			if (kiemTra()) {
				boolean x = false;
				String hpBatBuoc = "";
				if (!rdBatBuoc.isSelected())
					x = true;
				Integer hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString().trim());
				Integer tinChi = Integer.parseInt(cmbSoTinChi.getSelectedItem().toString().trim());
				Khoa khoa = new Khoa(hocPhanDAO.timMaKhoaTheoTenKhoa(cbbThemKhoa.getSelectedItem().toString()));
				if (hocPhanDAO.timMaTrung(txtMaHocPhan.getText().trim())) {
					showMes(txtMaHocPhan, "Trùng mã");
					return;
				}
				if (cbbHocPhanBatBuoc.getSelectedItem().toString().equals("-- Chọn học phần --"))
					hpBatBuoc = null;
				else {
					hpBatBuoc = "" + hocPhanDAO.timMaHpTheoTenHp(cbbHocPhanBatBuoc.getSelectedItem().toString());
				}
				HocPhan hp = new HocPhan(txtMaHocPhan.getText().toString().trim(),
						txtTenHocPhan.getText().toString().trim(), hocKy, tinChi, x, hpBatBuoc, khoa);
				if (hocPhanDAO.themHocPhan(hp)) {
					napDanhSachHocPhan(hocPhanDAO.danhSachHocPhan());
					JOptionPane.showMessageDialog(this, "Đã thêm");
					btnLuu.setEnabled(false);
					btnSua.setEnabled(true);
					btnThem.setEnabled(true);
				} else
					JOptionPane.showMessageDialog(this, "Không thêm được");
			}
		}
		if (o.equals(btnSua)) {
			if (kiemTra()) {
				boolean x = false;
				String hpBatBuoc = "";
				if (rdBatBuoc.isSelected())
					x = true;
				Integer hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString().trim());
				Integer tinChi = Integer.parseInt(cmbSoTinChi.getSelectedItem().toString().trim());
				Khoa khoa = new Khoa(hocPhanDAO.timMaKhoaTheoTenKhoa(cbbThemKhoa.getSelectedItem().toString()));
				if (cbbHocPhanBatBuoc.getSelectedItem().toString().equals("-- Chọn học phần --"))
					hpBatBuoc = null;
				else {
					hpBatBuoc = "" + hocPhanDAO.timMaHpTheoTenHp(cbbHocPhanBatBuoc.getSelectedItem().toString());
				}
				HocPhan hp = new HocPhan(txtMaHocPhan.getText().toString().trim(),
						txtTenHocPhan.getText().toString().trim(), hocKy, tinChi, x, hpBatBuoc, khoa);
				System.out.println(hp);
				if (hocPhanDAO.suaHocPhan(hp)) {
					napDanhSachHocPhan(hocPhanDAO.danhSachHocPhan());
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				} else
					JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
			}
		}
		if (o.equals(btnThem)) {
			lamMoi();
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnLuu.setEnabled(true);
			txtMaHocPhan.setEditable(true);

		}
		if (o.equals(cmbTimKiem)) {
			String tk = cmbTimKiem.getSelectedItem().toString().trim();
			if (tk.equals("Tất cả học phần"))
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhan());
			if (tk.equals("Theo mã"))
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhanTheoMa(txtTimKiem.getText().toString().trim()));
			if (tk.equals("Theo tên"))
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhanTheoTen(txtTimKiem.getText().toString().trim()));
		}
		if (o.equals(cbbKhoa)) {
			String kh = cbbKhoa.getSelectedItem().toString().trim();
			if (kh.equalsIgnoreCase("Tất cả khoa")) {
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhan());
			}
			if (hocPhanDAO.kiemTraKhoa(kh)) {
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhanTheoKhoa(kh));
				napCbbHocPhanTheoKhoa(kh);
			}

			for (int i = 0; i < cbbThemKhoa.getItemCount(); i++) {
				if (cbbKhoa.getSelectedItem().toString().trim().equals(cbbThemKhoa.getItemAt(i).toString())) {
					cbbThemKhoa.setSelectedIndex(i);
					break;
				}
			}
		}
	}

	private void napCbbHocPhanTheoKhoa(String kh) {
		String sql = "select tenMonHoc from HocPhan h join khoa k on h.maKhoa=k.maKhoa where  k.tenKhoa like (N'%" + kh
				+ "%')";
		List<String> ds = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenMonHoc"));
			}
			String[] mang = new String[ds.size() + 1];
			mang[0] = "-- Chọn học phần --";
			for (int i = 0; i < ds.size(); i++) {
				mang[i + 1] = ds.get(i);
			}
			cbbHocPhanBatBuoc.setModel(new DefaultComboBoxModel(mang));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void napComboboxHocPhan() {
		String sql = "select tenMonHoc from HocPhan where hocPhanYeuCau is not null";
		List<String> ds = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenMonHoc"));
			}
			String[] mang = new String[ds.size() + 1];
			mang[0] = "-- Chọn học phần --";
			for (int i = 0; i < ds.size(); i++) {
				mang[i + 1] = ds.get(i);
			}
			cbbHocPhanBatBuoc.setModel(new DefaultComboBoxModel(mang));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void lamMoi() {
		txtMaHocPhan.setEditable(false);
		txtMaHocPhan.setText("");
		txtTenHocPhan.setText("");
		txtTimKiem.setText("");
		cmbHocKy.setSelectedIndex(0);
		cmbSoTinChi.setSelectedIndex(0);
		cmbTimKiem.setSelectedIndex(0);
		napCbbHocPhanTheoKhoa(cbbThemKhoa.getSelectedItem().toString());
		cbbHocPhanBatBuoc.setSelectedIndex(0);
		cbbKhoa.setSelectedIndex(0);

	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tblHocPhan.getColumn("STT").setCellRenderer(centerCellRenderer);
		tblHocPhan.getColumn("Mã học phần").setCellRenderer(centerCellRenderer);
		tblHocPhan.getColumn("Học kỳ").setCellRenderer(centerCellRenderer);
		tblHocPhan.getColumn("Số tín chỉ").setCellRenderer(centerCellRenderer);
		tblHocPhan.getColumn("Bắt buộc").setCellRenderer(centerCellRenderer);
		tblHocPhan.getColumn("Mã khoa").setCellRenderer(centerCellRenderer);
	}

	private boolean kiemTra() {

		if (txtMaHocPhan.getText().equalsIgnoreCase("")) {
			showMes(txtMaHocPhan, "Không để trống mã học phần");
			return false;
		}
		if (!txtMaHocPhan.getText().trim().matches("HP[0-9]{3}")) {
			showMes(txtMaHocPhan, "Mã học phần bắt đầu bằng HP tiếp là 3 con số\nVí dụ: HP123");
			return false;
		}
		if (txtTenHocPhan.getText().equalsIgnoreCase("")) {
			showMes(txtTenHocPhan, "Không để trống tên học phần");
			return false;
		}

		if (cbbThemKhoa.getSelectedItem().toString().equals("Tất cả khoa")) {
			JOptionPane.showMessageDialog(this, "Chưa chọn khoa");
			return false;
		}

		return true;
	}

	public void showMes(JTextField tf, String mes) {
		JOptionPane.showMessageDialog(this, mes);
		tf.selectAll();
		tf.requestFocus();
	}
}
