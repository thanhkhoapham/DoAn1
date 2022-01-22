package ui.form;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.ConnectDB;
import dao.ThongKeDao;
import entity.LopHocPhan;
import entity.LopSinhVien;
import entity.SinhVien;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frm_ThongKeTinhTrangHocPhan extends JPanel {

	private Connection con;
	private JPanel pnlSoLuongDangKy;
	private JPanel pnlTingTrang;
	private ThongKeDao thongKeDao;
	private DefaultTableModel modelThongKe;
	private JTable tableThongKe;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public frm_ThongKeTinhTrangHocPhan() {
		setLayout(null);

		con = ConnectDB.getInstance().getConnection();
		pnlTingTrang = new JPanel();
		pnlTingTrang.setBounds(34, 10, 1258, 416);
		add(pnlTingTrang);

		pnlSoLuongDangKy = new JPanel();
		pnlSoLuongDangKy.setBounds(35, 441, 1258, 217);
		add(pnlSoLuongDangKy);
		pnlSoLuongDangKy.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("DANH SÁCH TRẠNG THÁI CÁC LỚP HỌC PHẦN"));
		pnlSoLuongDangKy.add(scrollPane, BorderLayout.CENTER);

		String[] headers = "STT;Tên lớp học phần;Trạng thái;Số lượng".split(";");
		modelThongKe = new DefaultTableModel(headers, 10);
		tableThongKe = new JTable(modelThongKe) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableThongKe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableThongKe.getTableHeader().setReorderingAllowed(false);

		scrollPane.setViewportView(tableThongKe);

		this.thongKeDao = new ThongKeDao();
		setDataToChart(pnlTingTrang);

		napDanhSach(thongKeDao.inDanhSachLHP());
		tableDesign(tableThongKe);
		tableRenderer();
		tableThongKe.getColumnModel().getColumn(0).setPreferredWidth(10);
//		tableThongKe.getColumnModel().getColumn(3).setPreferredWidth(30);
	}

	private void xoaBang() {
		while (modelThongKe.getRowCount() > 0) {
			modelThongKe.removeRow(0);
		}
	}

	private void napDanhSach(List<LopHocPhan> list) {
		xoaBang();
		int i = 1;
		for (LopHocPhan hp : list) {
			String[] row = { i + "", hp.getTenLopHocPhan(), hp.getTrangThai(), hp.getSiSoToiDa() + "" };
			modelThongKe.addRow(row);
			tableThongKe.setModel(modelThongKe);
			i -= -1;
		}
	}

	private void setDataToChart(JPanel jp) {
		List<LopHocPhan> ds = thongKeDao.inDanhSachTinhTrang();
		if (ds != null) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (LopHocPhan lopHocPhan : ds) {
				dataset.addValue(lopHocPhan.getSiSoToiDa(), "Lớp học phần", lopHocPhan.getTrangThai());
			}
			JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ TRẠNG THÁI LỚP HỌC PHẦN", "Trạng thái", "Số lượng",
					dataset);
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new Dimension(jp.getHeight(), 300));
			jp.removeAll();
			jp.setLayout(new CardLayout());
			jp.add(chartPanel);
			jp.validate();
			jp.repaint();
		}
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableThongKe.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableThongKe.getColumn("Tên lớp học phần").setCellRenderer(centerCellRenderer);
		tableThongKe.getColumn("Trạng thái").setCellRenderer(centerCellRenderer);
		tableThongKe.getColumn("Số lượng").setCellRenderer(centerCellRenderer);

	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}
}
