package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import dao.NhanVienDAO;
import entity.NhanVienPDT;

public class frm_TimKiemNhanVienPDT extends JPanel implements ActionListener {
	private JTextField txtHoTenNhanVien;
	private JTextField txtDiaChi;
	private JDateChooser txtNgaySinh;
	private JLabel lblNgaySinh;
	private JLabel lblDiaChi;
	private JLabel lblSDT;
	private JTextField txtSoDienThoai;
	private JTextField txtTimKiem;
	private JComboBox<String> cmbTimKiem;
	private JScrollPane scrNhanVien;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private DefaultTableModel modelNhanVienPDT;
	private JTable tableNhanVienPDT;
	private JTextField txtMaNhanVien;
	private NhanVienDAO nhanVienDAO;

	private void napDanhSachNhanVien(List<NhanVienPDT> danhSachNhanVien) {
		xoaBang();
		int i = 1;
		for (NhanVienPDT nv : danhSachNhanVien) {
			String[] row = { i + "", nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh() + "", nv.getGioiTinh(),
					nv.getDiaChi(), nv.getSoDienThoai() };
			modelNhanVienPDT.addRow(row);
			tableNhanVienPDT.setModel(modelNhanVienPDT);
			i++;
		}
	}

	private void xoaBang() {
		while (modelNhanVienPDT.getRowCount() > 0) {
			modelNhanVienPDT.removeRow(0);
		}

	}

	public frm_TimKiemNhanVienPDT() {
//		setBackground(new Color(0, 153, 255));
		setLayout(null);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setBounds(20, 569, 97, 20);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblMaNhanVien);

		JLabel lblHoTenNhanVien = new JLabel("Họ tên nhân viên");
		lblHoTenNhanVien.setBounds(290, 569, 118, 19);
		lblHoTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblHoTenNhanVien);

		txtHoTenNhanVien = new JTextField();
		txtHoTenNhanVien.setEditable(false);
		txtHoTenNhanVien.setBounds(410, 569, 234, 20);
		txtHoTenNhanVien.setColumns(10);
		add(txtHoTenNhanVien);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(20, 609, 97, 20);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblGioiTinh);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(770, 609, 230, 20);
		txtDiaChi.setColumns(10);
		add(txtDiaChi);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBounds(410, 609, 234, 19);
		txtNgaySinh.setDateFormatString("yyyy/MM/dd");
		add(txtNgaySinh);

		lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setBounds(290, 609, 83, 19);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNgaySinh);

		lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(680, 609, 66, 20);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDiaChi);

		lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(680, 569, 83, 20);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblSDT);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(770, 569, 230, 20);
		((JTextField) txtSoDienThoai).setColumns(10);
		add(txtSoDienThoai);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(171, 20, 159, 20);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cmbTimKiem = new JComboBox();
		cmbTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Tất cá nhân viên", "Theo mã", "Theo tên" }));
		cmbTimKiem.setBounds(330, 20, 140, 20);
		add(cmbTimKiem);

		JLabel lblTim = new JLabel("Tìm nhân viên");
		lblTim.setBounds(10, 10, 151, 40);
		lblTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTim.setIcon(new ImageIcon("images/Find.png"));
		add(lblTim);

		rdoNam = new JRadioButton("Nam", true);
		rdoNam.setBounds(140, 609, 52, 20);
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(200, 609, 52, 20);
		add(rdoNu);
		add(rdoNam);
		ButtonGroup group = new ButtonGroup();
		group.add(rdoNam);
		group.add(rdoNu);

		// Table
		this.nhanVienDAO = new NhanVienDAO();
		String[] headers = "STT;Mã nhân viên;Họ tên;Ngày sinh;Giới tính;Địa chỉ;Số điện thoại".split(";");
		modelNhanVienPDT = new DefaultTableModel(headers, 50);
		tableNhanVienPDT = new JTable(modelNhanVienPDT) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrNhanVien = new JScrollPane(tableNhanVienPDT, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrNhanVien.setBorder(BorderFactory.createTitledBorder("DANH SÁCH NHÂN VIÊN"));
		tableNhanVienPDT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableNhanVienPDT.getTableHeader().setReorderingAllowed(false);
		scrNhanVien.setBounds(20, 50, 1310, 490);
		scrNhanVien.setViewportView(tableNhanVienPDT);
		add(scrNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBounds(140, 569, 130, 19);
		add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
		cmbTimKiem.addActionListener(this);
		tableNhanVienPDT.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableNhanVienPDT.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableNhanVienPDT.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableNhanVienPDT.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableNhanVienPDT.getColumnModel().getColumn(5).setPreferredWidth(300);
		tableDesign(tableNhanVienPDT);
		tableRenderer();

		tableNhanVienPDT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<NhanVienPDT> list = nhanVienDAO.danhSachNhanVien();
				int row = tableNhanVienPDT.getSelectedRow();
				if (row >= 0 && row <= list.size()) {
					NhanVienPDT nv = list.get(row);
					napNhanVien(nv);
				}
			}

			private void napNhanVien(NhanVienPDT nv) {
				txtMaNhanVien.setText(nv.getMaNhanVien());
				txtHoTenNhanVien.setText(nv.getTenNhanVien());
				txtDiaChi.setText(nv.getDiaChi());
				txtSoDienThoai.setText(nv.getSoDienThoai());
				txtNgaySinh.setDate(nv.getNgaySinh());
				txtNgaySinh.setToolTipText(String.valueOf(nv.getNgaySinh()));
				String gt = nv.getGioiTinh();
				if (gt.equals("Nam"))
					rdoNam.setSelected(true);
				else
					rdoNu.setSelected(true);
			}

		});
	}

	private void lamMoi() {
		txtDiaChi.setText("");
		txtHoTenNhanVien.setText("");
		txtMaNhanVien.setText("");
		txtMaNhanVien.setEditable(false);
		txtNgaySinh.setDate(new java.util.Date());
		txtTimKiem.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(cmbTimKiem)) {
			xoaBang();
			napDanhSachNhanVien(nhanVienDAO.danhSachNhanVienTheoMa(txtMaNhanVien.getText().trim()));
			String s = cmbTimKiem.getSelectedItem().toString().trim();
			if (s.equalsIgnoreCase("Tất cá nhân viên"))
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
			else if (s.equalsIgnoreCase("Theo mã"))
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVienTheoMa(txtTimKiem.getText().trim()));
			else if (s.equalsIgnoreCase("Theo tên"))
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVienTheoTen(txtTimKiem.getText().trim()));
			else
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
		}
	}

	private boolean kiemTra() {
		int a = 0;
		if (a == 0)
			return true;
		return false;
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableNhanVienPDT.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableNhanVienPDT.getColumn("Mã nhân viên").setCellRenderer(centerCellRenderer);
		tableNhanVienPDT.getColumn("Ngày sinh").setCellRenderer(centerCellRenderer);
		tableNhanVienPDT.getColumn("Giới tính").setCellRenderer(centerCellRenderer);
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}
}
