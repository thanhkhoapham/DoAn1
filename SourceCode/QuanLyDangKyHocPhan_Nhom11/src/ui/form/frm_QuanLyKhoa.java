package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.KhoaDAO;
import entity.Khoa;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;

public class frm_QuanLyKhoa extends JPanel implements ActionListener {

	private JTextField txtMaKhoa;
	private JTextField txtTimKiem;
	private JComboBox cmbTimKiem;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnLuu;
	private JButton btnSua;
	private DefaultTableModel modelKhoa;
	private JTable tableKhoa;
	private KhoaDAO khoaDao;
	private JTextField txtTenKhoa;
	private ButtonGroup group;

	/**
	 * Create the panel.
	 */
	public frm_QuanLyKhoa() {
//		setBackground(new Color(0, 153, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã khoa");
		lblNewLabel.setBounds(52, 540, 130, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel);

		txtMaKhoa = new JTextField();
		txtMaKhoa.setBounds(188, 540, 190, 20);
		add(txtMaKhoa);
		txtMaKhoa.setColumns(10);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(140, 20, 190, 20);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cmbTimKiem = new JComboBox();
		cmbTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Tất cả khoa", "Theo tên", "Theo mã" }));
		cmbTimKiem.setBounds(330, 20, 140, 20);
		add(cmbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("Tìm Khoa");
		lblNewLabel_6.setBounds(10, 10, 130, 40);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setIcon(new ImageIcon("images/Find.png"));
		add(lblNewLabel_6);

		JLabel lbTenKhoa = new JLabel("Tên khoa");
		lbTenKhoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTenKhoa.setBounds(450, 540, 89, 20);
		add(lbTenKhoa);

		// Table
		String[] headers = "STT;Mã khoa;Tên khoa".split(";");

		modelKhoa = new DefaultTableModel(headers, 50);
		tableKhoa = new JTable(modelKhoa) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modelKhoa = (DefaultTableModel) tableKhoa.getModel();
		tableKhoa.setModel(modelKhoa);
		group = new ButtonGroup();

		scrollPane = new JScrollPane(tableKhoa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createTitledBorder("DANH SÁCH KHOA"));
		tableKhoa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
//				tableSinhVien.setRowHeight(20);
		tableKhoa.getTableHeader().setReorderingAllowed(false);
		scrollPane.setBounds(20, 50, 1310, 455);
		scrollPane.setViewportView(tableKhoa);
		add(scrollPane);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(1020, 515, 303, 135);
		add(panel);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("img/addKhoa.png"));
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
		txtTenKhoa = new JTextField();
		txtTenKhoa.setColumns(10);
		txtTenKhoa.setBounds(521, 540, 190, 20);
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("img/exchange.png"));
		btnSua.setBounds(15, 75, 130, 50);
		panel.add(btnSua);
		khoaDao = new KhoaDAO();
		this.khoaDao = new KhoaDAO();
		napDanhSachKhoa(khoaDao.danhSachKhoa());
		khoaDao = new KhoaDAO();

		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		cmbTimKiem.addActionListener(this);
		btnLuu.setEnabled(false);
		add(txtTenKhoa);
		txtMaKhoa.setEditable(false);
		tableDesign(tableKhoa);
		tableRenderer();

//		tableGiangVien.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableKhoa.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableKhoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Khoa> khoa = khoaDao.danhSachKhoa();
				int row = tableKhoa.getSelectedRow();
				if (row >= 0 && row <= khoa.size()) {
					Khoa kh = khoa.get(row);
					napKhoa(kh);
				}
			}

			private void napKhoa(Khoa kh) {
				txtMaKhoa.setText(kh.getMaKhoa());
				txtTenKhoa.setText(kh.getTenKhoa());
			}
		});
		tableKhoa.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableKhoa.getColumnModel().getColumn(1).setPreferredWidth(100);
	}

	private void xoaBang() {
		while (modelKhoa.getRowCount() > 0) {
			modelKhoa.removeRow(0);
		}
	}

	private void napDanhSachKhoa(List<Khoa> danhSachKhoa) {
		xoaBang();
		this.khoaDao = new KhoaDAO();
		int i = 1;
		for (Khoa kh : danhSachKhoa) {
			String[] row = { i + "", kh.getMaKhoa(), kh.getTenKhoa() };
			modelKhoa.addRow(row);
			tableKhoa.setModel(modelKhoa);
			i++;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object o = e.getSource();
			if (o.equals(btnLamMoi)) {
				lamMoi();
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
			}
			if (o.equals(btnLuu)) {
				if (kiemTra()) {
					if (khoaDao.timMaKhoa(txtMaKhoa.getText().trim())) {
						showMes(txtMaKhoa, "Trùng mã");
						return;
					}
					Khoa khoa = new Khoa(txtMaKhoa.getText().trim(), txtTenKhoa.getText().trim());
					if (khoaDao.themKhoa(khoa)) {
						napDanhSachKhoa(khoaDao.danhSachKhoa());
						JOptionPane.showMessageDialog(this, "Đã thêm");
						btnLuu.setEnabled(false);
						btnThem.setEnabled(true);
						btnSua.setEnabled(true);
						lamMoi();
					} else
						JOptionPane.showMessageDialog(this, "Không thêm được");
				}

			}
			if (o.equals(btnSua)) {
				if (kiemTra()) {
					Khoa khoa = new Khoa(txtMaKhoa.getText().trim(), txtTenKhoa.getText().trim());
					if (khoaDao.suaKhoa(khoa)) {
						napDanhSachKhoa(khoaDao.danhSachKhoa());
						JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					} else
						JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
				}
			}
			if (o.equals(btnThem)) {
				lamMoi();
				btnThem.setEnabled(false);
				btnLuu.setEnabled(true);
				txtMaKhoa.setEditable(true);
				btnSua.setEnabled(false);
			}
			if (o.equals(cmbTimKiem)) {
				if (cmbTimKiem.getSelectedItem().equals("Tất cả khoa")) {
					napDanhSachKhoa(khoaDao.danhSachKhoa());
				}
				if (cmbTimKiem.getSelectedItem().equals("Theo tên")) {
					napDanhSachKhoa(khoaDao.timTheoTen(txtTimKiem.getText().trim()));
				}
				if (cmbTimKiem.getSelectedItem().equals("Theo mã")) {
					napDanhSachKhoa(khoaDao.timKhoa(txtTimKiem.getText().trim()));
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	private void lamMoi() {
		txtMaKhoa.setEditable(false);
		txtMaKhoa.setText("");
		txtTenKhoa.setText("");
		txtTimKiem.setText("");
		btnLuu.setEnabled(false);
		btnThem.setEnabled(true);
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

		tableKhoa.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableKhoa.getColumn("Mã khoa").setCellRenderer(centerCellRenderer);
	}

	private boolean kiemTra() {

		if (txtMaKhoa.getText().equals("")) {
			showMes(txtMaKhoa, "Không để trống mã khoa");
			return false;
		}
		if (txtTenKhoa.getText().equals("")) {
			showMes(txtTenKhoa, "Không để trống tên khoa viên");
			return false;
		}
//		if (!txtTenKhoa.getText().trim().matches("[A-Za-z]*")) {
//			showMes(txtTenKhoa, "Không nhập số cho tên khoa");
//			return false;
//		}
		return true;
	}

	public void showMes(JTextField tf, String mes) {
		JOptionPane.showMessageDialog(this, mes);
		tf.selectAll();
		tf.requestFocus();
	}
}
