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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
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

import dao.ConnectDB;
import dao.SinhVienDAO;
import entity.LopSinhVien;
import entity.SinhVien;
import entity.TaiKhoan;

public class frm_TimKiemSinhVien extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1906248937583556942L;
	private static Connection con;
	private JPanel contentPane;
	private JTextField txtMaSinhVien;
	private JTextField txtDiaChi;
	private JDateChooser txtNgaySinh;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_3;
	private JTextField txtSoDienThoai;
	private JTextField txtTimKiem;
	private JPanel panel;
	private JComboBox<String> cbbTimKiem;
	private JScrollPane scrollPane;
	private JTextField txtHoTenSV;
	private DefaultTableModel modelSinhVien;
	private JTable tableSinhVien;
	private SinhVienDAO sinhVienDAO;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private ButtonGroup buttonGroup;
	private ButtonGroup group;
	private JTextField txtTenLop;
	private JTextField txtTenChuyenNganh;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void GiaoDien() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setBounds(20, 541, 79, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel);

		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaSinhVien.setBounds(122, 541, 180, 20);
		txtMaSinhVien.setText("SV13111");
		add(txtMaSinhVien);
		txtMaSinhVien.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Họ tên sinh viên");
		lblNewLabel_1.setBounds(20, 580, 103, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên lớp");
		lblNewLabel_1_1.setBounds(330, 580, 91, 17);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(405, 620, 546, 20);
		txtDiaChi.setText("24 Nguyễn Du, p1, Gò Vấp");
		txtDiaChi.setColumns(10);
		add(txtDiaChi);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		txtNgaySinh.setBounds(1095, 620, 190, 20);
		add(txtNgaySinh);

		lblNewLabel_4 = new JLabel("Ngày Sinh");
		lblNewLabel_4.setBounds(1005, 620, 64, 17);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Giới tính");
		lblNewLabel_5.setBounds(20, 619, 53, 17);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_5);

		lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setBounds(330, 620, 43, 17);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_2);

		lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setBounds(975, 580, 83, 17);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_3);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(1095, 580, 190, 20);
		txtSoDienThoai.setText("0959548574");
		txtSoDienThoai.setColumns(10);
		add(txtSoDienThoai);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setText("DHKTPM13A");
		txtTimKiem.setBounds(140, 20, 190, 25);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cbbTimKiem = new JComboBox();
		cbbTimKiem.setModel(new DefaultComboBoxModel(
				new String[] { "Tất cả sinh viên", "Theo mã", "Theo tên", "Theo lớp học", "Theo chuyên ngành" }));
		cbbTimKiem.setBounds(330, 20, 140, 25);
		add(cbbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("Tìm sinh viên");
		lblNewLabel_6.setBounds(10, 10, 130, 40);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setIcon(new ImageIcon("images/Find.png"));
		add(lblNewLabel_6);
		group = new ButtonGroup();

		txtHoTenSV = new JTextField();
		txtHoTenSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHoTenSV.setEditable(false);
		txtHoTenSV.setBounds(122, 580, 180, 20);
		txtHoTenSV.setText("Phạm Thành Khoa");
		txtHoTenSV.setColumns(10);
		add(txtHoTenSV);

		JLabel lblMLp_1 = new JLabel("Chuyên ngành");
		lblMLp_1.setBounds(660, 579, 110, 17);
		lblMLp_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblMLp_1);

		rdNam = new JRadioButton("Nam", true);
		rdNam.setBounds(119, 619, 53, 21);
		add(rdNam);
		rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(199, 619, 53, 21);
		add(rdNu);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdNam);
		buttonGroup.add(rdNu);
		// Table
		this.sinhVienDAO = new SinhVienDAO();
		String[] headers = "STT;Mã sinh viên;Họ tên;Mã lớp;Chuyên ngành;Ngày sinh;Giới tính;Địa chỉ;Số điện thoại"
				.split(";");
		modelSinhVien = new DefaultTableModel(headers, 50);
		tableSinhVien = new JTable(modelSinhVien) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		
		scrollPane = new JScrollPane(tableSinhVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(20, 50, 1310, 481);
		scrollPane.setBorder(BorderFactory.createTitledBorder("DANH SÁCH SINH VIÊN"));
		tableSinhVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableSinhVien.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tableSinhVien);
		add(scrollPane);
		
		tableSinhVien.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(2).setPreferredWidth(250);
		tableSinhVien.getColumnModel().getColumn(7).setPreferredWidth(250);
		tableSinhVien.getColumnModel().getColumn(6).setPreferredWidth(30);
	}

	private void xoaBang() {
		while (modelSinhVien.getRowCount() > 0) {
			modelSinhVien.removeRow(0);
		}
	}

	private void napDanhSachSinhVien(List<SinhVien> list) {
		xoaBang();
		int i = 1;
		for (SinhVien sv : list) {
			LopSinhVien lsv = sinhVienDAO.layThongTinBoiMa(sv.getLopSinhVien().getMaLopSV());
			String[] row = { i + "", sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getLopSinhVien().getMaLopSV(),
					lsv.getChuyenNganh().getMaChuyenNganh() + "", sv.getNgaySinh() + "", sv.getGioiTinh(),
					sv.getDiaChi(), sv.getSoDienThoai() };
			modelSinhVien.addRow(row);
			tableSinhVien.setModel(modelSinhVien);
			i -= -1;
		}
	}

	public frm_TimKiemSinhVien() {
		con = ConnectDB.getInstance().getConnection();
//		setBackground(new Color(0, 153, 255));
		GiaoDien();
		napDanhSachSinhVien(sinhVienDAO.danhSachSinhVien());
		cbbTimKiem.addActionListener(this);
//		cbbTenLopSV.setEnabled(false);
		txtMaSinhVien.setEditable(false);

		txtTenLop = new JTextField();
		txtTenLop.setEditable(false);
		txtTenLop.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenLop.setText("");
		txtTenLop.setColumns(10);
		txtTenLop.setBounds(405, 580, 180, 20);
		add(txtTenLop);

		txtTenChuyenNganh = new JTextField();
		txtTenChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenChuyenNganh.setText("");
		txtTenChuyenNganh.setEditable(false);
		txtTenChuyenNganh.setColumns(10);
		txtTenChuyenNganh.setBounds(771, 580, 180, 20);
		add(txtTenChuyenNganh);
		
		tableDesign(tableSinhVien);
		tableRenderer();
		tableSinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<SinhVien> list = sinhVienDAO.danhSachSinhVien();
				int row = tableSinhVien.getSelectedRow();
				if (row >= 0 && row <= list.size()) {
					SinhVien sv = list.get(row);
//					cbbTenChuyenNganh.removeAllItems();
//					cbbTenLopSV.removeAllItems();
					napSinhVien(sv);
					String tenLop = (String) tableSinhVien.getModel().getValueAt(row, 1);
					String tenChuyenNganh = (String) tableSinhVien.getModel().getValueAt(row, 1);
					txtTenChuyenNganh.setText(sinhVienDAO.timTenChuyenNganhTheoMaSV(tenChuyenNganh));
					txtTenLop.setText(sinhVienDAO.timTenLopHocTheoMaSV(tenLop));
				}
			}
		});
	}

	private void napSinhVien(SinhVien sv) {
		txtMaSinhVien.setText(sv.getMaSinhVien());
		txtHoTenSV.setText(sv.getTenSinhVien());
		txtDiaChi.setText(sv.getDiaChi());
		txtNgaySinh.setDate(sv.getNgaySinh());
		txtNgaySinh.setToolTipText(String.valueOf(sv.getNgaySinh()));
		txtSoDienThoai.setText(sv.getSoDienThoai());
		txtTimKiem.setText("");
		String x = sv.getGioiTinh();
		if (x.equals("Nam"))
			rdNam.setSelected(true);
		else
			rdNu.setSelected(true);
	}

	private void lamMoi() {
		txtDiaChi.setText("");
		txtHoTenSV.setText("");
		txtMaSinhVien.setText("");
		txtSoDienThoai.setText("");
		txtTimKiem.setText("");
		rdNam.setSelected(true);
		txtTenChuyenNganh.setText("");
		txtTenLop.setText("");
		cbbTimKiem.setSelectedIndex(0);
		txtNgaySinh.setDate(new java.util.Date());
//		cbbTenLopSV.setEnabled(false);
//		cbbTenLopSV.setEditable(false);
		txtMaSinhVien.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		try {

			if (o.equals(cbbTimKiem)) {
				xoaBang();
				napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoMaLop(txtTimKiem.getText().trim()));
				String s = cbbTimKiem.getSelectedItem().toString();
				if (s.equalsIgnoreCase("Tất cả sinh viên"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVien());
				else if (s.equalsIgnoreCase("Theo lớp học"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoMaLop(txtTimKiem.getText().trim()));
				else if (s.equalsIgnoreCase("Theo tên"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoTen(txtTimKiem.getText().trim()));
				else if (s.equalsIgnoreCase("Theo mã"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoMa(txtTimKiem.getText().trim()));
				else
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoTenChuyenNganh(txtTimKiem.getText().trim()));
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}

	}

//	private boolean kiemTra() {
//		if (txtHoTenSV.getText().trim() == "") {
//			showMes(txtHoTenSV, "Khong rong");
//			return false;
//		}
//		if (!txtHoTenSV.getText().trim().matches("[A-Z][a-z]{0,}\s([A-Z][a-z]){0,}")) {
//			showMes(txtHoTenSV, "Khong dung");
//			return false;
//		}
//
//		return true;
//	}
//
//	public void showMes(JTextField tf, String mes) {
//		JOptionPane.showMessageDialog(this, mes);
//		tf.selectAll();
//		tf.requestFocus();
//	}
	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableSinhVien.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("Mã sinh viên").setCellRenderer(centerCellRenderer);
//		tableSinhVien.getColumn("Họ tên").setCellRenderer(rightCellRenderer);
		tableSinhVien.getColumn("Mã lớp").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("Chuyên ngành").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("Ngày sinh").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("Giới tính").setCellRenderer(centerCellRenderer);
//		tableSinhVien.getColumn("Địa chỉ").setCellRenderer(centerCellRenderer);
//		tableSinhVien.getColumn("Số điện thoại").setCellRenderer(centerCellRenderer);
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}
}