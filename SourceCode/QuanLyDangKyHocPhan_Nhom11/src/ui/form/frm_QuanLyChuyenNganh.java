package ui.form;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.ChuyenNganhDAO;
import dao.ConnectDB;
import dao.KhoaDAO;
import entity.ChuyenNganh;
import entity.Khoa;

public class frm_QuanLyChuyenNganh extends JPanel implements ActionListener {
	private JScrollPane scrKhoa;
	private JPanel pnlChucNang;
	private DefaultTableModel modelKhoa;
	private DefaultTableModel modelChuyenNganh;
	private JTable tblKhoa;
	private JTable tblChuyenNganh;
	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnSua;
	private KhoaDAO khoaDao;
	private JTextField txtMaKhoa;
	private JTextField txtMaChuyenNganh;
	private JTextField txtTimKiemChuyenNganh;
	private JComboBox cmbTimKiemChuyenNganh;
//	private JComboBox cmbChuyenNganh;
	private Connection con;
	private JScrollPane scrChuyenNganh;
	private JComboBox cbbKhoa;
	private ChuyenNganhDAO chuyenNganhDAO;
	private JButton btnLuu;
	private JTextField txtChuyenNganh;

	/**
	 * Create the panel.
	 */
	public frm_QuanLyChuyenNganh() {
		setBackground(new Color(0, 153, 255));
		setLayout(null);

		pnlChucNang = new JPanel();
		pnlChucNang.setBackground(SystemColor.text);
		pnlChucNang.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
		pnlChucNang.setBounds(1020, 515, 303, 135);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);

		btnThem = new JButton("Th??m");
		btnThem.setIcon(new ImageIcon("img/add.png"));
		btnThem.setBounds(15, 10, 130, 50);
		pnlChucNang.add(btnThem);

		btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setIcon(new ImageIcon("img/reset.png"));
		btnLamMoi.setBounds(160, 10, 130, 50);
		pnlChucNang.add(btnLamMoi);

		btnLuu = new JButton("L??u");
		btnLuu.setIcon(new ImageIcon("img/update.png"));
		btnLuu.setEnabled(false);
		btnLuu.setBounds(160, 75, 129, 50);
		pnlChucNang.add(btnLuu);

		btnSua = new JButton("S???a");
		btnSua.setIcon(new ImageIcon("img/exchange.png"));
		btnSua.setBounds(15, 75, 130, 50);
		pnlChucNang.add(btnSua);

