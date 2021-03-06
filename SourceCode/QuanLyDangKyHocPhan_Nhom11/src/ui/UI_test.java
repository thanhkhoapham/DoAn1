package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao.KetQuaHocTapDAO;
import dao.NhanVienDAO;
import dao.SinhVienDAO;
import entity.SinhVien;
import ui.form.frm_DangKyHocPhan;
import ui.form.frm_HuyLopHocPhan;
import ui.form.frm_KetQuaHocTap;
import ui.form.frm_QuanLyChuyenNganh;
import ui.form.frm_QuanLyGiangVien;
import ui.form.frm_QuanLyHocPhan;
import ui.form.frm_QuanLyKhoa;
import ui.form.frm_QuanLyLopHP;
import ui.form.frm_QuanLyNhanVienPDT;
import ui.form.frm_QuanLySinhVien;
import ui.form.frm_ThongKeTinhTrangHocPhan;
import ui.form.frm_TimKiemGiangVien;
import ui.form.frm_TimKiemHocPhan;
import ui.form.frm_TimKiemNhanVienPDT;
import ui.form.frm_TimKiemSinhVien;
import ui.form.frm_XemCacMonDangKy;
import ui.form.frm_XemLichHoc;


public class UI_test extends JFrame {
//	private frm_QuanLyDiem pnlQLDiem = new frm_QuanLyDiem();
	private frm_QuanLyGiangVien pnlQLGiangVien = new frm_QuanLyGiangVien();
	private frm_QuanLySinhVien pnlSinhVien = new frm_QuanLySinhVien();
	private frm_TimKiemSinhVien pnlTimKiemSV = new frm_TimKiemSinhVien();
	private frm_QuanLyHocPhan pnlQLHocPhan = new frm_QuanLyHocPhan();
	private frm_QuanLyNhanVienPDT pnlQuanLyNhanVienPDT = new frm_QuanLyNhanVienPDT();
	private frm_TimKiemNhanVienPDT pnlTimKiemNV = new frm_TimKiemNhanVienPDT();
	private frm_QuanLyKhoa pnlQuanLyKhoa = new frm_QuanLyKhoa();
	private frm_QuanLyChuyenNganh pnlQuanLyChuyenNganh = new frm_QuanLyChuyenNganh();
	private frm_TimKiemGiangVien pnlTKGiangVien = new frm_TimKiemGiangVien();
	private frm_TimKiemHocPhan pnlTimKiemHocPhan = new frm_TimKiemHocPhan();
	private frm_ThongKeTinhTrangHocPhan frm_ThongKeTinhTrangHocPhan= new frm_ThongKeTinhTrangHocPhan();
	
	private SinhVienDAO svDAO = new SinhVienDAO();
	private NhanVienDAO nvDAO = new NhanVienDAO();
	private KetQuaHocTapDAO kqDAO = new KetQuaHocTapDAO();
	
