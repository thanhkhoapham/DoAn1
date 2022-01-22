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

public class frm_TimKiemHocPhan extends JPanel implements ActionListener {

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
	private JComponent pnlThongTin;
	private JComboBox cmbHocKy;
	private JComboBox cmbSoTinChi;
	private JRadioButton rdBatBuoc;
	private HocPhanDAO hocPhanDAO;
	private JComboBox<String> cmbMaKhoa;
	private JComboBox cbbHocPhanBatBuoc;

	public frm_TimKiemHocPhan() {
		setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(140, 20, 190, 25);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cmbTimKiem = new JComboBox();
		cmbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Tất cả học phần", "Theo mã ", "Theo tên" }));
		cmbTimKiem.setBounds(330, 20, 150, 25);
		add(cmbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("Tìm môn học");
		lblNewLabel_6.setBounds(10, 10, 130, 40);
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
		scrDanhSach.setBorder(new TitledBorder(null, "DANH S\u00C1CH H\u1ECCC PH\u1EA6N", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		tblHocPhan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		tblHocPhan.getColumnModel().getColumn(0).setPreferredWidth(42);
		tblHocPhan.getColumnModel().getColumn(1).setPreferredWidth(88);
		tblHocPhan.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblHocPhan.getColumnModel().getColumn(3).setPreferredWidth(66);
		tblHocPhan.getColumnModel().getColumn(4).setPreferredWidth(64);
		tblHocPhan.getColumnModel().getColumn(5).setPreferredWidth(92);
		add(scrDanhSach);
		scrDanhSach.setViewportView(tblHocPhan);

		pnlThongTin = new JPanel();
//		pnlThongTin.setBackground(new Color(248, 248, 255));
		pnlThongTin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlThongTin.setBounds(92, 515, 1165, 135);
		add(pnlThongTin);
		pnlThongTin.setLayout(null);

		JLabel lblTnHcPhn = new JLabel("Tên học phần");
		lblTnHcPhn.setBounds(133, 85, 110, 25);
		pnlThongTin.add(lblTnHcPhn);
		lblTnHcPhn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("Mã học phần");
		lblNewLabel.setBounds(133, 35, 110, 25);
		pnlThongTin.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtMaHocPhan = new JTextField();
		txtMaHocPhan.setEditable(false);
		txtMaHocPhan.setBounds(241, 35, 197, 25);
		pnlThongTin.add(txtMaHocPhan);
		txtMaHocPhan.setColumns(10);

		txtTenHocPhan = new JTextField();
		txtTenHocPhan.setBounds(241, 85, 197, 25);
		pnlThongTin.add(txtTenHocPhan);
		txtTenHocPhan.setColumns(10);

		JLabel lblHcK = new JLabel("Học kỳ");
		lblHcK.setBounds(370, 34, 78, 25);
		pnlThongTin.add(lblHcK);
		lblHcK.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblSTnCh = new JLabel("Số tín chỉ");
		lblSTnCh.setBounds(469, 85, 78, 25);
		pnlThongTin.add(lblSTnCh);
		lblSTnCh.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cmbHocKy = new JComboBox();
		cmbHocKy.setBounds(549, 35, 105, 25);
		pnlThongTin.add(cmbHocKy);
		cmbHocKy.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));

		cmbSoTinChi = new JComboBox();
		cmbSoTinChi.setBounds(549, 85, 105, 25);
		pnlThongTin.add(cmbSoTinChi);
		cmbSoTinChi.setModel(new DefaultComboBoxModel(new String[] { "2", "3", "4", "5" }));

		rdBatBuoc = new JRadioButton("Bắt buộc");
		rdBatBuoc.setBounds(982, 89, 97, 21);
		pnlThongTin.add(rdBatBuoc);

		JLabel lblHcPhnYu = new JLabel("Học phần yêu cầu");
		lblHcPhnYu.setBounds(679, 35, 130, 25);
		pnlThongTin.add(lblHcPhnYu);
		lblHcPhnYu.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMKhoa = new JLabel("Mã khoa");
		lblMKhoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKhoa.setBounds(679, 85, 97, 25);
		pnlThongTin.add(lblMKhoa);

		cmbMaKhoa = new JComboBox();
		cmbMaKhoa.setBounds(799, 89, 164, 21);
		pnlThongTin.add(cmbMaKhoa);

		cbbHocPhanBatBuoc = new JComboBox();
		cbbHocPhanBatBuoc.setBounds(799, 39, 164, 21);
		pnlThongTin.add(cbbHocPhanBatBuoc);

		JLabel lblHocKy = new JLabel("Học kỳ");
		lblHocKy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHocKy.setBounds(469, 35, 78, 25);
		pnlThongTin.add(lblHocKy);
//		setBackground(new Color(255, 255, 255));
		tableCenter();
		con = ConnectDB.getInstance().getConnection();
		napDanhSachHocPhan(hocPhanDAO.danhSachHocPhan());
		napComboBoxmaKhoa();
		cmbTimKiem.addActionListener(this);

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
					String yeuCau = (String) tblHocPhan.getModel().getValueAt(row, 6);
					String maKhoa = (String) tblHocPhan.getModel().getValueAt(row, 7);
					String tenKhoa = hocPhanDAO.timTenTheoMaKhoa(maKhoa);
					txtMaHocPhan.setText(maHP);
					txtTenHocPhan.setText(tenMonHoc);

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
					for (int i = 0; i < cmbMaKhoa.getItemCount(); i++)
						if (tenKhoa.equals(cmbMaKhoa.getItemAt(i).toString())) {
							cmbMaKhoa.setSelectedIndex(i);
							break;
						}
					if (batBuoc.equalsIgnoreCase("x"))
						rdBatBuoc.setSelected(true);
					else
						rdBatBuoc.setSelected(false);
//					txtMaHocPhanYeuCau.setText(yeuCau);
//					txtHocPhanYeuCau.setText(hocPhanDAO.timHocPhanTheoMa(yeuCau));
				}
			}
		});

	}

	private void napComboBoxmaKhoa() {
		try {
			PreparedStatement stmt = con.prepareStatement("select tenKhoa from Khoa order by tenKhoa");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				this.cmbMaKhoa.addItem(rs.getString("tenKhoa"));
			}
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
					batbuoc, hp.getHocPhanYeuCau(), hp.getKhoa().getMaKhoa() };
			HocPhanModel.addRow(row);
			tblHocPhan.setModel(HocPhanModel);
			i++;
		}
	}

	private void tableCenter() {
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
//		STT;Mã học phần;Tên môn học;Học kỳ;Số tín chỉ;Bắt buộc;Học phần yêu cầu
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

		if (o.equals(cmbTimKiem)) {
//			Tất cả học phần", "Theo mã ", "Theo tên", "Theo học kỳ
			String tk = cmbTimKiem.getSelectedItem().toString().trim();
			if (tk.equals("Tất cả học phần"))
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhan());
			if (tk.equals("Theo mã"))
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhanTheoMa(txtTimKiem.getText().toString().trim()));
			if (tk.equals("Theo tên"))
				napDanhSachHocPhan(hocPhanDAO.danhSachHocPhanTheoTen(txtTimKiem.getText().toString().trim()));
//			if (tk.equals("Theo học kỳ"))
//				napDanhSachHocPhan(
//						hocPhanDAO.danhSachHocPhanTheoHocKy(Integer.parseInt(txtTimKiem.getText().toString().trim())));
		}

	}

	private boolean kiemTra() {
		// TODO Auto-generated method stub
		return true;
	}

	private void lamMoi() {

		txtMaHocPhan.setEditable(false);
		txtMaHocPhan.setText("");
		txtTenHocPhan.setText("");
		txtTimKiem.setText("");
		cbbHocPhanBatBuoc.setSelectedIndex(0);
		cmbHocKy.setSelectedIndex(0);
		cmbSoTinChi.setSelectedIndex(0);
		cmbTimKiem.setSelectedIndex(0);

	}
}
