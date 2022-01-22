package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.GiangVienDAO;
import dao.ConnectDB;
import entity.ChuyenNganh;
import entity.GiangVien;

public class frm_QuanLyGiangVien extends JPanel implements ActionListener {

	private static Connection con;
	private JTextField txtMaGV;
	private JTextField txtHoTenGiangVien;
	private JTextField txtDiaChi;
	private JDateChooser txtNgaySinh;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_3;
	private JTextField txtSoDienThoai;
	private JTextField txtTimKiem;
	private JComboBox<String> cbbTimKiem;
	private JScrollPane scrollPane_2;
	private JPanel panel;
	private DefaultTableModel modelGiangVien;
	private JTable tableGiangVien;
	private JComboBox<String> cbbChuyenNganh;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnLamMoi;
	private JButton btnThem;
	private GiangVienDAO giangVienDAO;
	private ButtonGroup g;

	public frm_QuanLyGiangVien() {

		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã giảng viên");
		lblNewLabel.setBounds(20, 558, 97, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel);

		txtMaGV = new JTextField();
		txtMaGV.setBounds(140, 558, 156, 20);
		add(txtMaGV);
		txtMaGV.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Họ tên giảng viên");
		lblNewLabel_1.setBounds(20, 599, 118, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1);

		txtHoTenGiangVien = new JTextField();
		txtHoTenGiangVien.setBounds(140, 602, 156, 20);
		txtHoTenGiangVien.setColumns(10);
		add(txtHoTenGiangVien);

		JLabel lblNewLabel_1_1 = new JLabel("Chuyên ngành");
		lblNewLabel_1_1.setBounds(320, 560, 97, 20);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(420, 600, 230, 20);
		txtDiaChi.setColumns(10);
		add(txtDiaChi);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBounds(790, 540, 190, 20);
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		add(txtNgaySinh);

		lblNewLabel_4 = new JLabel("Ngày Sinh");
		lblNewLabel_4.setBounds(690, 540, 83, 20);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Giới tính");
		lblNewLabel_5.setBounds(690, 571, 83, 18);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_5);

		lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setBounds(320, 600, 66, 20);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_2);

		lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setBounds(690, 599, 90, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_3);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(790, 600, 190, 20);
		((JTextField) txtSoDienThoai).setColumns(10);
		add(txtSoDienThoai);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(140, 20, 190, 20);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cbbTimKiem = new JComboBox();
		cbbTimKiem.setBounds(330, 20, 140, 20);
		cbbTimKiem.setModel(new DefaultComboBoxModel(
				new String[] { "Tất cả giảng viên", "Theo mã", "Theo tên", "Theo chuyên ngành" }));
		add(cbbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("Tìm giảng viên");
		lblNewLabel_6.setBounds(10, 10, 130, 40);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setIcon(new ImageIcon("images/Find.png"));
		add(lblNewLabel_6);

		panel = new JPanel();
		panel.setBounds(1020, 515, 303, 135);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("img/addGV.png"));
		btnThem.setBounds(15, 10, 130, 50);
		panel.add(btnThem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("img/reset.png"));
		btnLamMoi.setBounds(160, 10, 130, 50);
		panel.add(btnLamMoi);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("img/capnhat.png"));
		btnLuu.setBounds(160, 75, 129, 50);
		panel.add(btnLuu);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("img/change.png"));
		btnSua.setBounds(15, 75, 130, 50);
		panel.add(btnSua);

		giangVienDAO = new GiangVienDAO();
		this.giangVienDAO = new GiangVienDAO();
		String[] headers = "STT;Mã giảng viên;Họ tên;Chuyên ngành;Ngày sinh;Giới tính;Địa chỉ;Số điện thoại".split(";");
		modelGiangVien = new DefaultTableModel(headers, 50);
		tableGiangVien = new JTable(modelGiangVien) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane_2 = new JScrollPane(tableGiangVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setBounds(20, 50, 1310, 444);
		scrollPane_2.setBorder(BorderFactory.createTitledBorder("DANH SÁCH GIANG VIÊN"));
		tableGiangVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableGiangVien.getTableHeader().setReorderingAllowed(false);
		scrollPane_2.setViewportView(tableGiangVien);
		add(scrollPane_2);

		cbbChuyenNganh = new JComboBox<String>();
		cbbChuyenNganh.setBounds(420, 560, 156, 20);
		add(cbbChuyenNganh);

		rdNam = new JRadioButton("Nam", true);
		rdNam.setBounds(790, 570, 60, 20);
		add(rdNam);
		rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(861, 570, 60, 20);
		add(rdNu);
		g = new ButtonGroup();
		g.add(rdNam);
		g.add(rdNu);
		// -------Xu ly-----
		// Table
		con = ConnectDB.getInstance().getConnection();
		napDanhSachGiangVien(giangVienDAO.danhSachGiangVien());
		napComboboxChuyenNganh();

		txtMaGV.setEditable(false);
		btnLuu.setEnabled(false);

//		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		cbbChuyenNganh.addActionListener(this);
		cbbTimKiem.addActionListener(this);

		tableDesign(tableGiangVien);
		tableRenderer();

		tableGiangVien.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableGiangVien.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableGiangVien.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableGiangVien.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableGiangVien.getColumnModel().getColumn(6).setPreferredWidth(300);

		btnLamMoi.addActionListener(e -> {
			lamMoiGV();
		});

		tableGiangVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<GiangVien> list = giangVienDAO.danhSachGiangVien();
				int row = tableGiangVien.getSelectedRow();
				if (row >= 0 && row <= list.size()) {
					GiangVien gv = list.get(row);
					napGiangVien(gv);
					cbbChuyenNganh.removeAllItems();
					napComboboxChuyenNganh();
					String x = (String) tableGiangVien.getModel().getValueAt(row, 1);
					for (int i = 0; i < cbbChuyenNganh.getItemCount(); i++) {
						String ma = giangVienDAO.timTenChuyenNganhTheoMaGV(x);
						if (ma.equals(cbbChuyenNganh.getItemAt(i).toString())) {
							cbbChuyenNganh.setSelectedIndex(i);
							break;
						}
					}
				}
			}

			private void napGiangVien(GiangVien gv) {
				txtMaGV.setText(gv.getMaGiangVien());
				txtHoTenGiangVien.setText(gv.getTenGiangVien());
				txtNgaySinh.setDate(gv.getNgaySinh());
				txtNgaySinh.setToolTipText(String.valueOf(gv.getNgaySinh()));
				txtDiaChi.setText(gv.getDiaChi());
				txtSoDienThoai.setText(gv.getSoDienThoai());
				if (gv.getGioiTinh().equals("Nam"))
					rdNam.setSelected(true);
				else
					rdNu.setSelected(true);
			}
		});
	}

	private void napComboboxChuyenNganh() {
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select distinct C.tenChuyenNganh from [dbo].[ChuyenNganh] C order by tenchuyenNganh");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				this.cbbChuyenNganh.addItem(rs.getString("tenChuyenNganh"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void xoaBang() {
		while (modelGiangVien.getRowCount() > 0) {
			modelGiangVien.removeRow(0);
		}
	}

	private void napDanhSachGiangVien(List<GiangVien> list) {
		xoaBang();
		int i = 1;
		for (GiangVien gv : list) {

			String[] row = { i + "", gv.getMaGiangVien(), gv.getTenGiangVien(),
					gv.getChuyenNganh().getMaChuyenNganh() + "", gv.getNgaySinh() + "", gv.getGioiTinh(),
					gv.getDiaChi(), gv.getSoDienThoai() };
			modelGiangVien.addRow(row);
			tableGiangVien.setModel(modelGiangVien);
			i++;
		}
	}

	private void lamMoiGV() {
		txtDiaChi.setText("");
		txtHoTenGiangVien.setText("");
		txtMaGV.setText("");
		txtNgaySinh.setDate(new java.util.Date());
		txtSoDienThoai.setText("");
		rdNam.setSelected(true);
		cbbChuyenNganh.removeAllItems();
		napComboboxChuyenNganh();
		cbbChuyenNganh.setSelectedIndex(0);
		cbbTimKiem.setSelectedIndex(0);
		napDanhSachGiangVien(giangVienDAO.danhSachGiangVien());
		txtMaGV.setEditable(false);
		btnLuu.setEnabled(false);
		btnThem.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object o = e.getSource();
			if (o.equals(btnLamMoi)) {
				lamMoiGV();
			}
			if (o.equals(btnThem)) {
				lamMoiGV();
				txtMaGV.setEditable(true);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(false);
				btnSua.setEnabled(false);
			}
			if (o.equals(btnLuu)) {
				if (kiemTra()) {
					if (giangVienDAO.timMaGiangVien(txtMaGV.getText().trim())) {
						showMes(txtMaGV, "Trùng mã giảng viên");
						return;
					}
					long ngay = txtNgaySinh.getDate().getTime();
					Date ngaysinh = new Date(ngay);
					String gioiTinh = (rdNam.isSelected() ? "Nam" : "Nữ");
					String tenChuyenNganh = cbbChuyenNganh.getSelectedItem().toString().trim();
					ChuyenNganh chuyenNganh = new ChuyenNganh(giangVienDAO.timMaLop(tenChuyenNganh));

					GiangVien giangVien = new GiangVien(txtMaGV.getText().trim(), txtHoTenGiangVien.getText().trim(),
							ngaysinh, gioiTinh, txtDiaChi.getText().trim(), txtSoDienThoai.getText().trim(),
							chuyenNganh);
					if (giangVienDAO.themGiangVien(giangVien)) {
						napDanhSachGiangVien(giangVienDAO.danhSachGiangVien());
						JOptionPane.showMessageDialog(this, "Đã thêm", "Chú ý", JOptionPane.OK_OPTION);
						txtMaGV.setEditable(false);
						btnLuu.setEnabled(false);
						btnThem.setEnabled(true);
						btnSua.setEnabled(true);
					} else
						JOptionPane.showMessageDialog(this, "Không thêm được", "Chú ý", JOptionPane.OK_OPTION);
					btnThem.setEnabled(true);
					lamMoiGV();
				}
			}
			if (o.equals(btnSua)) {
				if (kiemTra()) {
					long ngay = txtNgaySinh.getDate().getTime();
					Date ngaysinh = new Date(ngay);
					String gioiTinh = (rdNam.isSelected() ? "Nam" : "Nữ");
					String tenChuyenNganh = cbbChuyenNganh.getSelectedItem().toString().trim();
					ChuyenNganh chuyenNganh = new ChuyenNganh(giangVienDAO.timMaLop(tenChuyenNganh));
					GiangVien giangVien = new GiangVien(txtMaGV.getText().trim(), txtHoTenGiangVien.getText().trim(),
							ngaysinh, gioiTinh, txtDiaChi.getText().trim(), txtSoDienThoai.getText().trim(),
							chuyenNganh);
					if (giangVienDAO.suaGiangVien(giangVien)) {
						napDanhSachGiangVien(giangVienDAO.danhSachGiangVien());
						JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					} else
						JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
					btnThem.setEnabled(true);
					lamMoiGV();
				}
			}
			if (o.equals(cbbTimKiem)) {
				xoaBang();
				String tf = txtTimKiem.getText().trim();
				String opt = cbbTimKiem.getSelectedItem().toString().trim();
				if (opt.equalsIgnoreCase("Tất cả giảng viên"))
					napDanhSachGiangVien(giangVienDAO.danhSachGiangVien());
				if (opt.equalsIgnoreCase("Theo mã"))
					napDanhSachGiangVien(giangVienDAO.danhSachGiangVienTheoMa(tf));
				if (opt.equalsIgnoreCase("Theo tên"))
					napDanhSachGiangVien(giangVienDAO.danhSachGiangVienTheoTen(tf));
				if (opt.equalsIgnoreCase("Theo chuyên ngành"))
					napDanhSachGiangVien(giangVienDAO.danhSachGiangVienTheoTenChuyenNganh(tf));
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	private boolean kiemTra() {

		if (txtMaGV.getText().equalsIgnoreCase("")) {
			showMes(txtMaGV, "Không để trống mã giảng viên");
			return false;
		}
		if (txtHoTenGiangVien.getText().equalsIgnoreCase("")) {
			showMes(txtHoTenGiangVien, "Không để trống tên giảng viên");
			return false;
		}

		if (txtSoDienThoai.getText().equalsIgnoreCase("")) {
			showMes(txtSoDienThoai, "Không để trống số điện thoại");
			return false;
		}

		if (!txtMaGV.getText().trim().matches("GV[0-9]{5}")) {
			showMes(txtMaGV, "Mã sinh viên bắt đầu bằng NV tiếp là 5 con số\nVí dụ: NV12345");
			return false;
		}
		if (!txtSoDienThoai.getText().trim().matches("0[0-9]{9}")) {
			showMes(txtSoDienThoai, "Số điện thoại là 10 con số bắt đầu bằng số 0");
			return false;
		}
		return true;
	}

	public void showMes(JTextField tf, String mes) {
		JOptionPane.showMessageDialog(this, mes);
		tf.selectAll();
		tf.requestFocus();
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableGiangVien.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableGiangVien.getColumn("Mã giảng viên").setCellRenderer(centerCellRenderer);
		tableGiangVien.getColumn("Chuyên ngành").setCellRenderer(centerCellRenderer);
		tableGiangVien.getColumn("Ngày sinh").setCellRenderer(centerCellRenderer);
		tableGiangVien.getColumn("Giới tính").setCellRenderer(centerCellRenderer);
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}
}
