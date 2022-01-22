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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.ConnectDB;
import dao.GiangVienDAO;
import entity.GiangVien;

public class frm_TimKiemGiangVien extends JPanel implements ActionListener {

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
	private DefaultTableModel modelGiangVien;
	private JTable tableGiangVien;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private GiangVienDAO giangVienDAO;
	private ButtonGroup g;
	private JTextField txtTenChuyenNganh;

	public frm_TimKiemGiangVien() {
//		setBackground(new Color(0, 153, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã giảng viên");
		lblNewLabel.setBounds(20, 558, 97, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel);

		txtMaGV = new JTextField();
		txtMaGV.setBounds(140, 560, 190, 20);
		add(txtMaGV);
		txtMaGV.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Họ tên giảng viên");
		lblNewLabel_1.setBounds(20, 599, 118, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1);

		txtHoTenGiangVien = new JTextField();
		txtHoTenGiangVien.setEditable(false);
		txtHoTenGiangVien.setBounds(140, 602, 190, 20);
		txtHoTenGiangVien.setColumns(10);
		add(txtHoTenGiangVien);

		JLabel lblNewLabel_1_1 = new JLabel("Chuyên ngành");
		lblNewLabel_1_1.setBounds(343, 559, 97, 20);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(450, 600, 200, 20);
		txtDiaChi.setColumns(10);
		add(txtDiaChi);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBounds(1100, 560, 190, 20);
		txtNgaySinh.setDateFormatString("yyyy/MM/dd");
		add(txtNgaySinh);

		lblNewLabel_4 = new JLabel("Ngày Sinh");
		lblNewLabel_4.setBounds(1006, 560, 83, 20);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Giới tính");
		lblNewLabel_5.setBounds(690, 560, 83, 18);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_5);

		lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setBounds(690, 600, 66, 20);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_2);

		lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setBounds(343, 599, 90, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_3);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(790, 600, 500, 20);
		((JTextField) txtSoDienThoai).setColumns(10);
		add(txtSoDienThoai);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(140, 20, 190, 20);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cbbTimKiem = new JComboBox();
		cbbTimKiem.setBounds(330, 20, 140, 20);
		cbbTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Tất cả giảng viên", "Theo mã", "Theo tên" }));
		add(cbbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("Tìm nhanh");
		lblNewLabel_6.setBounds(10, 10, 130, 40);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setIcon(new ImageIcon("images/Find.png"));
		add(lblNewLabel_6);

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
		scrollPane_2.setBounds(20, 50, 1310, 470);
		scrollPane_2.setBorder(BorderFactory.createTitledBorder("DANH SÁCH GIANG VIÊN"));
		tableGiangVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableGiangVien.getTableHeader().setReorderingAllowed(false);
		scrollPane_2.setViewportView(tableGiangVien);
		add(scrollPane_2);

		rdNam = new JRadioButton("Nam", true);
		rdNam.setBounds(790, 560, 60, 20);
		add(rdNam);
		rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(861, 560, 60, 20);
		add(rdNu);
		g = new ButtonGroup();
		g.add(rdNam);
		g.add(rdNu);
		// -------Xu ly-----
		// Table
		con = ConnectDB.getInstance().getConnection();
		napDanhSachGiangVien(giangVienDAO.danhSachGiangVien());

		txtMaGV.setEditable(false);
		cbbTimKiem.addActionListener(this);

		txtTenChuyenNganh = new JTextField();
		txtTenChuyenNganh.setEditable(false);
		txtTenChuyenNganh.setColumns(10);
		txtTenChuyenNganh.setBounds(450, 560, 200, 20);
		add(txtTenChuyenNganh);
		tableDesign(tableGiangVien);
		tableRenderer();
		tableGiangVien.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableGiangVien.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableGiangVien.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableGiangVien.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableGiangVien.getColumnModel().getColumn(6).setPreferredWidth(300);
		
		tableGiangVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<GiangVien> list = giangVienDAO.danhSachGiangVien();
				int row = tableGiangVien.getSelectedRow();
				if (row >= 0 && row <= list.size()) {
					GiangVien gv = list.get(row);
					napGiangVien(gv);
					String x = (String) tableGiangVien.getModel().getValueAt(row, 1);
					txtTenChuyenNganh.setText(giangVienDAO.timTenChuyenNganhTheoMaGV(x));
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
		cbbTimKiem.setSelectedIndex(0);
		napDanhSachGiangVien(giangVienDAO.danhSachGiangVien());
		txtMaGV.setEditable(false);

	}

	private boolean kiemTra() {
		int a = 0;
		if (a == 0)
			return true;
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object o = e.getSource();
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
