package ui.form;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.HocPhanDAO;
import dao.KetQuaHocTapDAO;
import dao.SinhVienDAO;
import entity.HocPhan;
import entity.KetQuaHocTap;

public class frm_KetQuaHocTap extends JPanel {
	private JTable tableKQHT;
	private DefaultTableModel modelKQHT;
	private JScrollPane scroll;

	private SinhVienDAO sinhVienDAO = new SinhVienDAO();
	private KetQuaHocTapDAO kqDAO = new KetQuaHocTapDAO();
	private HocPhanDAO hpDAO = new HocPhanDAO();
	private JComboBox<String> cmbHocKy;
	private JComboBox<String> cmbNamHoc;
	private JButton btnChon;

	public frm_KetQuaHocTap(String uname) {
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

		JPanel pnlKQHT = new JPanel();

		JLabel lblTieuDe;
		b1.add(lblTieuDe = new JLabel("KẾT QUẢ HỌC TẬP", JLabel.CENTER));
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

		b3.add(pnlKQHT);

		
		pnlKQHT.setBorder(BorderFactory.createTitledBorder("Kết quả học tập"));

		String[] tieuDe = { "STT", "Mã học phần", "Tên môn học", "Điểm thường kỳ", "Điểm giữa kỳ", "Điểm cuối kỳ",
				"Điểm tổng kết", "Xếp loại" };
		modelKQHT = new DefaultTableModel(tieuDe, 0);
		tableKQHT = new JTable(modelKQHT) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableKQHT.getTableHeader().setReorderingAllowed(false);
		tableKQHT.setPreferredScrollableViewportSize(new Dimension(1200, 500));
		tableKQHT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlKQHT.add(scroll = new JScrollPane(tableKQHT, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		String maSV = sinhVienDAO.layThongTinSV(uname).getMaSinhVien();

		btnChon.addActionListener(e -> {
			String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex());
			String namHoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
			int hocKy = Integer.parseInt(hk);
			loadTBKetQuaHT(maSV, hocKy, namHoc);

		});

		int hk = Integer.parseInt(cmbHocKy.getItemAt(0).toString());
		loadTBKetQuaHT(maSV, hk, cmbNamHoc.getItemAt(0).toString());
		setTBKQHTColumnWidth();
		tableRenderer();
		tableDesign(tableKQHT);
	}

	private void setTBKQHTColumnWidth() {
		TableColumn column = null;
		for (int i = 0; i < tableKQHT.getColumnCount(); i++) {
			column = tableKQHT.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(20);
			} else if (i == 2) {
				column.setPreferredWidth(200);
			}
		}
	}

	private void xoaTBKQHT() {
		while (modelKQHT.getRowCount() > 0) {
			modelKQHT.removeRow(0);
		}
	}

	public void loadTBKetQuaHT(String maSV, int hocKy, String namHoc) {
		xoaTBKQHT();
		List<KetQuaHocTap> dskq = kqDAO.layDsKQHocTap(maSV, hocKy, namHoc);
		int i = 1;
		for (KetQuaHocTap kq : dskq) {
			HocPhan hp = hpDAO.timHPTheoMa(kq.getHocPhan().getMaHocPhan());
			String diemThK = kq.getDiemThuongKy() == null ? "" : kq.getDiemThuongKy();
			String diemGK = kq.getDiemGiuaKy() == null ? "" : kq.getDiemGiuaKy();
			String diemCK = kq.getDiemCuoiKy() == null ? "" : kq.getDiemCuoiKy();
			String diemTK = kq.getDiemTongKet() == null ? "" : kq.getDiemTongKet();
			String xepLoai = kq.getXepLoai() == null ? "" : kq.getXepLoai();

			String[] rowData = { i + "", hp.getMaHocPhan(), hp.getTenMonHoc(), diemThK, diemGK, diemCK, diemTK,
					xepLoai };
			modelKQHT.addRow(rowData);
			tableKQHT.setModel(modelKQHT);
			i++;
		}
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(25);
		tb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableKQHT.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableKQHT.getColumn("Mã học phần").setCellRenderer(centerCellRenderer);
		tableKQHT.getColumn("Tên môn học").setCellRenderer(centerCellRenderer);
		tableKQHT.getColumn("Điểm thường kỳ").setCellRenderer(centerCellRenderer);
		tableKQHT.getColumn("Điểm giữa kỳ").setCellRenderer(centerCellRenderer);
		tableKQHT.getColumn("Điểm cuối kỳ").setCellRenderer(centerCellRenderer);
		tableKQHT.getColumn("Điểm tổng kết").setCellRenderer(centerCellRenderer);
		tableKQHT.getColumn("Xếp loại").setCellRenderer(centerCellRenderer);
	}
}
