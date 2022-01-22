package ui.form;

import javax.swing.JPanel;

import dao.HocPhanDAO;
import dao.KetQuaHocTapDAO;
import dao.LopHocPhanDAO;
import dao.NhanVienDAO;
import dao.PhieuDangKyDAO;
import dao.SinhVienDAO;
import entity.HocPhan;
import entity.LopHocPhan;
import entity.NhanVienPDT;
import entity.PhieuDangKy;
import entity.SinhVien;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frm_HuyLopHocPhan extends JPanel{
	private NhanVienDAO nvDAO = new NhanVienDAO();
	private SinhVienDAO sinhVienDAO = new SinhVienDAO();
	private PhieuDangKyDAO pdkDAO = new PhieuDangKyDAO();
	private HocPhanDAO hocPhanDAO = new HocPhanDAO();
	private LopHocPhanDAO lopHocPhanDAO = new LopHocPhanDAO();
	private KetQuaHocTapDAO kqDAO = new KetQuaHocTapDAO();
	
	private JTextField tfMSSV;
	private JTextField tfHoTenSV;
	private DefaultTableModel modelSV, modelLHP;
	private JTable tableSV, tableLHP;
	
	public frm_HuyLopHocPhan(String uname) {
		setLayout(null);
		NhanVienPDT nv = nvDAO.layThongTinNV(uname);
		
		JPanel pnlSinhVien = new JPanel();
		pnlSinhVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSinhVien.setBounds(21, 32, 524, 638);
		add(pnlSinhVien);
		pnlSinhVien.setLayout(null);
		
		JLabel lblMSSV = new JLabel("Mã sinh viên:");
		lblMSSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSSV.setBounds(90, 24, 109, 22);
		pnlSinhVien.add(lblMSSV);
		
		JLabel lnlHoTenSV = new JLabel("Họ tên SV:");
		lnlHoTenSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnlHoTenSV.setBounds(90, 78, 109, 22);
		pnlSinhVien.add(lnlHoTenSV);
		
		tfMSSV = new JTextField();
		tfMSSV.setBounds(197, 26, 236, 22);
		pnlSinhVien.add(tfMSSV);
		tfMSSV.setColumns(10);
		
		tfHoTenSV = new JTextField();
		tfHoTenSV.setBounds(197, 80, 236, 22);
		pnlSinhVien.add(tfHoTenSV);
		tfHoTenSV.setColumns(10);
		
		JButton btnTimSV = new JButton("Tìm");
		btnTimSV.setBounds(188, 133, 85, 29);
		pnlSinhVien.add(btnTimSV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 196, 482, 392);
		pnlSinhVien.add(scrollPane);
		
		JPanel pnlDsLopHP = new JPanel();
		pnlDsLopHP.setBorder(new TitledBorder(null, "Danh sách lớp học phần", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDsLopHP.setBounds(563, 32, 754, 638);
		add(pnlDsLopHP);
		pnlDsLopHP.setLayout(null);
		
		JLabel lblChonHK = new JLabel("Chọn học kỳ:");
		lblChonHK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChonHK.setBounds(160, 65, 100, 30);
		pnlDsLopHP.add(lblChonHK);
		
		JComboBox cmbHocKy = new JComboBox();
		cmbHocKy.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		cmbHocKy.setBounds(300, 65, 60, 30);
		pnlDsLopHP.add(cmbHocKy);
		
		JComboBox cmbNamHoc = new JComboBox();
		cmbNamHoc.setModel(new DefaultComboBoxModel(new String[] {"2020 - 2021"}));
		cmbNamHoc.setBounds(380, 65, 100, 30);
		pnlDsLopHP.add(cmbNamHoc);
		
		JButton btnChonHK = new JButton("Chọn");
		btnChonHK.setBounds(510, 65, 85, 30);
		pnlDsLopHP.add(btnChonHK);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 197, 734, 390);
		pnlDsLopHP.add(scrollPane2);
		
		String[] tieuDe = { "Mã sinh viên", "Tên sinh viên", "Lớp sinh viên", "Chuyên ngành" };
		modelSV = new DefaultTableModel(tieuDe, 0);
		tableSV = new JTable(modelSV) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableSV.getTableHeader().setReorderingAllowed(false);
		tableSV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableSV);
		
		String[] tieuDe2 = {"STT", "Mã học phần", "Mã lớp học phần", "Tên lớp học phần", "Lớp tín chỉ", "Sĩ số tối đa", "Sĩ số đăng ký", "Trạng thái" };
		modelLHP = new DefaultTableModel(tieuDe2, 0);
		tableLHP = new JTable(modelLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableLHP.getTableHeader().setReorderingAllowed(false);
		tableLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		scrollPane2.setViewportView(tableLHP);
		
		JButton btnHuyLopHP = new JButton("Hủy lớp HP");
		btnHuyLopHP.setBounds(621, 597, 110, 31);
		pnlDsLopHP.add(btnHuyLopHP);
		
		btnTimSV.addActionListener(e ->{
			String mssv = tfMSSV.getText();
			String hoTenSV = tfHoTenSV.getText();
			loadTBSinhVien(mssv, hoTenSV);
		});
		
		btnChonHK.addActionListener(e ->{
			int hocKy = Integer.parseInt(cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex()).toString());
			String namHoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex()).toString();
			int index = tableSV.getSelectedRow();
			if (index>=0 && index<tableSV.getRowCount()) {
				String mssv = tableSV.getValueAt(index, 0).toString();
				loadTBLopHp(mssv, hocKy, namHoc);
			}else {
				JOptionPane.showMessageDialog(null, "Chưa chọn sinh viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnHuyLopHP.addActionListener(e ->{
			int index = tableLHP.getSelectedRow();
			int index2 = tableSV.getSelectedRow();
			if(index>=0 && index<tableLHP.getRowCount()) {
				String maSV = tableSV.getValueAt(index2, 0).toString();
				String maLHP = tableLHP.getValueAt(index, 2).toString();
				LopHocPhan lophp = lopHocPhanDAO.timLopTheoMa(maLHP);
				String trThaiCu = lophp.getTrangThai();
				int siSoToiDa = lophp.getSiSoToiDa();
				
				if (JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy đăng ký môn này không?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					lopHocPhanDAO.huyDangKyLHP(maLHP, maSV);
					
					String maHP = tableLHP.getValueAt(tableLHP.getSelectedRow(), 1).toString();
					kqDAO.xoaKQHocTap(maSV, maHP);

					int siSoMoi = lopHocPhanDAO.laySiSoMoi(maLHP);
					String trThaiMoi = lopHocPhanDAO.capNhatTrangThaiLHP(siSoMoi, siSoToiDa);
					lopHocPhanDAO.capNhatThongTinLHP(lophp, siSoMoi, trThaiMoi);
					JOptionPane.showInternalMessageDialog(null, "Hủy đăng ký thành công!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						
						
					
					
					String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex()).toString();
					String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex()).toString();
					int hocKy = Integer.parseInt(hk);
					loadTBLopHp(maSV, hocKy, namhoc);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Chưa chọn lớp học phần!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		tableDesign(tableSV);
		tableDesign(tableLHP);
	}
	
	private void xoaTBSinhVien() {
		while (modelSV.getRowCount() > 0) {
			modelSV.removeRow(0);
		}
	}
	
	private void loadTBSinhVien(String mssv, String hoTen) {
		xoaTBSinhVien();
		List<SinhVien> dssv = sinhVienDAO.timSinhVienQuaTenVaMaso(mssv, hoTen);
		for (SinhVien sinhVien : dssv) {
			String[] rowData = {sinhVien.getMaSinhVien(), sinhVien.getTenSinhVien(), sinhVien.getLopSinhVien().getMaLopSV(),
					sinhVien.getLopSinhVien().getChuyenNganh().getMaChuyenNganh()};
			modelSV.addRow(rowData);
			tableSV.setModel(modelSV);
		}
	}
	
	private void xoaTBLopHP() {
		while (modelLHP.getRowCount() > 0) {
			modelLHP.removeRow(0);
		}
	}
	
	private void loadTBLopHp(String mssv, int hocKy, String namHoc) {
		xoaTBLopHP();
		List<PhieuDangKy> dspdk = pdkDAO.layDsPhieuDangKy(mssv); 
		int i = 1;

		for (PhieuDangKy phieuDangKy : dspdk) {
			LopHocPhan lopHocPhan = phieuDangKy.getLopHocPhan();
			HocPhan hocPhan = hocPhanDAO.timHPTheoMa(lopHocPhan.getHocPhan().getMaHocPhan());
			
			if (hocPhan.getHocKy() == hocKy && lopHocPhan.getNamHoc().equals(namHoc)) {
				String batBuoc = "";
				if (hocPhan.isBatBuoc()) {
					batBuoc = "x";
				}
				java.util.Date ngayDangKy = new java.util.Date(phieuDangKy.getNgayDangKy().getTime());
				SimpleDateFormat sdm = new SimpleDateFormat("dd-MM-yyyy");

				String[] rowData = {i+"", hocPhan.getMaHocPhan(), lopHocPhan.getMaLopHocPhan(), lopHocPhan.getTenLopHocPhan(), lopHocPhan.getLopTinChi(),
						 lopHocPhan.getSiSoToiDa()+"", lopHocPhan.getSiSoDangKy()+"", lopHocPhan.getTrangThai()};
				modelLHP.addRow(rowData);
				tableLHP.setModel(modelLHP);
				i++;
			}
		}
	}
	
	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
		tb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}
}