		// Table
		// M?? chuy??n ng??nh;T??n Chuy??n ng??nh;M?? khoa;T??n khoa
		String[] headerKhoa = "STT;M?? khoa;T??n khoa".split(";");
		modelKhoa = new DefaultTableModel(headerKhoa, 50);
		tblKhoa = new JTable(modelKhoa) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] headerChuyenNganh = "STT;M?? chuy??n ng??nh;T??n chuy??n ng??nh;M?? khoa".split(";");
		modelChuyenNganh = new DefaultTableModel(headerChuyenNganh, 50);
		tblChuyenNganh = new JTable(modelChuyenNganh) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		scrKhoa = new JScrollPane(tblKhoa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrKhoa.setBorder(new TitledBorder(null, "DANH S??CH KHOA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tblKhoa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblKhoa.getTableHeader().setReorderingAllowed(false);
		scrKhoa.setBounds(20, 22, 1310, 210);
		scrKhoa.setViewportView(tblKhoa);
		add(scrKhoa);

		scrChuyenNganh = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrChuyenNganh.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"DANH S??CH CHUY??N NG??NH", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrChuyenNganh.setBounds(20, 284, 1310, 220);
		add(scrChuyenNganh);

		tblChuyenNganh = new JTable();
		tblChuyenNganh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrChuyenNganh.setViewportView(tblChuyenNganh);

		JLabel lblMKhoa = new JLabel("M?? khoa");
		lblMKhoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMKhoa.setBounds(40, 540, 97, 20);
		add(lblMKhoa);

		JLabel lblMaChuyenNganh = new JLabel("M?? chuy??n ng??nh");
		lblMaChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaChuyenNganh.setBounds(40, 580, 140, 20);
		add(lblMaChuyenNganh);

		txtMaKhoa = new JTextField();
		txtMaKhoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaKhoa.setColumns(10);
		txtMaKhoa.setBounds(174, 540, 156, 24);
		add(txtMaKhoa);

		txtMaChuyenNganh = new JTextField();
		txtMaChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaChuyenNganh.setColumns(10);
		txtMaChuyenNganh.setBounds(174, 580, 156, 24);
		add(txtMaChuyenNganh);

		JLabel lblTenKhoa = new JLabel("T??n Khoa");
		lblTenKhoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenKhoa.setBounds(370, 540, 97, 20);
		add(lblTenKhoa);

		JLabel lblChuyenNganh = new JLabel("T??n chuy??n ng??nh");
		lblChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChuyenNganh.setBounds(370, 580, 140, 20);
		add(lblChuyenNganh);

		cbbKhoa = new JComboBox();
		cbbKhoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbKhoa.setBounds(520, 539, 240, 24);
		add(cbbKhoa);

//		cmbChuyenNganh = new JComboBox();
//		cmbChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		cmbChuyenNganh.setBounds(520, 579, 240, 24);
//		add(cmbChuyenNganh);
		cmbTimKiemChuyenNganh = new JComboBox();
		cmbTimKiemChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbTimKiemChuyenNganh
				.setModel(new DefaultComboBoxModel(new String[] { "T???t c??? chuy??n ng??nh", "Theo m??", "Theo t??n" }));
		cmbTimKiemChuyenNganh.setBounds(390, 250, 172, 25);
		add(cmbTimKiemChuyenNganh);

		JLabel lblTimChuyenNganh = new JLabel("T??m chuy??n ng??nh");
		lblTimChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimChuyenNganh.setBounds(30, 245, 172, 30);
		add(lblTimChuyenNganh);

		txtTimKiemChuyenNganh = new JTextField();
		txtTimKiemChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiemChuyenNganh.setColumns(10);
		txtTimKiemChuyenNganh.setBounds(200, 250, 190, 25);
		add(txtTimKiemChuyenNganh);

		con = ConnectDB.getInstance().getConnection();
		this.khoaDao = new KhoaDAO();
		this.chuyenNganhDAO = new ChuyenNganhDAO();
		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		cbbKhoa.addActionListener(this);
		btnLuu.addActionListener(this);
		cmbTimKiemChuyenNganh.addActionListener(this);
		napDanhSachKhoa(khoaDao.danhSachKhoa());
		napDanhSachChuyenNganh(chuyenNganhDAO.danhSachChuyenNganh());
//		napComboboxChuyenNganh();
		napComboboxKhoa();
		btnLuu.setEnabled(false);
		tableDesign(tblChuyenNganh);
		tableDesign(tblKhoa);
		txtChuyenNganh = new JTextField();
		txtChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChuyenNganh.setBounds(520, 580, 240, 24);
		add(txtChuyenNganh);
		txtChuyenNganh.setColumns(10);
		tableRenderer();
		tblKhoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				napComboboxKhoa();
				txtMaChuyenNganh.setText("");
				List<Khoa> khoa = khoaDao.danhSachKhoa();
				int row = tblKhoa.getSelectedRow();
				String maKhoa = (String) tblKhoa.getModel().getValueAt(row, 1);
				txtMaKhoa.setText("");
				txtMaChuyenNganh.setText("");
				txtChuyenNganh.setText("");
				if (row >= 0 && row <= khoa.size()) {
					Khoa kh = khoa.get(row);
					napKhoa(kh);
					String x = (String) tblKhoa.getModel().getValueAt(row, 1);
					napDanhSachChuyenNganh(chuyenNganhDAO.danhSachChuyenNganhTheoKhoa(x));
					for (int i = 0; i < cbbKhoa.getItemCount(); i++) {
						String s = khoaDao.timTenKhoaTheoMa(x);
						if (s.equals(cbbKhoa.getItemAt(i).toString())) {
							cbbKhoa.setSelectedIndex(i);
							break;
						}
					}
				}
				txtMaKhoa.setText(maKhoa);
			}

			private void napKhoa(Khoa kh) {
				txtMaKhoa.setText(kh.getMaKhoa());
			}
		});

		tblChuyenNganh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblChuyenNganh.getSelectedRow();
