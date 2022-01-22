package ui.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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

public class frm_XemLichHoc extends JPanel {
	private JTable tblLichHoc;
	private DefaultTableModel modelLichHoc;
	private JScrollPane scroll;

	private SinhVienDAO sinhVienDAO = new SinhVienDAO();
	private PhieuDangKyDAO phieuDangKyDAO = new PhieuDangKyDAO();
	private HocPhanDAO hpDAO = new HocPhanDAO();
	private LopHocPhanDAO lhpDAO = new LopHocPhanDAO();

	private JComboBox<String> cmbHocKy;
	private JComboBox<String> cmbNamHoc;
	private JButton btnChon;

	public frm_XemLichHoc(String uname) {
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

		b.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel pnlLichHoc = new JPanel();

		JLabel lblTieuDe;
		b1.add(lblTieuDe = new JLabel("XEM LỊCH HỌC", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.RED);

		b2.add(Box.createHorizontalStrut(400));
		JLabel lblChonHK;
		b2.add(lblChonHK = new JLabel("Chọn học kỳ: "));
		b2.add(cmbHocKy = new JComboBox<>());
		cmbHocKy.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(cmbNamHoc = new JComboBox<>());
		cmbNamHoc.setModel(new DefaultComboBoxModel(new String[] { "2020 - 2021" }));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(btnChon = new JButton("Chọn"));
		b2.add(Box.createHorizontalStrut(400));

		b3.add(pnlLichHoc);
		pnlLichHoc.setBorder(BorderFactory.createTitledBorder("Lịch học"));

		String[] tieuDe = { "Thứ", "Tên môn học", "Lớp học phần", "Tiết", "Phòng", "Giảng viên" };
		modelLichHoc = new DefaultTableModel(tieuDe, 0);
		tblLichHoc = new JTable(modelLichHoc) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tblLichHoc.getTableHeader().setReorderingAllowed(false);
		tblLichHoc.setPreferredScrollableViewportSize(new Dimension(1200, 500));
		tblLichHoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlLichHoc.add(scroll = new JScrollPane(tblLichHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		String maSV = sinhVienDAO.layThongTinSV(uname).getMaSinhVien();

		btnChon.addActionListener(e -> {
			String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex());
			String namHoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
			int hocKy = Integer.parseInt(hk);
			loadTBLichHoc(maSV, hocKy, namHoc);

		});
		int hk = Integer.parseInt(cmbHocKy.getItemAt(0).toString());
		loadTBLichHoc(maSV, hk, cmbNamHoc.getItemAt(0));

//		tblLichHoc.setAutoCreateRowSorter(true);
		setTBLHColumnWidth();
		tableRenderer();
		tableDesign(tblLichHoc);
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tblLichHoc.getColumn("Thứ").setCellRenderer(centerCellRenderer);
		tblLichHoc.getColumn("Tên môn học").setCellRenderer(centerCellRenderer);
		tblLichHoc.getColumn("Lớp học phần").setCellRenderer(centerCellRenderer);
		tblLichHoc.getColumn("Tiết").setCellRenderer(centerCellRenderer);
		tblLichHoc.getColumn("Phòng").setCellRenderer(centerCellRenderer);
		tblLichHoc.getColumn("Giảng viên").setCellRenderer(centerCellRenderer);
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(25);
		tb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}

	private void setTBLHColumnWidth() {
		TableColumn column = null;
		for (int i = 0; i < tblLichHoc.getColumnCount(); i++) {
			column = tblLichHoc.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(20);
			} else if (i == 1 || i == 5) {
				column.setPreferredWidth(200);
			}
		}
	}

	private void xoaTBLichHoc() {
		while (modelLichHoc.getRowCount() != 0) {
			modelLichHoc.removeRow(0);
		}
	}

	private void loadTBLichHoc(String maSV, int hocKy, String namHoc) {
		xoaTBLichHoc();
		List<PhieuDangKy> dspdk = phieuDangKyDAO.layDsPhieuDangKy(maSV);
		for (PhieuDangKy phieuDangKy : dspdk) {
			LopHocPhan lhp = phieuDangKy.getLopHocPhan();
			HocPhan hp = hpDAO.timHPTheoMa(lhp.getHocPhan().getMaHocPhan());
			List<CT_LopHocPhan> dsct = lhpDAO.layDsCTLopHoc(lhp.getMaLopHocPhan());
			for (CT_LopHocPhan ct : dsct) {
				if (hp.getHocKy() == hocKy && lhp.getNamHoc().equals(namHoc)) {
					String[] rowData = { ct.getThu(), hp.getTenMonHoc(), lhp.getLopTinChi(), ct.getTietHoc(),
							ct.getPhongHoc().getTenPhong(), ct.getGiangVien().getTenGiangVien() };
					modelLichHoc.addRow(rowData);
					tblLichHoc.setModel(modelLichHoc);
				}
			}
		}
	}
}