	public UI_test(String uname) {
		Font font = new Font("Times New Roman ", Font.PLAIN,18);
		Font font2 = new Font("Times New Roman ", Font.PLAIN,16);
		
		frm_DangKyHocPhan pnlDangKyHP = new frm_DangKyHocPhan(uname);
		frm_XemCacMonDangKy pnlXemCacMonDangKy = new frm_XemCacMonDangKy(uname);
		frm_KetQuaHocTap pnlKQHT = new frm_KetQuaHocTap(uname);
		frm_QuanLyLopHP pnlLopHP = new frm_QuanLyLopHP(uname);
		frm_XemLichHoc pnlLichHoc = new frm_XemLichHoc(uname);
		frm_HuyLopHocPhan pnlHuyLopHP = new frm_HuyLopHocPhan(uname);
        
		System.out.println(svDAO.layThongTinSV(uname));
		System.out.println(nvDAO.layThongTinNV(uname));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHeThong = new JMenu("H??? th???ng");
		mnHeThong.setFont(font);
		menuBar.add(mnHeThong);
		
		JMenuItem jmiTrangChu = new JMenuItem("Trang ch???", new ImageIcon("img/home.png"));
		jmiTrangChu.setFont(font2);
		mnHeThong.add(jmiTrangChu);
		
		JMenuItem jmiDoiMatKhau = new JMenuItem("?????i m???t kh???u", new ImageIcon("img/key.png"));
		jmiDoiMatKhau.setFont(font2);
		mnHeThong.add(jmiDoiMatKhau);
		
		JMenuItem jmiDangXuat = new JMenuItem("????ng xu???t", new ImageIcon("img/logout.png"));
		jmiDangXuat.setFont(font2);
		mnHeThong.add(jmiDangXuat);
		
		JMenuItem jmiThoat = new JMenuItem("Tho??t", new ImageIcon("img/exit.png"));
		jmiThoat.setFont(font2);
		mnHeThong.add(jmiThoat);
		
		JMenu mnSinhVien = new JMenu("Sinh vi??n");
		mnSinhVien.setFont(font);
		menuBar.add(mnSinhVien);
		
		JMenuItem jmiQuanLySV = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
//		jmCapNhatSV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		jmiQuanLySV.setFont(font2);
		mnSinhVien.add(jmiQuanLySV);
		
		JMenuItem jmiTimKiemSV = new JMenuItem("T??m ki???m", new ImageIcon("img/timkiem.png"));
		jmiTimKiemSV.setFont(font2);
		mnSinhVien.add(jmiTimKiemSV);
		
		JMenuItem jmiDKHP = new JMenuItem("????ng k?? h???c ph???n", new ImageIcon("img/hocphan.png"));
//		jmDKHP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));
		jmiDKHP.setFont(font2);
		mnSinhVien.add(jmiDKHP);
		
		JMenuItem jmiXemTKB = new JMenuItem("Xem th???i kh??a bi???u", new ImageIcon("img/lichhoc.png"));
		jmiXemTKB.setFont(font2);
		mnSinhVien.add(jmiXemTKB);
		
		JMenuItem jmiXemKQHT = new JMenuItem("Xem k???t qu??? h???c t???p", new ImageIcon("img/kqht.png"));
		jmiXemKQHT.setFont(font2);
		mnSinhVien.add(jmiXemKQHT);
		
		JMenu mnGiangVien = new JMenu("Gi???ng vi??n");
		mnGiangVien.setFont(font);
		menuBar.add(mnGiangVien);
		
		JMenuItem jmiQuanLyGV = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyGV.setFont(font2);
		mnGiangVien.add(jmiQuanLyGV);
		
		JMenuItem jmiTimKiemGV = new JMenuItem("T??m ki???m", new ImageIcon("img/timkiem.png"));
		jmiTimKiemGV.setFont(font2);
		mnGiangVien.add(jmiTimKiemGV);
		
		JMenu mnNhanVien = new JMenu("Nh??n vi??n PDT");
		mnNhanVien.setFont(font);
		menuBar.add(mnNhanVien);
		
		JMenuItem jmiQuanLyNV = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyNV.setFont(font2);
		mnNhanVien.add(jmiQuanLyNV);
		
		JMenuItem jmiTimKiemNV = new JMenuItem("T??m ki???m", new ImageIcon("img/timkiem.png"));
		jmiTimKiemNV.setFont(font2);
		mnNhanVien.add(jmiTimKiemNV);
		
		JMenu mnLopHocPhan = new JMenu("L???p h???c ph???n");
		mnLopHocPhan.setFont(font);
		menuBar.add(mnLopHocPhan);
		
		JMenuItem jmiQuanLyLHP = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyLHP.setFont(font2);
		mnLopHocPhan.add(jmiQuanLyLHP);
		
//		JMenuItem jmiNhapDiem = new JMenuItem("Nh???p ??i???m", new ImageIcon("img/nhapdiem.png"));
//		jmiNhapDiem.setFont(font2);
//		mnLopHocPhan.add(jmiNhapDiem);
		
		JMenu mnHocPhan = new JMenu("H???c ph???n");
		mnHocPhan.setFont(font);
		menuBar.add(mnHocPhan);
		
		JMenuItem jmiQuanLyHP = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyHP.setFont(font2);
		mnHocPhan.add(jmiQuanLyHP);
		
		JMenuItem jmiTimKiemHP = new JMenuItem("T??m ki???m", new ImageIcon("img/timkiem.png"));
		jmiTimKiemHP.setFont(font2);
		mnHocPhan.add(jmiTimKiemHP);
		
		JMenu mnKhoa = new JMenu("Khoa");
		mnKhoa.setFont(font);
		menuBar.add(mnKhoa);
		
		JMenuItem jmiQuanLyKhoa = new JMenuItem("Qu???n l??", new ImageIcon("img/capnhat.png"));
		jmiQuanLyKhoa.setFont(font2);
		mnKhoa.add(jmiQuanLyKhoa);
		
		JMenu mnThongKe = new JMenu("Th???ng k??");
		mnThongKe.setFont(font);
		menuBar.add(mnThongKe);
		
		JMenuItem jmiTKLopChapNhanMo = new JMenuItem("Th???ng k?? theo tr???ng th??i", new ImageIcon("img/chapnhanmo.png"));
		jmiTKLopChapNhanMo.setFont(font2);
		mnThongKe.add(jmiTKLopChapNhanMo);
		
//		JMenuItem jmiTKLopBiHuy = new JMenuItem("C??c l???p b??? h???y", new ImageIcon("img/bihuy.png"));
//		jmiTKLopBiHuy.setFont(font2);
//		mnThongKe.add(jmiTKLopBiHuy);
		
		mnHeThong.setPreferredSize(new Dimension(150, 45));
		mnSinhVien.setPreferredSize(new Dimension(150, 45));
		mnGiangVien.setPreferredSize(new Dimension(150,45));
		mnNhanVien.setPreferredSize(new Dimension(170,45));
		mnLopHocPhan.setPreferredSize(new Dimension(160, 45));
		mnHocPhan.setPreferredSize(new Dimension(150, 45));
		mnKhoa.setPreferredSize(new Dimension(150, 45));
		mnThongKe.setPreferredSize(new Dimension(150, 45));
		
		mnHeThong.setIcon(new ImageIcon("img/system.png"));
		mnSinhVien.setIcon(new ImageIcon("img/student.png"));
		mnGiangVien.setIcon(new ImageIcon("img/teacher.png"));
		mnNhanVien.setIcon(new ImageIcon("img/nhanvien.png"));
		mnLopHocPhan.setIcon(new ImageIcon("img/lophocphan.png"));
		mnHocPhan.setIcon(new ImageIcon("img/hocphan.png"));
		mnKhoa.setIcon(new ImageIcon("img/khoa.png"));
		mnThongKe.setIcon(new ImageIcon("img/thongke.png"));
		
		jmiDoiMatKhau.setPreferredSize(new Dimension(180, 45));
		jmiDangXuat.setPreferredSize(new Dimension(180, 45));
		jmiThoat.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLySV.setPreferredSize(new Dimension(220, 45));
		jmiTimKiemSV.setPreferredSize(new Dimension(220, 45));
		jmiDKHP.setPreferredSize(new Dimension(220, 45));
		jmiXemTKB.setPreferredSize(new Dimension(220, 45));
		jmiXemKQHT.setPreferredSize(new Dimension(220, 45));
		
		jmiQuanLyGV.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemGV.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyNV.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemNV.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyLHP.setPreferredSize(new Dimension(180, 45));
//		jmiNhapDiem.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyHP.setPreferredSize(new Dimension(180, 45));
		jmiTimKiemHP.setPreferredSize(new Dimension(180, 45));
		
		jmiQuanLyKhoa.setPreferredSize(new Dimension(180, 45));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(font);
		getContentPane().add(tabbedPane);
		
		JLabel lblMain = new JLabel();
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon("img/trangChu03.png"));
		lblMain.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JPanel pnlMain = new JPanel();
		GroupLayout layout = new GroupLayout(pnlMain);
		pnlMain.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addComponent(lblMain, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap()));
		
		SinhVien sv = svDAO.layThongTinSV(uname);
		
		/*=====================================================================================
		 * H??? th???ng
		 */
		jmiTrangChu.addActionListener(e ->{
			setTitle("Xin ch??o, "+ sv.getTenSinhVien()+"!");
			tabbedPane.removeAll();
			tabbedPane.addTab("Trang ch???", new ImageIcon("img/home.png"), pnlMain, "Trang ch???");
		});
		
		jmiDoiMatKhau.addActionListener(e ->{
			new UI_DoiMatKhau(uname);
		});
		
		jmiDangXuat.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "B???n c?? mu???n ????ng xu???t kh??ng?", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.dispose();
				UI_DangNhap.main(null);
			}
		});
		
		jmiThoat.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "B???n c?? mu???n tho??t kh??ng?", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(EXIT_ON_CLOSE);;
			}
		});
		
		/*======================================================================================
		 * Sinh vi??n
		 */
		jmiQuanLySV.addActionListener(e ->{
			setTitle("Qu???n l?? sinh vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? sinh vi??n", new ImageIcon("img/add.png"), pnlSinhVien, "Qu???n l?? sinh vi??n");
//			tabbedPane.addTab("C???p nh???t sinh vi??n", new ImageIcon("img/update.png"), null, "C???p nh???t sinh vi??n");
		});
		
		jmiTimKiemSV.addActionListener(e ->{
			setTitle("T??m ki???m sinh vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("T??m ki???m sinh vi??n", new ImageIcon("img/timkiem.png"), pnlTimKiemSV, "T??m ki???m sinh vi??n");
		});
		
		jmiDKHP.addActionListener(e ->{
			setTitle("????ng k?? h???c ph???n");
			tabbedPane.removeAll();
			tabbedPane.addTab("????ng k?? h???c ph???n", new ImageIcon("img/hocphan.png"), pnlDangKyHP, "????ng k?? h???c ph???n");
			tabbedPane.addTab("Xem c??c m??n ???? ????ng k??", new ImageIcon("img/hocphan.png"), pnlXemCacMonDangKy, "Xem c??c m??n ???? ????ng k??");
		});
		
		jmiXemTKB.addActionListener(e ->{
			setTitle("Xem th???i kh??a bi???u");
			tabbedPane.removeAll();
			tabbedPane.addTab("Xem th???i kh??a bi???u", new ImageIcon("img/lichhoc.png"), pnlLichHoc, "Xem th???i kh??a bi???u");
		});
		
		jmiXemKQHT.addActionListener(e ->{
			setTitle("K???t qu??? h???c t???p");
			tabbedPane.removeAll();
			tabbedPane.addTab("K???t qu??? h???c t???p", new ImageIcon("img/kqht.png"), pnlKQHT, "Xem k???t qu??? h???c t???p");
//			pnlKQHT.loadTBKetQuaHT(sv.getMaSinhVien());
		});
		
		/*======================================================================================
		 * Gi???ng vi??n
		 */
		jmiQuanLyGV.addActionListener(e ->{
			setTitle("Qu???n l?? gi???ng vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? gi???ng vi??n", new ImageIcon("img/add.png"), pnlQLGiangVien, "Qu???n l?? gi???ng vi??n");
//			tabbedPane.addTab("X??a gi???ng vi??n", new ImageIcon("img/delete.png"), null, "X??a gi???ng vi??n");
//			tabbedPane.addTab("C???p nh???t gi???ng vi??n", new ImageIcon("img/update.png"), null, "C???p nh???t gi???ng vi??n");
		});
		
		jmiTimKiemGV.addActionListener(e ->{
			setTitle("Qu???n l?? gi???ng vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("T??m ki???m gi???ng vi??n", new ImageIcon("img/timkiem.png"), pnlTKGiangVien, "T??m ki???m gi???ng vi??n");
		});
		
		/*======================================================================================
		 * Nh??n vi??n ph??ng ????o t???o
		 */
		jmiQuanLyNV.addActionListener(e ->{
			setTitle("Qu???n l?? nh??n vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? nh??n vi??n", new ImageIcon("img/add.png"), pnlQuanLyNhanVienPDT, "Th??m nh??n vi??n");
//			tabbedPane.addTab("X??a gi???ng vi??n", new ImageIcon("img/delete.png"), null, "X??a gi???ng vi??n");
//			tabbedPane.addTab("C???p nh???t nh??n vi??n", new ImageIcon("img/update.png"), null, "C???p nh???t nh??n vi??n");
		});
		
		jmiTimKiemNV.addActionListener(e ->{
			setTitle("Qu???n l?? nh??n vi??n");
			tabbedPane.removeAll();
			tabbedPane.addTab("T??m ki???m nh??n vi??n", new ImageIcon("img/timkiem.png"), pnlTimKiemNV, "T??m ki???m nh??n vi??n");
		});
		/*======================================================================================
		 * L???p h???c ph???n
		 */
		jmiQuanLyLHP.addActionListener(e ->{
			setTitle("Qu???n l?? l???p h???c ph???n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? l???p h???c ph???n", new ImageIcon("img/add.png"), pnlLopHP, "Qu???n l?? l???p h???c ph???n");
			tabbedPane.addTab("H???y l???p h???c ph???n", new ImageIcon("img/delete.png"), pnlHuyLopHP, "H???y l???p h???c ph???n");
		});
		
//		jmiNhapDiem.addActionListener(e ->{
//			setTitle("Qu???n l?? l???p h???c ph???n");
//			tabbedPane.removeAll();
//			tabbedPane.addTab("Nh???p ??i???m", new ImageIcon("img/nhapdiem.png"), null, "Nh???p ??i???m");
//		});
		
		/*======================================================================================
		 * H???c ph???n
		 */
		jmiQuanLyHP.addActionListener(e ->{
			setTitle("Qu???n l?? h???c ph???n");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? h???c ph???n", new ImageIcon("img/add.png"), pnlQLHocPhan, "Qu???n l?? h???c ph???n");
//			tabbedPane.addTab("X??a h???c ph???n", new ImageIcon("img/delete.png"), null, "X??a h???c ph???n");
//			tabbedPane.addTab("C???p nh???t h???c ph???n", new ImageIcon("img/update.png"), null, "C???p nh???t h???c ph???n");
		});
		
		jmiTimKiemHP.addActionListener(e ->{
			setTitle("Qu???n l?? h???c ph???n");
			tabbedPane.removeAll();
			tabbedPane.addTab("T??m ki???m h???c ph???n", new ImageIcon("img/timkiem.png"), pnlTimKiemHocPhan, "T??m ki???m h???c ph???n");
		});

		/*======================================================================================
		 * Khoa
		 */
		jmiQuanLyKhoa.addActionListener(e ->{
			setTitle("Qu???n l?? khoa");
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? khoa", new ImageIcon("img/add.png"), pnlQuanLyKhoa, "Qu???n l?? khoa");
			tabbedPane.addTab("Qu???n l?? chuy??n ng??nh", new ImageIcon("img/add.png"), pnlQuanLyChuyenNganh, "Qu???n l?? chuy??n ng??nh");
//			tabbedPane.addTab("C???p nh???t khoa", new ImageIcon("img/update.png"), null, "C???p nh???t khoa");
		});
		
		/*======================================================================================
		 * Th???ng k??
		 */
		jmiTKLopChapNhanMo.addActionListener(e ->{
			setTitle("Th???ng k??");
			tabbedPane.removeAll();
			tabbedPane.addTab("Th???ng k??", new ImageIcon("img/chapnhanmo.png"), frm_ThongKeTinhTrangHocPhan, "Th???ng k?? c??c l???p ch???p nh???n m???");
		});
		
		//======================================================================================
		setTitle("Xin ch??o, "+ sv.getTenSinhVien()+"!");
		setSize(1350, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
//      setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon main = new ImageIcon("img/main_icon.png");
		setIconImage(main.getImage());
	
		tabbedPane.addTab("Trang ch???", new ImageIcon("img/home.png"), pnlMain, "Trang ch???");
	}
	

	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> new UI_test("tester"));
		
	}
}