//				cmbChuyenNganh.removeAllItems();
//				cmbKhoa.removeAllItems();
//				napComboboxKhoa();
				String maChuyenNganh = (String) tblChuyenNganh.getModel().getValueAt(row, 1);
				String chuyenNganh = (String) tblChuyenNganh.getModel().getValueAt(row, 2);
				String maKhoa = (String) tblChuyenNganh.getModel().getValueAt(row, 3);
				txtMaChuyenNganh.setText(maChuyenNganh);
				txtMaKhoa.setText(maKhoa);
				String tenKhoa = khoaDao.timTenKhoaTheoMa(maKhoa);
				for (int i = 0; i < cbbKhoa.getItemCount(); i++)
					if (tenKhoa.equalsIgnoreCase(cbbKhoa.getItemAt(i).toString().trim())) {
						cbbKhoa.setSelectedIndex(i);
						break;
					}
				String khoa = cbbKhoa.getSelectedItem().toString().trim();
				txtChuyenNganh.setText(chuyenNganh);
			}
		});

	}

//	}

	private void napComboboxKhoaTheoMa(String maKhoa) {
		this.cbbKhoa.addItem(maKhoa);
	}

	private void napDanhSachChuyenNganh(List<ChuyenNganh> danhSachChuyenNganh) {
		xoaBang(modelChuyenNganh);
		this.chuyenNganhDAO = new ChuyenNganhDAO();
		int i = 1;
		for (ChuyenNganh cn : danhSachChuyenNganh) {
			String[] row = { i + "", cn.getMaChuyenNganh(), cn.getTenChuyenNganh(), cn.getKhoa().getMaKhoa() };
			modelChuyenNganh.addRow(row);
			tblChuyenNganh.setModel(modelChuyenNganh);
			i++;
		}
	}

	private void xoaBang(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void napDanhSachKhoa(List<Khoa> danhSachKhoa) {
		xoaBang(modelKhoa);
		this.khoaDao = new KhoaDAO();
		int i = 1;
		for (Khoa kh : danhSachKhoa) {
			String[] row = { i + "", kh.getMaKhoa(), kh.getTenKhoa() };
			modelKhoa.addRow(row);
			tblKhoa.setModel(modelKhoa);
			i++;
		}
	}

	private void napComboboxKhoa() {
//		cmbKhoa.removeAllItems();
		try {
			PreparedStatement stmt = con.prepareStatement("select tenKhoa from Khoa order by tenKhoa");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				this.cbbKhoa.addItem(rs.getString("tenKhoa"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ChuyenNganh> danhSachChuyenNganhTheoTenKhoa(String s) {
		List<ChuyenNganh> list = new ArrayList<ChuyenNganh>();
		try {
			PreparedStatement stmt = con.prepareStatement("");
			stmt.setString(1, s);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChuyenNganh chuyenNganh = new ChuyenNganh(rs.getString("maChuyenNganh"), rs.getString("tenChuyenNganh"),
						new Khoa(rs.getString("maKhoa")));
				list.add(chuyenNganh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
			lamMoi();
		}
//		if (o.equals(cmbKhoa)) {
//			if (!(txtChuyenNganh.getText().equals("") || txtMaChuyenNganh.getText().equals(""))) {
//				txtChuyenNganh.setText("");
//				txtMaChuyenNganh.setText("");
//			}
//		}
		if (o.equals(btnSua)) {
			if (kiemTra()) {
				Khoa kh = new Khoa(txtMaKhoa.getText().trim());
				ChuyenNganh chuyenNganh = new ChuyenNganh(txtMaChuyenNganh.getText().trim(),
						txtChuyenNganh.getText().trim(), kh);
//				System.out.println(chuyenNganh);
				if (chuyenNganhDAO.suaChuyenNganh(chuyenNganh)) {
					napDanhSachChuyenNganh(chuyenNganhDAO.danhSachChuyenNganh());
					JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
				} else
					JOptionPane.showMessageDialog(this, "C???p nh???t kh??ng th??nh c??ng");
			}
			btnThem.setEnabled(true);
			lamMoi();
		}
		if (o.equals(btnThem)) {
			btnThem.setEnabled(false);
			btnLuu.setEnabled(true);
			btnSua.setEnabled(false);
			xoaBang(modelChuyenNganh);
			lamMoi();
		}
		if (o.equals(cmbTimKiemChuyenNganh)) {
			String s = txtTimKiemChuyenNganh.getText().trim();
			String chuyenNganh = cmbTimKiemChuyenNganh.getSelectedItem().toString().trim();
			if (chuyenNganh.equalsIgnoreCase("T???t c??? chuy??n ng??nh"))
				napDanhSachChuyenNganh(chuyenNganhDAO.danhSachChuyenNganh());
			if (chuyenNganh.equalsIgnoreCase("Theo m??"))
				napDanhSachChuyenNganh(chuyenNganhDAO.timKiemDsChuyenNganh(s));
			if (chuyenNganh.equalsIgnoreCase("Theo t??n"))
				napDanhSachChuyenNganh(chuyenNganhDAO.timTheoTen(s));
		}
		if (o.equals(cbbKhoa)) {
			if (cbbKhoa.getItemCount() > 0) {
				txtMaKhoa.setText(khoaDao.timMaKhoaTheoTen(cbbKhoa.getSelectedItem().toString().trim()));
			}
		}
		if (o.equals(btnLuu)) {

			if (kiemTra()) {
				if (chuyenNganhDAO.timMa(txtMaChuyenNganh.getText().trim())) {
					showMes(txtMaChuyenNganh, "Tr??ng m??");
					return;
				}
				Khoa kh = new Khoa(txtMaKhoa.getText().trim());
				ChuyenNganh chuyenNganh = new ChuyenNganh(txtMaChuyenNganh.getText().trim(),
						txtChuyenNganh.getText().trim(), kh);
				System.out.println(chuyenNganh);
				if (chuyenNganhDAO.themChuyenNganh(chuyenNganh)) {
					napDanhSachChuyenNganh(chuyenNganhDAO.danhSachChuyenNganh());
					JOptionPane.showMessageDialog(this, "???? th??m");
					btnLuu.setEnabled(false);
					btnThem.setEnabled(true);
					btnSua.setEnabled(true);
					lamMoi();
				} else
					JOptionPane.showMessageDialog(this, "Kh??ng th??m ???????c");
			}

		}
	}

	private void lamMoi() {
//		napComboboxChuyenNganh();
		napDanhSachKhoa(khoaDao.danhSachKhoa());
		napDanhSachChuyenNganh(chuyenNganhDAO.danhSachChuyenNganh());
//		cmbChuyenNganh.removeAllItems();
		cbbKhoa.setSelectedIndex(0);
		xoaBang(modelChuyenNganh);
		txtMaChuyenNganh.setText("");
		txtMaKhoa.setText("");
		txtTimKiemChuyenNganh.setText("");
		txtChuyenNganh.setText("");
	}

//	private void locTheoKhoa(String s) {
//		cmbChuyenNganh.removeAllItems();
//		try {
//			PreparedStatement stmt = con.prepareStatement(
//					"select tenChuyenNganh from [dbo].[Khoa] K join [dbo].[ChuyenNganh] C on K.maKhoa=C.maKhoa where K.tenKhoa like N'%"
//							+ s + "%'");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				this.cmbChuyenNganh.addItem(rs.getString("tenChuyenNganh"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tblChuyenNganh.getColumn("STT").setCellRenderer(centerCellRenderer);
		tblChuyenNganh.getColumn("M?? chuy??n ng??nh").setCellRenderer(centerCellRenderer);
		tblChuyenNganh.getColumn("M?? khoa").setCellRenderer(centerCellRenderer);
		tblKhoa.getColumn("STT").setCellRenderer(centerCellRenderer);
		tblKhoa.getColumn("M?? khoa").setCellRenderer(centerCellRenderer);
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}

	private boolean kiemTra() {

		if (txtMaKhoa.getText().equalsIgnoreCase("")) {
			showMes(txtMaKhoa, "Kh??ng ????? tr???ng m?? khoa");
			return false;
		}
		if (txtChuyenNganh.getText().equalsIgnoreCase("")) {
			showMes(txtChuyenNganh, "Kh??ng ????? tr???ng chuy??n ng??nh");
			return false;
		}

		if (txtMaChuyenNganh.getText().equalsIgnoreCase("")) {
			showMes(txtMaChuyenNganh, "Kh??ng ????? tr???ng m?? chuy??n ng??nh");
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
